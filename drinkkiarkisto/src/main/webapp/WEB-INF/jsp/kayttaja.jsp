<%-- 
    Document   : haku
    Created on : 23.7.2013, 15:08:51
    Author     : lehtimik
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Käyttäjän tiedot</title>
    </head>
    <body>
        <h1>Käyttäjän tiedot</h1>
         <c:url var="logout" value="http://localhost:8080/drinkkiarkisto/app/logout">   
        </c:url>
        <a href="<c:out value="${logout}"/>">logout</a>
         <p>${sana}</P>
        <pre>
            <c:forEach var="alkio" items="${kayttajat}">
       ${alkio}     
            </c:forEach>
        </pre>
        
          <c:url var="takaisin" value="http://localhost:8080/drinkkiarkisto/app/admin">   
        </c:url>
        <a href="<c:out value="${takaisin}"/>"><-takaisin</a>
    </body>
</html>

