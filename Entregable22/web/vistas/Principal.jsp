

<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.PersonaDAO"%>
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
            <div class="dropdown">
                <a style="color:white" href="#" class="nav-link dropdown-toggler" data-toggle="dropdown">Cerrar Sesion</a>
                <div class="dropdown-menu text-center">
                    <a><img src="img/user.png" height="80" width="80"/></a><br>
                    <a>${nom}</a>
                    <a>${correo}</a>
                    <div class="dropdown-divider"></div>
                    <a href="ControladorValidar?accion=Salir" class="dropdown-item">Salir</a>
                </div>
            </div>
        </nav>
                    
                    
        <div class="container">
            <h1>Asociados</h1>
            <div class="navbar">
            <a class="btn btn-outline-success btn-bg" href="ControladorCRUD?accion=add">Agregar Nuevo</a>
            <form class="form-inline">
                <input type="search" name="txtBuscar" class="form-control">
                <input type="submit" name="accion" value="Buscar" class="btn btn-outline-success">
            </form>
            </div>
            <br>
            <br>
            <div class="">
            <table class="table table-bordered table-hover responsive nowrap">
                <thead>
                    <tr>
                        <th class="text-center" >ID</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Apellido</th>
                        <th class="text-center">Telefono</th>
                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao=new PersonaDAO();
                    List<Persona>list=dao.listar();
                    Iterator<Persona>iter=list.iterator();
                    Persona per=null;
                    while(iter.hasNext()){
                        per=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td>
                        <td class="text-center"><%= per.getDni()%></td>
                        <td class="text-center"><%= per.getNombre()%></td>
                        <td class="text-center"><%= per.getApellido()%></td>
                        <td class="text-center"><%= per.getTelef()%></td>
                        <td>
                            <a class="btn btn-warning btn-bg" href="ControladorCRUD?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger btn-bg" href="ControladorCRUD?accion=eliminar&id=<%= per.getId()%>">Remove</a>
                            
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>

