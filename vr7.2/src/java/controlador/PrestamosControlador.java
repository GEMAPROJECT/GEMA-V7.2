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
import modeloVO.PrestamosVO;
import ModeloDAO.PrestamosDAO;
import modeloVO.DetatallePrestamoVO;
import ModeloDAO.DetallePrestamoDAO;

/**
 *
 * @author HP
 */
@WebServlet(name = "PrestamosControlador", urlPatterns = {"/Prestamos"})
public class PrestamosControlador extends HttpServlet {

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
         * controlador para Gestionar los prestamos
         */
        
        
        /**
         * parametros que resive de la vista
         */
       
       int opcion = Integer.parseInt(request.getParameter("opcion"));
        String nume_prestamo = request.getParameter("textnum_presta");
        String nume_prestamo2 = request.getParameter("textnum_presta2");
        String id_empleado = request.getParameter("textid_emple");
        String id_profesor = request.getParameter("textid_Profe");
        String fecha_prestamo = request.getParameter("textfecha_presta");
        String Fecha_devolucion = request.getParameter("textfecha_devo_presta"); 
        String hora_entrega = request.getParameter("textHora_presta");
        String hora_devolucion = request.getParameter("textHora_devo_presta");
        String curso= request.getParameter("textCurso");
        String estado = request.getParameter("textEstado");
        
        String Observacion = request.getParameter("observacion");
        String estado_pre = request.getParameter("Estado_pre");
        String Serial = request.getParameter("serial");
        
        
        /** 
         * Metodo constructor para  la gestion de los  prestamos
         */
        PrestamosVO PreVO = new PrestamosVO(nume_prestamo, id_empleado, id_profesor, fecha_prestamo, Fecha_devolucion,hora_entrega,hora_devolucion,estado);
        PrestamosDAO PreDAO = new PrestamosDAO(PreVO);  
        
        
         /**
         * Metodo constructor para  actualizar el estado de el prestamo
         */
        PrestamosVO PVO = new PrestamosVO(nume_prestamo, estado);
        PrestamosDAO PDAO = new PrestamosDAO(PVO);
        
         /**
         * Metodo constructor para  actualizar el estado de el detalle
         */
        PrestamosVO PrestaVO = new PrestamosVO(nume_prestamo2, estado);
        PrestamosDAO PrestaDAO = new PrestamosDAO(PrestaVO);
        
        
        /**
         * Metodo constructor para  actualizar el estado de los productos
         */
        PrestamosVO PrVO = new PrestamosVO(Serial, Observacion, estado_pre);
        PrestamosDAO PrDAO = new PrestamosDAO(PrVO);
        
         switch (opcion) {
            case 1: //Agregar Registro
                if (PreDAO.agregarRegistro()) {
                   request.setAttribute("mensajeExito", "El prestamo Se realizo correctamente");
                } else {
                    request.setAttribute("mensajeError", "El prestamo no puedo ser registrado!");      
                }          
               request.getRequestDispatcher("PrestamoParte2.jsp").forward(request, response);
                break;
                case 2://Actualizar Registro y finalizar prestamos y detalles
                if (PDAO.actualizarRegistro()) {
                     if (PrDAO.Finalizar_Prestamo()) {
                         if (PrestaDAO.Finalizar_Prestamo2()) {
                         
                         
                    request.setAttribute("mensajeExito", "El Empleado/Administrador se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El Empleado/Administrador NO pudo ser actualizado correctamente!");
                    
                } 
                         
                 
                } else {
                    request.setAttribute("mensajeError", "El Empleado/Administrador NO pudo ser actualizado correctamente!");
                    
                }
                    
                } else {
                    request.setAttribute("mensajeError", "El Empleado/Administrador NO pudo ser actualizado correctamente!");
                    
                }
                request.getRequestDispatcher("Lista_prestamos.jsp").forward(request, response);
                break;
               /* case 3://Inhabilitar
                if (PreDAO.inabilitar()) { 
                    request.setAttribute("mensajeExito", "El Empleado/Administrador se inhabilito correctamente!");
                } else {
                    request.setAttribute("mensajeError", "¡ El Empleado/Administrador no púdo ser inhabilitado!");                     
                }
                request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                break;*/
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
