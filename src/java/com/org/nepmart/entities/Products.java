/**
 *
 */
package com.org.nepmart.entities;

/**
 * @author Aashish Katwal
 *
 */
public class Products {

    private int prodId, price, discount, quantity, quantitySold, catId;
    private String prodName, prodDetails, photo, prodBy, date;

    public Products() {
    }

    public Products(int prodId, int price, int discount, int quantity, int quantitySold, String prodName,
            String prodDetails, String photo, String prodBy, String date, int catId) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodDetails = prodDetails;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.quantitySold = quantitySold;
        this.photo = photo;
        this.prodBy = prodBy;
        this.date = date;
        this.catId = catId;
    }

    public Products(String prodName, String prodDetails, int price, int discount, int quantity, int quantitySold,
            String photo, String prodBy, String date, int catId) {
        this.prodName = prodName;
        this.prodDetails = prodDetails;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.quantitySold = quantitySold;
        this.photo = photo;
        this.prodBy = prodBy;
        this.date = date;
        this.catId = catId;
    }

//TO PLACE ORDER AT ORDERS TABLE
    public Products(int prodId, int price, int discount, int quantity, int catId, String prodName, String prodDetails, String photo, String date) {
        this.prodId = prodId;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.catId = catId;
        this.prodName = prodName;
        this.prodDetails = prodDetails;
        this.photo = photo;
        this.date = date;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDetails() {
        return prodDetails;
    }

    public void setProdDetails(String prodDetails) {
        this.prodDetails = prodDetails;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getProdBy() {
        return prodBy;
    }

    public void setProdBy(String prodBy) {
        this.prodBy = prodBy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCategoryId() {
        return catId;
    }

    public void setCategoryId(int catId) {
        this.catId = catId;
    }

    @Override
    public String toString() {
        return "Products{" + "id=" + prodId + ", price=" + price + ", discount=" + discount + ", quantity=" + quantity + ", quantitySold=" + quantitySold + ", prodName=" + prodName + ", prodDetails=" + prodDetails + ", photo=" + photo + ", prodBy=" + prodBy + ", date=" + date + '}';
    }

}
