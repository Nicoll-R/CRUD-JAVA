<%-- 
    Document   : add
    Created on : 2 may. 2024, 22:40:33
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
            <nav class="navbar navbar-dark bg-dark">
            <a style="color: white" class="navbar toggler"><span class="navbar-toggler-icon"></span>  Home</a>
            
        </nav>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Persona </h1>
                <form action="ControladorCRUD" >
                ID: <br>
                <input class="form-control" type="text" name="txtDni"><br>
                Nombres: <br>
                <input class="form-control" type="text" name="txtNom"><br>
                Apellidos: <br>
                <input class="form-control" type="text" name="txtApe"><br>
                Telefono: <br>
                <input class="form-control" type="text" name="txtTelf"><br>
                <input class="btn btn-outline-primary btn-bg" type="submit" name="accion" value="Agregar">
                <a href="ControladorCRUD?accion=listar">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
