<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 29/03/2022
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<jsp:include page="utils/dispatcher.jsp" />--%>

<%
    String login = "login.jsp";
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(login);
    Object role =  (String) session.getAttribute("role");
    if (role == null) requestDispatcher.forward(request, response);
    if (!role.equals("admin") )requestDispatcher.forward(request, response);
%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Damzxyno Store Administration Dashboard</title>

</head>
<body>
<jsp:include page="utils/header.jsp" />;
<hr>


</nav>
</div>


</body>
</html>