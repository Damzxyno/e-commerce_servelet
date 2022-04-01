package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.CategoryDTO;
import com.example.damzxynostore.entities.CustomerDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends GenericDAO<CategoryDTO> {

    @Override
    public boolean create(CategoryDTO categoryDTO) {
        connectToDataBase();
        String query = "INSERT INTO category (category_name) VALUES(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, categoryDTO.getCategoryName());
            preparedStatement.execute();
            connection.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public CategoryDTO get(String categoryName) {
        connectToDataBase();
        CategoryDTO categoryDTO = null;

        try {
            String query = "SELECT * FROM category WHERE category_name =  " + "'" + categoryName + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryId(resultSet.getInt("category_id"));
                categoryDTO.setCategoryName(resultSet.getString("category_name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return categoryDTO;
    }

    public CategoryDTO getName(int id) {
        connectToDataBase();
        CategoryDTO categoryDTO = null;

        try {
            String query = "SELECT * FROM category WHERE category_id =  " + "'" + id + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryId(resultSet.getInt("category_id"));
                categoryDTO.setCategoryName(resultSet.getString("category_name"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return categoryDTO;
    }

    public List<CategoryDTO> listAll (){
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        connectToDataBase();
        try {
            String query = "SELECT * FROM category";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setCategoryId(resultSet.getInt("category_id"));
                categoryDTO.setCategoryName(resultSet.getString("category_name"));
                categoryDTOS.add(categoryDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryDTOS;
    }
}
