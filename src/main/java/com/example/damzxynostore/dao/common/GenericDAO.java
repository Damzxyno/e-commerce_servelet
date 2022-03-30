package com.example.damzxynostore.dao.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class GenericDAO<T> {
    protected Connection connection;
    private Statement statement;
    private final String dbURL = "jdbc:mysql://localhost:3306/e_storeDB";
    private final String dbUsername = "root";
    private final String dbPassword = "password";

    public Statement connectToDataBase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword );
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public void closeDatabaseConnection(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public abstract boolean create(T element);
}
