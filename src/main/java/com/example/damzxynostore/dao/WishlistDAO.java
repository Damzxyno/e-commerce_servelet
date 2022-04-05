package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.WishlistDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishlistDAO extends GenericDAO<WishlistDTO> {

    @Override
    public boolean create(WishlistDTO wishlistDTO) {
        connectToDataBase();
        String query = "INSERT INTO wishlist (customer_id, product_id) values (?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, wishlistDTO.getCustomer_id());
            preparedStatement.setInt(2, wishlistDTO.getProduct_id());
            preparedStatement.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<WishlistDTO> getWishLists (int customer_id){
        List<WishlistDTO> wishlistDTOS = new ArrayList<>();
        connectToDataBase();
        String query = "SELECT * FROM wishlist WHERE customer_id = '" + customer_id + "'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                WishlistDTO wishlistDTO = new WishlistDTO();
                wishlistDTO.setProduct_id(resultSet.getInt("product_id"));
                wishlistDTO.setCustomer_id(resultSet.getInt("customer_id"));
                wishlistDTOS.add(wishlistDTO);
            }
            closeDatabaseConnection();
            return wishlistDTOS;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
