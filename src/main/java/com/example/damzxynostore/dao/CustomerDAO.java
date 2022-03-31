package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.CustomerDTO;
import com.example.damzxynostore.utils.PasswordHashing;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO extends GenericDAO <CustomerDTO> {

    @Override
    public boolean create(CustomerDTO customerDTO) {
        connectToDataBase();
        String query = "INSERT INTO customer(email, last_name, first_name, address, phone, password, registered_date) " +
                "VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerDTO.getEmail());
            preparedStatement.setString(2, customerDTO.getLastName());
            preparedStatement.setString(3, customerDTO.getFirstName());
            preparedStatement.setString(4, customerDTO.getAddress());
            preparedStatement.setString(5, customerDTO.getPhone());
            preparedStatement.setString(6, customerDTO.getPassword());
            preparedStatement.setDate(7, new java.sql.Date(customerDTO.getDate().getTime()));
            preparedStatement.execute();
            connection.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
            return false;
    }


    public CustomerDTO get(String email) {
        connectToDataBase();
        CustomerDTO customerDTO = null;

        try {
            String query = "SELECT * FROM customer WHERE email = '" + email + "'";
            Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()){
                customerDTO = new CustomerDTO();
                customerDTO.setCustomerId(resultSet.getInt("customer_id"));
                customerDTO.setPassword(PasswordHashing.decryptPassword(resultSet.getString("password")));
                customerDTO.setDate(resultSet.getDate("registered_date"));
                customerDTO.setEmail(resultSet.getString("email"));
                customerDTO.setFirstName(resultSet.getString("first_name"));
                customerDTO.setLastName(resultSet.getString("last_name"));
                customerDTO.setPhone(resultSet.getString("phone"));
                customerDTO.setAddress(resultSet.getString("address"));

                System.out.println(customerDTO);
            }
            closeDatabaseConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        return customerDTO;
    }

    public List<CustomerDTO> listAll (){
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        connectToDataBase();
        try {
            String query = "SELECT * FROM customer";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setCustomerId(resultSet.getInt("customer_id"));
                customerDTO.setAddress(resultSet.getString("address"));
                customerDTO.setEmail(resultSet.getString("email"));
                customerDTO.setFirstName(resultSet.getString("first_name"));
                customerDTO.setLastName(resultSet.getString("last_name"));
                customerDTO.setPhone(resultSet.getString("phone"));

                customerDTOS.add(customerDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerDTOS;
    }
}
