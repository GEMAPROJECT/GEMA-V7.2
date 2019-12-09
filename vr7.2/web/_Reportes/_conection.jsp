<%-- 
    Document   : conection
    Created on : 17/11/2019, 06:27:19 PM
    Author     : aguir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection con = null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3307/prueba2","root","");
                out.print("Conexion funca");
            }
            catch(Exception e)
            {
                out.print("Error"+e.getMessage());
                
            }
        

        %>
    </body>
</html>
