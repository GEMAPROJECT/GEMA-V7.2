
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>    
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <link rel="icon" type="image/png" href="imagenes/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/noui/nouislider.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="css/util.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!--===============================================================================================-->

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Registrar Profesor</title>


    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <link href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/npm/weathericons@2.1.0/css/weather-icons.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.css" rel="stylesheet" />

</head>
<body>

   
    <% 
        try{ 
        HttpSession miSesion=(HttpSession) request.getSession();
        UsuarioVO usuVO =(UsuarioVO) miSesion.getAttribute("usuLogin");
        UsuarioDAO usuDAO= new UsuarioDAO(usuVO);        
    %> 
     <%@include file="WEB-INF/Sesiones/sesion-validate.jspf"%>
     <%@include file="WEB-INF/Sesiones/sesion.jspf" %>
    <% 
    if(usuVO.getusuRol().equals("1")){%>
        
        <aside id="left-panel" class="left-panel">
        
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    
                    
                    
                    <li class="active">
                        <a href="Menu_principal.jsp"><i class="menu-icon fa fa-laptop"></i>Dashboard </a>
                    </li>
                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Profesores</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Profesor.jsp">Ver </a></li>
                             <li><i class="fa fa-table"></i><a href="ingresarProfesor.jsp">Registrar</a></li>
                        </ul>
                       
                    </li>
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Cursos</a>
                        <ul class="sub-menu children dropdown-menu">
                          
                             <li><i class="fa fa-table"></i><a href="Curso.jsp">Ver </a></li>
                             <li><i class="fa fa-table"></i><a href="insertarCurso.jsp">Registrar</a></li>
                        </ul>
                       
                    </li>
                    
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Estudiantes</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Estudiantes.jsp">Ver </a></li>
                             <li><i class="fa fa-table"></i><a href="ingresarEstudiante.jsp">Registrar</a></li>
                        </ul>
                       
                    </li>
                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Empleados</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Empleado.jsp">Ver </a></li>
                            <li><i class="fa fa-table"></i><a href="insertarEmpleados.jsp">Registrar</a></li>
                        </ul>             
                    </li>

                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>Producto</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="Producto.jsp">Ver </a></li>
                            <li><i class="fa fa-table"></i><a href="ingresarProducto.jsp">Registrar</a></li>
                        </ul>
                    </li>
                    
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Prestamos</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Prestamo.jsp">Realizar prestamos </a></li>
                            <li><i class="fa fa-table"></i><a href="Lista_prestamos.jsp">Ver prestamos activos</a></li>
                            <li><i class="fa fa-table"></i><a href="Listar_todos_prestamos.jsp">Ver todos los prestamos</a></li>
                        </ul>
                    </li>
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Mi sesion</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Csesion">Cerrar sesion</a></li> 
                            <li><i class="fa fa-table"></i><a href="Cambio_de_clave.jsp">Cambiar mi contraseña</a></li>
                            <li><i class="fa fa-table"></i><a href="https://drive.google.com/open?id=1jaewsQYWcdjaUFfatu39EXdKLbSQ6e0a">Ayuda</a></li>
                        </ul>
                    </li> 
                              
        </nav>
    </aside>
         
    <% } 
    else if(usuVO.getusuRol().equals("2")){%>
        <aside id="left-panel" class="left-panel">
        
        <nav class="navbar navbar-expand-sm navbar-default">
            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    
                    
                    
                    <li class="active">
                        <a href="Menu_principal.jsp"><i class="menu-icon fa fa-laptop"></i>Dashboard </a>
                    </li>
                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Profesores</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Profesor.jsp">Ver </a></li>
                            <li><i class="fa fa-table"></i><a href="ingresarUsuario.jsp">Registrar</a></li>
                        </ul>
                      
                    </li>
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Cursos</a>
                        <ul class="sub-menu children dropdown-menu">
                          
                             <li><i class="fa fa-table"></i><a href="Curso.jsp">Ver </a></li>
                             <li><i class="fa fa-table"></i><a href="insertarCurso.jsp">Registrar</a></li>
                        </ul>
                       
                    </li>
                    
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Estudiantes</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Estudiantes.jsp">Ver </a></li>
                             <li><i class="fa fa-table"></i><a href="ingresarEstudiante.jsp">Registrar</a></li>
                        </ul>                     
                    </li>


                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>Producto</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="Producto.jsp">Ver </a></li>
                            <li><i class="fa fa-table"></i><a href="ingresarProducto.jsp">Registrar producto</a></li>
                        </ul>
                        
                    </li>
                    
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Prestamos</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Prestamo.jsp">Realizar prestamos </a></li>
                            <li><i class="fa fa-table"></i><a href="Lista_prestamos.jsp">Ver prestamos activos</a></li>
                            <li><i class="fa fa-table"></i><a href="Listar_todos_prestamos.jsp">Ver todos los prestamos</a></li>
                        </ul>
                    </li>
                     <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Mi sesion</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="Csesion">Cerrar sesion</a></li> 
                            <li><i class="fa fa-table"></i><a href="Cambio_de_clave.jsp">Cambiar mi contraseña</a></li>
                            <li><i class="fa fa-table"></i><a href="https://drive.google.com/open?id=1jaewsQYWcdjaUFfatu39EXdKLbSQ6e0a">Ayuda</a></li>
                        </ul>
                    </li> 
        </nav>
    </aside>
    <% }
    %>

                                    <div id="right-panel" class="right-panel">

                                        <!-- Header-->
                                        <header id="header" class="header">
                                            <div class="top-left">
                                                <div class="navbar-header">
                                                    <a class="navbar-brand" href="./"><img src="images/Gema_Complete_logo.png" alt="Logo"></a>
                                                    <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                                                </div>
                                            </div>

                                        </header>

                                        <div class="container">

                                            <div class="container-contact100">
                                                <div class="wrap-contact100">
                                                    <form class="contact100-form validate-form" method="post" action="profesores">

                                                        <span class="contact100-form-title">
                                                            Registrar Profesor
                                                        </span>
                                                        <div class="wrap-input100 validate-input bg1" data-validate="La Identificacion Es Obligatoria">
                                                            <span class="label-input100">Identificacion del Profesor</span>
                                                            <input class="input100" type="text" name="id_Profesor" onkeypress="return soloNumeros(evet)" maxlength="20" placeholder="Escribe la Identificacion de Profesor">
                                                        </div>

                                                        <div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate="El nombre es olbigatorio">
                                                            <span class="label-input100">Nombre*</span>
                                                            <input class="input100" type="text" name="nombre" onkeypress="return soloLetras(evet)" maxlength="40" placeholder="Escribe el Nombre del producto">
                                                        </div>
                                                        <div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate="El Apellido es obligatorio">
                                                            <span class="label-input100">Apellido *</span>
                                                            <input class="input100" type="text" name="apellido" onkeypress="return soloLetras(evet)" maxlength="40" placeholder="Escribe el Apellido del Profesor">
                                                        </div>
                                                        <div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate="El Telefono es obligatorio">
                                                            <span class="label-input100">Telefono *</span>
                                                            <input class="input100" type="number" name="telefono" onkeypress="return soloNumeros(evet)"  maxlength="12" placeholder="Escribe el Telefono del Profesor">
                                                        </div>
                                                        <div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate="La direccion es Obligatoria">
                                                            <span class="label-input100">Direccion *</span>
                                                            <input class="input100" type="text" name="direccion" maxlength="30" placeholder="Escribe la direccion del Profesor">
                                                        </div>
                                                        <div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate = "El correo es obligatorio (e@a.x)">
                                                            <span class="label-input100">Correo *</span>
                                                            <input class="input100" type="text" name="correo" maxlength="50" placeholder="Escribe el correo del Profesor">
                                                        </div> 

                                                        <div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate = "El cargo es obligatorio (ej.@gmail.com)">
                                                            <span class="label-input100">Cargo del profesor *</span>
                                                            <input class="input100" type="text" name="cargo" onkeypress="return soloLetras(evet)" maxlength="40" placeholder="Escribe el cargo del Profesor">
                                                        </div> 

                                                   
                                                        <input  type="hidden" name="estado" value="Activo">



                                                        <%
                                                            String Clave = "";
                                                            int a;
                                                            String CaracteresNoDeseados = "AEIOU";
                                                            for (int i = 0; i < 18; i++) {
                                                                if (i < 4) {    // 0,1,2,3 posiciones de numeros
                                                                    Clave = (int) (Math.random() * 9) + "" + Clave;

                                                                } else {       // 4,5,6 posiciones de letras
                                                                    do {
                                                                        a = (int) (Math.random() * 26 + 65);///
                                                                    } while (CaracteresNoDeseados.indexOf(a) >= 0);

                                                                    char letra = (char) a;
                                                                    if (i == 4) {
                                                                        Clave = Clave + letra;
                                                                    } else {
                                                                        Clave = Clave + "" + letra;
                                                                    }

                                                                }
                                                            }
                                                           
                                                           
                                                        %>


                                                        <input type="hidden" name="textPassword" value="<%= Clave %>">

                                                        <input type="hidden" name="Rol" value="3">
                                                        <input type="hidden" name="ingreso" value="0">



                                                        <input class="input100" type="hidden" name="de" value="maicolsnikacosta@gmail.com">
                                                        <input class="input100" type="hidden" name="clave" value="natsudragneel">
                                                        <input class="input100" type="hidden" name="Asunto" value="Registro">
                                                        <input class="input100" type="hidden" name="mensaje" value=" Usted a sido registrado correctamente en nuestro sistema su usuario es su identificacion y su contraseña provicional es: <%= Clave %> le recomendamos que cambie la contraseña apenas inicie sesion, gracias por usar nuestro servicio">

                                                        <div class="container-contact100-form-btn">
                                                            <button class="contact100-form-btn">
                                                                <span>
                                                                    Registrar   
                                                                    <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                                                </span>
                                                            </button>
                                                            <input type="hidden" name="opcion" value="1">
                                                        </div>

                                                    </form>
                                                </div>
                                            </div>

                                        </div>
                                    </div>

                                    <div class="clearfix"></div>


                                    <!-- Scripts -->
                                    <script src="validacion_letras.js"></script>
                                    <!--===============================================================================================-->
                                    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
                                    <!--===============================================================================================-->
                                    <script src="vendor/animsition/js/animsition.min.js"></script>
                                    <!--===============================================================================================-->
                                    <script src="vendor/bootstrap/js/popper.js"></script>
                                    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
                                    <!--===============================================================================================-->
                                    <script src="vendor/select2/select2.min.js"></script>
                                    <script src="script_select.js"></script>
                                    <!--===============================================================================================-->
                                    <script src="vendor/daterangepicker/moment.min.js"></script>
                                    <script src="vendor/daterangepicker/daterangepicker.js"></script>
                                    <!--===============================================================================================-->
                                    <script src="vendor/countdowntime/countdowntime.js"></script>
                                    <!--===============================================================================================-->
                                    <script src="vendor/noui/nouislider.min.js"></script>

                                    <!--===============================================================================================-->
                                    <script src="js/main.js"></script>

                                    <!-- Global site tag (gtag.js) - Google Analytics -->
                                    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>

                                    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
                                    <script src="assets/js/main.js"></script>

                                    <!--  Chart js -->
                                    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.7.3/dist/Chart.bundle.min.js"></script>

                                    <!--Chartist Chart-->
                                    <script src="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.js"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/chartist-plugin-legend@0.6.2/chartist-plugin-legend.min.js"></script>

                                    <script src="https://cdn.jsdelivr.net/npm/jquery.flot@0.8.3/jquery.flot.min.js"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/flot-pie@1.0.0/src/jquery.flot.pie.min.js"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/flot-spline@0.0.1/js/jquery.flot.spline.min.js"></script>

                                    <script src="https://cdn.jsdelivr.net/npm/simpleweather@3.1.0/jquery.simpleWeather.min.js"></script>
                                    <script src="assets/js/init/weather-init.js"></script>

                                    <script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
                                    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
                                    <script src="assets/js/init/fullcalendar-init.js"></script>

                                    <!--Local Stuff-->
                                    <script src="scripts_globales.js"></script>

                                    <%        if (request.getAttribute("mensajeError") != null) {
                                    %>
                                    ${mensajeError}
                                    <%    }%>

                                    <%
                                        if (request.getAttribute("mensajeExito") != null) {
                                    %>
                                    ${mensajeExito}
                                    <%    }%>

                                    <% } catch (Exception e) {
                                            response.sendRedirect("Index.jsp");
                                        }
                                    %>

                                    </body>
                                    </html>