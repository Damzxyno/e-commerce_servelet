package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.ProductDTO;

import java.sql.PreparedStatement;

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

           return preparedStatement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            closeDatabaseConnection();
        }
        return false;
    }
}
