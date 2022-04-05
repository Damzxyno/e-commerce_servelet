<div align="center">
    <h1 style="color: red">Damzxyno Store Administrative Board</h1>
    <h3> Welcome, <%= session.getAttribute("username")%>, <a href = "/LogOutServlet">Log out</a> </h3>

    <br>
    <b>
        <a href="admin/register_new_admin.jsp">Register New Admin</a>
        <a href="admin/view_all_categories.jsp">See all Categories</a>
        <a href="admin/view_all_products.jsp"> See all Products</a>
        <a href="admin/view_all_customers.jsp">See all Customers</a>
        <a href="admin/view_all_reviews.jsp">See all Reviews</a>
        <hr>
        <p style="color: #5cb85c">QUICK ACTIONS: </p>
        <a href="admin/create_new_product.jsp">Add New Product</a>
        <a href="admin/delete_product.jsp">Delete Product</a>
        <a href="admin/create_new_category.jsp">Create New Category</a>
    </b>
</div>