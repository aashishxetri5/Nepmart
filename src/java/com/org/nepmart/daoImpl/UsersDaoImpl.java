package com.org.nepmart.daoImpl;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.org.nepmart.dao.UserDao;
import com.org.nepmart.entities.Users;
import com.org.nepmart.utility.DBConnection;
import com.org.nepmart.utility.Helper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersDaoImpl implements UserDao {

    Helper helper = new Helper();

    @Override
    public void addUser(Users user) {
        try {
            String sql = "insert into users (fname, lname, username, user_password, user_phone, user_address, "
                    + "user_email, user_type) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setString(1, user.getFname());
            pst.setString(2, user.getLname());
            pst.setString(3, user.getUsername());
            pst.setString(4, user.getUserPassword());
            pst.setString(5, user.getUserPhone());
            pst.setString(6, user.getUserAddress());
            pst.setString(7, user.getUserEmail());
            pst.setString(8, user.getUserType());
            pst.executeUpdate();

            new DBConnection().getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Users> getAllUsers() {
        ArrayList<Users> allUsers = new ArrayList<>();
        try {

            String sql = "select * from users";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setId(rs.getInt("user_id"));
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setUsername(rs.getString("username"));
                user.setUserPassword(helper.passwordDecryption(rs.getString("user_password")));
                user.setUserPhone(rs.getString("user_phone"));
                user.setUserAddress(rs.getString("user_address"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserType(rs.getString("user_type"));
                allUsers.add(user);
            }
            new DBConnection().getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allUsers;
    }

    @Override
    public void updateUser(Users user) {
        try {
            String sql = "update user set fname=?, lname=?, username=?, user_password=?, user_phone=?, user_address=?, "
                    + "user_email=?, user_type=? where id=?";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setString(1, user.getFname());
            pst.setString(2, user.getLname());
            pst.setString(3, user.getUsername());
            pst.setString(4, user.getUserPassword());
            pst.setString(5, user.getUserPhone());
            pst.setString(6, user.getUserAddress());
            pst.setString(7, user.getUserEmail());
            pst.setString(8, user.getUserType());
            pst.setInt(8, user.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Users getUserByUName(String uName) {
        Users user = new Users();
        try {
            String sql = "select * from users where username=?";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setString(1, uName);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user.setFname(rs.getString("fname"));
                user.setLname(rs.getString("lname"));
                user.setUsername(rs.getString("username"));
                user.setUserPassword(helper.passwordDecryption(rs.getString("user_password")));
                user.setUserPhone(rs.getString("user_phone"));
                user.setUserAddress(rs.getString("user_address"));
                user.setUserEmail(rs.getString("user_email"));
                user.setUserType(rs.getString("user_type"));
            }
            new DBConnection().getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    @Override
    public void deleteUser(String uName) {
        try {
            String sql = "delete from users where uName = ?";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            pst.setString(1, uName);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean doesUserExist(String uName) {
        boolean isFound = false;
        try {
            String sql = "select * from users";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (uName.equalsIgnoreCase(rs.getString("username"))) {
                    isFound = true;
                    break;
                }
            }
            new DBConnection().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isFound;
    }

    @Override
    public boolean isUserValid(String uName, String password) {
        boolean isValidUser = false;
        try {
            String sql = "select * from users";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (uName.equals(rs.getString("username")) && password.equals(helper.passwordDecryption(rs.getString("user_password")))) {
                    isValidUser = true;
                    break;
                }
            }
            new DBConnection().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(UsersDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValidUser;
    }

    @Override
    public List<Users> getSearchedUser(String searchValue) {
        List<Users> searchedUsers = new ArrayList<>();
        try {
            String sql = "select * from users ";
            PreparedStatement pst = new DBConnection().getConnection().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchedUsers;
    }

}
