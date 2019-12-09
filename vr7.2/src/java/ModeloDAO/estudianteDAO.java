package ModeloDAO;

import util.InterfaceCrud;
import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.estudianteVO;


public class estudianteDAO extends ConexionBD implements InterfaceCrud{

    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;


    private String id_estudiante = "";
    private String Nombre_estudiante = "";
    private String apellidos_studiante = "";
    private String id_curso = "";
    private String estado = "";

    private boolean operaciones = false;


    public estudianteDAO(estudianteVO estVO)
    {
        super();
            try {
               conexion = this.obtnerConexion();
               puente = conexion.createStatement();

               id_estudiante = estVO.getId_estudiante();
              Nombre_estudiante = estVO.getNombre_estudiante();
              apellidos_studiante = estVO.getApellidos_studiante();
              id_curso = estVO.getId_curso();
              estado = estVO.getEstado();
    }
            catch(Exception e)
            {
                System.out.println("Error" + e.toString());
            }
    }

     @Override
    public boolean agregarRegistro() {
        try {
           CallableStatement call = conexion.prepareCall("call ingresarEstudiantes (?,?,?,?,?);");

                call.setString(1, id_estudiante);
                call.setString(2, Nombre_estudiante);
                call.setString(3, apellidos_studiante);
                call.setString(4, id_curso);
                call.setString(5, estado);
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
        CallableStatement call = conexion.prepareCall("call actualizarEstudiantes (?,?,?,?,?);");
                call.setString(1, id_estudiante);
                call.setString(2, Nombre_estudiante);
                call.setString(3, apellidos_studiante);
                call.setString(4, id_curso);
                call.setString(5, estado);
                call.execute();
                operaciones = true;
                this.cerrarConexion();
                }
                catch(Exception e){
                System.out.println("Error" + e.toString());
                }
                return operaciones;
    }

        public boolean inabilitar(){
        try{
            puente.executeUpdate("update estudiantes set estado='Inactivo' where id_estudiante='"+id_estudiante+"'");
            operaciones = true;
        }
    catch (Exception e){
        System.out.println("Error" + e.toString());
    }
        return operaciones;
   }

    public ArrayList<estudianteVO> listar() {
        ArrayList<estudianteVO> listarEstudiantes = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {


            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call listarEstudiantes");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_estudiante = mensajero.getString("id_estudiante");
                Nombre_estudiante = mensajero.getString("Nombre_estudiante");
                apellidos_studiante = mensajero.getString("apellidos_studiante");
                id_curso = mensajero.getString("id_curso");
                estado = mensajero.getString("estado");

                estudianteVO estVO2 = new estudianteVO(id_estudiante, Nombre_estudiante, apellidos_studiante, id_curso, estado);
                estVO2.setId_estudiante(id_estudiante);
                estVO2.setNombre_estudiante(Nombre_estudiante);
                estVO2.setApellidos_studiante(apellidos_studiante);
                estVO2.setId_curso(id_curso);
                estVO2.setEstado(estado);
                listarEstudiantes.add(estVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(estudianteDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return listarEstudiantes;

    }

      public ArrayList<estudianteVO> listarEstudiantes(String id_Estudiante) {
        ArrayList<estudianteVO> ActualizarEstu = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {


            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call TraerEstudiantes (?)");

            callStat.setString(1,id_Estudiante);

            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                id_estudiante = mensajero.getString("id_estudiante");
                Nombre_estudiante = mensajero.getString("Nombre_estudiante");
                apellidos_studiante = mensajero.getString("apellidos_studiante");
                id_curso = mensajero.getString("id_curso");
                estado = mensajero.getString("estado");

                estudianteVO estuVO3 = new estudianteVO();
                estuVO3.setId_estudiante(id_estudiante);
                estuVO3.setNombre_estudiante(Nombre_estudiante);
                estuVO3.setApellidos_studiante(apellidos_studiante);
                estuVO3.setId_curso(id_curso);
                estuVO3.setEstado(estado);

                ActualizarEstu.add(estuVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return ActualizarEstu;
       }


}
