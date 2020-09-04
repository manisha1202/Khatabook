package com.manisha.khatabook.controllers;

import com.manisha.khatabook.models.User;
import com.manisha.khatabook.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class KhatabookController {

    @Autowired
    private JwtUtil jwtTokenUtil;


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/register")
    public User registerUser(@RequestBody User user){
        String url="jdbc:mysql://localhost:3306/khatabookdb?autoReconnect=true&&useSSL=false";
        String username="root";
        String password="root";
        try {
            Connection myCon= DriverManager.getConnection(url,username,password);
            Statement stmt = myCon.createStatement();
            String query="INSERT INTO users (User_Name,Phone_Number,Password,Email,Address,Image)"+ "VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStmt = myCon.prepareStatement(query);
            preparedStmt.setString(1,user.getUser_name());
            preparedStmt.setString(2, user.getPhone_number());
            preparedStmt.setString(3, user.getPassword());
            preparedStmt.setString(4,user.getEmail());
            preparedStmt.setString(5,"");
            preparedStmt.setString(6,"");
            preparedStmt.executeUpdate();
            myCon.close();
            System.out.println("register");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginInUser(@RequestBody User user){
        String url="jdbc:mysql://localhost:3306/khatabookdb?autoReconnect=true&&useSSL=false";
        String username="root";
        String password="root";
        Connection myCon= null;
        String userName="";
        try {
            myCon = DriverManager.getConnection(url,username,password);
            Statement stmt = myCon.createStatement();
            String query = "SELECT * FROM users;";
            stmt.executeQuery(query);
            ResultSet rs = stmt.getResultSet();
            boolean login=false;

            while(rs.next()) {
                String dbPhoneNumber = rs.getString("Phone_Number");
                String dbPassword = rs.getString("Password");


                if (dbPhoneNumber.equals(user.getPhone_number()) && dbPassword.equals(user.getPassword())) {
                    System.out.println("OK");
                    userName=rs.getString("User_Name");
                    login = true;
                    final String jwt = jwtTokenUtil.generateToken(user);
                    return ResponseEntity.ok(jwt);
                }
            }
            myCon.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
        }

        @CrossOrigin(origins = "http://localhost:3000")
        @RequestMapping(value = "/khatabooks", method = RequestMethod.POST)
        public List<String> getKhatabooksForAUser(@RequestBody String phone_no){
            //String data=user.getPhone_number();
            //System.out.println("phone_number: "+data);
            String url="jdbc:mysql://localhost:3306/khatabookdb?autoReconnect=true&&useSSL=false";
            String username="root";
            String password="root";
            Connection myCon= null;
            List<String> res=new ArrayList<>();
            try{
                myCon = DriverManager.getConnection(url,username,password);
                Statement stmt = myCon.createStatement();
                String query = "SELECT Name FROM khatabook WHERE Khatabook_Id IN (SELECT " +
                        "khatabook_Khatabook_Id FROM user_khatabook_relation where " +
                        "users_Phone_Number="+phone_no+")";
                stmt.executeQuery(query);
                ResultSet rs = stmt.getResultSet();
                int size=0;
                while(rs.next()) {
                    //System.out.println(rs.getString(1));
                    size++;
                    res.add(rs.getString(1));
                }
                System.out.println("size: "+size);
            }catch(SQLException throwables){
                throwables.printStackTrace();
            }
            return res;
        }
    }
