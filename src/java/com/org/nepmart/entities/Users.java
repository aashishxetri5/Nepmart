/**
 *
 */
package com.org.nepmart.entities;

/**
 * @author Aashish Katwal
 *
 */
public class Users {

    private int id;
    private String fname, lname, username, userEmail, userPhone, userAddress, userPassword, userType;

    public Users() {
    }

    public Users(String fname, String lname, String username, String userEmail, String userPhone, String userAddress,
            String userPassword, String userType) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public Users(int id, String fname, String lname, String username, String userEmail, String userPhone,
            String userAddress, String userPassword, String userType) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

}
