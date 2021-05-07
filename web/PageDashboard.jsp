<%-- 
    Document   : dashboard
    Created on : Sep 8, 2020, 2:05:24 PM
    Author     : Aashish Katwal
--%>


<%
    if (session.getAttribute("current-user") != null) {
        Users loggedUuser = (Users) session.getAttribute("current-user");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <title>Dashboard</title>

        <%@include file="components/all_css_js.jsp" %>

        <link rel="stylesheet" href="css/dashboardLayout.css" type="text/css" />
        <script type="text/javascript" src="js/NavTriggerer.js"></script>

        <style>
            #profile{
                /*background: url("imgs/userProfile/default.jpg");*/
                height: 100px;
                width: 100px;
                border-radius: 50%;
                background-size: cover;
            }
        </style>



    </head>
    <body>
        <!--! For Mobile View -->

        <div class="header">
            <div class="logo">
                <i class="fa fa-tachometer"></i>
                <span>Dashboard </span>
            </div>
            <a style="cursor: pointer" class="nav-trigger"><span></span></a>
            <div class="backBtn">
                <a
                    class="fa fa-home" 
                    href="home">
                    Home
                </a>

            </div>
        </div>

        <!--! The side navbar starts from here -->

        <div class="side-nav">
            <div class="logo">
                <a href="dashboard?show=all">
                    <i class="fa fa-tachometer"></i>
                    <span>Dashboard</span>
                </a>
            </div>
            <nav>
                <ul>
                    <li>
                        <a href="dashboard?show=profile">
                            <span><i class="fa fa-user"></i></span>
                            <span>Profile</span>
                        </a>
                    </li>

                    <%                         if (loggedUuser.getUserType().equalsIgnoreCase("admin")) {
                    %>

                    <li>
                        <a href="dashboard?show=users">
                            <span><i class="fa fa-users"></i></span>
                            <span>Users</span>
                        </a>
                    </li>

                    <li>
                        <a href="dashboard?show=all categories">
                            <span><i class="fa fa-th-large"></i></span>
                            <span>All Categories</span>
                        </a>
                    </li>

                    <%}%>
                    <li>
                        <a href="dashboard?show=all products">
                            <span><i class="fas fa-box-open"></i></span>
                            <span>All Products</span>
                        </a>
                    </li>

                    <%                         if (loggedUuser.getUserType().equalsIgnoreCase("admin")) {
                    %>

                    <li>
                        <a href="dashboard?show=orders">
                            <span><i class="fas fa-business-time"></i></span>
                            <span>Orders</span>
                        </a>
                    </li>

                    <%}%>

                </ul>
            </nav>
        </div>

        <!--! Import the main content in here -->

        <div class="main-content">
            <div class="title" style="text-transform: capitalize;"><%= request.getParameter("show")%></div>


            <div class="main">

                <%                    if (request.getParameter("show").equalsIgnoreCase("profile") || request.getParameter("show").equalsIgnoreCase("all")) {
                %>

                <h4>Profile page...</h4>
                <%@include file="currentUserProfile.jsp" %>

                <% } else if (request.getParameter("show").equalsIgnoreCase("users")) {

                %>

                <%@include file="components/users.jsp"%>

                <% } else if (request.getParameter("show").equalsIgnoreCase("all categories")) {
                %>

                <%@include file="components/categories.jsp" %>

                <%} else if (request.getParameter("show").equalsIgnoreCase("all products")) {%>

                <%@include file="components/products.jsp"%>

                <%                } else if (request.getParameter("show").equalsIgnoreCase("orders")) {
                %>
                <%@include file="components/orders.jsp"%>
                <%}%>
            </div>
        </div>
    </body>
</html>

<%
    } else {
        response.sendRedirect("home");
    }
%>