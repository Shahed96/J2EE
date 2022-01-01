<%-- 
    Document   : students
    Created on : Dec 11, 2021, 12:59:39 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students Page</title>
       <link type="text/css" rel="stylesheet" href="CSS/style.css">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h2>FooBar University</h2>
            </div>
        </div>
        <div id="container">

            <div id="content">
                <input type="button" value="Add student" onclick="window.location.href='add-student-form.jsp'; return false;" class="add-student-button">
                <table>

                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Email</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="tempStudent" items="${students_list}"> <!--it will take the request object behind the scene-->
                       <!--define a link for the update-->
                        <c:url var="tempLink" value="Students">
                            <c:param name="command" value="LOAD"/>
                                <c:param name="id" value="${tempStudent.id}"/>
                            </c:url>
                        <!--define a link for the delete-->
                        <c:url var="deleteLink" value="Students">
                            <c:param name="command" value="DELETE"/>
                                <c:param name="id" value="${tempStudent.id}"/>
                            </c:url>
                        <tr>
                        <td>${tempStudent.firstName}</td> <!--When we use JSP expression language, it will call .getFirstName()-->
                        <td>${tempStudent.lastName}</td>
                        <td>${tempStudent.email}</td>
                        <td><a href="${tempLink}">Update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this studet?'))) return false">Delete</a> </td>
                    </tr>
                    </c:forEach>
                </table>

            </div>
        </div>


    </body>
</html>
