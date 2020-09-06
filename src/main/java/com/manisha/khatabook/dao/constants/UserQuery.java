package com.manisha.khatabook.dao.constants;

public final class UserQuery {

    public static final String INSERT_USER = "INSERT INTO users (User_Name,Phone_Number,Password," +
            "Email,Address,Image) VALUES (?,?,?,?,?,?)";

    public static final String GET_USER =
            "SELECT * FROM users WHERE Phone_Number= ? AND Password= ?";

    public static final String GET_LIST_OF_KHATABOOKS = "SELECT Name FROM khatabook WHERE " +
            "Khatabook_Id IN (SELECT khatabook_Khatabook_Id FROM user_khatabook_relation where users_Phone_Number = ?)";

    public static final String INSERT_CUSTOMER = "Insert INTO customer(Name,Phone_Number," +
            "Loan_Amount) VALUES(?,?,?)";

    private UserQuery() {

    }
}
