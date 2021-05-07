<%@page import="com.org.nepmart.entities.Users"%>
<%

    Users currentUser = (Users) session.getAttribute("current-user");

%>

<nav class="navbar navbar-expand-md navbar-dark custom-bg px-4 py-3">
    <a class="navbar-brand" href="home">Nep<b>Mart</b></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse text-center mx-5" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="home"> Home </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="about"> About Us </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="shop"> Shop </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="contactUs"> Contact </a>
            </li>

        </ul>

        <ul class="navbar-nav ml-auto right-menu">
            <li class="nav-item">
                <a style="cursor: pointer" class = "nav-link cart" data-toggle="modal" data-target="#cartModal">
                    <i class="fas fa-shopping-cart"></i><span class="cart-items">(0)</span>
                </a>
            </li>

            <%                if (currentUser == null) {

            %>
            <li class="nav-item">
                <a class = "nav-link login-btn" data-toggle="modal" data-target="#loginModal">Login</a>
            </li>
            <li class="nav-item ml-2">
                <button type = "button" class="btn btn-primary navbar-btn" data-toggle="modal" data-target="#signUpModal">
                    Sign Up
                </button>
            </li>
            <%            } else {
            %>
            <li class="nav-item">
                <a class = "nav-link cUser"><%=currentUser.getUsername()%></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    More
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="dashboard?show=all"> Dashboard </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="logout">Logout</a>
                </div>
            </li>
            <%
                }
            %>

        </ul>

    </div>
</nav>

<!--Modals--> 

<!--Login modal-->

<div class="modal fade" id="loginModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Login</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
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
                        <input type="submit" class="loginBtn" name="loginBtnHome" value="Login" />
                    </div>

                </form>
            </div>
            <div class="modal-footer text-center">
            </div>
        </div>
    </div>
</div>

<!--SignUp modal-->

<div class="modal fade" id="signUpModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Registration</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="POST" action="user-verify">
                    <div class="form-group">
                        <label>First name</label>
                        <input type="text" name="fname" class="form-control" placeholder="Type your first name" required />

                        <label>Last name</label>
                        <input type="text" name="lname" class="form-control" placeholder="Type your last name" required />

                        <label>Username</label>
                        <input type="text" name="uname" class="form-control" placeholder="Type your Username" required />
                        <small class="form-text text-danger">You won't be able to change your username!! </small>

                        <label>Email address</label>
                        <input type="email" name="email" class="form-control" placeholder="Enter your Email" required="">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>

                        <label>Phone Number</label>
                        <input type="text" name="phoneNum" class="form-control" placeholder="Enter your Phone Number" required />

                        <label>Address</label>
                        <input type="text" name="address" class="form-control" placeholder="Enter your Address" required />

                        <label>Password</label>
                        <input type="password" name="pwd" class="form-control" placeholder="Type your password" minlength="6" required />
                    </div>

                    <div class="form-group text-center">
                        <input type="submit" class="regisBtn" value="Sign Up" />
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>


<!--Cart Modal-->


<div class="modal fade bd-example-modal-lg" id="cartModal" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel"> Cart </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="cart-body">

                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary checkout-btn" onclick="checkout()"> Checkout </button>
            </div>
        </div>
    </div>
</div>