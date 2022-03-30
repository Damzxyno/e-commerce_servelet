<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 29/03/2022
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Successful registration</title>
</head>
<body>
    <h1> Successful Registration</h1>
    <%
        HttpSession session1 = request.getSession();
        System.out.println(session1.getAttribute("email"));
    %>
    <a href="../index.jsp">Go back to Main page to start Shopping</a>
</body>
</html>
