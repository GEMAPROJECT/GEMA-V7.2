
package ModeloDAO;

import util.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloVO.ProductoVO;
import util.InterfaceCrud;

    public class ProductoDAO extends ConexionBD implements InterfaceCrud{
    
    private Connection conexion = null;
    private Statement puente = null;
    private ResultSet mensajero = null;
    
    
    private String idProducto = "";
    private String nombre = "";
    private String tipoProducto = "";
    private String serial = "";
    private String observacion = "";
    private String cantidad = "";
    private String estado = "";
    private String id_detalle = "";
    
    private boolean operaciones = false;
    
    
        public ProductoDAO(ProductoVO proVO) {
            super();
            try {
               conexion = this.obtnerConexion();
               puente = conexion.createStatement();

               idProducto = proVO.getIdProducto();
               nombre = proVO.getNombre();
               tipoProducto = proVO.getTipoProducto();
               serial = proVO.getSerial();
               observacion = proVO.getObservacion();
               cantidad = proVO.getCantidad();
               estado = proVO.getEstado();
               id_detalle = proVO.getId_detalle();
               
          } catch (Exception e) {
                System.out.println("Error" + e.toString());
            }
    
        }   

    @Override
    public boolean agregarRegistro() {
        try {
           CallableStatement call = conexion.prepareCall("call ingresarProducto (?,?,?,?,?,?,?);");
                
                call.setString(1, idProducto);
                call.setString(2, nombre);
                call.setString(3, tipoProducto);
                call.setString(4, serial);
                call.setString(5, observacion);
                call.setString(6, cantidad);
                call.setString(7, estado);
                call.executeUpdate();    
                operaciones = true;
             this.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Error" + e.toString()); 
        }
        return operaciones;
    }
   

    /*@Override
    public boolean actualizarRegistro() {
        try {
            puente.executeUpdate("update productos set nombre=('"+nombre+"', "
                    + "tipo_producto='"+tipoProducto+"', Serial='"+serial+"', "
                    + "Observacion='"+observacion+"', cantidad='"+cantidad+"', "
                    + "estado='"+estado+"' where id_producto='"+idProducto+"');");
            operaciones = true;
        } catch (Exception e) {
            System.out.println("Error" + e.toString());
        }
        return operaciones;
    }*/
    
    public boolean inabilitar(){
          try{
            
        CallableStatement call = conexion.prepareCall("call ActualizarEstadoProducto(?);");
        call.setString(1, serial);
        call.execute();  
        operaciones = true;
        this.cerrarConexion();        
        }
        catch(Exception e){
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
 
        CallableStatement call = conexion.prepareCall("call actualizarProducto(?,?,?,?,?,?,?);");
        call.setString(1, idProducto);
        call.setString(2, nombre);
        call.setString(3, tipoProducto);
        call.setString(4, serial);
        call.setString(5, observacion);
        call.setString(6, cantidad);
        call.setString(7, estado);
        call.execute();  
        operaciones = true;
        this.cerrarConexion();        
        }
        catch(Exception e){
        System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
      public boolean ActivarProducto() {
        try{
        CallableStatement call = conexion.prepareCall("call Activar_producto (?);");
        call.setString(1, serial);
        call.execute();  
        operaciones = true;
        this.cerrarConexion();        
        }
        catch(Exception e){
        System.out.println("Error" + e.toString());
        }
        return operaciones;
    }
   
    
    
       public ArrayList<ProductoVO> listar() {    
        ArrayList<ProductoVO> listaProducto = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call ListarProducto");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                idProducto = mensajero.getString("id_producto");
                nombre = mensajero.getString("nombre");
                tipoProducto = mensajero.getString("tipo_producto");
                serial = mensajero.getString("Serial");
                observacion = mensajero.getString("Observacion");
                cantidad = mensajero.getString("cantidad");
                estado = mensajero.getString("estado");

                ProductoVO ProductoVO2 = new ProductoVO();
                ProductoVO2.setIdProducto(idProducto);
                ProductoVO2.setNombre(nombre);
                ProductoVO2.setTipoProducto(tipoProducto);
                ProductoVO2.setSerial(serial);
                ProductoVO2.setObservacion(observacion);
                ProductoVO2.setCantidad(cantidad);
                ProductoVO2.setEstado(estado);
                
                listaProducto.add(ProductoVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return listaProducto;

    }
       public ArrayList<ProductoVO> listar2() {    
        ArrayList<ProductoVO> listaProducto2 = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call ProductosActivos");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                idProducto = mensajero.getString("id_producto");
                nombre = mensajero.getString("nombre");
                tipoProducto = mensajero.getString("tipo_producto");
                serial = mensajero.getString("Serial");
                observacion = mensajero.getString("Observacion");
                cantidad = mensajero.getString("cantidad");
                estado = mensajero.getString("estado");

                ProductoVO ProductoVO3 = new ProductoVO();
                ProductoVO3.setIdProducto(idProducto);
                ProductoVO3.setNombre(nombre);
                ProductoVO3.setTipoProducto(tipoProducto);
                ProductoVO3.setSerial(serial);
                ProductoVO3.setObservacion(observacion);
                ProductoVO3.setCantidad(cantidad);
                ProductoVO3.setEstado(estado);
                
                listaProducto2.add(ProductoVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return listaProducto2;

    }
       
       
       public ArrayList<ProductoVO> listarSerial(String Seriales) {    
        ArrayList<ProductoVO> Actualizarprodu = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call TraerSerialproducto (?)");
            
            callStat.setString(1,Seriales);
            
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                idProducto = mensajero.getString("id_producto");
                nombre = mensajero.getString("nombre");
                tipoProducto = mensajero.getString("tipo_producto");
                serial = mensajero.getString("Serial");
                observacion = mensajero.getString("Observacion");
                cantidad = mensajero.getString("cantidad");
                estado = mensajero.getString("estado");

                ProductoVO ProductoVO3 = new ProductoVO();
                ProductoVO3.setIdProducto(idProducto);
                ProductoVO3.setNombre(nombre);
                ProductoVO3.setTipoProducto(tipoProducto);
                ProductoVO3.setSerial(serial);
                ProductoVO3.setObservacion(observacion);
                ProductoVO3.setCantidad(cantidad);
                ProductoVO3.setEstado(estado);
                
                Actualizarprodu.add(ProductoVO3);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return Actualizarprodu;
       }
       
       
        public  ArrayList<ProductoVO> listarCarrito() {    
        ArrayList<ProductoVO> ObtenerProducto = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
                
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call ListarProducto");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                idProducto = mensajero.getString("id_producto");
                nombre = mensajero.getString("nombre");
                tipoProducto = mensajero.getString("tipo_producto");
                serial = mensajero.getString("Serial");
                observacion = mensajero.getString("Observacion");
                cantidad = mensajero.getString("cantidad");
                estado = mensajero.getString("estado");

                ProductoVO ProductoVO2 = new ProductoVO();
                ProductoVO2.setIdProducto(idProducto);
                ProductoVO2.setNombre(nombre);
                ProductoVO2.setTipoProducto(tipoProducto);
                ProductoVO2.setSerial(serial);
                ProductoVO2.setObservacion(observacion);
                ProductoVO2.setCantidad(cantidad);
                ProductoVO2.setEstado(estado);
                
                ObtenerProducto.add(ProductoVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return ObtenerProducto;

    }
        
        public ArrayList<ProductoVO> listar_nombre() {    
        ArrayList<ProductoVO> listaNombre = new ArrayList<>();
            ConexionBD conexion2 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion2.obtnerConexion().prepareCall("call listarNombreDelProducto");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {

                nombre = mensajero.getString("nombre");

                ProductoVO ProductoVO2 = new ProductoVO();
                ProductoVO2.setNombre(nombre);

                
                listaNombre.add(ProductoVO2);

            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
                    .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return listaNombre;
    }
        public ArrayList<ProductoVO> listarP(String nombre) {    
        ArrayList<ProductoVO> producto_nombre = new ArrayList<>();
            ConexionBD conexion3 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion3.obtnerConexion().prepareCall("SELECT * FROM productos WHERE estado = 'Activo' and nombre = '"+nombre+"'");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {


               ProductoVO proVO5 = new ProductoVO(mensajero.getString(2),mensajero.getString(3),mensajero.getString(4),mensajero.getString(1),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7));
                producto_nombre.add(proVO5);
                    
            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
             .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return producto_nombre;

    }
           public ArrayList<ProductoVO> listarCon(String nume_prestamo) {    
        ArrayList<ProductoVO> Productos_carrito = new ArrayList<>();
            ConexionBD conexion3 = new ConexionBD();
        try {
            
            
            CallableStatement callStat = conexion3.obtnerConexion().prepareCall("SELECT p.id_producto,p.nombre,p.tipo_producto,p.Serial, p.Observacion,p.cantidad,p.estado,dp.id_detalle FROM detalle_prestamo dp INNER JOIN productos p on dp.Serial = p.Serial WHERE nume_prestamo = '"+nume_prestamo+"'");
            mensajero = callStat.executeQuery();
            while (mensajero.next()) {


               ProductoVO proVO6 = new ProductoVO(mensajero.getString(1),mensajero.getString(2),mensajero.getString(3),mensajero.getString(4),mensajero.getString(5),mensajero.getString(6),mensajero.getString(7),mensajero.getString(8));
                Productos_carrito.add(proVO6);
                    
            }
        } catch (SQLException e) {

            Logger.getLogger(ProductoDAO.class
             .getName()).log(Level.SEVERE, null, "Error: " + e);

        }
        return Productos_carrito;

    }
}
