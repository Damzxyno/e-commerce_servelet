<%
    String login = "login.jsp";
    RequestDispatcher requestDispatcher = request.getRequestDispatcher(login);
    Object role =  (String) session.getAttribute("role");
    if (role == null) requestDispatcher.forward(request, response);
    if (!role.equals("admin") )requestDispatcher.forward(request, response);
%>