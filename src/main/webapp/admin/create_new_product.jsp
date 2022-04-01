<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 29/03/2022
  Time: 18:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <%
        String login = "login.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(login);
        Object role =  session.getAttribute("role");
        if (role == null) requestDispatcher.forward(request, response);

    %>
    <title>Add new product</title>
    <style>
        form{

        }

        label {
            padding-bottom: 5px;
        }

    </style>
</head>
<body>
<hr>
<jsp:include page="utils/header.jsp" />
<hr>
<h2>Administrative Backend : Create New Product</h2>
    <form action="/AddNewProductServlet" method="post" >
       <label for="product_name">Product Name: </label> <input name="product_name" class="" type="" id="product_name" required />
       <label for="product_price">Product Price: </label> <input name="product_price" class="" type="number" id="product_price" required />
        <p>Product Category: <jsp:include page="utils/categories.jsp" /> </p>
        <label for="product_description">Product Description: </label> <input name="product_description" class="" type="" id="product_description" required />
        <button type="submit">Save</button>
    </form>
</body>
</html>
