/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.entities;

/**
 *
 * @author Aashish Katwal
 */
public class Orders {

    private int orderId;
    private String orderedBy;

    public Orders() {
    }

    public Orders(int orderId, String orderedBy) {
        this.orderId = orderId;
        this.orderedBy = orderedBy;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(String orderedBy) {
        this.orderedBy = orderedBy;
    }

}
