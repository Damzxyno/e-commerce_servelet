<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 31/03/2022
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Damzxyno Store - Administration Page: Delete Product</title>
    <%
        String login = "login.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(login);
        Object role =  session.getAttribute("role");
        if (role == null) requestDispatcher.forward(request, response);
    %>
</head>
<body>
<jsp:include page="utils/header.jsp" />;
    <form action="/DeleteProductServlet" method="post">
        <jsp:include page="utils/products_checked_input.jsp" />
        <button type="submit">Delete All Checked</button>
    </form>
</body>
</html>
