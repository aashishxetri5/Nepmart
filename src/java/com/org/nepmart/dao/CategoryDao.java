/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.dao;

import com.org.nepmart.entities.Category;
import java.util.ArrayList;

/**
 *
 * @author Aashish Katwal
 */
public interface CategoryDao {
    
    public boolean addCategory(Category category);
    
    public ArrayList<Category> getAllCategories();
    
    public int getCategoryIdByName(String catTitle);
    
}
