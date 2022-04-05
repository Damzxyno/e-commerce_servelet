<% String display = null;
    String role = (String) session.getAttribute("role");
    if (role == null){
        display = "<a href='user/login.jsp'>Sign In</a> |" +
                " <a href='user/register.jsp'>Register</a>";
    } else if (role.equals("user")) {
        display = "Welcome " + session.getAttribute("username") + " | " +
                "<a href ='/WishlistServlet'>My Wishlist</a> | " +

                "<a href='/LogOutServlet'>Log Out</a>";
    }
%>

<div align="center">
    <h1 style="color: red">WELCOME TO DAMZXYNO STORE</h1>
    <div><%=display%></div>&nbsp;&nbsp;&nbsp;&nbsp;
</div>