<%-- 
    Document   : edit
    Created on : 2 may. 2024, 22:40:44
    Author     : HP
--%>

<%@page import="Modelo.Persona"%>
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

            
        </nav>
        <div class="container">
            <div class="col-lg-6">
            <%
            PersonaDAO dao= new PersonaDAO();
            int id= Integer.parseInt((String)request.getAttribute("idper"));
            Persona p = (Persona) dao.list(id);
            %>
            <h1>Modificar Persona </h1>
            <form action="ControladorCRUD" >
            ID: <br>
            <input class="form-control" type="text" name="txtDni" value="<%= p.getDni()%>"><br>
            Nombres: <br>
            <input class="form-control"  type="text" name="txtNom" value="<%= p.getNombre()%>"><br>
            Apellidos: <br>
            <input class="form-control"  type="text" name="txtApe" value="<%= p.getApellido()%>"><br>
            Telefono: <br>
            <input class="form-control"  type="text" name="txtTelf" value="<%= p.getTelef()%>"><br>
            <input type="hidden" name="txtid" value="<%= p.getId()%>">
            <input class="btn btn-outline-primary btn-bg"  type="submit" name="accion" value="Actualizar"><br>
            </form>
            </div>
        </div>
    </body>
</html>
