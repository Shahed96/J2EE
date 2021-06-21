<%-- 
    Document   : RFA
    Created on : Jun 18, 2021, 3:37:51 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Fruit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RFA Page</title>
    </head>
    <body>
        <%
            ArrayList<Fruit> a = (ArrayList<Fruit>) request.getAttribute("FL");
            if (a != null) {
        %>
        <table> 
            <%for (Fruit fr : a) {%>
            <tr> <td><%=fr.getId()%> </td>  <td><a href="FC?cmd=FRO&id=<%=fr.getId()%>"> <%=fr.getName()%></a> </td></tr>

            <%}%>
        </table>
        <%}%>



        </br>
        </br>
        <h3> My List </h3>
        <%
            ArrayList<Fruit> ses = (ArrayList<Fruit>) request.getSession().getAttribute("se");
            if (ses != null) {
        %>

        <table border="1">
            <thead><th>No.</th> <th>Name</th> <th>Grams</th> <th>Calories</th>  </thead>
                <%int i = 1, grms = 0, cal = 0;%>
                <%for (Fruit fr : ses) {
                        //inside the loop, each iteration +
                        grms += fr.getGrms();
                        cal += fr.getCalories();
                %>
        <tr> <td><%=i++%> </td> <td><%=fr.getName()%> </td> <td><%=fr.getGrms()%> </td> <td><%=fr.getCalories()%> </td>   </tr>

        <%}%>
        <!-- after the loop, before ending the table show the total-->
        <tr ><td colspan="2">Totals</td><td ><%=grms%></td><td><%=grms%></td></tr>
    </table>
    <%}%>



</body>
</html>
