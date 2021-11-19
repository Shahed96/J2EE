
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:set var="theLocale" 
       value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
       scope="session" />
<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="com.mycompany.multilingual.i18n.resources.mylabels"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="i18n-messages-test.jsp?theLocale=en_US">English  </a>
        <a href="i18n-messages-test.jsp?theLocale=de_DE">German  </a>
        <a href="i18n-messages-test.jsp?theLocale=es_ES">Spanish </a>
        <hr/>
        <fmt:message key="label.greeting" /> <br/> <br/>

        <fmt:message key="label.firstname" /> <i>John</i> <br/>

        <fmt:message key="label.lastname" /> <i>Doe</i> <br/><br/>

        <fmt:message key="label.welcome" /> <br/>
        

    </body>
</html>
