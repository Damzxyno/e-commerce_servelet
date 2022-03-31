package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.CategoryDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
}