<%@page import="com.org.nepmart.entities.Users"%>
<%@page import="com.org.nepmart.entities.Category"%>
<%@page import="com.org.nepmart.daoImpl.CategoryDaoImpl"%>
<%@page import="com.org.nepmart.entities.Products"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.org.nepmart.daoImpl.ProductDaoImpl"%>



<%
    ArrayList<Products> allProducts = new ArrayList();
    Users loggedInUser = (Users) session.getAttribute("current-user");

    if (loggedInUser.getUserType().equalsIgnoreCase("admin")) {
        allProducts = new ProductDaoImpl().getAllProducts();
    } else if (loggedInUser.getUserType().equalsIgnoreCase("customer") || loggedInUser.getUserType().equalsIgnoreCase("seller")) {
        allProducts = new ProductDaoImpl().productByCurrentUser(loggedInUser.getUsername());
    }
    int count = 1;
%>

<div class="card-container my-3">
    <button class="btn btn-danger fa fa-plus font-weight-bold py-2" data-toggle="modal" data-target="#addProduct" > 
        Add Product
    </button>
</div>

<div class="card-container-fluid table-responsive-lg  user-table mt-2" style="max-height: 70vh; overflow: auto;">
    <table class="table">
        <thead  class="thead-light">
            <tr>
                <th>S.N.</th>
                <th>ProductName</th>
                <th>Product Detail</th>
                <th>Photo</th>
                <th>Price(Rs)</th>
                <th>Discount</th>
                <th>Quantity</th>
                <th>Qty Sold</th>
                <th>Uploaded By</th>
                <th>Date Uploaded</th>
                <th>Category</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>

        <tbody>

            <%
                for (Products product : allProducts) {
            %>

            <tr>
                <td><%= count++%></td>
                <td><%=product.getProdName()%></td>
                <td><%=product.getProdDetails()%></td>
                <td>
                    <img src="image/productImg/<%=product.getPhoto()%>" height="50px" width="50px" />
                </td>
                <td><%=product.getPrice() + "/-"%></td>
                <td><%=product.getDiscount()%></td>
                <td><%=product.getQuantity()%></td>
                <td><%=product.getQuantitySold()%></td>
                <td><%=product.getProdBy()%></td>
                <td><%=product.getDate()%></td>
                <td><%=new CategoryDaoImpl().getCategoryById(product.getCategoryId())%></td>

                <td class="text-center">

                    <a href="edit?editedId<%=product.getProdId()%>" 
                       class="fa fa-edit text-info catDltBtn">
                    </a>
                </td>

                <td class="text-center">

                    <a href="delete?edletedId<%=product.getProdId()%>" 
                       onclick="confirm('Are you sure to delete this product?');"
                       class="fa fa-trash text-danger catDltBtn">
                    </a>
                </td>
            </tr>
            <%
                }

            %>

        </tbody>
    </table>
</div>


<script type="text/javascript">
    $(document).ready(function () {
        $('.fileUpload').bind("click", function ()
        {
            var imgVal = $('.fileUpload').val();
            if (imgVal === '')
            {

                $('.addBtn').attr("disabled");
//                return false;
            }


        });
    });
</script> 


<!--ADD PRODUCT MODAL-->

<div class="modal fade" id="addProduct" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add New Category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="post" action="addProduct" enctype="multipart/form-data">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-form-label">Product Name</label>
                        <input type="text" class="form-control" name="pTitle"placeholder="Enter Product Name" required />
                    </div>
                    <div class="form-group">
                        <label class="col-form-label">Product Details</label>
                        <textarea class="form-control" style="resize: none;" name="pDesc"
                                  placeholder="Enter Product Details" required/></textarea>
                    </div>
                    <div class="form-row">
                        <div class="col-md-4 mb-3">
                            <label> Price </label>
                            <input type="text" class="form-control" name="pPrice" placeholder="Product Price" required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label> Discount </label>
                            <input type="text" class="form-control" name="discount" placeholder="Disocunt" required>
                        </div>
                        <div class="col-md-4 mb-3">
                            <label> Quantity </label>
                            <input type="text" class="form-control" name="pQty" placeholder="Available Quantity" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-form-label"> Category </label>
                        <select class="form-control custom-select" name="category" required>
                            <%                                ArrayList<Category> allCategories = new CategoryDaoImpl().getAllCategories();
                                for (Category categories : allCategories) {
                            %>
                            <option><%= categories.getCatTitle()%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="file" class="fileUpload" name="pImg" required/>
                        <small class="form-text text-muted">You won't be able to change your image!!</small>
                    </div>

                    <button type="sumbit" name="addProduct" class="btn btn-primary addBtn" value="addProduct"> ADD </button>
                </div>
            </form>
            <div class="modal-footer mb-3">
            </div>
        </div>
    </div>
</div>

