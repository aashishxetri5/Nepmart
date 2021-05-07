/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aashish Katwal
 */
public class Category {

    private int catId;
    private String catTitle, catDesription;
    private List<Products> products = new ArrayList<>();

    public Category() {
    }

    public Category(int catId, String catTitle, String catDesription) {
        this.catId = catId;
        this.catTitle = catTitle;
        this.catDesription = catDesription;
    }
    
    public Category(String catTitle, String catDesription, List<Products> products) {
        this.catTitle = catTitle;
        this.catDesription = catDesription;
        this.products = products;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatTitle() {
        return catTitle;
    }

    public void setCatTitle(String catTitle) {
        this.catTitle = catTitle;
    }

    public String getCatDesription() {
        return catDesription;
    }

    public void setCatDesription(String catDesription) {
        this.catDesription = catDesription;
    }

    @Override
    public String toString() {
        return "Category{" + "catId=" + catId + ", catTitle=" + catTitle + ", catDesription=" + catDesription + '}';
    }

}
