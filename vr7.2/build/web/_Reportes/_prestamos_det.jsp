<%-- 
    -Document   : reportes
    Created on : 17/11/2019, 12:10:05 PM
    Author     : aguir
--%>

<%@page import="util.ConexionBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<%@page import="net.sf.jasperreports.engine.*"%>
<%@page import="net.sf.jasperreports.view.JasperViewer"%>
<%@page import="javax.servlet.ServletResponse"%>
<%@include file="_conection.jsp"%>

<%--
<%@include file="../src/java/util/ConexionBD.java"%>
<a href="../src/java/util/ConexionBD.java"></a> 

--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reporte Prestamos y detalle</title>
    </head>
    <body>
        <%
            //ConexionBD con = new ConexionBD();
           // coneccion = con.obtnerConexion();
            
            File reportFile = new File (application.getRealPath("_Reportes/_prestamos_det.jasper"));
            
            Map<String, Object> parameter = new HashMap<String,Object>();
            
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parameter, con);
            
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream outputstream = response.getOutputStream();
            outputstream.write(bytes,0,bytes.length);
            
            outputstream.flush();
            outputstream.close();
            
        %>
    </body>
</html>