<%-- 
    Document   : tulostus
    Created on : 31.7.2013, 10:54:49
    Author     : lehtimik
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tietokannan tietoja</h1>
        
        <P>Drinkki:<P></br>
   
            <c:forEach var="alkio" items="${drinkki_id}">
                <p>${alkio.key}</p><p>${alkio.value}</p>
            </c:forEach>
   
            
        
            <c:forEach var="alkio2" items="${drinkki_name}">
     <p>${alkio2.key}</p><p>${alkio2.value}</p>
            </c:forEach>

            
            
            <c:forEach var="alkio3" items="${drinkkiAinesosa}">
    <p>${alkio3.key}</p><p>${alkio3.value}</p>
            </c:forEach>
   
        
         <P>DrinkkiAinesosa:<P></br>
        
            <c:forEach var="alkio4" items="${drinkkiAinesosa_maara}">
    <p>${alkio4.key}</p><p>${alkio4.value}</p>
            </c:forEach>
    
         
                 <P>Ainesosa:<P></br>
            
            <c:forEach var="alkio5" items="${ainesosa_id}">
    <p>${alkio5.key}</p><p>${alkio5.value}</p>
            </c:forEach>
       
             
            <c:forEach var="alkio6" items="${ainesosa_name}">
    <p>${alkio6.key}</p><p>${alkio6.value}</p>
            </c:forEach>
    
              <P>Tyyppi:<P></br>
            
            <c:forEach var="alkio7" items="${tyyppi_id}">
    <p>${alkio7.key}</p><p>${alkio7.value}</p>
            </c:forEach>
       
             
            <c:forEach var="alkio8" items="${tyyppi_name}">
    <p>${alkio8.key}</p><p>${alkio8.value}</p>
            </c:forEach>
       
    </body>
</html>
