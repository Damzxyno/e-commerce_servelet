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
<h1>Log in page!</h1>
<div class="flex-item-right">
    <div class="shadow p-3 mb-5 bg-white rounded">
        <form action="<%=request.getContextPath()%>/AdminLoginServlet" method="POST">
            <!-- ################################################################# -->
            <div class="form-group">
                <input
                        id="email_input"
                        class="form-control form-control-lg"
                        type="text"
                        name="email"
                        placeholder="Email address"
                        required
                />
                <input
                        id="password_input"
                        class="form-control form-control-lg"
                        type="password"
                        name="password"
                        placeholder="Password"
                        required
                />
                <button
                        id="btn1"
                        type="submit"
                        class="btn btn-primary btn-lg btn-block"
                >
                    Log in
                </button>
            </div>
        </form>
        <p id="password">Forgotten password?</p>
        <hr/>
        <button
                onclick="modal()"
                id="btn2"
                type="button"
                class="btn btn-lg btn-block btn-lg btn-block"
        >
            Create New Account
        </button>
    </div>
    <p style="text-align: center; font-size: 14px">
        <a href="" style="text-decoration: none; color: black"
        ><strong>Create a Page</strong></a
        >
        for a celebrity, band or business.
    </p>
</div>

</body>
</html>
