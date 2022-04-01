<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 01/04/2022
  Time: 06:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="utils/header.jsp" />
<br />
        <form action="${pageContext.request.contextPath}/RegisterNewAdminServlet" method="post">
            <label for = "last_name">Last Name: </label>
            <input required type="text" name="last_name" id="last_name" max="18" />

            <label for = "first_name">First Name: </label>
            <input required type="text" name="first_name" id="first_name" max="18" />

            <label for = "email">E-mail: </label>
            <input required type="email" name="email" id="email" max="18" />

            <label for = "password">Password: </label>
            <input required type="password" name="password" id="password" max="18" />

            <button type="submit">Register New Admin</button>
        </form>


</body>
</html>
