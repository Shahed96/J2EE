
<%@page import="java.util.ArrayList"%>
<%@page import="model.*, Services.*, Controllers.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
   <!--CSS -->
   <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Read All</title>
      
    </head>
    <body>
        <%@include file="master.jsp"%>
        <a href="add.jsp" title="Add" class="btn btn-info" style="margin: .5em;" >Add</a>
       
        <%
            ArrayList<BusninessCard> a =(ArrayList<BusninessCard>) request.getAttribute("bcv");
            if (a!= null){
            %>
            
            <table class="table table-hover table-dark" style="max-width: 400px; margin: .5em;" >
                <thead><th>ID</th><th>Name</th><th>Telephone</th><th>View</th></thead>
                <%for (BusninessCard bc :a){%>
                <tr>
                    <td><%=bc.id%></td>
                     <td><%=bc.name%></td>
                      <td><%=bc.tel%></td>
                      <td><a href="C?cmd=RBC&id=<%=bc.id%>"class="btn btn-info"> View </a></td>
                </tr>
                <%}%>
            </table>
            <a href="C?cmd=BCS" class="btn btn-info" style="margin: .5em;"> Save </a>
            <%}%>
            
            
            
            
            
            
            <!-- jQuery first, then Popper.js, then Bootstrap JS. -->
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
