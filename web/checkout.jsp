
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" errorPage="pageNotFound.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width,maximum-scale=1 ,initial-scale=1.0" />

        <%@include file="components/all_css_js.jsp"%>

        <link rel="stylesheet" href="css/checkout.css" type="text/css"/>
        <title>Checkout</title>
    </head>
    <body>
        <%

            if (session.getAttribute("current-user") != null) {
                Users loggedUuser = (Users) session.getAttribute("current-user");


        %>

        <!--<div class="page-wrapper">-->
        <%@include file="components/navbar.jsp"%>

        <div class="card-container-fluid mb-3">
            <div class="row mt-4">
                <div class="col-lg-6 checkout-prods">
                    <!--cart items-->
                    <div class="card">
                        <div class="card-body">
                            <div class="cart-body">

                            </div>
                        </div>
                    </div>

                </div>
                
                <div class="col-lg-6 checkout-form">
                    <!--user detail for delivery-->

                    <div class="card">
                        <div class="card-body">

                            <%                                Users user = (Users) session.getAttribute("current-user");

                            %>

                            <form>
                                <input type="hidden" name="id" class="form-control" value="<%=user.getId()%>"  placeholder="Type your first name"/>

                                <label>First name</label>
                                <input type="text" name="fname" class="form-control" value="<%=user.getFname()%>" placeholder="Type your first name" required />

                                <label>Last name</label>
                                <input type="text" name="lname" class="form-control" value="<%=user.getLname()%>" placeholder="Type your last name" required />

                                <label>Email address</label>
                                <input type="email" name="email" class="form-control" value="<%=user.getUserEmail()%>" placeholder="Enter your Email" required="">
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>

                                <label>Phone Number</label>
                                <input type="text" name="phoneNum" class="form-control" value="<%=user.getUserPhone()%>" placeholder="Enter your Phone Number" required />

                                <label>Address</label>
                                <input type="text" name="address" class="form-control" placeholder="Enter your Address" required />

                                <div class="text-center form-group">
                                <input type="submit" name="checkout" class="btn btn-outline-info mt-4" value="Checkout" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <%@include file="components/footer.jsp" %>

    <%} else {
        session.setAttribute("location", "from login");
    %>


    <script>
        $(document).ready(function () {
            $("#loginModal").modal('show');
        });
    </script>

    <div class="modal fade" id="loginModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="staticBackdropLabel" style="font-family: Source Sans Pro, sans-serif;">
                        Please Login first to Order
                    </h5>
                </div>
                <div class="modal-body">
                    <form method="POST" action="login">
                        <div class="form-group">
                            <label>Username</label>
                            <input type="text" name="uName" class="form-control" placeholder="Type your username" required />
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="password" name="pwd" class="form-control" placeholder="Type your password" required />
                        </div>
                        <div class="form-group text-center">
                            <input type="submit" class="loginBtn" value="Login" />
                        </div>

                    </form>
                </div>
                <div class="modal-footer text-center">
                </div>
            </div>
        </div>
    </div>

    <%    }
    %>
    <!--</div>-->
</body>
</html>