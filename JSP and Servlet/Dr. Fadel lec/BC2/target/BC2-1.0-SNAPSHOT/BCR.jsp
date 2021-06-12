<%-- 
    Document   : BCR
    Created on : Jun 6, 2021, 6:39:19 PM
    Author     : DELL
--%>

<%@page import="model.BC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>BC</title>
    </head>
    <body>
        
        <%
            BC bc = (BC) request.getAttribute("bc");
            if (bc != null) {
        %>
        
        <form action="BC" method="post" class="form-group">
        
            <label for="form-name">Name:</label>           <input type="text" name="name" class="form-control my-in" id="form-name" value="<%=bc.getName()%>">
            <label for="form-phone">Telephone:</label>     <input type="tel" name="telphone" class="form-control my-in" id="form-phone" value="<%=bc.getTel()%>">
           

       
        <%}%>
        <a href="BC?cmd=RBCA" class="btn btn-primary my-st">Back</a>
        
        <input type="hidden" name="id" value="<%=bc.getId()%>" > 
        <input type="hidden" name="cmd" value="BCU" > 
      <button class="btn btn-primary my-st">Update</button>
        
        <a class="btn btn-danger my-st" href="BC?cmd=BCD&id=<%=bc.getId()%>">Delete</a>
      
       </form>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
