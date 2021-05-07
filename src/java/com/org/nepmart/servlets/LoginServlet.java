/**
 *
 */
package com.org.nepmart.servlets;

import com.org.nepmart.daoImpl.UsersDaoImpl;
import com.org.nepmart.entities.Users;
import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Aashish Katwal
 *
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        UsersDaoImpl udi = new UsersDaoImpl();

        String uname = request.getParameter("uName");
        String pwd = request.getParameter("pwd");

        if (udi.isUserValid(uname, pwd)) {
            Users user = udi.getUserByUName(uname);
            session.setAttribute("current-user", user);
        } else {
            session.setAttribute("message", "Either Username or Password did not match!!");
        }
        if (session.getAttribute("location") != null) {
            response.sendRedirect("checkout");
        } else if(request.getParameter("loginBtnHome") != null){
            
            response.sendRedirect("home");
        }

    }

}
