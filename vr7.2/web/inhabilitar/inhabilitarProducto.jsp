<%-- 
    Document   : inhabilitarProducto
    Created on : 27/08/2019, 07:23:37 AM
    Author     : aguir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inhabilitar Producto</title>
    </head>
    <body>
        <h1>Inhabilitar Producto</h1>
        
                <form action="Producto" method="post">
            Identificacion del producto:
            <input type="text" name="id_producto" placeholder="Identificacion del producto"> 
            <!--<input type="submit" value="Buscar" name="buscar">--><br>
            Nombre:
            <input type="text" name="nombre" placeholder="Nombre"><br>
            Tipo de producto:
            <input type="text" name="tipo_producto" placeholder="Tipo de producto"><br>
            Serial:
            <input type="text" name="serial" placeholder="Serial"><br>
            Observaciones:
            <input type="text" name="observacion" placeholder="Observaciones"><br>
            Cantidad:
            <input type="text" name="cantidad" placeholder="cantidad"><br>
            Estado:
            <input type="text" name="estado" placeholder="estado"><br>

            <br><br>
            
            <div>
            <button>Inhabilitar</button>
            <input type="hidden" name="opcion" value="3">
            </div>
                </form>
    </body>
</html>
