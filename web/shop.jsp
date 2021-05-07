<%-- 
    Document   : shop
    Created on : Sep 11, 2020, 3:28:31 PM
    Author     : Aashish Katwal
--%>

<%@page import="com.org.nepmart.utility.Helper"%>
<%@page import="com.org.nepmart.daoImpl.ProductDaoImpl"%>
<%@page import="com.org.nepmart.entities.Products"%>
<%@page import="com.org.nepmart.daoImpl.CategoryDaoImpl"%>
<%@page import="com.org.nepmart.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,maximum-scale=1 ,initial-scale=1.0" />
        <title> Shop </title>

        <%@include file="components/all_css_js.jsp" %>
        <link rel="stylesheet" href="css/sidebar.css" />
        <!--<link rel="stylesheet" href="css/shop.css" />-->

    </head>
    <body>
        <%@include file="components/navbar.jsp" %>

        <section style="min-height: 60vh">

            <!--Show Categories-->

            <%                    ArrayList<Category> allCategories = new CategoryDaoImpl().getAllCategories();
            %>

            <div class="sidebar-container">
                <div class="hamburger-menu-btn">
                    <span class="fas fa-bars"></span>
                </div>

                <aside class="sidebar">
                    <ul>
                        <li>
                            <a href="shop">All</a>
                        </li>
                        <%
                            for (Category category : allCategories) {
                        %>

                        <li>
                            <a href="shop"><%=category.getCatTitle()%></a>
                        </li>

                        <%
                            }
                        %>
                    </ul>
                </aside>
            </div>


            <div class="container-fluid">
                <div class="row row-cols-1 row-cols-md-3">
                    <!--<div class="col mb-"></div>-->
                    <!--<div class="col mb-4">-->
                    <!--<div class="card-deck">-->

                    <%
                        ArrayList<Products> allProducts = new ProductDaoImpl().getAllProducts();

                        for (Products product : allProducts) {
                            int price = new Helper().getDiscountedPrice(product.getPrice(), product.getDiscount());
                    %>

                    <div class="col mb-4">
                        <div class="card h-100">
                            <img src="image/productImg/nuts.jpeg" height="150px" width="100px" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </div>

</section>

<%@include file="components/footer.jsp" %>


</body>
</html>
