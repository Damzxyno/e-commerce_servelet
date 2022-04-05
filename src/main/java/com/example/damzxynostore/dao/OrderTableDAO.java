package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.OrderTableDTO;


import java.sql.PreparedStatement;
import java.sql.SQLException;

public  class OrderTableDAO extends GenericDAO<OrderTableDTO> {

    @Override
    public boolean create(OrderTableDTO orderTableDTO) {
        connectToDataBase();
        String query = "INSERT INTO order_table (customer_id, order_date, order_total, order_status) values (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, orderTableDTO.getCustomerId());
            preparedStatement.setDate(2, new java.sql.Date(orderTableDTO.getOrderDate().getTime()));
            preparedStatement.setDouble(3, orderTableDTO.getOrderTotal());
            preparedStatement.setString(4, "Pending");
            preparedStatement.execute();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
