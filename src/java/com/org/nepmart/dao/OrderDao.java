/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.dao;

import com.org.nepmart.entities.Orders;
import java.util.ArrayList;

/**
 *
 * @author Aashish Katwal
 */
public interface OrderDao {

    public boolean addOrder(Orders order);

    public ArrayList<Orders> getAllOrders();

}
