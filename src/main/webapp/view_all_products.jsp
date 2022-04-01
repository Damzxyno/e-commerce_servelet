<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 31/03/2022
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>View All Customers</title>
  <%
    String login = "login.jsp";
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(login);
    Object role =  session.getAttribute("role");
    if (role == null) requestDispatcher.forward(request, response);
  %>
</head>
<body>
<jsp:include page="utils/header.jsp" />;
<hr>
<h2>Administrative Backend : All Products</h2>
<jsp:include page="utils/products.jsp" />

</body>
</html>
