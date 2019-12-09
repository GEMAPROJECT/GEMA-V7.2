-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-11-2019 a las 16:35:36
-- Versión del servidor: 10.3.15-MariaDB
-- Versión de PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `prueba2`
--
CREATE DATABASE IF NOT EXISTS `prueba2` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `prueba2`;

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Activar_producto` (IN `_Serial` VARCHAR(20))  BEGIN
UPDATE productos SET estado = 'Activo' WHERE Serial = _Serial;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarControl` (IN `_id_control_profesor` INT(11), IN `_Estado` ENUM('Perfecto','Danado','No devuelto'), IN `_descripcion` VARCHAR(200), IN `_Estado_Prestamo` ENUM('Activo','Inactivo'))  BEGIN
UPDATE control_profe set Estado = _Estado , descripcion = _descripcion , Estado_Prestamo = _Estado_Prestamo where id_control_profesor = _id_control_profesor;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarCurso` (IN `_id_curso` INT(5), IN `_id_profe` VARCHAR(30))  BEGIN
UPDATE curso SET  id_curso = _id_curso, id_profe=_id_profe where id_curso = _id_curso;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarEmpleado` (IN `_id_empleado` VARCHAR(20), IN `_id_usuario` VARCHAR(20), IN `_nombre` VARCHAR(40), IN `_apellidos` VARCHAR(40), IN `_telefono` VARCHAR(12), IN `_direccion` VARCHAR(30), IN `_correo` VARCHAR(50), IN `_observaciones` VARCHAR(200), IN `_estado` VARCHAR(10))  BEGIN
update empleados_administradores 
set nombre = _nombre, apellidos = _apellidos, telefono = _telefono, direccion = _direccion, correo = _correo, observaciones = _observaciones, estado = _estado 
where id_empleado = _id_empleado;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarEstadoDetalle` (IN `_id_detalle` INT(11), IN `_estado` ENUM('Activo','Inactivo'))  BEGIN
UPDATE detalle_prestamo set estado = _estado WHERE id_detalle = _id_detalle;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarEstadoProducto` (IN `_Serial` VARCHAR(20))  BEGIN
UPDATE productos SET estado = 'Prestado' WHERE Serial = _Serial ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarEstudiantes` (`_id_estudiante` VARCHAR(15), `_Nombre_estudiante` VARCHAR(60), `_apellidos_studiante` VARCHAR(60), `_id_curso` INT(11), `_estado` ENUM('Activo','Inactivo'))  begin
	update estudiantes set Nombre_estudiante = _Nombre_estudiante, apellidos_studiante= _apellidos_studiante, id_curso = _id_curso, estado = _estado where id_estudiante = _id_estudiante;
		End$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarProducto` (IN `_id_producto` VARCHAR(20), IN `_nombre` VARCHAR(40), IN `_tipo_producto` VARCHAR(50), IN `_Serial` VARCHAR(20), IN `_Observacion` VARCHAR(200), IN `_cantidad` INT(11), IN `_estado` ENUM('Activo','Inactivo'))  BEGIN
