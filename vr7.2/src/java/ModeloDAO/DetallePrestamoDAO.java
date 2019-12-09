/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.DetatallePrestamoVO;
import util.ConexionBD;
import util.InterfaceCrud;

/**
 *
 * @author HP
 */
public class DetallePrestamoDAO extends ConexionBD implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    
    private String id_detalle = "";
    private String num_prestamo = "";
    private String cantidad = "";
    private String Serial = "";
    private String estado = "";

    private boolean operaciones = false;

    public DetallePrestamoDAO(DetatallePrestamoVO DpreVO) {
        super();
        try {
            conexion = this.obtnerConexion();
            puente = conexion.createStatement();
            
            id_detalle = DpreVO.getId_detalle();
            num_prestamo = DpreVO.getNum_prestamo();
            cantidad = DpreVO.getCantidad();
            Serial = DpreVO.getSerial();
            estado = DpreVO.getEstado();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }

    }

    @Override 
    public boolean agregarRegistro() {
        try {
             CallableStatement call= conexion.prepareCall("call AgregarDetalle_prestamo(?,?,?,?,?);");
             call.setString(1, id_detalle);
             call.setString(2, num_prestamo); 
             call.setString(3, cantidad);
             call.setString(4, Serial);
             call.setString(5, estado);
             call.executeUpdate();         
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
     public boolean EliminarRegistro() {
        try {
             CallableStatement call= conexion.prepareCall("call EliminarDetalle_prestamo(?);");
             call.setString(1, id_detalle);
             call.execute();         
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }

    @Override
    public boolean actualizarRegistro() {
          try {
         CallableStatement call= conexion.prepareCall("call ActualizarEstadoDetalle(?,?);");
             call.setString(1, id_detalle);
             call.setString(2, estado); 
             call.execute();         
            operaciones = true;
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
    
     public ArrayList<DetatallePrestamoVO> listarID_detalle() {    
        ArrayList<DetatallePrestamoVO> ListarID = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call Listarid_detalle");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_detalle = mensajero.getString("id_detalle");         
                DetatallePrestamoVO DetalleVO = new DetatallePrestamoVO();
                DetalleVO.setId_detalle(id_detalle);  
                ListarID.add(DetalleVO);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return ListarID;

    }

}
