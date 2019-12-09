/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.estudianteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloVO.estudianteVO;

/**
 *
 * @author aguir
 */
@WebServlet(name = "estudianteControlador", urlPatterns = {"/Estudiante"})
public class estudianteControlador extends HttpServlet {

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
        
                 
        /**
         * controlador para Gestionar a los estudiantes
         */
        
        
        
        
                 
        /**
         * parametros que resive de la vista
         */
         int opcion = Integer.parseInt(request.getParameter("opcion"));
         String id_estudiante = request.getParameter("txt_id_estudiante");
         String Nombre = request.getParameter("txt_nombre");
         String Apellido = request.getParameter("txt_apellido");
         String id_curso = request.getParameter("txt_id_curso");
         String estado = request.getParameter("estado");
         
         
                  
        /**
         * Metodo constructor para gestionar el estudiante
         */
         estudianteVO estVO = new estudianteVO(id_estudiante, Nombre, Apellido, id_curso, estado);
         estudianteDAO  estDAO = new estudianteDAO(estVO);
         
         
         
         
         /**
         * dependiendo desde que formulario lo redirija entrara en alguna de las opciones
         */
         switch (opcion)
         {
             
             /**
         * el caso 1 es para agregar un registro
         */
             case 1:
                 if (estDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El Estudiante se registró correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El Estudiante NO pudo ser registrado correctamente!");
                }
                request.getRequestDispatcher("ingresarEstudiante.jsp").forward(request, response);
                break;
                  /**
                    * el caso 2 es para actualizar un registro ya existente
                   */
             case 2:
                 if (estDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El Estudiante se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El Estudiante NO pudo ser actualizado correctamente!");
                }
                request.getRequestDispatcher("Estudiantes.jsp").forward(request, response);
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
