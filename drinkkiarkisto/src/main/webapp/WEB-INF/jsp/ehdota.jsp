<%-- 
    Document   : ehdota
    Created on : 24.7.2013, 15:34:31
    Author     : lehtimik
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ehdota drinkki�</h1>
        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/ehdota-drinkkia">
            <label>Drinkkisi nimi (pakollinen): <input type="text" name="name" id="name" /></label> <br>
             <br>
            <label>P��ainesosa (pakollinen):<input type="text" name="ainesosa1" id ="ainesosa1"/></label> <br>
            <label>m��r�: <input type="text" name="maara1" id ="maara1"/></label> <br>
             <br>
            <label>Ainesosa 2:<input type="text" name="ainesosa2" id ="ainesosa2"/></label> <br>
            <label>m��r�: <input type="text" name="maara2" id ="maara2"/></label> <br>
             <br>
             <label>Ainesosa 3:<input type="text" name="ainesosa3" id ="ainesosa3"/></label> <br>
            <label>m��r�: <input type="text" name="maara3" id ="maara3"/></label> <br>
             <br>
             <label>Ainesosa 4:<input type="text" name="ainesosa4" id ="ainesosa4"/></label> <br>
            <label>m��r�: <input type="text" name="maara4" id ="maara4"/></label> <br>
             <br>
             <label>Ainesosa 5:<input type="text" name="ainesosa5" id ="ainesosa5"/></label> <br>
            <label>m��r�: <input type="text" name="maara5" id ="maara5"/></label> <br>
             <br>
            <input type="submit" value ="Ehdota drinkki�" />
        </form>
        <c:url var="takaisin" value="http://localhost:8080/drinkkiarkisto/app/haku">   
        </c:url>
        <a href="<c:out value="${takaisin}"/>"><-takaisin hakusivulle</a>
    </body>
</html> 
