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
import javax.swing.text.html.HTMLDocument;
import modeloVO.ControlVO;
import util.ConexionBD;
import util.InterfaceCrud;

public class ControlDAO extends ConexionBD implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;

    private String id_control_profesor = "";
    private String Estado = "";
    private String descripcion = "";
    private String id_estudiante = "";
    private String id_curso = "";
    private String id_detalle = "";
    private String id_empleado = "";
    private String id_profesor = "";
    private String Serial = "";
    private String Estado_prestamo = "";
     private String Nombre_producto = "";
    private String Nombre_estudiante = "";

    private boolean operaciones = false;

    public ControlDAO(ControlVO ControlVO) {
        super();
        try {
            conexion = this.obtnerConexion();
            puente = conexion.createStatement();
            id_control_profesor = ControlVO.getId_control_profesor();
            Estado = ControlVO.getEstado();
            descripcion = ControlVO.getDescripcion();
            id_estudiante = ControlVO.getId_estudiante();
            id_curso = ControlVO.getId_curso();
            id_detalle = ControlVO.getId_detalle();
            id_empleado = ControlVO.getId_empleado();
            id_profesor = ControlVO.getId_profesor();
            Serial = ControlVO.getSerial();
            Estado_prestamo = ControlVO.getEstado_prestamo();
            Nombre_producto = ControlVO.getNombre_producto();
            Nombre_estudiante = ControlVO.getNombre_estudiante();

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }

    }
    @Override
    public boolean agregarRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarRegistro() {
       try
        {
        CallableStatement call = conexion.prepareCall("call ActualizarControl (?,?,?,?);");
        call.setString(1, id_control_profesor);
        call.setString(2, Estado);
        call.setString(3, descripcion);
        call.setString(4, Estado_prestamo);
        call.execute();
        operaciones = true;
        this.cerrarConexion();
    }
    catch(Exception e){
        System.out.println("Error" + e.toString());
    }
    return operaciones ;
    }
    
     public ArrayList<ControlVO> listar_Controles() {
        ArrayList<ControlVO> listar_Controles = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call listarcontroles");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                Serial = mensajero.getString("Serial");
                Nombre_producto = mensajero.getString("nombre");
                id_estudiante = mensajero.getString("id_estudiante");
                Nombre_estudiante = mensajero.getString("Nombre_estudiante");
                id_curso = mensajero.getString("id_curso");
                id_profesor = mensajero.getString("nombre_profesor");
                id_empleado = mensajero.getString("nombre_prestamista");
                descripcion = mensajero.getString("des_producto");
                Estado = mensajero.getString("Estado");
                
                ControlVO ControlVO4 = new ControlVO();
                ControlVO4.setSerial(Serial);
                ControlVO4.setNombre_producto(Nombre_producto);
                ControlVO4.setId_estudiante(id_estudiante);
                ControlVO4.setNombre_estudiante(Nombre_estudiante);
                ControlVO4.setId_curso(id_curso);
                ControlVO4.setId_profesor(id_profesor);
                ControlVO4.setId_empleado(id_empleado);
                ControlVO4.setDescripcion(descripcion);
                ControlVO4.setEstado(Estado);
                listar_Controles.add(ControlVO4);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return listar_Controles;

    }
    
}
