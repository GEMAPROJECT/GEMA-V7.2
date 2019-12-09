/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.ProfesorVO;
import util.ConexionBD;
import util.InterfaceCrud;

/**
 *
 * @author APRENDIZ
 */
public class ProfesorDAO extends ConexionBD implements InterfaceCrud{

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    
    private String id_Profesor = "";
    private String id_Usuario = "";
    private String nombre = "";
    private String apellido = "";
    private String telefono = "";
    private String correo = "";
    private String direccion = "";
    private String cargo = "";
    private String estado = "";
    
    private boolean operaciones = false;
     
        public ProfesorDAO(ProfesorVO profesorVO){
            super();
            try {
                conexion = this.obtnerConexion();
                puente = conexion.createStatement();
                
                id_Profesor = profesorVO.getId_Profesor();
                id_Usuario = profesorVO.getId_Usuario();
                nombre = profesorVO.getNombre();
                apellido = profesorVO.getApellido();
                telefono = profesorVO.getTelefono();
                correo = profesorVO.getCorreo();
                direccion = profesorVO.getDireccion();
                cargo = profesorVO.getCargo();
                estado = profesorVO.getEstado();
                
            } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
        }
    
    
    @Override
    public boolean agregarRegistro() {
         try {
        CallableStatement call = conexion.prepareCall("call insertarProfesores(?,?,?,?,?,?,?,?,?);");
        call.setString(1, id_Profesor);
        call.setString(2, id_Usuario);
        call.setString(3, nombre);
        call.setString(4, apellido);
        call.setString(5, telefono);
        call.setString(6, correo);
        call.setString(7, direccion);
        call.setString(8, cargo);
        call.setString(9, estado);
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
         try {
        CallableStatement call = conexion.prepareCall("call actualizarProfesor(?,?,?,?,?,?,?,?,?);");
        call.setString(1, id_Profesor);
        call.setString(2, id_Usuario);
        call.setString(3, nombre);
        call.setString(4, apellido);
        call.setString(5, telefono);
        call.setString(6, correo);
        call.setString(7, direccion);
        call.setString(8, cargo);
         call.setString(9, estado);
        call.execute();   
        operaciones = true;
        this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error" + e.toString()); 
        }
        return operaciones;
    }
     public ArrayList<ProfesorVO> listar() {    
        ArrayList<ProfesorVO> listaProfesores = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call ListarProfesores");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_Profesor = mensajero.getString("id_profesor");
                nombre = mensajero.getString("nombre");
                apellido = mensajero.getString("apellidos");
                telefono = mensajero.getString("telefono");
                correo = mensajero.getString("correo");
                direccion = mensajero.getString("direccion");
                cargo = mensajero.getString("Cargo_del_profesor");
                estado = mensajero.getString("estado");

                ProfesorVO ProfesorVO2 = new ProfesorVO();
                ProfesorVO2.setId_Profesor(id_Profesor);
                ProfesorVO2.setNombre(nombre);
                ProfesorVO2.setApellido(apellido);
                ProfesorVO2.setTelefono(telefono);
                ProfesorVO2.setCorreo(correo);
                ProfesorVO2.setDireccion(direccion);
                ProfesorVO2.setCargo(cargo);
                ProfesorVO2.setEstado(estado);
                
                listaProfesores.add(ProfesorVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return listaProfesores;

    }
    
     
      public ArrayList<ProfesorVO> listarProfesor(String id_profesor) {    
        ArrayList<ProfesorVO> Actualizarprofe = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call TraerProfesores (?)");
            
            callStat.setString(1,id_profesor);
            
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_Profesor = mensajero.getString("id_profesor");
                nombre = mensajero.getString("nombre");
                apellido = mensajero.getString("apellidos");
                telefono = mensajero.getString("telefono");
                correo = mensajero.getString("correo");
                direccion = mensajero.getString("direccion");
                cargo = mensajero.getString("Cargo_del_profesor");
                estado = mensajero.getString("estado");

                ProfesorVO ProfrVO3 = new ProfesorVO();
                ProfrVO3.setId_Profesor(id_Profesor);
                ProfrVO3.setNombre(nombre);
                ProfrVO3.setApellido(apellido);
                ProfrVO3.setTelefono(telefono);
                ProfrVO3.setCorreo(correo);
                ProfrVO3.setDireccion(direccion);
                ProfrVO3.setCargo(cargo);
                ProfrVO3.setEstado(estado);
                
                Actualizarprofe.add(ProfrVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return Actualizarprofe;
       }
}
