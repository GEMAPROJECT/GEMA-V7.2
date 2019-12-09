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
import modeloVO.CursosVO;
import ModeloDAO.CursoDAO;

/**
 *
 * @author aguir
 */
@WebServlet(name = "cursoControlador", urlPatterns = {"/Curso"})
public class cursoControlador extends HttpServlet {

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
         * controlador para Gestionar a los cursos
         */
        
        
        /**
         * parametros que resive de la vista
         */
        
        int opcion = Integer.parseInt(request.getParameter("opcion"));      
        String id_curso = request.getParameter("txt_id_curso");
        String id_profe = request.getParameter("txt_id_profe");
        
        
        /**
         * Metodo constructor para a los cursos
         */
        CursosVO cuVO= new CursosVO(id_curso, id_profe);
        CursoDAO cuDAO = new CursoDAO (cuVO);
        
        
        switch (opcion)
         {
             case 1:
                 //Registrar Curso
                 if (cuDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El curso se registró correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El curso NO pudo ser registrado correctamente!");
                }
                request.getRequestDispatcher("insertarCurso.jsp").forward(request, response);
                break;
                 
                 //Actualizar Curso
             case 2:
                 if (cuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El curso se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El curso NO pudo ser actualizado correctamente!");
                }
                request.getRequestDispatcher("Curso.jsp").forward(request, response);
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
