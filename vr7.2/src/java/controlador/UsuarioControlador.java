/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modeloVO.*;


/**
 *
 * @author HP
 */
@WebServlet(name = "UsuarioControlador", urlPatterns = {"/Usuario"})
public class UsuarioControlador extends HttpServlet {

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
         * controlador para controlar el inicio de sesion
         */
        
        
        /**
         * parametros que resive de la vista
         */
         
         
         int opcion = Integer.parseInt(request.getParameter("opcion"));
        
         String usuLogin = "";
          String usuPassword = "";
         
        usuLogin = request.getParameter("textUsuLogin");
        usuPassword = request.getParameter("textUsuPassword");
        String usuId = request.getParameter("Id_usuario");
        String usuario = request.getParameter("Usuario");
        String Contraseña = request.getParameter("textPassword");
        String Rol = request.getParameter("Rol");
        String estado = request.getParameter("Rol");
        String Clave_nueva = request.getParameter("txtClaveNueva");
        String ingreso = request.getParameter("ingreso");
        
        
        
       /**
         * Metodo constructor para generar el cambio de clave
         */
       
        CambioClave ClaVO= new CambioClave(usuLogin, Clave_nueva);
        cambioClaveDAO ClaDAO = new cambioClaveDAO(ClaVO);
        
        
        
        /**
         * Metodo constructor para validar el inicio de sesion
         */
        UsuarioVO usuVO = new UsuarioVO(usuId,usuLogin,usuPassword);
        UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
        
        
        /**
         * Metodo constructor para generar el cambio de clave
         */
        UsuarioVO usuaVO = new UsuarioVO(usuLogin, usuPassword);
        UsuarioDAO usuaDAO = new UsuarioDAO(usuaVO);
        
        
        /**
         * Metodo constructor para gestionar el usuario
         */
        UsuarioVO Uvo = new UsuarioVO(usuId, usuario, Contraseña, Rol,estado,ingreso);
        UsuarioDAO Udao = new UsuarioDAO(Uvo);
          
        switch(opcion){
            case 1://agregar registro
                if (Udao.agregarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se registró correctamente ahora registre los siguientes datos!");
                    if (Uvo.getusuRol().equals("1")) {
                                request.getRequestDispatcher("insertarEmpleados.jsp").forward(request, response);
                            } else if (Uvo.getusuRol().equals("2")) {
                                request.getRequestDispatcher("insertarEmpleados.jsp").forward(request, response);
                            } else if (Uvo.getusuRol().equals("3")) {
                                request.getRequestDispatcher("ingresarProfesor.jsp").forward(request, response);
                            }
                } else {
                    request.setAttribute("mensajeError", "El usuario NO pudo ser registrado correctamente!");
                    request.getRequestDispatcher("ingresarUsuario.jsp").forward(request, response);
                }            
                break;
                case 2://Actualizar Registro
                if (usuDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El usuario se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El usuario NO pudo ser actualizado correctamente!");
                }
                request.getRequestDispatcher("actualizar_usuario.jsp").forward(request, response);
                break;
                case 3://Validar Ingreso
                        ArrayList<UsuarioVO> lista = usuDAO.IniciarSesion2(usuLogin, usuPassword);
                        if (lista.size() == 0) {
                            request.getRequestDispatcher("Index.jsp").forward(request, response);
                            request.setAttribute("MensajeError", "El usuario y/o contraseña son incorrectas");
                            
                        } else {
                             UsuarioVO usuVO2 = lista.get(0);
                            HttpSession sesion = request.getSession(true);
                            sesion.setAttribute("usuLogin", usuVO2);
                            if(usuVO2.getEstado().equals("Inactivo")){
                             request.setAttribute("MensajeError", "Su usuario esta inactivo, hable con el administrador para  activarlo");   
                             request.getRequestDispatcher("Index.jsp").forward(request, response);
                            }
                            else{
                 
                            if(usuVO2.getIngreso().equals("0")){
                               request.getRequestDispatcher("Cambio_de_clave2.jsp").forward(request, response);
                            }else{
                             if (usuVO2.getusuRol().equals("1")) {
                                request.getRequestDispatcher("Menu_principal.jsp").forward(request, response);
                            } else if (usuVO2.getusuRol().equals("2")) {
                                request.getRequestDispatcher("Menu_principal.jsp").forward(request, response);
                            } else if (usuVO2.getusuRol().equals("3")) {
                                request.getRequestDispatcher("Menu_profesor.jsp").forward(request, response);
                            }       
                            }                                     
                          }
                        }
                    
                
                        // request.getRequestDispatcher("Index.jsp").forward(request, response);
                      break;
                    
                      case 4://Valida el ingreso al sistena para validar el cambio de contraseña
    
                        ArrayList<UsuarioVO> lista2 = usuDAO.IniciarSesion2(usuLogin, usuPassword);
                        if (lista2 == null) {
                             request.setAttribute("MensajeError", "La contraseña no es correcta");
                            request.getRequestDispatcher("Cambio_de_clave.jsp").forward(request, response);
                        } else {

                            UsuarioVO usuVO2 = lista2.get(0);
                            HttpSession sesion = request.getSession(true);
                            sesion.setAttribute("usuLogin", usuVO2);
                             if(ClaDAO.actualizarRegistro()){                                        
                                request.getRequestDispatcher("Index.jsp").forward(request, response);
                            }else{  
                                 request.getRequestDispatcher("Cambio_de_clave.jsp").forward(request, response);
                                 request.setAttribute("MensajeError", "La contraseña no es correcta");
                            }
                        }
                     
                       
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
