package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.ProductDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends GenericDAO<ProductDTO> {

//    public void create (String  ) {
//
//
//

    @Override
    public boolean create(ProductDTO productDTO) {
        connectToDataBase();
        String query = "INSERT INTO product(product_id, product_name, image, price, description, category_id) " +
                        "VALUES(?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, productDTO.getProductId());
            preparedStatement.setString(2, productDTO.getProductName());
            preparedStatement.setByte(3, productDTO.getImage());
            preparedStatement.setDouble(4, productDTO.getPrice());
            preparedStatement.setString(5, productDTO.getDescription());
            preparedStatement.setInt(6, productDTO.getCategoryId());
            preparedStatement.execute();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeDatabaseConnection();
        }
        return false;
    }


    public List<ProductDTO> listAll (){
        List<ProductDTO> productDTOS = new ArrayList<>();

        connectToDataBase();
        try {
            String query = "SELECT * FROM product";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setProductId(resultSet.getInt("product_id"));
                productDTO.setProductName(resultSet.getString("product_name"));
                productDTO.setPrice(resultSet.getDouble("price"));
                productDTO.setDescription(resultSet.getString("description"));
                productDTO.setCategoryId(resultSet.getInt("category_id"));
                productDTOS.add(productDTO);
            }
            closeDatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productDTOS;
    }

    public void delete (String productName){
        connectToDataBase();
        try {
            String query = "DELETE FROM product WHERE product_name = '" + productName + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            closeDatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
