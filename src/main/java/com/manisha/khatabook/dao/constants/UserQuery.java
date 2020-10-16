package com.manisha.khatabook.dao.constants;

public final class UserQuery {

    public static final String INSERT_USER = "INSERT INTO users (User_Name,Phone_Number,Password," +
            "Email,Address,Image) VALUES (?,?,?,?,?,?)";

    public static final String GET_USER =
            "SELECT * FROM users WHERE Phone_Number= ? AND Password= ?";

    public static final String ADD_KHATABOOK = "Insert into khatabook(Name,users_Phone_Number," +
            "Credit,Debit) values(?,?,?,?)";

    public static final String GET_LIST_OF_KHATABOOKS = "SELECT * FROM khatabook WHERE " +
            "users_Phone_Number = ?";

    public static final String INSERT_CUSTOMER = "Insert INTO customer(Name,Phone_Number," +
            "Amount,khatabook_Khatabook_Id,Type) VALUES(?,?,?,?,?)";

    public static final String GET_CUSTOMERS = "SELECT Customer_Id,Name,Amount FROM customer " +
            "WHERE " +
            "khatabook_Khatabook_Id = ?";

    public static final String GET_BALANCE = "SELECT Credit,Debit FROM Khatabook WHERE " +
            "Khatabook_Id = ?";

    public static final String ADD_TRANSACTION = "Insert INTO transaction(Date,Amount,Type," +
            "Description,customer_Customer_Id,khatabook_Khatabook_Id) VALUES(?,?,?,?,?,?)";

    public static final String GET_CUSTOMER_AMOUNT_TYPE = "Select Amount,Type from customer where" +
            " " +
            "Customer_Id = ? And khatabook_Khatabook_Id = ?";

    public static final String GET_KHATABOOK_BALANCE = "select Credit,Debit from khatabook where " +
            "Khatabook_Id=?";

    public static final String UPDATE_CUSTOMER = "Update customer set Amount = ?,Type = ? where " +
            "Customer_Id = ?";

    public static final String UPDATE_KHATABOOK = "Update khatabook set Credit = ?, Debit = ? " +
            "where" +
            " " +
            "Khatabook_Id = ?";

    public static final String GET_TRANSACTIONS = "select Date,Amount,Type,Description from transaction " +
            "where " +
            "customer_Customer_Id = ? and khatabook_Khatabook_Id = ?";

    private UserQuery() {

    }
}
