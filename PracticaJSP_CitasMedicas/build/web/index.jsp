<%-- 
    Document   : index
    Created on : 16/05/2017, 11:35:10 AM
    Author     : alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/pure-min.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div class="content pure-g">
            <div class="pure-u-24-24">
            <h1>Sistema de citas medicas</h1>
            <div class="pure-menu pure-menu-horizontal">
                <ul class="pure-menu-list">
                    <li class="pure-menu-item pure-menu-selected"><a href="." class="pure-menu-link"> inicio </a>
                    <li class="pure-menu-item"><a href="altaPaciente.jsp" class="pure-menu-link">
                            Agregar Paciente</a></li>
                    <li class="pure-menu-item"><a href="buscarPaciente.jsp" class="pure-menu-link">
                            Buscar Paciente</a></li>
                    <li class="pure-menu-item"><a href="listaPacientes.jsp" class="pure-menu-link">
                            Lista Pacientes</a></li>
                    <li class="pure-menu-item"><a href="seleccionarPaciente.jsp" class="pure-menu-link">
                            Nueva Cita</a></li>
                    <li class="pure-menu-item"><a href="listaCitas.jsp" class="pure-menu-link">
                            Lista Citas</a></li>
                    <li class="pure-menu-item"><a href="pacientes.jsp" class="pure-menu-link">
                            Citas de Pacientes</a></li>
                </ul>
            </div>       
            </div>
        </div>
    </body>
</html>
