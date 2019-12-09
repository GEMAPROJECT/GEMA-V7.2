 


<%@page import="ModeloDAO.Control_profeDAO"%>
<%@page import="modeloVO.Control_profeVO"%>
<%@page import="ModeloDAO.*"%>
<%@page import="modeloVO.*"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<title>Registrar Producto</title>


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
<style>
    #weatherWidget .currentDesc {
        color: #ffffff!important;
    }
    .traffic-chart {
        min-height: 335px;
    }
    #flotPie1  {
        height: 150px;
    }
    #flotPie1 td {
        padding:3px;
    }
    #flotPie1 table {
        top: 20px!important;
        right: -10px!important;
    }
    .chart-container {
        display: table;
        min-width: 270px ;
        text-align: left;
        padding-top: 10px;
        padding-bottom: 10px;
    }
    #flotLine5  {
        height: 105px;
    }

    #flotBarChart {
        height: 150px;
    }
    #cellPaiChart{
        height: 160px;
    }

</style>
</head>
<body>

    <%
        try {
            HttpSession miSesion = (HttpSession) request.getSession();
            UsuarioVO usuVO = (UsuarioVO) miSesion.getAttribute("usuLogin");
            UsuarioDAO usuDAO = new UsuarioDAO(usuVO);
    %> 
    <%@include file="WEB-INF/Sesiones/sesion-validate.jspf"%>
    <%@include file="WEB-INF/Sesiones/sesion.jspf" %>
    <%        if (usuVO.getusuRol().equals("1")) {%>

    <aside id="left-panel" class="left-panel">

        <nav class="navbar navbar-expand-sm navbar-default">


        </nav>
    </aside>

    <% } else if (usuVO.getusuRol().equals("2")) {%>
    <aside id="left-panel" class="left-panel">

        <nav class="navbar navbar-expand-sm navbar-default">

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
                    <span class="contact100-form-title">
                        Prestar Productos
                    </span>

                    <form class="contact100-form validate-form" method="post" action="PrestamoParte2.jsp">
                        <div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate="El Serial Es Obligatorio">
                            <span class="label-input100">Nombre del producto</span>
                            <div>
                                <select class="js-select2" name="nombre_producto">

                                    <%
                                        ProductoVO ProVO2 = new ProductoVO();
                                        ProductoDAO ProDAO2 = new ProductoDAO(ProVO2);
                                        ArrayList<ProductoVO> listaNombre = ProDAO2.listar_nombre();
                                        for (int i = 0; i < listaNombre.size(); i++) {
                                            ProVO2 = listaNombre.get(i);
                                    %>
                                    <option><%= ProVO2.getNombre()%></option>    

                                    <% }%>   
                                </select>              
                                <div class="dropDownSelect2"></div>
                            </div>
                        </div>

                        <div class="rs1-wrap-input100">
                            <button class="contact100-form-btn">       
                                <span>   
                                    Registrar
                                    <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                </span>
                            </button>  
                        </div>
                    </form>

                    <form class="contact100-form validate-form" method="post" action="DeallePrestamo">                    
                        <%
                            PrestamosVO PreVO = new PrestamosVO();
                            PrestamosDAO PreDAO = new PrestamosDAO(PreVO);
                            ArrayList<PrestamosVO> Listanum_prestamo = PreDAO.listar();
                            for (int i = 0; i < Listanum_prestamo.size(); i++) {
                                PreVO = Listanum_prestamo.get(i);
                            }

                            String num1 = PreVO.getNum_prestamo();
                            String numero_completo;

                            if (num1 == null) {
                                numero_completo = "1";
                            } else {
                                numero_completo = PreVO.getNum_prestamo();
                            }

                        %>

                        <%                                                            DetatallePrestamoVO DeVO = new DetatallePrestamoVO();
                            DetallePrestamoDAO DEDAO = new DetallePrestamoDAO(DeVO);
                            ArrayList<DetatallePrestamoVO> ListarID = DEDAO.listarID_detalle();
                            for (int i = 0; i < ListarID.size(); i++) {
                                DeVO = ListarID.get(i);
                            }

                            String num = DeVO.getId_detalle();
                            String numero = "";

                            if (num == null) {
                                numero = "1";
                            } else {
                                int incre = Integer.parseInt(num);
                                int num_incre = incre + 1;
                                numero = Integer.toString(num_incre);

                            }

                        %>       


                        <%        Control_profeVO CrontrolVO2 = new Control_profeVO();
                            Control_profeDAO CrontrolDAO2 = new Control_profeDAO(CrontrolVO2);
                            ArrayList<Control_profeVO> IncrementarControl = CrontrolDAO2.listar();
                            for (int i = 0; i < IncrementarControl.size(); i++) {
                                CrontrolVO2 = IncrementarControl.get(i);
                            }

                            String num2 = CrontrolVO2.getId_control_profesor();
                            String numero_completo1 = "";

                            if (num2 == null) {
                                numero_completo1 = "1";
                            } else {
                                int numero1 = Integer.parseInt(num1);
                                int num_incren = numero1 + 1;
                                numero_completo1 = Integer.toString(num_incren);
                            }


                        %>


                        <%                                                                    String id_profesor = usuVO.getUsuId();
                            Control_profeVO ControlVO = new Control_profeVO();
                            Control_profeDAO ControlDAO = new Control_profeDAO(ControlVO);
                            ArrayList<Control_profeVO> ListarControl = ControlDAO.listar(id_profesor);
                            for (int i = 0; i < ListarControl.size(); i++) {
                                ControlVO = ListarControl.get(i);
                            }


                        %>

                        <input class="input100" type="hidden" name="textDetalle" value="<%= numero%>">



                        <input class="input100" type="hidden" name="textnum_presta" value="<%= numero_completo%>">



                        <%   String Cantidad = ""; %> 

                        <div class="wrap-input100 validate-input bg1 rs1-wrap-input100" data-validate="El Serial Es Obligatorio">
                            <span class="label-input100">Serial:</span>
                            <div>

                                <select class="js-select2" name="txtSerial">

                                    <%
                                        String nombre = request.getParameter("nombre_producto");
                                        ProductoVO ProVO = new ProductoVO();
                                        ProductoDAO ProDAO = new ProductoDAO(ProVO);
                                        ArrayList<ProductoVO> listaProducto2 = ProDAO.listarP(nombre);
                                        for (int i = 0; i < listaProducto2.size(); i++) {
                                            ProVO = listaProducto2.get(i);

                                            Cantidad = ProVO.getCantidad();
                                    %>
                                    <option><%= ProVO.getSerial()%></option>    

                                    <% }%> 

                                </select>              
                                <div class="dropDownSelect2"></div>
                            </div>
                        </div>                                                                                                            
                        <input type="hidden" name="Cantidad" value="<%= Cantidad%>">


                        <div class="wrap-input100  bg1 rs1-wrap-input100">
                            <span class="label-input100">Cantidad</span>
                            <input class="input100" type="Number" name="txtCantidad">
                        </div>                   

                        <input type="hidden" min="0" max="8" class="input100" name="estado" value="Activo">

                        <div class="container-contact100-form-btn">
                            <button class="contact100-form-btn">
                                <span>
                                    Registrar
                                    <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                </span>
                            </button>
                            <input  type="hidden" name="opcion" value="1">
                        </div>
                    </form>
                    <form class="contact100-form validate-form" method="post" action="DeallePrestamo">    
                        <table id="table_id" class="table display AllDataTables" style="width:100%">               
                            <thead>
                                <tr>                          
                                    <th>Serial</th>
                                    <th>Nombre</th>
                                    <th>Observaciones</th>
                                    <th>Acciones</th> 
                                </tr>
                            </thead>
                            <tbody> 
                                <%
                                    String num_prest = numero_completo;
                                    ProductoVO ProVO4 = new ProductoVO();
                                    ProductoDAO ProDAO4 = new ProductoDAO(ProVO4);
                                    ArrayList<ProductoVO> Productos_carrito = ProDAO4.listarCon(num_prest);
                                    for (int i = 0; i < Productos_carrito.size(); i++) {
                                        ProVO4 = Productos_carrito.get(i);
                                        
                                        
                                       String detalle = ProVO4.getId_detalle();
                                %>
                                <tr>  
                                    <td>
                                        <%= ProVO4.getSerial()%>
                                    </td>
                                    <td>
                                        <%= ProVO4.getNombre()%>
                                    </td>                
                                    <td>
                                        <%= ProVO4.getObservacion()%>
                                    </td>  
                                    <td>                 
                                        <input type="submit" value="Eliminar">       
                                    </td>
                                </tr>
                            <input  type="hidden" name="opcion" value="2">
                            <input  type="hidden" name="detalle" value="<%= detalle %>">
                            <input  type="hidden" name="txtSerial" value="<%= ProVO4.getSerial()%>">
                            <% } %>
                            </tbody>     
                        </table> 
                    </form>

                    <form method="post" action="DeallePrestamo">                      
                        <input  type="hidden" name="nume_prest" value="<%= num_prest %>">
                        <input  type="hidden" name="opcion" value="3">                       
                        <div class="container-contact100-form-btn">
                            <div class="container-contact100-form-btn">
                                <button class="contact100-form-btn">
                                    <span>
                                        Finalizar
                                        <i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
                                    </span>
                                </button>                                                       
                            </div>
                        </div>
                    </form>   
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
        <!--==================sdsd=============================================================================-->
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
                                show: true,
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


