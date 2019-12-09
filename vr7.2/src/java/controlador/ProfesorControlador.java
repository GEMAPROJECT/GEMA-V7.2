/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.ProfesorDAO;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloVO.ProfesorVO;
import modeloVO.UsuarioVO;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "ProfesorControlador", urlPatterns = {"/profesores"})
public class ProfesorControlador extends HttpServlet {

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
         * controlador para Gestionar a los profesores
         */
        
        
        /**
         * parametros que resive de la vista
         */
                
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String id_Profesor = request.getParameter("id_Profesor");
        String id_Usuario = request.getParameter("id_Profesor");
        String Nombre = request.getParameter("nombre");
        String Apellido = request.getParameter("apellido");
        String Telefono = request.getParameter("telefono");
        String Correo = request.getParameter("correo");
        String Direccion = request.getParameter("direccion");
        String Cargo = request.getParameter("cargo");
        String Estado = request.getParameter("estado");
        
         /**
         * parametros que resive de la vista para agregar el usuario
         */
        String usuId = request.getParameter("id_Profesor");
        String usuario = request.getParameter("id_Profesor");
        String Contraseña = request.getParameter("textPassword");
        String Rol = request.getParameter("Rol");
        String ingreso = request.getParameter("ingreso");
        
        /**
         * Metodo constructor para a los usuarios
         */
        UsuarioVO Uvo = new UsuarioVO(usuId, usuario, Contraseña, Rol ,Estado,ingreso);
        UsuarioDAO Udao = new UsuarioDAO(Uvo);
        
        /**
         java mail
         */    
        
        
        
         Email email = new Email();
        
            String de = request.getParameter("de");
            String clave = request.getParameter("clave");
            String para = request.getParameter("correo");
            String mensaje = request.getParameter("mensaje");
            String asunto = request.getParameter("Asunto");
            
            boolean resultado = email.enviarCorreo(de, clave, para, mensaje, asunto);
            
           
            
            
        /**
         * Metodo constructor para a los profesores
         */    

        ProfesorVO profesorVO = new ProfesorVO(id_Profesor, id_Usuario, Nombre, Apellido, Telefono, Correo, Direccion, Cargo, Estado);
        ProfesorDAO profesorDAO = new ProfesorDAO(profesorVO);

        switch (opcion) {
            case 1: //Agregar Registro
                
                 if (Udao.agregarRegistro()) {
                     if (profesorDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El Profesor se registró correctamente!");
                   
                } else {
                    request.setAttribute("mensajeError", "El Profesor NO pudo ser registrado correctamente!");
                }
                   
                } else {
                    request.setAttribute("mensajeError", "El usuario NO pudo ser registrado correctamente!");
                    
                }
               
                 
                 
                request.getRequestDispatcher("ingresarProfesor.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (profesorDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El Profesor se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El Profesor NO pudo ser actualizado correctamente!");
                }
                request.getRequestDispatcher("Profesor.jsp").forward(request, response);
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
