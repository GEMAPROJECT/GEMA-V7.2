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
import modeloVO.Empleado;
import ModeloDAO.EmpleadoDao;
import ModeloDAO.ProductoDAO;
import ModeloDAO.UsuarioDAO;
import modeloVO.ProductoVO;
import modeloVO.UsuarioVO;

/**
 *
 * @author APRENDIZ
 */
@WebServlet(name = "EmpleadoControlador", urlPatterns = {"/Empleado"})
public class EmpleadoControlador extends HttpServlet {

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
        
        
          /**
         * controlador para Gestionar a los Empleados o administradores
         */
        
        
        /**
         * parametros que resive de la vista
         */
        int opcion = Integer.parseInt(request.getParameter("opcion"));
        String id_Empleado = request.getParameter("IdEmpleado");
        String id_Usuario = request.getParameter("IdEmpleado");
        String nombre = request.getParameter("Nombre");
        String Apellido = request.getParameter("Apellido");
        String Telefono = request.getParameter("Telefono"); 
        String Direccion = request.getParameter("Direccion");
        String correo = request.getParameter("correo");
        String observacion= request.getParameter("Observaciones");
        String estado = request.getParameter("estado");
        
        /**
         * parametros que resive de la vista para agregar el usuario
         */
        String usuId = request.getParameter("IdEmpleado");
        String usuario = request.getParameter("IdEmpleado");
        String Contraseña = request.getParameter("textPassword");
        String Rol = request.getParameter("Rol");
        String ingreso = request.getParameter("ingreso");
        
        UsuarioVO Uvo = new UsuarioVO(usuId, usuario, Contraseña, Rol ,estado,ingreso);
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
         * Metodo constructor para a los empleados
         */    
        Empleado emVO = new Empleado(id_Empleado, id_Usuario, nombre, Apellido, Telefono, Direccion, correo, observacion, estado);
        EmpleadoDao emDAO = new EmpleadoDao(emVO);
        
        switch (opcion) {
            case 1: //Agregar Registro
                
                if (Udao.agregarRegistro()) {
                if (emDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El Empleado/Administrador se registró correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El Empleado/Administrador NO pudo ser registrado correctamente!");
                     
                }
                }
                 else {
                    request.setAttribute("mensajeError", "El usuario NO pudo ser registrado correctamente!");
                    
                }
                
               request.getRequestDispatcher("insertarEmpleados.jsp").forward(request, response);
                break;
                case 2://Actualizar Registro
                if (emDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El Empleado/Administrador se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El Empleado/Administrador NO pudo ser actualizado correctamente!");
                    
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                break;
                case 3://Inhabilitar
                if (emDAO.inabilitar()) { 
                    request.setAttribute("mensajeExito", "El Empleado/Administrador se inhabilito correctamente!");
                } else {
                    request.setAttribute("mensajeError", "¡ El Empleado/Administrador no púdo ser inhabilitado!");                     
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
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
    