update productos set  nombre= _nombre, tipo_producto = _tipo_producto, id_producto = _id_producto, Observacion = _Observacion, cantidad = _cantidad, estado = _estado where serial = _Serial;
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarProfesor` (IN `_id_profesor` VARCHAR(20), IN `_id_usuario` VARCHAR(20), IN `_nombre` VARCHAR(40), IN `_apellidos` VARCHAR(40), IN `_telefono` VARCHAR(12), IN `_correo` VARCHAR(50), IN `_direccion` VARCHAR(30), IN `_Cargo_del_profesor` VARCHAR(40), IN `_estado` ENUM('Activo','Inactivo'))  BEGIN
update profesores 
set nombre = _nombre, apellidos = _apellidos, telefono = _telefono, correo = _correo, direccion = _direccion, Cargo_del_profesor = _Cargo_del_profesor, estado = estado
where id_profesor = _id_profesor;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AgregarDetalle_prestamo` (`_id_detalle` INT(11), `_nume_prestamo` INT(11), `_cantidad` INT(11), `_Serial` VARCHAR(20), `_estado` ENUM('Activo','inactivo'))  BEGIN 
insert into detalle_prestamo (id_detalle,nume_prestamo,cantidad,Serial,estado) values (_id_detalle,_nume_prestamo,_cantidad,_Serial,_estado);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `AgregarPrestamos` (IN `_nume_prestamo` INT(11), IN `_id_empleado` VARCHAR(20), IN `_id_profesor` VARCHAR(20), IN `_fecha_prestamo` DATE, IN `_fecha_Entrega` DATE, IN `_id_hora_entrega` INT(11), IN `_id_hora_devolucion` INT(11), IN `_estado` ENUM('Activo','Inactivo'))  BEGIN 
insert into prestamos (nume_prestamo, id_empleado,id_profesor,fecha_prestamo, fecha_Entrega, id_hora_entrega,id_hora_devolucion ,estado) 
values  (_nume_prestamo,_id_empleado,_id_profesor,_fecha_prestamo,_fecha_Entrega,_id_hora_entrega,_id_hora_devolucion,_estado) ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cambiarClave` (IN `_id_usuario` CHAR(20), IN `_contraseña` CHAR(30))  BEGIN
UPDATE usuario set contraseña = _contraseña WHERE id_usuario = _id_usuario;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cambiarClave2` (IN `_id_usuario` CHAR(20), IN `_contraseña` CHAR(30))  BEGIN
UPDATE usuarios set ingreso = 1 ,contraseña = _contraseña WHERE id_usuario = _id_usuario;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `EliminarDetalle_prestamo` (IN `_id_detalle` INT(11))  BEGIN
DELETE FROM detalle_prestamo WHERE id_detalle = _id_detalle;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FinalizarPrestamo` (IN `_id_detalle` INT(11), IN `_estado` ENUM('Activo','Inactivo'))  BEGIN
UPDATE detalle_prestamo SET estado = _estado WHERE id_detalle = _id_detalle;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FinalizarPrestamo2` (IN `_Serial` VARCHAR(11), IN `_Observacion` VARCHAR(300), IN `_estado` ENUM('Activo','Prestado','Inactivo'))  BEGIN
UPDATE productos SET Observacion = _Observacion , estado = _estado WHERE Serial = _Serial;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `FinalizarPrestamo3` (IN `_nume_prestamo` INT(11), IN `_estado` ENUM('Activo','Inactivo'))  BEGIN
UPDATE prestamos SET estado = _estado  WHERE nume_prestamo =  _nume_prestamo;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `IncrementarControl` ()  BEGIN 
SELECT * FROM control_profe ORDER BY id_control_profesor DESC LIMIT 1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Incrementar_num_prestamo` ()  BEGIN
SELECT * FROM prestamos ORDER BY nume_prestamo DESC LIMIT 1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ingresarEmpleado` (IN `_id_empleado` VARCHAR(20), IN `_id_usuario` VARCHAR(20), IN `_nombre` VARCHAR(40), IN `_apellidos` VARCHAR(40), IN `_telefono` VARCHAR(12), IN `_direccion` VARCHAR(30), IN `_correo` VARCHAR(50), IN `_observaciones` VARCHAR(200), IN `_estado` VARCHAR(10))  BEGIN
insert empleados_administradores (id_empleado, id_usuario, nombre, apellidos, telefono, direccion, correo, observaciones, estado)
    values (_id_empleado, _id_usuario, _nombre, _apellidos, _telefono, _direccion, _correo, _observaciones, _estado);
    END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ingresarEstudiantes` (`_id_estudiante` VARCHAR(15), `_Nombre_estudiante` VARCHAR(60), `_apellidos_studiante` VARCHAR(60), `_id_curso` INT(11), `_estado` ENUM('Activo','Inactivo'))  begin
	insert into estudiantes (id_estudiante, Nombre_estudiante, apellidos_studiante, id_curso, estado) values (_id_estudiante, _Nombre_estudiante, _apellidos_studiante, _id_curso, _estado);
		End$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ingresarProducto` (IN `_id_producto` VARCHAR(20), IN `_nombre` VARCHAR(40), IN `_tipo_producto` VARCHAR(50), IN `_Serial` VARCHAR(20), IN `_Observacion` VARCHAR(200), IN `_cantidad` INT(11), IN `_estado` ENUM('Activo','Inactivo'))  BEGIN
