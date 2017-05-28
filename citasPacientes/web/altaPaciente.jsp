<%-- 
    Document   : altaPaciente
    Created on : 16/05/2017, 04:17:42 PM
    Author     : antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos del Paciente!</h1>
        <div class="container">
  <form action="AltaPacientes" method="POST">
    <div class="form-group row">
      <label for="nombrep" class="col-sm-2 col-form-label col-form-label-sm">Nombre </label>
      <div class="col-sm-10">
          <input type="text" class="form-control form-control-sm" id="nombrep" name="nombrep">
      </div>
    </div>
      <div class="form-group row">
      <label for="fechap" class="col-sm-2 col-form-label col-form-label-sm">Fecha Nacimiento </label>
      <div class="col-sm-10">
          <input type="date" class="form-control form-control-sm" id="fechap" name="fechap">
      </div>
    </div>
      <div class="form-group row">
      <label for="estaturap" class="col-sm-2 col-form-label col-form-label-sm">Estatura </label>
      <div class="col-sm-10">
          <input type="number" class="form-control form-control-sm" id="estaturap" name="estaturap">
      </div>
    </div>
      <div class="form-group row">
          <label for="sexop" class="col-sm-2 col-form-label col-form-label-sm">Sexo </label>
          <div class="col-sm-10">
            <label class="radio-inline"><input type="radio" name="sexop" value="M">Masculino</label>
            <label class="radio-inline"><input type="radio" name="sexop" value="F">Femenino</label>
          </div>
    </div>
      <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
    </body>
</html>
