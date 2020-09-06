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
    public UserAuthDao getUserDao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/khatabookdb?autoReconnect=true&&useSSL=false";
        String username = "root";
        String password = "root";
        Connection dbConn = DriverManager.getConnection(url, username, password);
        return new UserAuthDaoImpl(dbConn);
    }

    @Bean
    public KhatabookDao getKhatabookDao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/khatabookdb?autoReconnect=true&&useSSL=false";
        String username = "root";
        String password = "root";
        Connection dbConn = DriverManager.getConnection(url, username, password);
        return new KhatabookDaoImpl(dbConn);
    }
    @Bean
    public CustomerDao getCustomerDao() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/khatabookdb?autoReconnect=true&&useSSL=false";
        String username = "root";
        String password = "root";
        Connection dbConn = DriverManager.getConnection(url, username, password);
        return new CustomerDaoImpl(dbConn);
    }
}
