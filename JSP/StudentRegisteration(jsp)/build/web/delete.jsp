<%-- 
    Document   : delete
    Created on : Mar 22, 2021, 5:39:33 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%
    if (request.getParameter("submit") != null) {
        //get the data:
       
        String id = request.getParameter("id");

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/school?zeroDateTimeBehavior=convertToNull", "root", "12345678");
            PreparedStatement ps;

            ps = con.prepareStatement("DELETE FROM `recored` WHERE `ID`=? ");

             ps.setInt(1, Integer.valueOf(id));
            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
%>

<script>
    alert("recored Deleted!");
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
        <title>Delete Page</title>
    </head>
    <body>
        <h1>Delete a recored!</h1>
         <form method="POST" action="#">
            <%          Connection con = null;
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
                <button class="btn btn-default btn-info" name="submit">Delete</button>
                <button class="btn btn-default btn-warning" name="reset">Reset</button>
            </div>
            <a href="index.jsp">Back</a>

        </form>
    </body>
</html>
