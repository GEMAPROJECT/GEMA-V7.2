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
import modeloVO.Empleado;
import modeloVO.ProductoVO;
import util.ConexionBD;
import util.InterfaceCrud;
/**
 *
 * @author caban
 */
public class EmpleadoDao extends ConexionBD implements InterfaceCrud {
    
    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;


   private String idEmpleado = "";
    private String idUsuario = "";
    private String nombre = "";
    private String Apellido = "";
     private String Telefono = "";
      private String Direccion = "";
    private String correo = "";
    private String observacion = "";
    private String estado = "";
    
    private boolean operaciones = false;
   
    
    
     public EmpleadoDao(Empleado emVO) {

        super();
        try {
            conexion = this.obtnerConexion();
            puente = conexion.createStatement();

        

                 idEmpleado = emVO.getIdEmpleado();
                 idUsuario = emVO.getIdUsuario();
                 nombre = emVO.getNombre();
                 Apellido = emVO.getApellido();
                 Telefono = emVO.getTelefono();
                 Direccion= emVO.getDireccion();
                 correo = emVO.getCorreo();
                 observacion = emVO.getObservacion();
                 estado = emVO.getEstado();

        }catch (Exception e) {
             System.out.println("Error" + e.toString());
        }
    }
      @Override
    public boolean agregarRegistro() {
        try {
          CallableStatement call = conexion.prepareCall("call ingresarEmpleado (?,?,?,?,?,?,?,?,?);");
                call.setString(1, idEmpleado);
                call.setString(2, idUsuario);
                call.setString(3, nombre);
                call.setString(4, Apellido);
                call.setString(5, Telefono);
                call.setString(6, Direccion);
                call.setString(7, correo);
                call.setString(8, observacion);
                call.setString(9, estado);
                call.executeUpdate(); 
                 operaciones = true;
           
                this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error" + e.toString()); 
        }
        return operaciones;
    }
   
    public boolean inabilitar(){
        try{
            puente.executeUpdate("update empleados_administradores set estado='Inactivo' where id_Empleado='"+idEmpleado+"'");
            operaciones = true;
        }
    catch (Exception e){
        System.out.println("Error" + e.toString());
    }
        return operaciones;
   }    
    
    @Override
    public boolean actualizarRegistro() {
        try{
            
            // conseguimos la conexion con la que llamaremos a la función  
      //  Session session = HibernateUtil.currentSession();
       // Connection conn = (Connection) session.connection();  
 
        CallableStatement call = conexion.prepareCall("call actualizarEmpleado(?,?,?,?,?,?,?,?,?);");
        call.setString(1, idEmpleado);
        call.setString(2, idUsuario);
        call.setString(3, nombre);
        call.setString(4, Apellido);
        call.setString(5, Telefono);
        call.setString(6, Direccion);
        call.setString(7, correo);
        call.setString(8, observacion);
        call.setString(9, estado);
        call.execute();   
        this.cerrarConexion();
        }
        catch(Exception e){
        System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
      
    
     public ArrayList<Empleado> listar() {    
        ArrayList<Empleado> ListarEmpleados = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call ListarEmpleados");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                idEmpleado = mensajero.getString("id_empleado");
                nombre = mensajero.getString("nombre");
                Apellido = mensajero.getString("apellidos");
                Telefono = mensajero.getString("telefono");       
                Direccion = mensajero.getString("direccion");
                correo = mensajero.getString("correo");
                observacion = mensajero.getString("observaciones");
                estado = mensajero.getString("estado");
                
                Empleado EmpleadoVO2 = new Empleado();
                EmpleadoVO2.setIdEmpleado(idEmpleado);
                EmpleadoVO2.setNombre(nombre);
                EmpleadoVO2.setApellido(Apellido);
                EmpleadoVO2.setTelefono(Telefono);
                EmpleadoVO2.setDireccion(Direccion);
                EmpleadoVO2.setCorreo(correo);
                EmpleadoVO2.setObservacion(observacion);
                EmpleadoVO2.setEstado(estado);
                
                ListarEmpleados.add(EmpleadoVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return ListarEmpleados;

    }
      public ArrayList<Empleado> listarEmpleado(String id_Empleado) {
        ArrayList<Empleado> ActualizarEmple = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {


            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call TraerEmpleados  (?)");

            callStat.setString(1,id_Empleado);

            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                idEmpleado = mensajero.getString("id_empleado");
                nombre = mensajero.getString("nombre");
                Apellido = mensajero.getString("apellidos");
                Telefono = mensajero.getString("telefono");       
                Direccion = mensajero.getString("direccion");
                correo = mensajero.getString("correo");
                observacion = mensajero.getString("observaciones");
                estado = mensajero.getString("estado");

                Empleado EmpleVO3 = new Empleado();
                EmpleVO3.setIdEmpleado(idEmpleado);
                EmpleVO3.setNombre(nombre);
                EmpleVO3.setApellido(Apellido);
                EmpleVO3.setTelefono(Telefono);
                EmpleVO3.setDireccion(Direccion);
                EmpleVO3.setCorreo(correo);
                EmpleVO3.setObservacion(observacion);
                EmpleVO3.setEstado(estado);

                ActualizarEmple.add(EmpleVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return ActualizarEmple;
       }
    


}