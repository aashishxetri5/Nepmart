/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.org.nepmart.servlets;

import com.org.nepmart.daoImpl.CategoryDaoImpl;
import com.org.nepmart.daoImpl.ProductDaoImpl;
import com.org.nepmart.entities.Products;
import com.org.nepmart.entities.Users;
import com.org.nepmart.utility.Helper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Aashish Katwal
 */
@WebServlet(urlPatterns = {"/addProduct"})
@MultipartConfig
public class ProductUpload extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ProductDaoImpl pdi = new ProductDaoImpl();
        CategoryDaoImpl cdi = new CategoryDaoImpl();
        Helper help = new Helper();

        try (PrintWriter out = response.getWriter()) {

            /* Code to add product with its image */
            // taking of product info
            String productName = request.getParameter("pTitle").trim();
            String productDetail = request.getParameter("pDesc").trim();
            int productPrice = Integer.parseInt(request.getParameter("pPrice").trim());
            int discount = Integer.parseInt(request.getParameter("discount").trim());
            int productQty = Integer.parseInt(request.getParameter("pQty").trim());
            int qtySold = 0;
            String catTitle = request.getParameter("category");//from dropdown
            Users currentUser = (Users) session.getAttribute("current-user");
            String addedBy = currentUser.getUsername();
            //# taking of basic product info ends

            //gives uploaded file name's photo
            Part part = request.getPart("pImg");
            String imgName = part.getSubmittedFileName();

            //# photo name extraction ends
            // gives the uploaded date
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String uploadDate = formatter.format(date);
            //# date extracting ends

            Products product = new Products(productName, productDetail, productPrice, discount, productQty, qtySold,
                    imgName, addedBy, uploadDate, cdi.getCategoryIdByName(catTitle));

            pdi.addProduct(product);

//            Image save to local folder 
            String path = request.getRealPath("image") + File.separator + "productImg" + File.separator + imgName;

            help.imageUpload(part, path);
            response.sendRedirect("dashboard?show=all products");

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
