<%@page import="java.util.ArrayList"%>
<%@page import="com.org.nepmart.daoImpl.UsersDaoImpl"%>
<%@page import="com.org.nepmart.entities.Users"%>



<%

    ArrayList<Users> allUsers = new UsersDaoImpl().getAllUsers();
    int count = 1;
%>

<div class="card-container-fluid table-responsive-lg user-table mt-5" style="max-height: 75vh; overflow: auto;">
    <table class="table table-striped">
        <thead  class="thead-light">
            <tr>
                <th>S.N.</th>
                <th>FullName</th>
                <th>Username</th>
                <th>Email</th>
                <th>Contact</th>
                <th>Address</th>
                <th>Password</th>
                <th>UserType</th>
                <th class="text-center">Action</th>
            </tr>
        </thead>

        <tbody>

            <%
                for (Users user : allUsers) {
            %>

            <tr>
                <td><%= count++%></td>
                <td><%=user.getFname() + " " + user.getLname()%></td>
                <td><%=user.getUsername()%></td>
                <td><%=user.getUserEmail()%></td>
                <td><%=user.getUserPhone()%></td>
                <td><%=user.getUserAddress()%></td>
                <td><%=user.getUserPassword()%></td>
                <td><%=user.getUserType()%></td>
                <td class="text-center"><a href="delete?deleteId<%=user.getId()%>" 
                       onclick="confirm('Are you sure to delete this user?');"
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
