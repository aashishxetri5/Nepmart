/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.dao;

import com.org.nepmart.entities.Products;
import java.util.ArrayList;

/**
 *
 * @author Aashish Katwal
 */
public interface ProductDao {

    public boolean addProduct(Products product);

    public ArrayList<Products> getAllProducts();

    public void updateProduct(int prodId);

    public void deleteProduct(int prodId);

    public ArrayList<Products> productByCurrentUser(String username);

}
