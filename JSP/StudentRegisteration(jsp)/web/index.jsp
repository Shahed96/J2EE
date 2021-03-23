<%-- 
    Document   : index
    Created on : Mar 14, 2021, 9:01:30 AM
    Author     : Shahed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>

<%
    if (request.getParameter("submit") != null) {
        //get the data:
        String name = request.getParameter("sname");
        String course = request.getParameter("course");
        String feeS = request.getParameter("fee");
        if (name.equals("")) {
%>
<script>alert("Enter your name");</script>
<%                     }
   
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school?zeroDateTimeBehavior=convertToNull", "root", "12345678");
        PreparedStatement ps;
        ps = con.prepareStatement("INSERT INTO `recored`( `stname`, `course`, `fee`) VALUES (?,?,?)");
        ps.setString(1, name);
        ps.setString(2, course);
        double feed = Double.valueOf(feeS);
        ps.setDouble(3, feed);

        ps.executeUpdate();

    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }
%>
<script>
    alert("recored added!");
</script>
<%
    }

%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <!--link to css-->
        <link href="style.css" rel="stylesheet" />

        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="#">





            <div class="form-group ">
                <label for="ex1">Student Name:<input type="text" id="ex1" name="sname" placeholder="name" class="form-control"  title="Enter your name" required>
                </label>
            </div>

            <div class="form-group ">
                <label for="ex2">Course:
                    <input type="text" id="ex2" name="course" placeholder="course" class="form-control"title="Enter your course" required>
                </label>
            </div>

            <div class="form-group ">
                <label for="ex3">Fee:
                    <input type="text" id="ex2" placeholder="fee"  name="fee" class="form-control" title="Enter the fee" required>
                </label>
            </div>



            <div class="">
                <button class="btn btn-default btn-info" name="submit" title="submit the form" >submit</button>
                <button class="btn btn-default btn-warning" name="reset"title="Reset the form">Reset</button>
            </div>

        </form>

        <div class="panel-body col-sm-8 tb">
            <table id="tbl-student" class="table table-responsive table-bordered"  cellpadding="0" width="100%">
                <thead>
                    <tr>
                        <th>Student</th>
                        <th>Course</th>
                        <th>Fee</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>

                <%  
                    Class.forName("com.mysql.jdbc.Driver");                  
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school?zeroDateTimeBehavior=convertToNull", "root", "12345678");
                    ResultSet rs;
                    PreparedStatement ps;
                    ps = con.prepareStatement("SELECT * FROM `recored`");
                    rs = ps.executeQuery();
                    while (rs.next()) {

                        int id = rs.getInt("id");

                %>
                <tr>
                    <td><%=rs.getString("stname")%> </td>
                    <td> <%=rs.getString("course")%></td>
                    <td> <%=rs.getDouble("fee")%></td>
                    <td> <a href="edit.jsp?id=<%=id%>">Edit</a> </td>
                    <td><a href="delete.jsp?id=<%=id%>">Delete</a></td>
                </tr>

                <%
                    }
                %>

            </table>
        </div>








    </body>
</html>
