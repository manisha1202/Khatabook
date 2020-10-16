package com.manisha.khatabook.dao.impl;

import com.manisha.khatabook.dao.CustomerDao;
import com.manisha.khatabook.dao.KhatabookDao;
import com.manisha.khatabook.dao.TransactionDao;
import com.manisha.khatabook.dao.constants.UserQuery;
import com.manisha.khatabook.dao.models.TotalAmount;
import com.manisha.khatabook.dao.models.TransactionDetail;
import com.manisha.khatabook.dao.models.TransactionType;
import com.manisha.khatabook.dao.models.request.AddTransactionRequest;
import com.manisha.khatabook.dao.models.request.GetTransactionsRequest;
import com.manisha.khatabook.dao.models.response.GetTransactionsResponse;
import com.manisha.khatabook.dao.utils.ConverterUtil;
import com.manisha.khatabook.dao.utils.DbUtils;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDaoImpl implements TransactionDao {

    private Connection myConn = null;
    @Autowired
    private KhatabookDao khatabookDao;
    @Autowired
    private CustomerDao customerDao;

    public TransactionDaoImpl(Connection conn) {
        this.myConn = conn;
    }

    @Override
    public void addTransaction(AddTransactionRequest addTransactionRequest) throws Exception {
        try {
            myConn.setAutoCommit(false);
            PreparedStatement ps = myConn.prepareStatement(UserQuery.ADD_TRANSACTION);
            DbUtils.updateStatementForSaveTransaction(ps, addTransactionRequest);
            ps.executeUpdate();

            TransactionDetail customerCurrentTransactionState =
                    getCustomerCurrentTransactionState(addTransactionRequest);
            TotalAmount currentTotalAmount = getTotalDebitAndCredit(addTransactionRequest);

            double totalDebitWithoutThisCustomer =
                    getTotalDebitWithoutThisCustomer(customerCurrentTransactionState,
                            currentTotalAmount.getDebit());

            double totalCreditWithoutThisCustomer =
                    getTotalCreditWithoutThisCustomer(customerCurrentTransactionState,
                            currentTotalAmount.getCredit());

            TransactionDetail currentContributionDetail =
                    getCurrentContributionDetail(customerCurrentTransactionState,
                            addTransactionRequest);

            TotalAmount updatedCreditDebitAmount =
                    getUpdatedCreditDebitAmount(currentContributionDetail,
                            totalDebitWithoutThisCustomer,
                            totalCreditWithoutThisCustomer);

            customerDao.updateCustomer(addTransactionRequest, currentContributionDetail);
            khatabookDao.updateKhatabook(addTransactionRequest, updatedCreditDebitAmount);

            myConn.commit();

            System.out.println("transaction added");
        } catch (SQLException e) {
            throw new Exception("Failed to add the transaction.", e);
        }

    }

    private TransactionDetail getCurrentContributionDetail(
            @NonNull TransactionDetail customerCurrentTransactionState,
            @NonNull AddTransactionRequest addTransactionRequest) {
        double amount = 0;
        String type = "";
        if (customerCurrentTransactionState.getTransactionType().equals(TransactionType.debit) &&
                addTransactionRequest.getType().equals("debit")) {
            amount =
                    customerCurrentTransactionState.getAmount() + addTransactionRequest.getAmount();
            type = "debit";
        } else if (customerCurrentTransactionState.getTransactionType()
                .equals(TransactionType.credit) &&
                addTransactionRequest.getType().equals("credit")) {
            amount =
                    customerCurrentTransactionState.getAmount() + addTransactionRequest.getAmount();
            type = "credit";
        } else if (customerCurrentTransactionState.getTransactionType()
                .equals(TransactionType.debit) &&
                addTransactionRequest.getType().equals("credit")) {
            if (customerCurrentTransactionState.getAmount() > addTransactionRequest.getAmount()) {
                amount =
                        customerCurrentTransactionState.getAmount() -
                                addTransactionRequest.getAmount();
                type = "debit";
            } else {
                amount =
                        addTransactionRequest.getAmount() -
                                customerCurrentTransactionState.getAmount();
                type = "credit";
            }

        } else if (customerCurrentTransactionState.getTransactionType()
                .equals(TransactionType.credit) &&
                addTransactionRequest.getType().equals("debit")) {
            if (customerCurrentTransactionState.getAmount() > addTransactionRequest.getAmount()) {
                amount =
                        customerCurrentTransactionState.getAmount() -
                                addTransactionRequest.getAmount();
                type = "credit";
            } else {
                amount =
                        addTransactionRequest.getAmount() -
                                customerCurrentTransactionState.getAmount();
                type = "debit";
            }
        }
        return TransactionDetail.builder().amount(amount)
                .transactionType(TransactionType.valueOf(type)).build();
    }

    private TotalAmount getUpdatedCreditDebitAmount(
            @NonNull TransactionDetail currentContributionDetail,
            double totalDebitWithoutThisCustomer,
            double totalCreditWithoutThisCustomer) {

        double credit = 0, debit = 0;
        if (currentContributionDetail.getTransactionType().equals(TransactionType.debit)) {

            debit = totalDebitWithoutThisCustomer;
            credit = totalCreditWithoutThisCustomer + currentContributionDetail.getAmount();
        } else {
            debit = totalDebitWithoutThisCustomer + currentContributionDetail.getAmount();
            credit = totalCreditWithoutThisCustomer;
        }
        return TotalAmount.builder().debit(debit).credit(credit).build();
    }

    private double getTotalCreditWithoutThisCustomer(
            @NonNull TransactionDetail customerCurrentTransactionState, double totalCredit) {
        if (customerCurrentTransactionState.getTransactionType().equals(TransactionType.debit) &&
                totalCredit > 0) {
            return totalCredit - customerCurrentTransactionState.getAmount();
        }
        return totalCredit;
    }

    private double getTotalDebitWithoutThisCustomer(
            @NonNull TransactionDetail customerCurrentTransactionState,
            double totalDebit) {
        if (customerCurrentTransactionState.getTransactionType().equals(TransactionType.credit) &&
                totalDebit > 0) {
            return totalDebit - customerCurrentTransactionState.getAmount();
        }
        return totalDebit;
    }

    private TotalAmount getTotalDebitAndCredit(AddTransactionRequest addTransactionRequest) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = myConn.prepareStatement(UserQuery.GET_KHATABOOK_BALANCE);
            DbUtils.updateStatementForGetKhatabookTypeBalance(preparedStatement,
                    addTransactionRequest.getKhatabookId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return TotalAmount.builder().credit(resultSet.getDouble("Credit"))
                        .debit(resultSet.getDouble("Debit")).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private TransactionDetail getCustomerCurrentTransactionState(
            AddTransactionRequest addTransactionRequest) {
        try {
            PreparedStatement preparedStatement =
                    myConn.prepareStatement(UserQuery.GET_CUSTOMER_AMOUNT_TYPE);
            DbUtils.updateStatementForGetCustomerAmountType(preparedStatement,
                    addTransactionRequest);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return TransactionDetail.builder().amount(resultSet.getDouble("Amount"))
                        .transactionType(
                                TransactionType.valueOf(resultSet.getString("Type"))).build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GetTransactionsResponse getTransactions(GetTransactionsRequest getTransactionsRequest)
            throws Exception {
        try {
            PreparedStatement ps = myConn.prepareStatement(UserQuery.GET_TRANSACTIONS);
            DbUtils.updateStatementForGetTransactions(ps, getTransactionsRequest);
            ResultSet rs = ps.executeQuery();
            return ConverterUtil.getTransactionsFromResultSet(rs);
        } catch (SQLException e) {
            throw new Exception("Failed to get the transactions.", e);
        }
    }
}
