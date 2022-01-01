<%-- 
    Document   : exception
    Created on : Dec 20, 2021, 8:55:49 PM
    Author     : DELL
--%>

<%@page import="exceptions.StudentNotFoundException"%>
<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>OOOPs! there are Exceptions</h1>
        <%=exception.getMessage()%>
    </body>
</html>
