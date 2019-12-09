/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import ModeloDAO.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modeloVO.DetatallePrestamoVO;
import ModeloDAO.DetallePrestamoDAO;
import java.util.ArrayList;
import modeloVO.ProductoVO;
import modeloVO.UsuarioVO;

/**
 *
 * @author HP
 */
@WebServlet(name = "DeallePrestamoControlador", urlPatterns = {"/DeallePrestamo"})
public class DeallePrestamoControlador extends HttpServlet {

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
         * controlador para Gestionar los detalles de los prestamos
         */
        
        
        /**
         * parametros que resive de la vista
         */
       int opcion = Integer.parseInt(request.getParameter("opcion"));
        String id_detalle = request.getParameter("textDetalle");
       String nume_prestamo = request.getParameter("textnum_presta");
        String Cantidad = request.getParameter("txtCantidad");
        String Serial = request.getParameter("txtSerial");
        String estado = request.getParameter("estado");      
        String Cantidad2 = request.getParameter("Cantidad");
        
        
         String detalle = request.getParameter("detalle");
      
        String num_pres = request.getParameter("nume_prest");
         /**
         * metodo constructor para consultar los productos
         */
        ProductoVO ProVO = new ProductoVO(Serial); 
        ProductoDAO ProDAO = new ProductoDAO(ProVO);
         
        
        /**
         * metodo constructor para gestionar el detalle
         */
        DetatallePrestamoVO DPvo = new DetatallePrestamoVO(id_detalle,nume_prestamo, Cantidad, Serial,estado);
        DetallePrestamoDAO DPdao = new DetallePrestamoDAO(DPvo);
        
        DetatallePrestamoVO DePvo = new DetatallePrestamoVO(detalle);
        DetallePrestamoDAO DePdao = new DetallePrestamoDAO(DePvo);
        
        
        ProductoVO ProVO4 = new ProductoVO();
        ProductoDAO ProDAO4 = new ProductoDAO(ProVO4);
        
        switch (opcion) {
            case 1: //Agregar Registro
                  /**
         * parametros que sirven para comparar la cantidad que esta poniendo desde la vista y la cantidad que hay en la base de datos
         */
        int Cantidad3 = Integer.parseInt(Cantidad);
        int Cantidad4 = Integer.parseInt(Cantidad2);
        
                if(Cantidad4 < Cantidad3 )
                {             
                    request.setAttribute("mensajeError", "la cantidad de productos que hay es: "+Cantidad4+" Ponga una cantidad de productos que este en ese rango");
                }
                else{
                if (DPdao.agregarRegistro()) {
                    if(ProDAO.inabilitar())
                    {
                        request.setAttribute("mensajeExito", "El producto Se Registro correctamente");
                    }
                    else{
                        request.setAttribute("mensajeError", "El producto no puedo ser registrado!");
                    }
                }
                 else {
                    request.setAttribute("mensajeError", "El producto no puedo ser registrado!");  
                } 
                }
               request.getRequestDispatcher("PrestamoParte2.jsp").forward(request, response);
                
                break;
           case 2: //Eliminar  Registro
               
               if(DePdao.EliminarRegistro())
               {
                   if(ProDAO.ActivarProducto()){
                    request.setAttribute("mensajeExito", "El producto se retiro de su carrito exitosamente!");
                  request.getRequestDispatcher("PrestamoParte2.jsp").forward(request, response);
                   }
                   else{
                   
                   }
               }
               else{
                    request.setAttribute("mensajeError", "El producto no puedo ser Eliminado de su carrito!"); 
                   request.getRequestDispatcher("PrestamoParte2.jsp").forward(request, response);
               }
               break;
           
           case 3:           
               ArrayList<ProductoVO> Productos_carrito = ProDAO4.listarCon(num_pres);
               if (Productos_carrito.size() == 0) {
                             request.setAttribute("mensajeError", "Tienes que terminar de realizar el prestamo"); 
                   request.getRequestDispatcher("PrestamoParte2.jsp").forward(request, response);
                        }
               else{
                   request.getRequestDispatcher("Menu_principal.jsp").forward(request, response);
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
