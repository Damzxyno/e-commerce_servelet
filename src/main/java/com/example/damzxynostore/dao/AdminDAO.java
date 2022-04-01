package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.AdminDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminDAO extends GenericDAO<AdminDTO> {
    @Override
    public boolean create(AdminDTO adminDTO) {
        connectToDataBase();
        String query = "INSERT INTO admin (last_name, first_name, email, password) " +
                "VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, adminDTO.getLastName());
            preparedStatement.setString(2, adminDTO.getFirstName());
            preparedStatement.setString(3, adminDTO.getEmail());
            preparedStatement.setString(4, adminDTO.getPassword());
            preparedStatement.execute();
            connection.close();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public AdminDTO get (String email) {
        connectToDataBase();
        AdminDTO adminDTO = null;

        try {
            String query = "SELECT * FROM admin WHERE email =  " + "'" + email + "'";
            Statement statement= connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()){
                adminDTO = new AdminDTO();
                adminDTO.setAdminId(resultSet.getInt("admin_id"));
                adminDTO.setEmail(resultSet.getString("email"));
                adminDTO.setPassword(resultSet.getString("password"));
                adminDTO.setFirstName(resultSet.getString("first_name"));
                adminDTO.setLastName(resultSet.getString("last_name"));
            }
            closeDatabaseConnection();
        } catch (Exception e){
            e.printStackTrace();
        }
        return adminDTO;
    }
}
