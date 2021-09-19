<%-- 
    Document   : last
    Created on : Jun 17, 2021, 4:58:33 PM
    Author     : Shahed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Data in session</h1>
        <!--Get the session (cube) -->
        <%HttpSession ses =request.getSession(); %>
        <h3> <%=ses.getAttribute("name123")%></h3>
        <h3> <%=ses.getAttribute("mail")%></h3>
        <h3> <%=ses.getAttribute("address")%></h3>
    </body>
</html>
