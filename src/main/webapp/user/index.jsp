<% Object String; %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home | Damzxyno Store</title>
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/display.css">
</head>
<body>
   <jsp:include page="util/header.jsp" />
   <form action="${request.getContextPath()}/SaveProductServlet" method="post">
       <jsp:include page="util/main.jsp" />
   </form>
   <jsp:include page="util/footer.jsp" />
</body>
</html>