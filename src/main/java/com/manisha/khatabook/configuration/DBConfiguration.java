package com.manisha.khatabook.configuration;

import com.manisha.khatabook.dao.CustomerDao;
import com.manisha.khatabook.dao.KhatabookDao;
import com.manisha.khatabook.dao.UserAuthDao;
import com.manisha.khatabook.dao.impl.CustomerDaoImpl;
import com.manisha.khatabook.dao.impl.KhatabookDaoImpl;
import com.manisha.khatabook.dao.impl.UserAuthDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DBConfiguration {

    @Bean
    public Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/khatabookdb?autoReconnect=true&&useSSL=false";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }
    @Bean
    public UserAuthDao getUserDao(Connection dbConn) {
        return new UserAuthDaoImpl(dbConn);
    }

    @Bean
    public KhatabookDao getKhatabookDao(Connection dbConn) {
        return new KhatabookDaoImpl(dbConn);
    }
    @Bean
    public CustomerDao getCustomerDao(Connection dbConn) {
        return new CustomerDaoImpl(dbConn);
    }
}
