<%-- 
    Document   : inhabilitarEmpleado
    Created on : 28/08/2019, 12:25:13 AM
    Author     : aguir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Inhabilitar Empleado</h1>
        
                 <form action="Producto" method="post">
            Id Empleado:
            <input type="text" name="id_Empleado" placeholder="Identificacion Empleado"> 
             Id Usuario:
            <input type="text" name="id_Usuario" placeholder="Identificacion Usuario"> 
            <!--<input type="submit" value="Buscar" name="buscar">--><br>
            Nombre:
            <input type="text" name="nombre" placeholder="Nombre"><br>
            Apellido:
            <input type="text" name="Apellido" placeholder="Apellido"><br>
            Telefono:
            <input type="text" name="Telefono" placeholder="Telefono"><br>
            Direccion:
            <input type="text" name="Direccion" placeholder="Direccion"><br>
            Correo:
            <input type="text" name="correo" placeholder="Correo"><br>
            Observaciones:
            <input type="text" name="observacion" placeholder="Observaciones"><br>
            Estado:
            <input type="text" name="estado" placeholder="estado"><br>

            <br><br>
            
            <div>
                
            <button>Inhabilitar</button>
            <input type="hidden" name="opcion" value="3">
            
            </div>
        </form>
                 <%
            if (request.getAttribute("mensajeError") != null) {
        %>
        ${mensajeError}
        <%    }%>
        
                        <%
            if (request.getAttribute("mensajeExito") != null) {
        %>
        ${mensajeExito}
        <%    }%>
    </body>
</html>
