/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Persona;
import Modelo.PersonaDAO;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author HP
 */
public class ControladorCRUD extends HttpServlet {
    String listar="vistas/Principal.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    Persona p = new Persona();
    PersonaDAO dao = new PersonaDAO();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCRUD</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCRUD at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");;
            String Apel=request.getParameter("txtApe");;
            String telf=request.getParameter("txtTelf");;
            p.setDni(dni);
            p.setNombre(nom);                
            p.setApellido(Apel);
            p.setTelef(telf);
            dao.add(p);
            acceso = listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper", request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String dni=request.getParameter("txtDni");
            String nom=request.getParameter("txtNom");;
            String Apel=request.getParameter("txtApe");;
            String telf=request.getParameter("txtTelf");;
            
            p.setId(id);
            p.setDni(dni);
            p.setNombre(nom);                
            p.setApellido(Apel);
            p.setTelef(telf);
            dao.edit(p);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            p.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("Buscar")){
            String dato= request.getParameter("txtBuscar");
            List<Persona>lista=dao.buscar(dato);
            request.setAttribute("buscar", lista);
            request.getRequestDispatcher("vistas/Principal.jsp").forward(request, response);
        }
        
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
