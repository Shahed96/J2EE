<%-- 
    Document   : RBCA
    Created on : Jun 6, 2021, 5:37:20 PM
    Author     : DELL
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.*, Services.*, controller.*"%>




<!DOCTYPE html>

<html>
    <head>
        
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    
        <!--bootstrap-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
        <!--CSS-->
       <style><%@include file="/WEB-INF/css/style.css"%></style>

       
        <title>BCRA</title>
    </head>
    <body>
        <a href="Add.jsp" title="Add" class=" btn btn-primary my-st">Add</a>
        <a href="BC?cmd=BCS" title="Save" class="btn btn-primary my-st">Save</a>
        <%
            ArrayList<BC> a =(ArrayList<BC>) request.getAttribute("bcv");
            if (a!= null){
            %>
            <table class="table table-bordered my-st my-tble ">
                <thead class="table-active">
                <tr><th scope="col">Name </th> <th>Telephone</th><th>View</th></tr>
               </thead>
                <%
                    for (BC bc:a){
                %>
                <tr><td><%= bc.getName() %> </td> <td><%= bc.getTel() %></td>   <td><a href="BC?cmd=BCR&id=<%= bc.getId() %>">view</a></td>   </tr>
                <%}%> <!--to end the loop-->
            </table>
             <%}%> <!--to end if-->
             
             
             
             <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
