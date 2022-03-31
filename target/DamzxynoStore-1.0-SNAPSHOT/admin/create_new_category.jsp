<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 31/03/2022
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Damzxyno Store - Create New Category</title>
    <%
        String login = "login.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(login);
        Object role =  session.getAttribute("role");
        if (role == null) requestDispatcher.forward(request, response);
    %>
</head>
<body>
<form action="/AddNewCategoryServlet" method="post" >
    <label for="category_name">Category Name: </label> <input name="category_name" class="" type="" id="category_name" required/>
    <button type="submit">Save</button>
</form>
</body>
</html>
