/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 20-09-2022
 *Created With : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    // Declaring a variable.
    private static final String URL = "jdbc:mysql://localhost:3306/school";
    // Declaring a variable.
    private static final String USERNAME = "root";
    // A variable declaration.
    private static final String PASSWORD = "Seetha@007";

    // A variable declaration.
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public DatabaseService() {
        this.connection = null;
    }

    public boolean connect() throws ClassNotFoundException, SQLException {
        // 1. load the jdbc driver into the program memory
        // Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. create a connection object using the DriverManager class
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        // 3. check if the connection is successful
        return connection != null;
    }

    public void printConnectionStatus() {
    }
}
