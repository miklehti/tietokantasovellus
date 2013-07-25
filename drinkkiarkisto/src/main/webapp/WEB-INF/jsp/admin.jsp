<%-- 
    Document   : admin
    Created on : 25.7.2013, 12:40:02
    Author     : lehtimik
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Admin sivu</title>
    </head>
    <body>
        <h1>Admin sivu</h1>
        <c:url var="logout" value="http://localhost:8080/drinkkiarkisto/app/logout">   
        </c:url>

        <a href="<c:out value="${logout}"/>">logout</a>


        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/hae-admin">
            <label>Hae drinkkejä: <input type="text" name="hae-admin" id="hae-admin" /></label>
            <input type="submit" value ="Hae drinkkejä"/>
        </form>

        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/hae-ehdotuksia-admin">
            <label>Hae ehdotuksia: <input type="text" name="hae-ehdotuksia" id="hae-ehdotuksia" /></label>
            <input type="submit" value ="Hae ehdotuksia"/>
        </form>
        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/hae-tyyppi-admin">
            <label>Hae tyypillä: <input type="text" name="hae-tyyppi" id="hae-tyyppi" /></label>
            <input type="submit" value ="Hae tyypillä"/>
        </form>

        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/hae-aakkoset-admin">
            <label>Hae aakkosjärjestyksessä: </label>
            <input type="submit" value ="Hae aakkosilla"/>
        </form>

      


        <p>${sana}</P>

        <pre>
            <c:forEach var="alkio" items="${osoitteita}">
    <a href="${alkio.value}">${alkio.key}</a>
            </c:forEach>
        </pre>

        <pre>
            <c:forEach var="ehdotus" items="${ehdotuksia}">
    <a href="${ehdotus.value}">${ehdotus.key}</a>
            </c:forEach>
        </pre>

        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/luo-drinkki">
            <label>Drinkkisi nimi (pakollinen): <input type="text" name="name" id="name" /></label>
            <label>Drinkkisi tyyppi (cocktail, alkujuoma...): <input type="text" name="tyyppi" id="tyyppi" /></label>
            <label>Pääainesosa (pakollinen):<input type="text" name="ainesosa1" id ="ainesosa1"/></label>
            <label>määrä: <input type="text" name="maara1" id ="maara1"/></label>
            <label>Ainesosa 2:<input type="text" name="ainesosa2" id ="ainesosa2"/></label>
            <label>määrä: <input type="text" name="maara2" id ="maara2"/></label>
            <label>Ainesosa 3:<input type="text" name="ainesosa3" id ="ainesosa3"/></label>
            <label>määrä: <input type="text" name="maara3" id ="maara3"/></label>
            <label>Ainesosa 4:<input type="text" name="ainesosa4" id ="ainesosa4"/></label>
            <label>määrä: <input type="text" name="maara4" id ="maara4"/></label>
            <label>Ainesosa 5:<input type="text" name="ainesosa5" id ="ainesosa5"/></label>
            <label>määrä: <input type="text" name="maara5" id ="maara5"/></label>
            <input type="submit" value ="Luo drinkki" />
        </form>

        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/hae-kayttaja">
            <label>Hae käyttäjä </label>
            <input type="submit" value ="Hae käyttäjä"/>
        </form>  

<pre>
            <c:forEach var="kayttaja" items="${kayttajia}">
    <a href="${kayttaja.value}">${kayttaja.key}</a>
            </c:forEach>
        </pre>

    </body>
</html>
