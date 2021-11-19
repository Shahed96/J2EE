<%-- 
    Document   : edit
    Created on : Mar 22, 2021, 5:34:25 AM
    Author     : DELL
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getParameter("submit") != null) {
        //get the data:
        String name = request.getParameter("sname");
        String course = request.getParameter("course");
        String feeS = request.getParameter("fee");
        String id = request.getParameter("id");

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school?zeroDateTimeBehavior=convertToNull", "root", "12345678");
            PreparedStatement ps;

            ps = con.prepareStatement("UPDATE `recored` SET `stname`=?,`course`=?,`fee`=? WHERE `ID`=? ");

            ps.setString(1, name);
            ps.setString(2, course);
            double feed = Double.valueOf(feeS);
            ps.setDouble(3, feed);
            ps.setInt(4, Integer.valueOf(id));
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
%>

<script>
    alert("recored Edited!");
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
        <!--link to css -->
        <link href="style.css" rel="stylesheet" />
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit a recored!</h1>
        <form method="POST" action="#">
            <%                  Connection con = null;
                ResultSet rs = null;
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school?zeroDateTimeBehavior=convertToNull", "root", "12345678");
                PreparedStatement ps;
                String id = request.getParameter("id");

                ps = con.prepareStatement("SELECT * FROM `recored` WHERE `ID`=?");
                ps.setInt(1, Integer.valueOf(id));
                rs = ps.executeQuery();
                while (rs.next()) {
            %>




            <div class="form-group ">
                <label for="ex1">Student Name:<input type="text" value="<%=rs.getString("stname")%>" id="ex1" name="sname" placeholder="name" class="form-control">
                </label>
            </div>

            <div class="form-group ">
                <label for="ex2">Course:
                    <input type="text" id="ex2" value="<%=rs.getString("course")%>" name="course" placeholder="course" class="form-control">
                </label>
            </div>

            <div class="form-group ">
                <label for="ex3">Fee:
                    <input type="text" id="ex2" placeholder="fee"value="<%=rs.getDouble("fee")%>"  name="fee" class="form-control">
                </label>
            </div>

            <% }%>



            <div class="form-group">
                <button class="btn btn-default btn-info" name="submit">Edit</button>
                <button class="btn btn-default btn-warning" name="reset">Reset</button>
            </div>
            <a href="index.jsp">Back</a>

        </form>
    </body>
</html>
