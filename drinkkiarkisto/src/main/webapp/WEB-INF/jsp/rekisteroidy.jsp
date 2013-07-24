<%-- 
    Document   : kirjaudu
    Created on : 24.7.2013, 15:15:19
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
        <h1>Rekisteröidy käyttäjäksi</h1>
                <form method="POST" action="http://localhost:8080/drinkkiarkisto/app/add-user">
  <label>Anna haluamasi käyttäjätunnus(6-15 merkkiä): <input type="text" name="username" id="username" /></label>
  <label>Anna salasanasi(6-15 merkkiä): <input type="password" name="password" id ="password"/></label>
    <label>Anna salasanasi uudestaan: <input type="password2" name="password2" id ="password2"/></label>
    <label>Anna sähköpostisi: <input type="email" name="email" id ="email"/></label>
  <input type="submit" name ="Rekisteröidy" />
</form>
    </body>
</html>
