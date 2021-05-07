package com.org.nepmart.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.nepmart.daoImpl.UsersDaoImpl;
import com.org.nepmart.entities.Users;
import com.org.nepmart.utility.Helper;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckNewUser
 */
public class CheckNewUser extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsersDaoImpl udi = new UsersDaoImpl();
        Helper helper = new Helper();
        HttpSession session = request.getSession();
        
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String username = request.getParameter("uname");
        String userEmail = request.getParameter("email");
        String userPhone = request.getParameter("phoneNum");
        String userAddress = request.getParameter("address");
        String userPassword = helper.passwordEncryption(request.getParameter("pwd"));
        String userType = "Customer";
        
        if (udi.doesUserExist(username)) {
            session.setAttribute("message", "username already exists... Try new one");
            response.sendRedirect("home");
        } else {
            udi.addUser(new Users(fname, lname, username, userEmail, userPhone, userAddress, userPassword, userType));
            session.setAttribute("message", "Account Created Successfully");
            response.sendRedirect("home");
        }
        
    }
    
}
