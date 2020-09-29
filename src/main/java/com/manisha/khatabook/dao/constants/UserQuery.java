package com.manisha.khatabook.dao.constants;

public final class UserQuery {

    public static final String INSERT_USER = "INSERT INTO users (User_Name,Phone_Number,Password," +
            "Email,Address,Image) VALUES (?,?,?,?,?,?)";

    public static final String GET_USER =
            "SELECT * FROM users WHERE Phone_Number= ? AND Password= ?";

    public static final String GET_LIST_OF_KHATABOOKS = "SELECT * FROM khatabook WHERE " +
            "users_Phone_Number = ?";

    public static final String INSERT_CUSTOMER = "Insert INTO customer(Name,Phone_Number," +
            "Loan_Amount,khatabook_Khatabook_Id) VALUES(?,?,?,?)";

    public static final String GET_CUSTOMERS = "SELECT Name,Loan_Amount FROM customer WHERE " +
            "khatabook_Khatabook_Id = ?";

    public static final String GET_BALANCE = "SELECT Credit,Debit FROM Khatabook WHERE " +
            "Khatabook_Id = ?";

    public static final String ADD_TRANSACTION = "Insert INTO transaction(Date,Amount,Type," +
            "Description,customer_Customer_Id,khatabook_Khatabook_Id) VALUES(?,?,?,?,?,?)";

//    public static final String UPDATE_CUSTOMER = "";
//    public static final String UPDATE_KHATABOOK = ;

    private UserQuery() {

    }
}
