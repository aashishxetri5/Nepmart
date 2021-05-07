<%@page import="com.org.nepmart.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.org.nepmart.daoImpl.CategoryDaoImpl"%>



<%

    ArrayList<Category> allCategories = new CategoryDaoImpl().getAllCategories();
    int count = 1;
%>

<div class="card-container my-3">
    <button class="btn btn-danger fa fa-plus font-weight-bold py-2" data-toggle="modal" data-target="#addCategory" > 
        Add Category 
    </button>
</div>
<div class="card-container-fluid table-responsive-lg user-table mt-2" style="max-height: 70vh; overflow: auto; display: block">

    <br>
    <table class="table table-striped">
        <thead  class="thead-light">
            <tr>
                <th>S.N.</th>
                <th>Category ID</th>
                <th>Category Name</th>
                <th>Category Detail</th>
                <th colspan="2">Action</th>

            </tr>
        </thead>

        <tbody>

            <%
                for (Category category : allCategories) {
            %>

            <tr>
                <td><%= count++%></td>
                <td><%=category.getCatId()%></td>
                <td><%=category.getCatTitle()%></td>
                <td><%=category.getCatDesription()%></td>
                <td class="text-center">
                    <a href="edit?editedId<%=category.getCatId()%>" 
                       class="fa fa-edit  text-info EditBtn">
                    </a>
                </td>
                <td class="text-center">
                    <a href="delete?deletedId<%=category.getCatId()%>" 
                       onclick="confirm('Are you sure to delete this category?');"
                       class="fa fa-trash text-danger DltBtn">
                    </a> 
                </td>
            </tr>
            <%
                }
            %>

        </tbody>
    </table>
</div>


<!--ADD CATEGORY MODAL-->

<div class="modal fade" id="addCategory" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Add New Category</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="get" action="addCategory">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="col-form-label">Category Title</label>
                        <input type="text" class="form-control" name="categoryTitle"placeholder="Enter Category Title" required/>
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="col-form-label">Category Details</label>
                        <textarea class="form-control" style="resize: none;" name="categoryDetail"
                                  placeholder="Enter Category Details" /></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" name="addCategory" value="addCat" class="btn btn-primary mb-3">Add</button>
                </div>
            </form>
        </div>
    </div>
</div>