insert into productos (id_producto, nombre, tipo_producto, Serial, Observacion, cantidad, estado) values (_id_producto, _nombre, _tipo_producto, _Serial, _Observacion, _cantidad, _estado);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertarcontrol2` (IN `_id_control_profesor` INT(11), IN `_Estado` ENUM('perfecto','Dañado','No devuelto'), IN `_descripcion` VARCHAR(200), IN `_id_detalle` INT(11), IN `_id_empleado` VARCHAR(20), IN `_id_profesor` VARCHAR(20), IN `_Estado_Prestamo` ENUM('Activo','Inactivo'), IN `_id_estudiante` VARCHAR(15), IN `_Nombre_Estudiante` VARCHAR(50))  BEGIN
INSERT  INTO  control_profe (id_control_profesor, Estado, descripcion, id_detalle, id_empleado ,id_profesor, id_estudiante, Nombre_Estudiante) VALUES (_id_control_profesor, _Estado, _descripcion, _id_detalle,_id_empleado,_id_profesor , _Estado_Prestamo, _id_estudiante, _Nombre_Estudiante);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarCurso` (IN `_id_curso` INT(5), IN `_id_profe` VARCHAR(30))  BEGIN
INSERT INTO curso (id_curso,id_profe) VALUES (_id_curso,_id_profe);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarProfesores` (IN `_id_profesor` VARCHAR(20), IN `_id_usuario` VARCHAR(20), IN `_nombre` VARCHAR(40), IN `_apellidos` VARCHAR(40), IN `_telefono` VARCHAR(12), IN `_correo` VARCHAR(50), IN `_direccion` VARCHAR(30), IN `_Cargo_del_profesor` VARCHAR(40), IN `_estado` ENUM('Activo','Inactivo'))  BEGIN 
insert into profesores (id_profesor, id_usuario, nombre, apellidos, telefono, correo, direccion, Cargo_del_profesor, estado) 
values (_id_profesor, _id_usuario, _nombre, _apellidos, _telefono, _correo, _direccion, _Cargo_del_profesor, _estado);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertarUsuario` (IN `_id_usuario` CHAR(20), IN `_usuario` CHAR(20), IN `_contraseña` CHAR(30), IN `_id_rol` CHAR(10), IN `_estado` ENUM('Activo','Inactivo'), IN `_ingreso` INT(11))  BEGIN
insert into usuarios (id_usuario,usuario,contraseña,id_rol,estado,ingreso)
    values (_id_usuario,_usuario,_contraseña,_id_rol,_estado,_ingreso);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `insertar_control` (IN `_id_control_profesor` INT(11), IN `_Estado` ENUM('Perfecto','Dañado','No devuelto'), IN `_descripcion` VARCHAR(200), IN `_id_detalle` INT(11), IN `_id_empleado` VARCHAR(20), IN `_id_profesor` VARCHAR(20), IN `_Estado_Prestamo` ENUM('Activo','Inactivo'), IN `_id_estudiante` VARCHAR(15), IN `_id_curso` INT(5))  BEGIN
