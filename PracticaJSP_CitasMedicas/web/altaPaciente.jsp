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
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/pure-min.css" />
        <title>Alta Paciente</title>
    </head>
    <body>
        <div class="content pure-g">
            <div class="pure-u-5-6">
            <form class="pure-form pure-form-aligned" action="AltaPaciente" metod="post">
                <h1>Agregar Paciente</h1>
                <fieldset>
                    <div class="pure-control-group">
                        <label for="nombre">Nombre</label>
                        <input id="nombre" name="nombre" type="text" placeholder="Nombre">              
                    </div>

                    <div class="pure-control-group">
                        <label for="fecha">Fecha de Nacimiento</label>
                        <input id="fecha" name="fecha" type="date" placeholder="Fecha de Nacimiento">              
                    </div>

                    <div class="pure-control-group">
                        <label for="estatura">Estatura (cm)</label>
                        <input id="estatura" name="estatura" type="number" placeholder="Estatura(cm)">              
                    </div>

                    <div class="pure-control-group">
                        <label for="sexo">Sexo</label>
                        <select id="sexo" name="sexo">
                            <option>M</option>
                            <option>H</option>
                        </select>
                    </div>                
                    <div class="pure-controls">
                        <button type="submit" class="pure-button pure-button-primary">Guardar</button>
                    </div>
                </fieldset>
            </form> 
            </div>
        </div>    
    </body>
</html>
