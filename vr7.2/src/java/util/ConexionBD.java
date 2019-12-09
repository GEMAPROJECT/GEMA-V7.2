/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private String driver, urlBD, userBD, passwordBD, bd;
    //puente, mensajero, puerta
    private Connection conexion;
    //puerta

    //metodo principal
    public ConexionBD() {
        driver = "com.mysql.jdbc.Driver";
        userBD = "root";
        passwordBD ="";
        bd = "prueba2";
        urlBD = "jdbc:mysql://localhost:3307/" + bd;

        try {

            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(urlBD, userBD, passwordBD);
            System.out.println("Conexion Ok");
                } catch (Exception e) {
                    System.out.println("Error al conectarse a la BD" + e.toString());
                }
            }
    
    public Connection obtnerConexion() {
        return conexion;
    }

    public Connection cerrarConexion() throws SQLException{
        conexion.close();
        conexion = null;
        return conexion;
    }
    public static void main(String[] args) {
        new ConexionBD();
    }
}