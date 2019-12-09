
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="modeloVO.UsuarioVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modeloVO.CursosVO"%>
<%@page import="ModeloDAO.CursoDAO"%>
<%@page import="modeloVO.estudianteVO"%>
<%@page import="ModeloDAO.estudianteDAO"%>
<%@page import="ModeloDAO.Control_profeDAO"%>
<%@page import="modeloVO.Control_profeVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>

<html>
    <head>
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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Productos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="modificar_tablas_css.css">

        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>



        <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">
        <script src="vendor/jquery/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js%22%3E"></script>


  
    </head>
    <body>
        <!-- Left Panel -->
        <%
            try {
                HttpSession miSesion = (HttpSession) request.getSession();
                UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("usuLogin");
                UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
                usuVO.getUsuId();

        %> 
        <!-- Left Panel -->

        <%         Control_profeVO CrontrolVO2 = new Control_profeVO();
            Control_profeDAO CrontrolDAO2 = new Control_profeDAO(CrontrolVO2);
            ArrayList<Control_profeVO> IncrementarControl = CrontrolDAO2.listar();
            for (int i = 0; i < IncrementarControl.size(); i++) {
                CrontrolVO2 = IncrementarControl.get(i);
            }

            String num1 = CrontrolVO2.getId_control_profesor();
            String numero_completo = "";

            if (num1 == null) {
                numero_completo = "1";
            } else {
                int numero = Integer.parseInt(num1);
                int num_incre = numero + 1;
                numero_completo = Integer.toString(num_incre);
            }


        %>

        <aside id="left-panel" class="left-panel">

            <nav class="navbar navbar-expand-sm navbar-default">
                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">



                        <li class="active">
                            <a href="Menu_profesor.jsp"><i class="menu-icon fa fa-laptop"></i>Dashboard </a>
                        </li>

                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Mi inventario</a>
                            <ul class="sub-menu children dropdown-menu">
                                <li><i class="fa fa-table"></i><a href="Inventario_Profesor.jsp">Ver</a></li>

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



        <div id="right-panel" class="right-panel">

            <!-- Header-->
            <header id="header" class="header">
                <div class="top-left">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="./"><img src="images/Gema_Complete_logo.png" alt="Logo"></a>
                        <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
                        <a id="menuToggle" class="menutoggle"><i class="fa fa-bars"></i></a>
                    </div>
                </div>

            </header>

            <div class="container">
                <div class="container-contact100">
                    <div class="wrap-contact100">


                        <span class="contact100-form-title">
                            Ver Productos
                        </span>



                        <form name="form1" class="contact100-form validate-form" method="post" action="Inventario_Profesor.jsp">
                            <div class="wrap-input100 validate-input bg1" data-validate="El curso Es Obligatorio">
                                <span class="label-input100">Curso:</span>
                                <div>

                                    <select class="js-select2" name="textCurso">
                                        <% 
                                            CursosVO curVO = new CursosVO();
                                            CursoDAO curDAO = new CursoDAO(curVO);
                                            ArrayList<CursosVO> cursos = curDAO.listarcursos();
                                            for (int a = 0; a < cursos.size(); a++) {
                                                curVO = cursos.get(a);

                                        %> 
                                        <option><%= curVO.getIdCurso()%></option>    
                                        <% } %>
                                    </select>

                                    <div class="dropDownSelect2"></div>
                                </div>
                            </div>
                            <div class="container-contact100-form-btn">
                                <button class="contact100-form-btn">       
                                    <span>   
                                        Registrar
                                        <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                    </span>
                                </button>  
                            </div>  
                        </form>

                        <br>
                        <br>
                        <form action="Controlprofe" method="post">
                            <table id="table_id" class="table display AllDataTables" style="width:100%">                  
                                <thead>
                                    <tr>                          
                                        <th>Serial</th>
                                        <th>Curso</th>
                                        <th>Identificacion del estudiante</th>
                                        <th>Acciones</th> 
                                    </tr>
                                </thead>

                                <tbody>

                                    <%
                                        String id_profesor = usuVO.getUsuId();
                                        Control_profeVO ControlVO = new Control_profeVO();
                                        Control_profeDAO ControlDAO = new Control_profeDAO(ControlVO);
                                        ArrayList<Control_profeVO> ListarControl = ControlDAO.listar(id_profesor);
                                        for (int i = 0; i < ListarControl.size(); i++) {
                                            ControlVO = ListarControl.get(i);

                                            String CursoDG = null;
                                            if (request.getParameter("textCurso") != null) {
                                                CursoDG = request.getParameter("textCurso");
                                            }
                                            else{
                                                CursoDG = "Digite un curso";
                                            }
                                    %>                   

                                    <tr>  

                                        <td >
                                            <%= ControlVO.getSerial()%>
                                        </td>

                                        <td>
                                            <%
                                                out.println(CursoDG);
                                            %>                                                          
                                        </td>                

                                        <td>

                                            <select class="js-select2_no_funque" name="textEstudiantes">
                                                <%
                                                    String CursoE = request.getParameter("textCurso");
                                                    CursosVO CuVO = new CursosVO();
                                                    CursoDAO CuDAO = new CursoDAO(CuVO);
                                                    ArrayList<CursosVO> Estudiante_curso = CuDAO.listarC(CursoDG);
                                                    for (int e = 0; e < Estudiante_curso.size(); e++) {
                                                        CuVO = Estudiante_curso.get(e);
                                                %> 
                                                <option><%=  CuVO.getEs_id()%></option>    
                                                <% }%>
                                            </select>

                                        </td>  

                                        <td>                 
                                            <input type="submit" value="Dar a estudiante">       
                                        </td>
                                    </tr>     
                                <input type="hidden" name="opcion" value="1"> 
                                <input type="hidden" name="Num_control" value="<%=numero_completo%>"> 
                                <input type="hidden" name="Num_detalle" value="<%=ControlVO.getId_detalle()%>"> 
                                <input type="hidden" name="Id_empleado" value="<%=ControlVO.getId_empleado()%>"> 
                                <input type="hidden" name="Id_profesor" value="<%=usuVO.getUsuId()%>"> 
                                <input type="hidden" name="Estado" value="Perfecto"> 
                                <input type="hidden" name="Curso" value="<%= CursoE%>">
                                <input type="hidden" name="Estado_Prestamo" value="Activo">
                                <input type="hidden" name="Estado_Detalle" value="Inactivo">
                                <input type="hidden" name="Observacion" value="ninguna">
                                <% } %>                                        
                                </tbody>                                                
                            </table>
                        </form>
                        <script>
                            $(document).ready(function () {
                                $('.AllDataTables').DataTable({
                                    language: {
                                        "sProcessing": "Procesando...",
                                        "sLengthMenu": "Mostrar _MENU_  registros",
                                        "sZeroRecords": "No se encontraron resultados",
                                        "sEmptyTable": "Ningún dato disponible en esta tabla",
                                        "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                                        "sInfoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                                        "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                                        "sInfoPostFix": "",
                                        "sSearch": "Buscar:",
                                        "sUrl": "",
                                        "sInfoThousands": ",",
                                        "sLoadingRecords": "Cargando...",
                                        "oPaginate": {
                                            "sFirst": "Primero",
                                            "sLast": "Último",
                                            "sNext": "Siguiente",
                                            "sPrevious": "Anterior"
                                        },
                                        "oAria": {
                                            "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                                            "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                                        }
                                    }
                                });
                            });
                        </script>

                        </form>
                    </div>
                </div>
            </div>

        </div>

        <div class="clearfix"></div>


        <!-- Scripts -->
        <!--===============================================================================================-->
        <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2/select2.min.js"></script>
        <script>
                            $(".js-select2").each(function () {
                                $(this).select2({
                                    minimumResultsForSearch: 20,
                                    dropdownParent: $(this).next('.dropDownSelect2')
                                });


                                $(".js-select2").each(function () {
                                    $(this).on('select2:close', function (e) {
                                        if ($(this).val() == "Please chooses") {
                                            $('.js-show-service').slideUp();
                                        } else {
                                            $('.js-show-service').slideUp();
                                            $('.js-show-service').slideDown();
                                        }
                                    });
                                });
                            })
        </script>
        <!--===============================================================================================-->
        <script src="vendor/daterangepicker/moment.min.js"></script>
        <script src="vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/countdowntime/countdowntime.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/noui/nouislider.min.js"></script>
        <script>
                            var filterBar = document.getElementById('filter-bar');

                            noUiSlider.create(filterBar, {
                                start: [1500, 3900],
                                connect: true,
                                range: {
                                    'min': 1500,
                                    'max': 7500
                                }
                            });

                            var skipValues = [
                                document.getElementById('value-lower'),
                                document.getElementById('value-upper')
                            ];

                            filterBar.noUiSlider.on('update', function (values, handle) {
                                skipValues[handle].innerHTML = Math.round(values[handle]);
                                $('.contact100-form-range-value input[name="from-value"]').val($('#value-lower').html());
                                $('.contact100-form-range-value input[name="to-value"]').val($('#value-upper').html());
                            });
        </script>
        <!--===============================================================================================-->
        <script src="js/main.js"></script>

        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
        <script>
                            window.dataLayer = window.dataLayer || [];
                            function gtag() {
                                dataLayer.push(arguments);
                            }
                            gtag('js', new Date());

                            gtag('config', 'UA-23581568-13');
        </script>
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
        <script>
                            jQuery(document).ready(function ($) {
                                "use strict";

                                // Pie chart flotPie1
                                var piedata = [
                                    {label: "Desktop visits", data: [[1, 32]], color: '#5c6bc0'},
                                    {label: "Tab visits", data: [[1, 33]], color: '#ef5350'},
                                    {label: "Mobile visits", data: [[1, 35]], color: '#66bb6a'}
                                ];

                                $.plot('#flotPie1', piedata, {
                                    series: {
                                        pie: {
                                            show: true,
                                            radius: 1,
                                            innerRadius: 0.65,
                                            label: {
                                                show: true,
                                                radius: 2 / 3,
                                                threshold: 1
                                            },
                                            stroke: {
                                                width: 0
                                            }
                                        }
                                    },
                                    grid: {
                                        hoverable: true,
                                        clickable: true
                                    }
                                });
                                // Pie chart flotPie1  End
                                // cellPaiChart
                                var cellPaiChart = [
                                    {label: "Direct Sell", data: [[1, 65]], color: '#5b83de'},
                                    {label: "Channel Sell", data: [[1, 35]], color: '#00bfa5'}
                                ];
                                $.plot('#cellPaiChart', cellPaiChart, {
                                    series: {
                                        pie: {
                                            show: true,
                                            stroke: {
                                                width: 0
                                            }
                                        }
                                    },
                                    legend: {
                                        show: false
                                    }, grid: {
                                        hoverable: true,
                                        clickable: true
                                    }

                                });
                                // cellPaiChart End
                                // Line Chart  #flotLine5
                                var newCust = [[0, 3], [1, 5], [2, 4], [3, 7], [4, 9], [5, 3], [6, 6], [7, 4], [8, 10]];

                                var plot = $.plot($('#flotLine5'), [{
                                        data: newCust,
                                        label: 'New Data Flow',
                                        color: '#fff'
                                    }],
                                        {
                                            series: {
                                                lines: {
                                                    show: true,
                                                    lineColor: '#fff',
                                                    lineWidth: 2
                                                },
                                                points: {
                                                    show: true,
                                                    fill: true,
                                                    fillColor: "#ffffff",
                                                    symbol: "circle",
                                                    radius: 3
                                                },
                                                shadowSize: 0
                                            },
                                            points: {
                                                show: true
                                            },
                                            legend: {
                                                show: false
                                            },
                                            grid: {
                                                show: false
                                            }
                                        });
                                // Line Chart  #flotLine5 End
                                // Traffic Chart using chartist
                                if ($('#traffic-chart').length) {
                                    var chart = new Chartist.Line('#traffic-chart', {
                                        labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
                                        series: [
                                            [0, 18000, 35000, 25000, 22000, 0],
                                            [0, 33000, 15000, 20000, 15000, 300],
                                            [0, 15000, 28000, 15000, 30000, 5000]
                                        ]
                                    }, {
                                        low: 0,
                                        showArea: true,
                                        showLine: false,
                                        showPoint: false,
                                        fullWidth: true,
                                        axisX: {
                                            showGrid: true
                                        }
                                    });

                                    chart.on('draw', function (data) {
                                        if (data.type === 'line' || data.type === 'area') {
                                            data.element.animate({
                                                d: {
                                                    begin: 2000 * data.index,
                                                    dur: 2000,
                                                    from: data.path.clone().scale(1, 0).translate(0, data.chartRect.height()).stringify(),
                                                    to: data.path.clone().stringify(),
                                                    easing: Chartist.Svg.Easing.easeOutQuint
                                                }
                                            });
                                        }
                                    });
                                }
                                // Traffic Chart using chartist End
                                //Traffic chart chart-js
                                if ($('#TrafficChart').length) {
                                    var ctx = document.getElementById("TrafficChart");
                                    ctx.height = 150;
                                    var myChart = new Chart(ctx, {
                                        type: 'line',
                                        data: {
                                            labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul"],
                                            datasets: [
                                                {
                                                    label: "Visit",
                                                    borderColor: "rgba(4, 73, 203,.09)",
                                                    borderWidth: "1",
                                                    backgroundColor: "rgba(4, 73, 203,.5)",
                                                    data: [0, 2900, 5000, 3300, 6000, 3250, 0]
                                                },
                                                {
                                                    label: "Bounce",
                                                    borderColor: "rgba(245, 23, 66, 0.9)",
                                                    borderWidth: "1",
                                                    backgroundColor: "rgba(245, 23, 66,.5)",
                                                    pointHighlightStroke: "rgba(245, 23, 66,.5)",
                                                    data: [0, 4200, 4500, 1600, 4200, 1500, 4000]
                                                },
                                                {
                                                    label: "Targeted",
                                                    borderColor: "rgba(40, 169, 46, 0.9)",
                                                    borderWidth: "1",
                                                    backgroundColor: "rgba(40, 169, 46, .5)",
                                                    pointHighlightStroke: "rgba(40, 169, 46,.5)",
                                                    data: [1000, 5200, 3600, 2600, 4200, 5300, 0]
                                                }
                                            ]
                                        },
                                        options: {
                                            responsive: true,
                                            tooltips: {
                                                mode: 'index',
                                                intersect: false
                                            },
                                            hover: {
                                                mode: 'nearest',
                                                intersect: true
                                            }

                                        }
                                    });
                                }
                                //Traffic chart chart-js  End
                                // Bar Chart #flotBarChart
                                $.plot("#flotBarChart", [{
                                        data: [[0, 18], [2, 8], [4, 5], [6, 13], [8, 5], [10, 7], [12, 4], [14, 6], [16, 15], [18, 9], [20, 17], [22, 7], [24, 4], [26, 9], [28, 11]],
                                        bars: {
                                            show: true,
                                            lineWidth: 0,
                                            fillColor: '#ffffff8a'
                                        }
                                    }], {
                                    grid: {
                                        show: false
                                    }
                                });
                                // Bar Chart #flotBarChart End
                            });
        </script>

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

        <% } catch (Exception e) {
                response.sendRedirect("Index.jsp");
            }
        %>

    </body>
</html>
