<%--
  Created by IntelliJ IDEA.
  User: decagon
  Date: 29/03/2022
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration Login</title>
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../css/home.css">
</head>
<body>
<center><h1 style="color: red; justify-self: center;">Welcome To Damzxyno Store!</h1>
    <h2>Administrative Log In</h2>
</center>
    <h3>Log in page!</h3>
        <form action="<%=request.getContextPath()%>/AdminLoginServlet" method="POST">
            <input id="email_input" class="form-control form-control-lg" type="text" name="email" placeholder="Email address"  required/>
            <input id="password_input" class="form-control form-control-lg" type="password" name="password" placeholder="Password" required/>
            <button id="btn1" type="submit" class="btn btn-primary btn-lg btn-block">Log in</button>
        </form>
</body>
</html>
