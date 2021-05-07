/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.daoImpl;

import com.org.nepmart.dao.CategoryDao;
import com.org.nepmart.entities.Category;
import com.org.nepmart.utility.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aashish Katwal
 */
public class CategoryDaoImpl implements CategoryDao {

    @Override
    public boolean addCategory(Category category) {
        boolean isAdded = false;
        try {
            String sql = "insert into category (cat_title, cat_description) values (?,?)";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setString(1, category.getCatTitle());
            pst.setString(2, category.getCatDesription());
            pst.executeUpdate();

            new DBConnection().getConnection().close();
            isAdded = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

    @Override
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> allCategories = new ArrayList<>();
        try {
            String sql = "select * from category";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCatId(rs.getInt("cat_id"));
                category.setCatTitle(rs.getString("cat_title"));
                category.setCatDesription(rs.getString("cat_description"));
                allCategories.add(category);
            }
            new DBConnection().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allCategories;
    }

    @Override
    public int getCategoryIdByName(String catTitle) {
        int catId = 0;
        try {
            String sql = "select * from category where cat_title=?";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setString(1, catTitle);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getString("cat_title").equals(catTitle)) {
                    catId = rs.getInt("cat_id");
                }

            }
            new DBConnection().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catId;
    }

    public String getCategoryById(int catId) {
        String catTitle = "";
        try {
            String sql = "select * from category where cat_id=?";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setInt(1, catId);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt("cat_id") == catId) {
                    catTitle = rs.getString("cat_title");
                }

            }
            new DBConnection().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catTitle;
    }

}
