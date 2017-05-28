<%-- 
    Document   : nuevaCita
    Created on : 21/05/2017, 10:59:19 AM
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <title>Nueva Cita</title>
    </head>
    <body>
        <h1>Nueva Cita</h1>
        <form action="NuevaCita" method="POST">
              <div class="form-group row">
                <label for="fechap" class="col-sm-2 col-form-label col-form-label-sm">Fecha</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control form-control-sm" id="fechap" name="fechap" required>
                </div>
              </div>
              <div class="form-group row">
                <label for="horap" class="col-sm-2 col-form-label col-form-label-sm">Hora </label>
                <div class="col-sm-2">
                    <input type="number" class="form-control form-control-sm" min="9" max="22" id="fechap" name="horap" required>
                </div>
<!--                <div class="col-sm-2">
                    <input type="number" class="form-control form-control-sm" max="60" id="minutop" name="minutop">
                </div>-->
              </div>
              <div class="form-group row">
                <label for="pacientep" class="col-sm-2 col-form-label col-form-label-sm">Paciente </label>
                <div class="col-sm-10">
                    <input type="number" class="form-control form-control-sm" id="estaturap" name="pacientep" required>
                </div>
              </div>
              <button type="submit" class="btn btn-primary">Submit</button>
          </form>
    </body>
</html>
