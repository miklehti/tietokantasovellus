<%-- 
    Document   : luoDrinkki
    Created on : 30.7.2013, 14:00:05
    Author     : lehtimik
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Luo Drinkki</title>
    </head>
    <body>
        <h1>Luo Drinkki</h1>
        
        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/luo-drinkki">
            <label>Drinkkisi nimi (pakollinen): <input type="text" name="name" id="name" /></label><br>
            <br>
            <label>Drinkkisi tyyppi (cocktail, alkujuoma...): <input type="text" name="tyyppi" id="tyyppi" /></label><br>
            <br>
            <label>Pääainesosa (pakollinen):<input type="text" name="ainesosa1" id ="ainesosa1"/></label><br>
            <label>määrä: <input type="text" name="maara1" id ="maara1"/></label><br>
            <br>
            <label>Ainesosa 2:<input type="text" name="ainesosa2" id ="ainesosa2"/></label><br>
            <label>määrä: <input type="text" name="maara2" id ="maara2"/></label><br>
            <br>
            <label>Ainesosa 3:<input type="text" name="ainesosa3" id ="ainesosa3"/></label><br>
            <label>määrä: <input type="text" name="maara3" id ="maara3"/></label><br>
            <br>
            <label>Ainesosa 4:<input type="text" name="ainesosa4" id ="ainesosa4"/></label><br>
            <label>määrä: <input type="text" name="maara4" id ="maara4"/></label><br>
            <br>
            <label>Ainesosa 5:<input type="text" name="ainesosa5" id ="ainesosa5"/></label><br>
            <label>määrä: <input type="text" name="maara5" id ="maara5"/></label><br>
            <br>
            <input type="submit" value ="Luo drinkki" />
        </form>
        
            <c:url var="takaisin" value="http://localhost:8080/drinkkiarkisto/app/haku">   
        </c:url>
        <a href="<c:out value="${takaisin}"/>"><-takaisin hakusivulle</a>
        
        <pre>
            <c:forEach var="alkio" items="${admin}">
    <a href="${alkio.value}">${alkio.key}</a>
            </c:forEach>
        </pre>
    </body>
</html>
