<%-- 
    Document   : listaCitas.jsp
    Created on : 22/05/2017, 11:30:29 AM
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/pure-min.css" />
        <title>Citas</title>
    </head>
    <body>
        <div class="pure-g">        
         <div class="pure-u-1 pure-u-md-5-8"> 
            <h3>Citas</h3>
            <jsp:include  page="ListaCitas"/>            
        </div>
        </div>
    </body>
</html>