INSERT INTO control_profe (id_control_profesor, Estado, descripcion, id_detalle,id_empleado, id_profesor,Estado_Prestamo, id_estudiante, id_curso) VALUES (_id_control_profesor,_Estado,_descripcion,_id_detalle,_id_empleado,_id_profesor,_Estado_Prestamo,_id_estudiante,_id_curso);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarActualizarControl` (IN `_id_control_profesor` INT(11))  BEGIN
Select * FROM control_profe where id_control_profesor = _id_control_profesor;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listarcontroles` ()  BEGIN
SELECT prod.Serial,prod.nombre,e.id_estudiante,e.Nombre_estudiante,e.id_curso,pro.nombre as nombre_profesor,emp.nombre as nombre_prestamista,cp.descripcion as des_producto,cp.Estado FROM control_profe cp INNER JOIN detalle_prestamo dp on cp.id_detalle = dp.id_detalle INNER JOIN prestamos pre ON dp.nume_prestamo = pre.nume_prestamo inner JOIN profesores pro ON pre.id_profesor = pro.id_profesor INNER JOIN empleados_administradores emp on pre.id_empleado = emp.id_empleado INNER JOIN productos prod on dp.Serial = prod.Serial INNER JOIN estudiantes e on cp.id_estudiante = e.id_estudiante;   
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listarcurso` ()  BEGIN
SELECT * from curso;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarEmpleados` ()  BEGIN 
SELECT * FROM empleados_administradores;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listarEstudiantes` ()  begin
	select * from estudiantes;
	End$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Listarid_detalle` ()  BEGIN
SELECT * FROM detalle_prestamo ORDER BY nume_prestamo DESC LIMIT 1;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `listarNombreDelProducto` ()  BEGIN
SELECT DISTINCT nombre FROM productos;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarPrestamos` ()  BEGIN
SELECT p.nume_prestamo,p.id_empleado,p.id_profesor,p.fecha_prestamo,p.fecha_Entrega,dp.id_detalle,dp.Serial FROM prestamos p INNER JOIN detalle_prestamo dp on p.nume_prestamo = dp.nume_prestamo INNER JOIN productos pro ON dp.Serial = pro.Serial WHERE dp.estado = 'Activo';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarProducto` ()  BEGIN
SELECT * from productos;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarProfesores` ()  BEGIN
SELECT * FROM profesores;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ListarTodosLosPrestamos` ()  BEGIN
SELECT p.nume_prestamo,e.nombre as Nombre_empleado ,profe.nombre as Nombre_profesor ,p.fecha_prestamo,p.fecha_Entrega,dp.Serial FROM prestamos p INNER JOIN detalle_prestamo dp on p.nume_prestamo = dp.nume_prestamo INNER JOIN productos pro ON dp.Serial = pro.Serial INNER JOIN empleados_administradores e ON p.id_empleado = e.id_empleado INNER JOIN profesores profe on p.id_profesor = profe.id_profesor;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ProductosActivos` ()  BEGIN
SELECT * FROM productos WHERE estado = 'Activo';
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TraerCursos` (IN `_id_curso` INT(5))  BEGIN 
SELECT * FROM curso WHERE id_curso = _id_curso ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TraerEmpleados` (IN `_id_empleado` VARCHAR(20))  BEGIN
SELECT * FROM empleados_administradores WHERE id_empleado = _id_empleado;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TraerEstudiantes` (IN `_id_estudiante` VARCHAR(15))  BEGIN
SELECT * FROM estudiantes WHERE id_estudiante = _id_estudiante; 
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TraerProfesores` (IN `_id_profesor` VARCHAR(20))  BEGIN
SELECT * FROM profesores WHERE id_profesor = _id_profesor;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `TraerSerialproducto` (IN `_serial` VARCHAR(20))  BEGIN 
SELECT * FROM productos WHERE Serial = _serial;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `Validar_ingreso` (IN `_usuario` CHAR(20), IN `_contraseña` CHAR(20))  BEGIN
select * from usuarios u NATURAL JOIN rol where usuario = _usuario and contraseña = _contraseña;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `control_profe`
--

CREATE TABLE `control_profe` (
  `id_control_profesor` int(11) NOT NULL,
  `Estado` enum('Perfecto','Dañado','No devuelto') NOT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `id_detalle` int(11) DEFAULT NULL,
  `id_empleado` varchar(20) DEFAULT NULL,
  `id_profesor` varchar(20) DEFAULT NULL,
  `Estado_Prestamo` enum('Activo','Inactivo') DEFAULT NULL,
  `id_estudiante` varchar(15) DEFAULT NULL,
  `id_curso` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `control_profe`
--

INSERT INTO `control_profe` (`id_control_profesor`, `Estado`, `descripcion`, `id_detalle`, `id_empleado`, `id_profesor`, `Estado_Prestamo`, `id_estudiante`, `id_curso`) VALUES
(1, 'Dañado', 'le falta la tecla A', 1, '52735928', '2', 'Activo', '1143521499', 402);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(5) NOT NULL,
  `id_profe` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id_curso`, `id_profe`) VALUES
