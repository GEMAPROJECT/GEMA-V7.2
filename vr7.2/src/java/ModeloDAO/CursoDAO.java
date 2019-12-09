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
import modeloVO.CursosVO;
import util.ConexionBD;
import util.InterfaceCrud;

/**
 *
 * @author HP
 */
public class CursoDAO extends ConexionBD implements InterfaceCrud{
    
    
     private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    
   
    private String idcurso = "";
    private String idprofesor = "";
   
    private String Es_id = "";

    
    private boolean operaciones = false;

    public CursoDAO(CursosVO curVO) {
        super();
        try {
            conexion = this.obtnerConexion();
            puente = conexion.createStatement();         
            idcurso = curVO.getIdCurso();
            idprofesor = curVO.getIdprofesor();
            Es_id = curVO.getEs_id();
        
            
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
 
    }
       public ArrayList<CursosVO> listarcursos() {    
        ArrayList<CursosVO> cursos = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call listarcurso");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                idcurso = mensajero.getString("id_curso");   
                idprofesor = mensajero.getString("id_profe"); 
                CursosVO CurVO2 = new CursosVO();
                CurVO2.setIdCurso(idcurso);
                CurVO2.setIdprofesor(idprofesor);
                cursos.add(CurVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return cursos;

    }

   @Override
    public boolean agregarRegistro() {
        try {
           CallableStatement call = conexion.prepareCall("call insertarCurso (?,?);");
                
                call.setString(1, idcurso);
                call.setString(2, idprofesor);
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
            
 
        CallableStatement call = conexion.prepareCall("call actualizarCurso (?,?);");
                call.setString(1, idcurso);
                call.setString(2, idprofesor);
        call.execute();  
        operaciones = true;
        this.cerrarConexion();        
        }
        catch(Exception e){
        System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
      
    public ArrayList<CursosVO> listarCurso(String Cursos) {    
        ArrayList<CursosVO> ActualizarCur = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call TraerCursos(?)");
            
            callStat.setString(1,Cursos);
            
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                idcurso = mensajero.getString("id_curso");
                idprofesor = mensajero.getString("id_profe");

                CursosVO CursVO3 = new CursosVO();
                CursVO3.setIdCurso(idcurso);
                CursVO3.setIdprofesor(idprofesor);

                
                ActualizarCur.add(CursVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return ActualizarCur;
       }
    
     public ArrayList<CursosVO> listarC(String Curso) {    
        ArrayList<CursosVO> Estudiante_curso = new ArrayList<>();
            ConexionBD conexion3 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion3.obtnerConexion().prepareCall("SELECT e.id_estudiante FROM curso c INNER JOIN estudiantes e on c.id_curso = e.id_curso WHERE c.id_curso = '"+Curso+"'");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {


               CursosVO CVO = new CursosVO(mensajero.getString(1));
                Estudiante_curso.add(CVO);
                    
            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return Estudiante_curso;

    }
    
}
