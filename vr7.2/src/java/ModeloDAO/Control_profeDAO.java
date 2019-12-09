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
import modeloVO.Control_profeVO;
import util.ConexionBD;
import util.InterfaceCrud;

public class Control_profeDAO extends ConexionBD implements InterfaceCrud {

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

    public Control_profeDAO(Control_profeVO ControlVO) {
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

    public ArrayList<Control_profeVO> listar(String idprofesor) {
        ArrayList<Control_profeVO> ListarControl = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("SELECT  dp.Serial,pre.id_profesor,pre.id_empleado,dp.id_detalle from profesores p INNER JOIN prestamos pre on p.id_profesor = pre.id_profesor INNER join detalle_prestamo dp on pre.nume_prestamo = dp.nume_prestamo WHERE pre.id_profesor = '" + idprofesor + "' and pre.estado = 'Activo' and dp.estado = 'Activo'");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                Control_profeVO ControlVO = new Control_profeVO(mensajero.getString(4), mensajero.getString(3), mensajero.getString(2), mensajero.getString(1));
                ListarControl.add(ControlVO);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return ListarControl;

    }

    public ArrayList<Control_profeVO> listar_estudiantes(String idprofesor2) {
        ArrayList<Control_profeVO> Estudiantes_producto = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("SELECT cp.id_estudiante,e.Nombre_estudiante,cp.id_detalle,dp.Serial,p.nombre,cp.id_control_profesor FROM control_profe cp INNER JOIN estudiantes e ON cp.id_estudiante = e.id_estudiante INNER JOIN detalle_prestamo dp ON cp.id_detalle = dp.id_detalle INNER JOIN productos  p on dp.Serial = p.Serial WHERE cp.id_profesor = '" + idprofesor2 + "' AND dp.estado='Inactivo' and p.estado='Prestado'");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                Control_profeVO ControlVO = new Control_profeVO(mensajero.getString(4), mensajero.getString(1), mensajero.getString(2), mensajero.getString(5), mensajero.getString(3),mensajero.getString(6));
                Estudiantes_producto.add(ControlVO);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return Estudiantes_producto;

    }

   
     
    public ArrayList<Control_profeVO> listar() {
        ArrayList<Control_profeVO> IncrementarControl = new ArrayList<>();
        ConexionBD conexion2 = new ConexionBD();
        try {

            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call IncrementarControl");

            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_control_profesor = mensajero.getString("id_control_profesor");
                Control_profeVO ControlVO2 = new Control_profeVO();
                ControlVO2.setId_control_profesor(id_control_profesor);
                IncrementarControl.add(ControlVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return IncrementarControl;

    }

    @Override
    public boolean agregarRegistro() {
        try {
            CallableStatement call = conexion.prepareCall("call Insertar_control (?,?,?,?,?,?,?,?,?);");
            call.setString(1, id_control_profesor);
            call.setString(2, Estado);
            call.setString(3, descripcion);
            call.setString(4, id_detalle);
            call.setString(5, id_empleado);
            call.setString(6, id_profesor);
            call.setString(7, Estado_prestamo);
            call.setString(8, id_estudiante);
            call.setString(9, id_curso);
            call.executeUpdate();
            operaciones = true;
            this.cerrarConexion();

        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
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
     public ArrayList<Control_profeVO> listarControl(String Id_Control) {    
        ArrayList<Control_profeVO> ListarControl = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call ListarActualizarControl(?)");
            
            callStat.setString(1,Id_Control);
            
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_control_profesor = mensajero.getString("id_control_profesor");
                Estado = mensajero.getString("Estado");
                descripcion = mensajero.getString("descripcion");
                id_detalle = mensajero.getString("id_detalle");
                id_empleado = mensajero.getString("id_empleado");
                id_profesor = mensajero.getString("id_profesor");
                Estado_prestamo = mensajero.getString("Estado_Prestamo");
                id_estudiante = mensajero.getString("id_estudiante");
                id_curso = mensajero.getString("id_curso");
                

                Control_profeVO ConVO = new Control_profeVO();
                ConVO.setId_control_profesor(id_control_profesor);
                ConVO.setEstado(Estado);
                ConVO.setDescripcion(descripcion);
                ConVO.setId_detalle(id_detalle);
                ConVO.setId_empleado(id_empleado);
                ConVO.setId_profesor(id_profesor);
                ConVO.setEstado_prestamo(Estado_prestamo);
                ConVO.setId_estudiante(id_estudiante);
                ConVO.setId_curso(id_curso);
               

                
                ListarControl.add(ConVO);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return ListarControl;
       }

}
