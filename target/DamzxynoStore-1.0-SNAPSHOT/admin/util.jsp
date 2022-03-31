<%
    String username = (String) session.getAttribute("username");
%>


<div align="center">
    <p>Welcome <%= username %></p>
    <a href = "/LogOutServlet">Log out</a>
    <br>

    <b>
        <a href="">Admin</a>
        <a href="admin/view_all_customers.jsp">Categories</a>
        <a href="">Products</a>
        <a href="">Customers</a>
        <a href="">Reviews</a>
    </b>
</div>