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
import modeloVO.ProductoVO;
import ModeloDAO.ProductoDAO;

/**
 *
 * @author aguir
 */
@WebServlet(name = "ProductoControlador", urlPatterns = {"/Producto"})
public class ProductoControlador extends HttpServlet {

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
         * controlador para Gestionar los productos
         */
        
        
        /**
         * parametros que resive de la vista
         */
                     
    int opcion = Integer.parseInt(request.getParameter("opcion"));
        String id_producto = request.getParameter("id_producto");
        String nombre = request.getParameter("nombre");
        String tipo_producto = request.getParameter("tipo_producto");
        String serial= request.getParameter("serial");
        String observacion= request.getParameter("observacion");
        String cantidad = request.getParameter("cantidad");
        String estado = request.getParameter("estado");

        
        
        
        /**
         * Metodo constructor para  los productos
         */
        ProductoVO proVO = new ProductoVO(id_producto, nombre, tipo_producto, serial, observacion, cantidad, estado);
        ProductoDAO proDAO = new ProductoDAO(proVO);

        switch (opcion) {
            case 1: //Agregar Registro
                if (proDAO.agregarRegistro()) {

                    request.setAttribute("mensajeExito", "El Producto se registró correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El Producto NO pudo ser registrado correctamente!");
                }
                request.getRequestDispatcher("ingresarProducto.jsp").forward(request, response);
                break;
            case 2://Actualizar Registro
                if (proDAO.actualizarRegistro()) {
                    request.setAttribute("mensajeExito", "El producto se actualizo correctamente!");
                } else {
                    request.setAttribute("mensajeError", "El producto NO pudo ser actualizado correctamente!");
                }
                request.getRequestDispatcher("Producto.jsp").forward(request, response);
                break;
            case 3://Inhabilitar
                if (proDAO.inabilitar()) { 
                    request.setAttribute("mensajeExito", "El Producto se inhabilito correctamente!");
                } else {
                    request.setAttribute("mensajeError", "¡ El Producto no púdo ser inhabilitado!");
                     request.getRequestDispatcher("inhabilitarProducto.jsp").forward(request, response);
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
