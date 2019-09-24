/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsfexample1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Admin
 */
@Named("studentBean")
@RequestScoped
public class Student {
    String firstName;
    String secondName;
    String emailAddress;
    String username;
    String password;
    
    public Student(){
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setCounty(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void save(){
        try {
            // load the driver class
            Class.forName("com.mysql.jdbc.Driver");
            
            //connection to db
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ist","root","");
            
            PreparedStatement ps = con.prepareStatement("INSERT INTO students(first_name,last_name,username, password) VALUES(?,?,?,?)");
            ps.setString(1, firstName);
            ps.setString(2, secondName);
            ps.setString(3, username);
            ps.setString(4, password);
            int i = ps.executeUpdate();
            System.out.println("You inserted " + i + "record succesfully");
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    
}
