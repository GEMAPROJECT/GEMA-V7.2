
<%@page import="java.util.ArrayList"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="ModeloDAO.*"%>
<%@page import="modeloVO.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>

<html class="no-js" lang=""> 
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Menu principal</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

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
                            <li><i class="fa fa-table"></i><a href="ControlesProducto.jsp">Ver Controles de productos</a></li>
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
    
    <!-- /#left-panel -->
    <!-- Right Panel -->
    <div id="right-panel" class="right-panel">
        <!-- Header-->
        <header id="header" class="header">
            <div class="top-left">
                <div class="navbar-header">
                    <a class="navbar-brand" href="./"><img src="images/Gema_Complete_logo.png" alt="Logo"></a>
                    <a class="navbar-brand hidden" href="./"><img src="images/Gema_Complete_logo.png" alt="Logo"></a>
                    <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                </div>
            </div>
            
        </header>
        <!-- /#header -->
        <!-- Content -->
        <div class="content">
            <!-- Animated -->
            <div class="animated fadeIn">
                <!-- Widgets  -->
                <div class="row">
                    

                    <div class="col-lg-3 col-md-6">
                        <div class="card">
                            <div class="card-body">
                                <div class="stat-widget-five">
                                    <div class="stat-icon dib flat-color-3">
                                        <i class="pe-7s-browser"></i>
                                    </div>
                                    <div class="stat-content">
                                        <div class="text-left dib">
                                            
                                             <%
                                                            PrestamosVO PreVO = new PrestamosVO();
                                                            PrestamosDAO PreDAO = new PrestamosDAO(PreVO);
                                                            ArrayList<PrestamosVO> Listanum_prestamo = PreDAO.listar();
                                                            for (int i = 0; i < Listanum_prestamo.size(); i++) {
                                                                PreVO = Listanum_prestamo.get(i);
                                                            }

                                                             
                                                   %>
                                            <div class="stat-text"><span class="count"><%= PreVO.getNum_prestamo()%></span></div>
                                            <div class="stat-heading">Prestamos</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="card">
                            <div class="card-body">
                                <div class="stat-widget-five">
                                    <div class="stat-icon dib flat-color-4">
                                        <i class="pe-7s-users"></i>
                                    </div>
                                    <div class="stat-content">
                                        <div class="text-left dib">
                                            <div class="stat-text"><span class="count">26</span></div>
                                            <div class="stat-heading">Profesores</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /Widgets -->
                <!--  Traffic  -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="box-title">Graficas </h4>
                            </div>
                            <div class="row">
                                <div class="col-lg-8">
                                    <div class="card-body">
                                        <!-- <canvas id="TrafficChart"></canvas>   -->
                                        <div id="traffic-chart" class="traffic-chart"></div>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="card-body">
                                       
                                        <div class="progress-box progress-2">
                                            <h4 class="por-title">dañados</h4>
                                            <div class="por-txt">2 (24%)</div>
                                            <div class="progress mb-2" style="height: 5px;">
                                                <div class="progress-bar bg-flat-color-2" role="progressbar" style="width: 24%;" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                   
                                        <div class="progress-box progress-2">
                                            <h4 class="por-title">Mas pedido</h4>
                                            <div class="por-txt">99 pc (90%)</div>
                                            <div class="progress mb-2" style="height: 5px;">
                                                <div class="progress-bar bg-flat-color-4" role="progressbar" style="width: 90%;" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100"></div>
                                            </div>
                                        </div>
                                    </div> <!-- /.card-body -->
                                </div>
                            </div> <!-- /.row -->
                            <div class="card-body"></div>
                        </div>
                    </div><!-- /# column -->
                </div>
               
      
    </div>


    <!-- Scripts -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
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

    
     <% }
        catch(Exception e){
        response.sendRedirect("Index.jsp");
        }
    %>
    
    
</body>
</html>