package com.org.nepmart.dao;

import com.org.nepmart.entities.Users;
import java.util.List;

public interface UserDao {

	public void addUser(Users user);

	public List<Users> getAllUsers();

	public void updateUser(Users user);

	public Users getUserByUName(String uName);

	public void deleteUser(String uName);

        public boolean doesUserExist(String uName);
        
        public boolean isUserValid(String uName, String password);
        
        public List<Users> getSearchedUser(String searchValue);
}
