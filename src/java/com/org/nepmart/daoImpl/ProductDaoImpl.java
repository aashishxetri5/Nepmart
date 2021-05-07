/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.daoImpl;

import com.org.nepmart.dao.ProductDao;
import com.org.nepmart.entities.Products;
import com.org.nepmart.utility.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aashish Katwal
 */
public class ProductDaoImpl implements ProductDao {

    @Override
    public boolean addProduct(Products product) {
        boolean isUploaded = false;
        try {
            String sql = "insert into products (prod_title, prod_detail, prod_photo, prod_price, prod_discount,"
                    + " prod_quantity, quantity_sold, added_by, date, category_id) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setString(1, product.getProdName());
            pst.setString(2, product.getProdDetails());
            pst.setString(3, product.getPhoto());
            pst.setInt(4, product.getPrice());
            pst.setInt(5, product.getDiscount());
            pst.setInt(6, product.getQuantity());
            pst.setInt(7, product.getQuantitySold());
            pst.setString(8, product.getProdBy());
            pst.setString(9, product.getDate());
            pst.setInt(10, product.getCategoryId());
            pst.executeUpdate();

            new DBConnection().getConnection().close();
            isUploaded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUploaded;
    }

    @Override
    public ArrayList<Products> getAllProducts() {
        ArrayList<Products> allProducts = new ArrayList<>();
        try {
            String sql = "select * from products";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Products products = new Products();
                products.setProdId(rs.getInt("prod_id"));
                products.setProdName(rs.getString("prod_title"));
                products.setProdDetails(rs.getString("prod_detail"));
                products.setPhoto(rs.getString("prod_photo"));
                products.setPrice(rs.getInt("prod_price"));
                products.setDiscount(rs.getInt("prod_discount"));
                products.setQuantity(rs.getInt("prod_quantity"));
                products.setQuantitySold(rs.getInt("quantity_sold"));
                products.setProdBy(rs.getString("added_by"));
                products.setDate(rs.getString("date"));
                products.setCategoryId(rs.getInt("category_id"));
                allProducts.add(products);
            }
            new DBConnection().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProducts;
    }

    @Override
    public void updateProduct(int prodId) {
        try {
            String sql = "update products set prod_title = ?, prod_detail = ?, prod_photo = ?, prod_price = ?,"
                    + "prod_discount = ?,prod_quantity = ?, quantity_sold = ?, added_by = ?, date = ?, category_id = ?"
                    + "where prod_id = ?";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setInt(1, prodId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Products products = new Products();
                products.setProdId(rs.getInt("prod_id"));
                products.setProdName(rs.getString("prod_title"));
                products.setProdDetails(rs.getString("prod_detail"));
                products.setPhoto(rs.getString("prod_photo"));
                products.setPrice(rs.getInt("prod_price"));
                products.setDiscount(rs.getInt("prod_discount"));
                products.setQuantity(rs.getInt("prod_quantity"));
                products.setQuantitySold(rs.getInt("quantity_sold"));
                products.setProdBy(rs.getString("added_by"));
                products.setDate(rs.getString("date"));
                products.setCategoryId(rs.getInt("cat_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(int prodId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Products> productByCurrentUser(String username) {
        ArrayList<Products> productByThisUser = new ArrayList<>();
        try {
            String sql = "select * from products where added_by=?";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Products products = new Products();
                products.setProdId(rs.getInt("prod_id"));
                products.setProdName(rs.getString("prod_title"));
                products.setProdDetails(rs.getString("prod_detail"));
                products.setPhoto(rs.getString("prod_photo"));
                products.setPrice(rs.getInt("prod_price"));
                products.setDiscount(rs.getInt("prod_discount"));
                products.setQuantity(rs.getInt("prod_quantity"));
                products.setQuantitySold(rs.getInt("quantity_sold"));
                products.setProdBy(rs.getString("added_by"));
                products.setDate(rs.getString("date"));
                products.setCategoryId(rs.getInt("category_id"));
                productByThisUser.add(products);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productByThisUser;
    }

}
