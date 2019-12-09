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
import modeloVO.PrestamosVO;
import util.ConexionBD;
import util.InterfaceCrud;

public class PrestamosDAO extends ConexionBD implements InterfaceCrud{
    
    
    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    
   
    private String num_prestamo = "";
    private String id_epleado = "";
    private String id_profesor = "";
    private String fecha_pres = "";
    private String fecha_devo_pres = "";
    private String id_Hora_Entrega = "";
    private String id_hora_devolucion = "";
    private String id_curso = "";
    private String estado = ""; 
    private String Serial = ""; 
    private String Observacion = ""; 
    private String Estado_pre = ""; 
    private String id_detalle = "";

    
    private boolean operaciones = false;

    public PrestamosDAO(PrestamosVO PreVO) {
        super();
        try {
            conexion = this.obtnerConexion();
            puente = conexion.createStatement();         
            num_prestamo = PreVO.getNum_prestamo();
            id_epleado = PreVO.getId_epleado();
            id_profesor = PreVO.getId_profesor();  
            fecha_pres = PreVO.getFecha_pres();
            fecha_devo_pres = PreVO.getFecha_devo_pres();         
            id_Hora_Entrega = PreVO.getId_Hora_Entrega();
            id_hora_devolucion = PreVO.getId_hora_devolucion();        
            estado = PreVO.getEstado();
            Serial = PreVO.getSerial();
            Observacion = PreVO.getObsevacion();
            Estado_pre = PreVO.getEstado_pre();
            id_detalle = PreVO.getId_detalle();
            
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
 
    }

    @Override
    public boolean agregarRegistro() {  
      
         try {           
           CallableStatement call = conexion.prepareCall("call AgregarPrestamos(?,?,?,?,?,?,?,?);");
             call.setString(1, num_prestamo);
             call.setString(2, id_epleado);
             call.setString(3, id_profesor);
             call.setString(4, fecha_pres);
             call.setString(5, fecha_devo_pres);
             call.setString(6, id_Hora_Entrega);
             call.setString(7, id_hora_devolucion);
             call.setString(8, estado);
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
        
     try{
           
 
        CallableStatement call = conexion.prepareCall("call FinalizarPrestamo(?,?);");
        call.setString(1, num_prestamo);
        call.setString(2, estado);
        call.execute();  
        operaciones = true;
        this.cerrarConexion();        
        }
        catch(Exception e){
        System.out.println("Error" + e.toString());
        }
        return operaciones;
    
    
    
    }
    
      public boolean Finalizar_Prestamo2() {
        
     try{
           
 
        CallableStatement call = conexion.prepareCall("call FinalizarPrestamo3(?,?);");
        call.setString(1, num_prestamo);
        call.setString(2, estado);
        call.execute();  
        operaciones = true;
        this.cerrarConexion();        
        }
        catch(Exception e){
        System.out.println("Error" + e.toString());
        }
        return operaciones;
    
    
    
    }
  
    
     public ArrayList<PrestamosVO> listar() {    
        ArrayList<PrestamosVO> Listanum_prestamo = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call Incrementar_num_prestamo");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                num_prestamo = mensajero.getString("nume_prestamo");   
                id_profesor = mensajero.getString("id_profesor"); 
                PrestamosVO PrestamosVO2 = new PrestamosVO();
                PrestamosVO2.setNum_prestamo(num_prestamo);  
                PrestamosVO2.setId_profesor(id_profesor); 
                Listanum_prestamo.add(PrestamosVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return Listanum_prestamo;

    }
     
      public ArrayList<PrestamosVO> listarcursos() {    
        ArrayList<PrestamosVO> cursos = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call listarcurso");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                num_prestamo = mensajero.getString("nume_prestamo");   
                id_profesor = mensajero.getString("id_profesor"); 
                PrestamosVO PrestamosVO2 = new PrestamosVO();
                PrestamosVO2.setNum_prestamo(num_prestamo);  
                PrestamosVO2.setId_profesor(id_profesor); 
                cursos.add(PrestamosVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return cursos;

    }
      
       public ArrayList<PrestamosVO> listar_prestamos() {    
        ArrayList<PrestamosVO> listar_prestamos = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call ListarPrestamos");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

               ;
                
                
                num_prestamo = mensajero.getString("nume_prestamo");   
                id_epleado = mensajero.getString("id_empleado");
                id_profesor = mensajero.getString("id_profesor");   
                fecha_pres = mensajero.getString("fecha_prestamo");
                fecha_devo_pres = mensajero.getString("fecha_Entrega");
                id_detalle = mensajero.getString("id_detalle");
                Serial = mensajero.getString("Serial");
                
                
                
                PrestamosVO PrestamosVO3 = new PrestamosVO();
                PrestamosVO3.setNum_prestamo(num_prestamo);  
                PrestamosVO3.setId_epleado(id_epleado); 
                PrestamosVO3.setId_profesor(id_profesor);  
                PrestamosVO3.setFecha_pres(fecha_pres);
                PrestamosVO3.setFecha_devo_pres(fecha_devo_pres);
                PrestamosVO3.setId_detalle(id_detalle);
                PrestamosVO3.setSerial(Serial);
                listar_prestamos.add(PrestamosVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return listar_prestamos;

    }
        public boolean Finalizar_Prestamo() {
        try{

        CallableStatement call = conexion.prepareCall("call FinalizarPrestamo2(?,?,?);");
        call.setString(1, Serial);
        call.setString(2, Observacion);
        call.setString(3, Estado_pre);
        call.execute();  
        operaciones = true;
        this.cerrarConexion();        
        }
        catch(Exception e){
        System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
        
          public ArrayList<PrestamosVO> listar_prestamos2() {    
        ArrayList<PrestamosVO> listar_prestamos2 = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call ListarTodosLosPrestamos");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

               ;
                
                
                num_prestamo = mensajero.getString("nume_prestamo");   
                id_epleado = mensajero.getString("Nombre_empleado");
                id_profesor = mensajero.getString("Nombre_profesor");   
                fecha_pres = mensajero.getString("fecha_prestamo");
                fecha_devo_pres = mensajero.getString("fecha_Entrega");
                Serial = mensajero.getString("Serial");
                
                
                
                PrestamosVO PrestamosVO3 = new PrestamosVO();
                PrestamosVO3.setNum_prestamo(num_prestamo);  
                PrestamosVO3.setId_epleado(id_epleado); 
                PrestamosVO3.setId_profesor(id_profesor);  
                PrestamosVO3.setFecha_pres(fecha_pres);
                PrestamosVO3.setFecha_devo_pres(fecha_devo_pres);
                PrestamosVO3.setSerial(Serial);
                listar_prestamos2.add(PrestamosVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return listar_prestamos2;

    }
}