(401, '2'),
(402, '2'),
(403, '2'),
(404, '2'),
(301, '4237864587'),
(303, '4237864587'),
(304, '4237864587'),
(405, '4237864587');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_prestamo`
--

CREATE TABLE `detalle_prestamo` (
  `id_detalle` int(11) NOT NULL,
  `nume_prestamo` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `Serial` varchar(20) NOT NULL,
  `estado` enum('Activo','Inactivo') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalle_prestamo`
--

INSERT INTO `detalle_prestamo` (`id_detalle`, `nume_prestamo`, `cantidad`, `Serial`, `estado`) VALUES
(1, 6, 1, '652165dffs', 'Activo'),
(2, 8, 1, 'AW54F14', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados_administradores`
--

CREATE TABLE `empleados_administradores` (
  `id_empleado` varchar(20) NOT NULL,
  `id_usuario` varchar(20) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `direccion` varchar(30) DEFAULT NULL,
  `correo` varchar(50) NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados_administradores`
--

INSERT INTO `empleados_administradores` (`id_empleado`, `id_usuario`, `nombre`, `apellidos`, `telefono`, `direccion`, `correo`, `observaciones`, `estado`) VALUES
('1000492983', '1000492983', 'felipe', 'gonzales', '423423', 'calle65', 'maicol@gmail.com', 'ninguna', 'Activo'),
('1193544498', '1193544498', 'carolina', 'forero', '3102993454', 'calle 15', 'carolitaforeros@misena.edu.co', '', 'Activo'),
('52735928', '52735928', 'henry', 'barrera', '3205889636', 'calle 15', 'maicolsnikacosta@hotmail.com', 'ninguna', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiantes`
--

CREATE TABLE `estudiantes` (
  `id_estudiante` varchar(15) NOT NULL,
  `Nombre_estudiante` varchar(60) DEFAULT NULL,
  `apellidos_studiante` varchar(60) DEFAULT NULL,
  `id_curso` int(11) DEFAULT NULL,
  `estado` enum('Activo','Prestado','Inactivo') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `estudiantes`
--

INSERT INTO `estudiantes` (`id_estudiante`, `Nombre_estudiante`, `apellidos_studiante`, `id_curso`, `estado`) VALUES
('1025516421', 'sebastian', 'suarez', 301, 'Activo'),
('1143521499', 'Miguel', 'medina', 402, 'Activo'),
('1193524499', 'maicol', 'martinez', 401, 'Activo'),
('1193524589', 'pablo', 'beltran', 401, 'Activo'),
('1893528049', 'nicolas', 'corzo', 402, 'Activo'),
('5482374541', 'marlon', 'aguirrerrrr', 403, 'Activo'),
('5652132155', 'exequiel ', 'rios', 403, 'Activo'),
('8514021321', 'alex', 'Carneiro', 403, 'Activo'),
('8745435813', 'sebastian', 'suarez', 404, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamos`
--

CREATE TABLE `prestamos` (
  `nume_prestamo` int(11) NOT NULL,
  `id_empleado` varchar(20) NOT NULL,
  `id_profesor` varchar(20) NOT NULL,
  `fecha_prestamo` date NOT NULL,
  `fecha_Entrega` date NOT NULL,
  `id_hora_entrega` int(11) NOT NULL,
  `id_hora_devolucion` int(11) NOT NULL,
  `estado` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamos`
--

INSERT INTO `prestamos` (`nume_prestamo`, `id_empleado`, `id_profesor`, `fecha_prestamo`, `fecha_Entrega`, `id_hora_entrega`, `id_hora_devolucion`, `estado`) VALUES
(1, '52735928', '2', '2019-11-18', '2019-11-19', 1, 2, 'Activo'),
(2, '52735928', '2', '2019-11-18', '2019-11-19', 1, 3, 'Activo'),
(3, '52735928', '2', '2019-11-18', '2019-11-20', 1, 4, 'Activo'),
(4, '52735928', '2', '2019-11-18', '2019-11-19', 1, 3, 'Activo'),
(5, '52735928', '2', '2019-11-18', '2019-11-21', 1, 3, 'Activo'),
(6, '52735928', '2', '2019-11-18', '2019-11-19', 1, 3, 'Activo'),
(7, '52735928', '2', '2019-11-26', '2019-11-27', 1, 3, 'Activo'),
(8, '52735928', '2', '2019-11-26', '2019-11-27', 1, 3, 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Serial` varchar(20) NOT NULL,
  `id_producto` varchar(20) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `tipo_producto` varchar(50) NOT NULL,
  `Observacion` varchar(200) DEFAULT NULL,
  `cantidad` int(11) NOT NULL,
  `estado` enum('Activo','Prestado','Inactivo') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Serial`, `id_producto`, `nombre`, `tipo_producto`, `Observacion`, `cantidad`, `estado`) VALUES
('652165dffs', '1', 'teclado', 'Dell', 'falta tecla A', 1, 'Prestado'),
('AW54F14', '1', 'teclado', 'hp', '', 1, 'Prestado'),
('jkd332', '1', 'teclado', 'Dell', '', 1, 'Activo'),
('TG5251', '541211', 'pantalla', 'dell', 'Ninguna', 1, 'Prestado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `id_profesor` varchar(20) NOT NULL,
  `id_usuario` varchar(20) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `direccion` varchar(30) NOT NULL,
  `Cargo_del_profesor` varchar(40) NOT NULL,
  `estado` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`id_profesor`, `id_usuario`, `nombre`, `apellidos`, `telefono`, `correo`, `direccion`, `Cargo_del_profesor`, `estado`) VALUES
('1000617063', '1000617063', 'juan', 'beltran', '3102559874', 'beltrangjuan@gmail.com', 'calle 35', 'profesor', 'Activo'),
('15', '15', 'juanito', 'alima', '3215448965', 'maicolsnikacosta@hotmail.com', 'calle 36', 'profesor', 'Activo'),
('2', '2', 'miguel', 'medina', '3102118549', 'migolbain12@hotmail.com', 'calle 65', 'profesor', 'Activo'),
('4237864587', '4237864587', 'junior', 'cardenas', '6455334534', 'maicol@gmail.com', 'calle76', 'sena', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` varchar(10) NOT NULL,
  `Nombre_ROL` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `Nombre_ROL`) VALUES
('1', 'Administrador'),
('2', 'Empleado'),
('3', 'Profesor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` char(20) NOT NULL,
  `usuario` char(20) NOT NULL,
  `contraseña` char(30) NOT NULL,
  `id_rol` char(10) NOT NULL,
  `estado` enum('Activo','Inactivo') DEFAULT NULL,
  `ingreso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `usuario`, `contraseña`, `id_rol`, `estado`, `ingreso`) VALUES
('1000492983', 'felipe', '0987', '1', 'Inactivo', 1),
('1000617063', '1000617063', '5206RGWDPYHXJLSFBZ', '3', 'Activo', 0),
('1193524499', 'brayan', '1234', '3', 'Inactivo', 1),
('1193544498', '1193544498', '1053HZBGFRQHFNWYKY', '2', 'Activo', 0),
('15', '15', '123456789', '3', 'Activo', 1),
('2', 'MigolBain', '5555', '3', 'Activo', 1),
('4237864587', 'junior', '12345', '3', 'Activo', 0),
('52735928', '52735928', 'maicol2001', '1', 'Activo', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `control_profe`
--
ALTER TABLE `control_profe`
  ADD PRIMARY KEY (`id_control_profesor`),
  ADD KEY `id_empleado` (`id_empleado`),
  ADD KEY `id_profesor` (`id_profesor`),
  ADD KEY `id_detalle` (`id_detalle`),
  ADD KEY `id_estudiante` (`id_estudiante`),
  ADD KEY `id_curso` (`id_curso`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `id_profe` (`id_profe`);

--
-- Indices de la tabla `detalle_prestamo`
--
ALTER TABLE `detalle_prestamo`
  ADD PRIMARY KEY (`id_detalle`),
  ADD KEY `Serial` (`Serial`),
  ADD KEY `detalle_prestamo_ibfk_1` (`nume_prestamo`);

--
-- Indices de la tabla `empleados_administradores`
--
ALTER TABLE `empleados_administradores`
  ADD PRIMARY KEY (`id_empleado`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD PRIMARY KEY (`id_estudiante`),
  ADD KEY `id_curso` (`id_curso`);

--
-- Indices de la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD PRIMARY KEY (`nume_prestamo`),
  ADD KEY `id_profesor` (`id_profesor`),
  ADD KEY `id_empleado` (`id_empleado`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Serial`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`id_profesor`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `control_profe`
--
ALTER TABLE `control_profe`
  ADD CONSTRAINT `control_profe_ibfk_1` FOREIGN KEY (`id_empleado`) REFERENCES `empleados_administradores` (`id_empleado`),
  ADD CONSTRAINT `control_profe_ibfk_2` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id_profesor`),
  ADD CONSTRAINT `control_profe_ibfk_3` FOREIGN KEY (`id_detalle`) REFERENCES `detalle_prestamo` (`id_detalle`),
  ADD CONSTRAINT `control_profe_ibfk_4` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiantes` (`id_estudiante`),
  ADD CONSTRAINT `control_profe_ibfk_5` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`);

--
-- Filtros para la tabla `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`id_profe`) REFERENCES `profesores` (`id_profesor`);

--
-- Filtros para la tabla `detalle_prestamo`
--
ALTER TABLE `detalle_prestamo`
  ADD CONSTRAINT `detalle_prestamo_ibfk_1` FOREIGN KEY (`nume_prestamo`) REFERENCES `prestamos` (`nume_prestamo`),
  ADD CONSTRAINT `detalle_prestamo_ibfk_2` FOREIGN KEY (`Serial`) REFERENCES `productos` (`Serial`);

--
-- Filtros para la tabla `empleados_administradores`
--
ALTER TABLE `empleados_administradores`
  ADD CONSTRAINT `empleados_administradores_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `estudiantes`
--
ALTER TABLE `estudiantes`
  ADD CONSTRAINT `estudiantes_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`);

--
-- Filtros para la tabla `prestamos`
--
ALTER TABLE `prestamos`
  ADD CONSTRAINT `prestamos_ibfk_1` FOREIGN KEY (`id_profesor`) REFERENCES `profesores` (`id_profesor`),
  ADD CONSTRAINT `prestamos_ibfk_2` FOREIGN KEY (`id_empleado`) REFERENCES `empleados_administradores` (`id_empleado`);

--
-- Filtros para la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD CONSTRAINT `profesores_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id_rol`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
