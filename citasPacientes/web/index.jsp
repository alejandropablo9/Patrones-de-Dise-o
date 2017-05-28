<%-- 
    Document   : index
    Created on : 16/05/2017, 05:06:01 PM
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <div>
            <a href="altaPaciente.jsp">Alta Pacientes</a>
        </div><div>
            <a href="nuevaCita.jsp">Agendar Cita</a>
        </div>
        
        <jsp:include page="ListaPacientes"></jsp:include>
        
    </body>
</html>
