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
import modeloVO.CambioClave;
import util.ConexionBD;
import util.InterfaceCrud;

public class cambioClaveDAO extends ConexionBD implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;



   

    private String usuId = "";
    private String usuLogin = "";
    private String usuPassword = ""; 
    private String usuRol = "";
    private String nombreComparar = "";
    private String claveComparar = "";
    
        
     
    private boolean operaciones = false;

    public cambioClaveDAO(CambioClave CambVO) {
        super();
        try {
            conexion = this.obtnerConexion();
            puente = conexion.createStatement();

            usuId = CambVO.getUsuId();
            usuPassword = CambVO.getUsuPassword();
            
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
          try {
             CallableStatement call = conexion.prepareCall("call cambiarClave2(?,?);");
             call.setString(1, usuId);
             call.setString(2, usuPassword);
                  
             call.execute();       
             operaciones = true;
             this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
    
}
