<%-- 
    Document   : ehdota
    Created on : 24.7.2013, 15:34:31
    Author     : lehtimik
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ehdota drinkkiä</h1>
        <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/ehdota-drinkkia">
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
            <input type="submit" name ="Rekisteröidy" />
        </form>
    </body>
</html>
