package com.example.damzxynostore.dao;

import com.example.damzxynostore.dao.common.GenericDAO;
import com.example.damzxynostore.entities.WishlistDTO;

public class WishlistDAO extends GenericDAO<WishlistDTO> {

    @Override
    public boolean create(WishlistDTO element) {
        return false;
    }
}
