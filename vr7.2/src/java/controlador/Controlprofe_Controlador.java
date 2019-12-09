/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloVO.Control_profeVO;
import modeloVO.ControlVO;
import ModeloDAO.Control_profeDAO;
import ModeloDAO.ControlDAO;
import modeloVO.DetatallePrestamoVO;
import ModeloDAO.DetallePrestamoDAO;

/**
 *
 * @author HP
 */
@WebServlet(name = "Controlprofe_Controlador", urlPatterns = {"/Controlprofe"})
public class Controlprofe_Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
           PrintWriter out = response.getWriter();
           
           
           
           
        /**
         * controlador para Gestionar el control de el profesor
         */
        
        
        /**
         * parametros que resive de la vista
         */
           int opcion = Integer.parseInt(request.getParameter("opcion"));
        String Num_control = request.getParameter("Num_control");
        String Num_detalle = request.getParameter("Num_detalle");
        String Id_profesor = request.getParameter("Id_profesor");
        String Id_empleado = request.getParameter("Id_empleado");
        String id_estudiante = request.getParameter("textEstudiantes");      
        String Estado = request.getParameter("Estado");
        String Estado_Prestamo = request.getParameter("Estado_Prestamo");
        String Observacion = request.getParameter("Observacion");
        String Id_curso = request.getParameter("Curso");
        String Estado_detalle = request.getParameter("Estado_Detalle");
        
        
        /**
         * metodo constructor para la gestion de los estados
         */
        ControlVO ColVO = new ControlVO(Num_control, Estado, Observacion, Estado_Prestamo);
        ControlDAO Codao = new ControlDAO(ColVO);
       
        /**
         * metodo constructor para la gestion de el cnotrol
         */
       Control_profeVO Controlvo = new Control_profeVO(Num_control, Estado, Observacion, Num_detalle, Id_empleado, Id_profesor, Estado_Prestamo, id_estudiante,Id_curso);
       Control_profeDAO ControlDAO = new Control_profeDAO(Controlvo);
       
       /**
         * parametros para la gestion del estado del detalle
         */
       DetatallePrestamoVO DpreVO = new DetatallePrestamoVO(Num_detalle, Estado_detalle);
       DetallePrestamoDAO DpreDAO = new DetallePrestamoDAO(DpreVO);
       
       
       
       
        
        switch (opcion) {
            case 1: //Agregar Registro
                if (ControlDAO.agregarRegistro()) {
                   request.setAttribute("mensajeExito", "El producto Se Presto al estudiante correctamente");
                   if (DpreDAO.actualizarRegistro()) {                   
                } else {     
                }                
                } else {
                    request.setAttribute("mensajeError", "El producto no puedo ser prestado al estudiante!");  
                }          
               request.getRequestDispatcher("Inventario_Profesor.jsp").forward(request, response);
                break;
            case 2:
                 if (Codao.actualizarRegistro() ) {       
                    if (DpreDAO.actualizarRegistro()) {  
                         request.setAttribute("mensajeExito", "El producto Se Presto al estudiante correctamente");
                } else {     
                          request.setAttribute("mensajeError", "El Control no puedo ser Actualizado");
                }   
                 }
                 else {     
                      request.setAttribute("mensajeError", "El Control no puedo ser Actualizado");
                 }
                  request.getRequestDispatcher("Menu_profesor.jsp").forward(request, response);
                break;
             
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
        processRequest(request, response);
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
