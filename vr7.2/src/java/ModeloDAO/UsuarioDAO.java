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
import modeloVO.UsuarioVO;
import util.ConexionBD;
import util.InterfaceCrud;

/**
 *
 * @author APRENDIZ
 */
public class UsuarioDAO extends ConexionBD implements InterfaceCrud {

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;



   

    private String usuId = "";
    private String usuLogin = "";
    private String usuPassword = ""; 
    private String usuRol = "";
    private String estado = "";
    private String ingreso = "";
    private String nombreComparar = "";
    private String claveComparar = "";
    
  
    
    
    private int validacion = 0;
                     
    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }
     public String getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(String usuLogin) {
        this.usuLogin = usuLogin;
    }

    public String getUsuPassword() {
        return usuPassword;
    }

    public void setUsuPassword(String usuPassword) {
        this.usuPassword = usuPassword;
    }

    public String getUsuRol() {
        return usuRol;
    }

    public void setUsuRol(String usuRol) {
        this.usuRol = usuRol;
    }

    public String getNombreComparar() {
        return nombreComparar;
    }

    public void setNombreComparar(String nombreComparar) {
        this.nombreComparar = nombreComparar;
    }

    public String getClaveComparar() {
        return claveComparar;
    }

    public void setClaveComparar(String claveComparar) {
        this.claveComparar = claveComparar;
    }
    
     
     
     
    private boolean operaciones = false;

    public UsuarioDAO(UsuarioVO usuVO) {
        super();
        try {
            conexion = this.obtnerConexion();
            puente = conexion.createStatement();

            usuId = usuVO.getUsuId();
            usuLogin = usuVO.getUsuLogin();
            usuPassword = usuVO.getUsuPassword();
            usuRol = usuVO.getusuRol();
            estado = usuVO.getEstado();
            ingreso = usuVO.getIngreso();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        
    }

    @Override
    public boolean agregarRegistro() {
        try {
             CallableStatement call = conexion.prepareCall("call insertarUsuario(?,?,?,?,?,?);");
             call.setString(1, usuId);
             call.setString(2, usuLogin);
             call.setString(3, usuPassword);
             call.setString(4, usuRol);
             call.setString(5, estado);
             call.setString(6, ingreso);
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
            
    
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
    
  public ArrayList<UsuarioVO> IniciarSesion(String usuLogin, String usuPassword){ 
             ConexionBD conBD= new ConexionBD();
        ArrayList<UsuarioVO> lista= new ArrayList<>();
        try {
            puente= conBD.obtnerConexion().createStatement();
            mensajero = puente.executeQuery("select * from usuarios u NATURAL JOIN rol where usuario='"+usuLogin+"' and contraseña='"+usuPassword+"'");
            while (mensajero.next()) {                
                usuId= mensajero.getString(2);
                usuLogin= mensajero.getString(3);
                usuPassword= mensajero.getString(4);
                usuRol= mensajero.getString(1);
                estado = mensajero.getString(5);
                ingreso = mensajero.getString(6);
                UsuarioVO usuVO= new UsuarioVO(usuId, usuLogin, usuPassword, usuRol,estado,ingreso);
                lista.add(usuVO);
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.toString());

        }
        return lista;
    } 

    public boolean validarIngreso(String usuLogin, String usuPassword ) {
        try {
            conexion = this.obtnerConexion();
            puente = conexion.createStatement();
            mensajero = puente.executeQuery("select usuario,contraseña from usuarios where usuario='" + usuLogin + "' and contraseña='" + usuPassword + "'");        
            if (mensajero.next()) {
                operaciones = true;
            }
            this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones; 
    }
    
    public int validarSesion() {

        try {

           CallableStatement callStat = conexion.prepareCall("CALL Validar_ingreso(?,?);");

            callStat.setString(1, usuLogin);
            callStat.setString(2, usuPassword);

            ResultSet resulConsulta = callStat.executeQuery();

            if (resulConsulta.next()) {

                usuRol = resulConsulta.getString("id_rol");
                usuId = resulConsulta.getString("id_usuario");
                nombreComparar = resulConsulta.getString("usuario");
                claveComparar = resulConsulta.getString("contraseña");         
                

                if (nombreComparar.equals(usuLogin) && claveComparar.equals(usuPassword) && usuRol.equals("1")) {

                    validacion = 1;

                }else if (nombreComparar.equals(usuLogin) && claveComparar.equals(usuPassword) && usuRol.equals("2") ){
                
                    validacion = 2;
                
                }else  if(nombreComparar.equals(usuLogin) && claveComparar.equals(usuPassword) && usuRol.equals("3")){
                
                    validacion = 3;
                
                }
            }

        } catch (SQLException e) {

            Logger.getLogger(UsuarioDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);
        } finally {

            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return validacion;

    }
    public ArrayList<UsuarioVO> IniciarSesion2(String usuario, String Contraseña) {    
        ArrayList<UsuarioVO> Inicio = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("CALL Validar_ingreso(?,?);");
            
            callStat.setString(1,usuario);
            callStat.setString(2,Contraseña);
            
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                usuRol = mensajero.getString("id_rol");
                usuId = mensajero.getString("id_usuario");
                usuLogin = mensajero.getString("usuario");
                usuPassword = mensajero.getString("contraseña");
                estado = mensajero.getString("estado");
                ingreso = mensajero.getString("ingreso");
                
                UsuarioVO usuVO3 = new UsuarioVO();
                usuVO3.setusuRol(usuRol);
                usuVO3.setUsuId(usuId);
                usuVO3.setUsuLogin(usuLogin);
                usuVO3.setUsuPassword(usuPassword);
                usuVO3.setEstado(estado);
                usuVO3.setIngreso(ingreso);

                
                Inicio.add(usuVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return Inicio;
       }

}
