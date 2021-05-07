/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.daoImpl;

import com.org.nepmart.dao.OrderDao;
import com.org.nepmart.entities.Orders;
import java.util.ArrayList;

/**
 *
 * @author Aashish Katwal
 */
public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean addOrder(Orders order) {
        boolean hasUploaded = false;

        return hasUploaded;
    }

    @Override
    public ArrayList<Orders> getAllOrders() {
        ArrayList<Orders> allOrders = new ArrayList<>();

        return allOrders;
    }

}
