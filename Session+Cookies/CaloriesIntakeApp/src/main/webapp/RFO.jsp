<%-- 
    Document   : RFO
    Created on : Jun 18, 2021, 4:08:01 PM
    Author     : Shahed
--%>

<%@page import="model.Fruit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%Fruit f = (Fruit) request.getAttribute("F");
        if (f!=null){
        
        %>
        <table border="1">
            <tr> <td colspan="2"> <img src="images/Fruits/<%=f.getPhoto()%>" width="190px" alt="<%=f.getName()%>"/> </td> </tr>
             <tr> <td colspan="2"> <%=f.getName()%> </td> </tr>
             <tr> <td>Grams:</td><td><%=f.getGrms()%></td> </tr>
             <tr> <td>Calories:</td><td> <%=f.getCalories()%> </td> </tr>
             <a href="FC?cmd=RFA">Back</a>
             <a href="FC?cmd=FAS&id=<%=f.getId()%>">Add to my list</a>
            </table>
             <%}%>
    </body>
</html>
