<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL</title>
    </head>
    <body>
       <c:set var="data" value="Shahed, reema, London" />
       <c:set var="citiesArray" value="${fn:split(data, ',')}" />
        <c:forEach var="temp" items="${citiesArray}">
            ${temp} </br>
        </c:forEach>
        
    </body>
</html>
