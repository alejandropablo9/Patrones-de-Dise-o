<%-- 
    Document   : altaPaciente
    Created on : 16/05/2017, 11:17:07 AM
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/pure-min.css" />
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Agregar Paciente</h1>
        <form class="pure-form pure-form-aligned" action="AltaPaciente" metod="post">
            <fieldset>
                <div class="pure-control-group">
                    <label for="name">Nombre</label>
                    <input name="nombre" type="text" placeholder="Nombre">              
                </div>

                <div class="pure-control-group">
                    <label for="name">Fecha de Nacimiento</label>
                    <input name="fecha" type="date" placeholder="Fecha de Nacimiento">              
                </div>

                <div class="pure-control-group">
                    <label for="name">Estatura (cm)</label>
                    <input name="estatura" type="number" placeholder="Estatura(cm)">              
                </div>
                
                <div class="pure-control-group">
                    <label for="name">Sexo</label>
                    <select name="sexo">
                        <option>M</option>
                        <option>H</option>
                    </select>
                </div>                
                <div class="pure-controls">
                    <button type="submit" class="pure-button pure-button-primary">Guardar</button>
                </div>
            </fieldset>
        </form>       
    </center>
    </body>
</html>
