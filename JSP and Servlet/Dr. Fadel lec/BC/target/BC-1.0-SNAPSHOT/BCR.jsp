
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
        <title>JSP Page</title>
    </head>
    <body>
         <%@include file="master.jsp"%>

        <%
            BusninessCard bc = (BusninessCard) request.getAttribute("bc");
            if (bc != null) {
        %>
        <form action="C" method="post"> 
            <input type="hidden" name="cmd" value="BCU"> <br> <!-- To send cmd to controller -->
            <input type="hidden" name="id" value="<%=bc.id%>"> <br>  <!-- To send id to controller -->
            <table class="table table-hover table-dark" style="max-width: 400px;">


                <tr>
                    <td>Name</td>
                    <td> <input type="text" name="name" value="<%=bc.name%>"></td>

                </tr>

                <tr>
                    <td>Telephone</td>
                    <td> <input type="text" name="tel" value="<%=bc.tel%>"></td>
                </tr>
                <tr>
                    <td colspan="2"><a href="C?cmd=RBCA"class="btn btn-info">Back</a></td>

                </tr>
                <tr>
                    <td colspan="2"><a href="C?cmd=BCD&id=<%=bc.id%>"class="btn btn-info">Delete</a></td>

                </tr>
                <tr>
                    <td colspan="2"> <button class="btn btn-info">Update</button> </td>
                </tr>


            </table>
        </form>
        <%}%>
          <!-- jQuery first, then Popper.js, then Bootstrap JS. -->
   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
