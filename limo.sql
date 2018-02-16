-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-02-2018 a las 03:35:38
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `limo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concesionarios`
--

CREATE TABLE `concesionarios` (
  `idConcesionario` int(11) NOT NULL,
  `nombre` text COLLATE utf8_spanish_ci NOT NULL,
  `apellidoP` text COLLATE utf8_spanish_ci NOT NULL,
  `apellidoM` text COLLATE utf8_spanish_ci NOT NULL,
  `genero` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `concesionarios`
--

INSERT INTO `concesionarios` (`idConcesionario`, `nombre`, `apellidoP`, `apellidoM`, `genero`, `fechaNac`, `direccion`, `telefono`) VALUES
(1, 'Jose Ramon', 'Espinoza', 'Penagos', 'Masculino', '1980-08-15', 'trancas', 23238823),
(2, 'Brian', 'Garrido', 'Perez', 'Masculino', '1994-12-24', 'Victor G piña #123', 22838499);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductores`
--

CREATE TABLE `conductores` (
  `idConductor` int(11) NOT NULL,
  `idUnidad` int(11) NOT NULL,
  `nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `apellidoP` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `apellidoM` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `genero` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `fechaNac` date NOT NULL,
  `direccion` varchar(255) COLLATE utf8_spanish2_ci NOT NULL,
  `codigo` varchar(4) COLLATE utf8_spanish2_ci NOT NULL,
  `telefono` int(11) NOT NULL,
  `permiso` varchar(30) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `conductores`
--

INSERT INTO `conductores` (`idConductor`, `idUnidad`, `nombre`, `apellidoP`, `apellidoM`, `genero`, `fechaNac`, `direccion`, `codigo`, `telefono`, `permiso`) VALUES
(1, 2, 'Jose', 'Espinoza', 'Espinoza', 'MASCULINO', '1978-10-29', 'Agustin Melgar #3', '7740', 228343443, 'AAAB000033'),
(6, 2, 'Brian', 'Garrido', 'Perez', 'Masculino', '1994-12-24', 'Victor G piña #123', '7720', 22838499, 'ABBDD2393');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `foraneas`
--

CREATE TABLE `foraneas` (
  `idForanea` int(11) NOT NULL,
  `Lugar` varchar(150) COLLATE utf8_spanish2_ci NOT NULL,
  `Monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `foraneas`
--

INSERT INTO `foraneas` (`idForanea`, `Lugar`, `Monto`) VALUES
(1, 'ABAZAL POR ALTO LUCERO', 475),
(2, 'ACAJETE', 180),
(3, 'ACATLAN POR NAOLINCO', 360),
(4, 'ACAYUCAN', 3630),
(5, 'ACAZONICA POR PASO DE OBEJAS', 880),
(6, 'ACTOPAN', 390),
(7, 'AEREOPUERTO LENCERO', 180),
(8, 'AEREOPUERTO VERACRUZ', 1100),
(9, 'AGUACERO POR ZONA MILITAR', 150),
(10, 'AGUA DULCE POR MINATITLAN', 4600),
(11, 'ALAMO', 3300),
(12, 'ALBORADA ', 140),
(13, 'ALCHICHICA', 800),
(14, 'ALMOLONGA', 240),
(15, 'ALPATLAHUAC POR HUATUSCO', 1100),
(16, 'ALTOS LOS', 800),
(17, 'ALTO LUCERO', 360),
(18, 'ALTO TIO DIEGO', 270),
(19, 'ALTOTONGA', 700),
(20, 'ALVARADO', 1800),
(21, 'ANGEL R CABADA', 2200),
(22, 'ANTIGUA LA', 800),
(23, 'ANTONIO LIZARDO', 1500),
(24, 'ACOTITA POR ACAZONICA', 850),
(25, 'APAZAPAN', 500),
(26, 'APIZACO TLAX.', 1800),
(27, 'ARENALES', 80),
(28, 'ATLIXCOS POR PALMA SOLA', 1480),
(29, 'ATALPA CHICO', 300),
(30, 'ATZALAN', 720),
(31, 'AYAHUALULCO POR IXHUACAN', 600),
(32, 'BAJADAS LAS POR VERACRUZ', 1100),
(33, 'BALCONES DE XALAPA', 60),
(34, 'BANDERA LA POR ACTOPAN', 485),
(35, 'BANDERILLA CENTRO ', 100),
(36, 'BANDERILLA MAS ALEJADO', 110),
(37, 'BARRANCA HONDA POR COAPEXPAN', 80),
(38, 'BELLA ESPERANZA POR ALBORADA', 185),
(39, 'BLANCA ESPUMA POR ALTO LUCERO', 460),
(40, 'BOCA DEL RIO (CONURBADO)', 1150),
(41, 'BOCA DEL RIO (CIUDAD)', 1200),
(42, 'BOCANA POR CERRO GORDO', 400),
(43, 'BOQUERON POR PASO DE OVEJAS', 780),
(44, 'BRIONES-CENTRO', 110),
(45, 'BUENA VISTA POR ACTOPAN', 480),
(46, 'BUGAMBILIAS-TRANCAS', 70),
(47, 'CAFETAL POR NAOLINCO', 300),
(48, 'CARDEL ', 700),
(49, 'CARRIZAL-EMILIANO ZAPATA', 400),
(50, 'CARRIZAL-BALNEARIO', 460),
(51, 'CASITAS-SAN RAFAEL', 1950),
(52, 'CASTILLO EL', 100),
(53, 'CASTILLO CHICO', 120),
(54, 'CATEMACO', 2800),
(55, 'CAMPO VIEJO POR COATEPEC', 130),
(56, 'CERRILLOS DE DIAZ', 465),
(57, 'CERRO AZUL', 3800),
(58, 'CERRO DE LEON', 480),
(59, 'CERRO GORDO', 250),
(60, 'CIUDAD MENDOZA', 1990),
(61, 'CHOAPAS LAS', 4700),
(62, 'COACOATZINTLA', 200),
(63, 'COATEPEC CENTRO', 130),
(64, 'COATEPEC COLONIAS', 145),
(65, 'COATZACOALCOS', 4230),
(66, 'COFRE DE PEROTE', 730),
(67, 'COLIPA', 850),
(68, 'COMOAPAN POR HUATUSCO', 780),
(69, 'CONCEPCION LA', 235),
(70, 'CONEJOS', 650),
(71, 'CONCHAL EL POR BOCA DEL RIO', 1340),
(72, 'CONSOLAPAN ', 100),
(73, 'CORDOBA ', 1400),
(74, 'CORRAL FALSO', 210),
(75, 'COSAMALOAPAN', 2520),
(76, 'COSAUTLAN', 500),
(77, 'COSCOMATEPEC', 1030),
(78, 'COYOL', 200),
(79, 'COYOLILLO', 330),
(80, 'CRUCES LAS POR EL CASTILLOS', 150),
(81, 'CRUZ BLANCA', 400),
(82, 'CUERNAVACA MORELOS', 4600),
(83, 'CUMBRE LA', 370),
(84, 'CHACHALACAS ', 800),
(85, 'CHALTEPEC POR BANDERILLA', 130),
(86, 'CHAVARRILLO (PUEBLO)', 220),
(87, 'CHICHICASTLE POR CARDEL', 580),
(88, 'CHAVARRILLO (ESTACION)', 220),
(89, 'CHICO EL', 140),
(90, 'CHICONQUIACO', 460),
(91, 'CHICUASEN', 320),
(92, 'CHILTOYAC', 170),
(93, 'CHINCHONTLA', 900),
(94, 'DIAMANTE POR ACTOPAN', 550),
(95, 'DOS RIOS', 180),
(96, 'ENERO COL. 6', 150),
(97, 'ENRIQUEZ COL. POR ALTO LUCERO', 430),
(98, 'EMILIO CARRANZA, VERACRUZ', 1550),
(99, 'ESPINAL EL POR NAOLINCO', 290),
(100, 'ESTANZUELA', 135),
(101, 'EX HACIENDA STA. ANA', 150),
(102, 'EL ATITO POR TOLOME', 750),
(103, 'EL FAISAN', 730),
(104, 'FARALLON EL ', 1050),
(105, 'FLORIDA LA', 115),
(106, 'FORTIN DE LAS FLORES', 1220),
(107, 'FRESNO (SAN MIGUEL)', 220),
(108, 'FRESNO POR TLACOLULAN', 220),
(109, 'FRAILES LOS', 250),
(110, 'GUADALUPE VICTORIA, VERACRUZ', 560),
(111, 'GUADALUPE VICTORIA, PUEBLA', 1300),
(112, 'GRANDE EL', 150),
(113, 'GUTIERREZ ZAMORA', 2400),
(114, 'GAS ATLANTICO', 235),
(115, 'HACIENDA DE LA LUZ', 400),
(116, 'HALDAS LAS', 300),
(117, 'HAYA EL (COLONIA)', 80),
(118, 'HUAMANTLA TLAX', 1600),
(119, 'HUEJUTLA DE REYES', 4800),
(120, 'HUATUSCO', 850),
(121, 'HUERFANO EL', 650),
(122, 'IDOLOS LOS POR RINCONADA', 600),
(123, 'IXHUACAN DE LOS REYES', 600),
(124, 'JALCOMULCO   ', 400),
(125, 'JALACINGO', 830),
(126, 'JALTIPAN', 3900),
(127, 'JARDIN BOTANICO', 80),
(128, 'JILOTEPEC', 140),
(129, 'JOYA LA', 240),
(130, 'JUCHIQUE DE FERRER', 900),
(131, 'LA LAGUNA POR PACHO VIEJO', 110),
(132, 'LAGUNA VERDE', 1180),
(133, 'LANDERO Y COSS', 450),
(134, 'LAS LOMAS POR JILOTEPEC', 230),
(135, 'LAS LOMAS POR PUERTO RICO', 180),
(136, 'LENCERO EL', 150),
(137, 'LERDO DE TEJADA', 2200),
(138, 'LIMONES-COSAUTLAN', 680),
(139, 'LINDEROS POR JILOTEPEC', 180),
(140, 'LLANO GRANDE POR TEOCELO', 380),
(141, 'MAFAFAS POR ALTO LUCERO', 480),
(142, 'MAHUIXTLAN', 200),
(143, 'MANCHA LA', 1000),
(144, 'MANDINGA POR VERACRUZ', 1380),
(145, 'MANLIO F. ALTAMIRANO', 1150),
(146, 'MARIA DE LA TORRE', 1450),
(147, 'MARIANO ESCOBEDO POR BRIONES', 130),
(148, 'MARTINEZ DE LA TORRE', 1350),
(149, 'MAZATEPEC', 200),
(150, 'MESA DE GUADALUPE', 330),
(151, 'MESA DE 24 POR PALMA SOLA', 1400),
(153, 'MIAHUATLAN', 350),
(154, 'MINAS LAS', 580),
(155, 'MINATITLAN', 4500),
(156, 'MIRADORES ', 200),
(157, 'MISANTLA', 850),
(158, 'MOLINOS LOS', 500),
(159, 'MONTE BLANCO POR TEOCELO', 275),
(160, 'MONTE REAL POR TONAYAN', 370),
(161, 'MONTEPIO (PLAYA)', 2800),
(162, 'MOZOMBOA POR ZEMPOALA', 930),
(163, 'NAOLINCO', 320),
(164, 'NARANJOS', 4000),
(165, 'NAUTLA', 1950),
(166, 'NOGALES', 1400),
(167, 'NUEVE EL', 750),
(168, 'OAXACA, OAXACA', 5),
(169, 'OJO ZARCO POR  ALTO LUCERO', 500),
(170, 'OJO DE AGUA POR TRANCAS', 80),
(171, 'OMIQUILA POR CASTILLO', 285),
(172, 'OTATES', 320),
(174, 'OTILPAN ', 120),
(175, 'ORIZABA POR LA LIBRE', 1540),
(176, 'ORIZABA POR CUOTA', 2400),
(177, 'PACHO VIEJO', 130),
(178, 'PACHO NUEVO', 160),
(179, 'PACHUCA HIDALGO', 4000),
(180, 'PALMA SOLA', 1250),
(181, 'PALMAR POR MIRADORES', 400),
(182, 'PALMAREJO POR MIRADORES', 250),
(183, 'PALO GACHO', 320),
(184, 'PANUCO ', 5200),
(185, 'PAPANTLA ', 2600),
(186, 'PASTORIAS ', 650),
(187, 'PASO SAN JUAN POR PASO DE OVEJAS', 770),
(188, 'PASO SAN JUAN POR CHILTOYAC', 190),
(189, 'PASO LA MILPA', 410),
(190, 'PASO DE OVEJAS', 700),
(191, 'PASO GRANDE ', 210),
(192, 'PASO LADRILLO', 120),
(193, 'PATLANALAN', 650),
(194, 'PEDREGAL', 850),
(195, 'PEROTE', 575),
(196, 'PIEDRA DE AGUA', 130),
(197, 'PIEDRA PARADA POR COSAUTLAN', 450),
(198, 'PILETAS', 120),
(199, 'PINOLTEPEC', 230),
(200, 'PITAYA LA', 120),
(201, 'PLAN CHICO, RUMBO A CHAVARRILLO', 150),
(202, 'PLAN DEL RIO', 310),
(203, 'PLAN DE LA CRUZ POR BRIONES', 110),
(204, 'PLAN DE LAS HAYAS', 680),
(206, 'PLAYA VICENTE', 3500),
(207, 'POCITOS (BALNEARIO)', 330),
(208, 'POTRERO ALTO POR PALMA SOLA', 1300),
(209, 'POTRERO DE LLANO POR ALAMO', 3600),
(210, 'POZA RICA', 2900),
(211, 'PROVIDENCIA POR ALTO LUCERO', 330),
(212, 'PUEBLO NUEVO (MIRADORES)', 190),
(213, 'PUEBLO VIEJO (PANUCO)', 5100),
(214, 'PUEBLA, PUEBLA', 2500),
(215, 'PUEBLITO', 150),
(216, 'PUENTE JULA', 850),
(217, 'PUENTE DE MOISES POR LA CONCHA', 180),
(218, 'PUENTE NACIONAL', 580),
(219, 'PUENTE SAN MARCOS DE LEON', 150),
(220, 'PUERTO RICO', 160),
(221, 'RANCHO NUEVO POR ALTO LUCERO', 600),
(222, 'RANCHO CHICO POR SAN MIGUEL', 160),
(223, 'RANCHO VIEJO POR MIRADORES', 220),
(224, 'RANCHO VIEJO POR COAPEXPAN', 180),
(225, 'RAUDAL EL ', 1330),
(226, 'REFORMA POR ACTOPAN', 480),
(227, 'RINCONADA', 500),
(228, 'RIO BLANCO ', 1590),
(229, 'ROMA', 160),
(230, 'ROSARIO EL POR PILETAS', 130),
(231, 'RUBI EL ', 1400),
(232, 'SALMORAL PORTOLOME', 740),
(233, 'SALTO DE EYIPANTLA', 2800),
(235, 'SAN ANDRES TLANELHUAYOCAN', 140),
(236, 'SAN ANDRES TLUXTLA', 2700),
(237, 'SAN ANTONIO TEPETLAN', 350),
(238, 'SAN ANTONIO POR SAN BRUNO', 135),
(239, 'SAN JOSE MIAHUATLAN', 340),
(240, 'SAN MARCOS DE LEON ', 155),
(241, 'SAN MARTIN POR LA CONCHA', 195),
(242, 'SAN MARTIN TEXMELUCAN', 3000),
(243, 'SAN MIGUEL POR RAFAEL LUCIO', 160),
(244, 'SAN PABLO COAPAN', 230),
(245, 'SAN PANCHO ', 760),
(246, 'SAN PANCHO POR CARDEL', 750),
(247, 'SAN RAFAEL POR MARTINEZ DE LA TORRE', 1550),
(248, 'SAN JULIAN', 950),
(249, 'SANTA FE', 920),
(250, 'SANTIAGO TUXTLA', 2550),
(251, 'SAYULA DE ALEMAN', 3750),
(252, 'SECO EL ', 1300),
(253, 'SIERRA DE AGUA', 450),
(254, 'SIHUATLAN POR JUCHIQUE', 880),
(255, 'SOLEDAD DE DOBLADO', 1265),
(256, 'SONCUANTLA', 145),
(257, 'SONIGAS POR CORRAL FALSO', 220),
(258, 'SEIS POR BRIONES', 110),
(259, 'TABACHIN', 80),
(260, 'TAMARINDO', 560),
(261, 'TAMIAHUA', 3700),
(262, 'TAMPICO-TAMAULIPAS', 5250),
(263, 'TANTOYUCA', 4300),
(264, 'TATATILA', 440),
(265, 'TEJERIA', 1030),
(266, 'TEHUACAN (PUEBLA)', 2200),
(267, 'TEMPOAL', 4600),
(268, 'TENAMPA', 260),
(269, 'TENENEXPAN', 1150),
(270, 'TENEXTEPEC', 720),
(271, 'TEPEACA (PUEBLA)', 1870),
(272, 'TEPETATES', 280),
(273, 'TEOCELO', 230),
(274, 'TEXCOCO', 4000),
(275, 'TEXIN ', 300),
(276, 'TEZIUTLAN (PUEBLA)', 960),
(277, 'TIGRILLOS ', 4090),
(278, 'TINAJA POR EL LENCERO', 250),
(279, 'TIERRA BLANCA., VERACRUX', 2000),
(280, 'TIERRA BLANCA POR EL ALTO', 650),
(281, 'TIERRA COLORADA', 860),
(282, 'TOCHE POR L. BANDERA/ACTOPAN', 460),
(283, 'TOLOME', 750),
(284, 'TONAYAN POR NAOLINCO', 260),
(285, 'TOPILTEPEC', 750),
(286, 'TOTALCO', 680),
(287, 'TOTUTLA', 780),
(288, 'TOXTLACOAYA', 320),
(289, 'TLACOLULAN', 250),
(290, 'TLACOTALPAN', 2180),
(291, 'TLALTETELA', 450),
(292, 'TLAPACOYAN', 980),
(293, 'TRAPICHE DEL ROSARIO', 300),
(294, 'TRANCAS LAS', 60),
(295, 'TLAXCALA, TLAXCALA', 2000),
(296, 'TRES DE MAYO POR BANDERILLA', 110),
(297, 'TINAJITAS', 980),
(298, 'TRES VALLES ', 2350),
(299, 'TRONCONAL', 150),
(300, 'TLUXPAN', 3330),
(301, 'TUZAMAPAN', 260),
(302, 'URSULO GALVAN POR SAN MARCOS', 185),
(303, 'URSULO GALVAN, VERACRUZ.', 800),
(304, 'VARGAS POR PASO SE OVEJAS', 925),
(305, 'VEGA DE A LA TORRE POR E. CARRANZA', 1680),
(306, 'VENTA LA (TABASCO)', 5200),
(307, 'VERACRUZ CENTRO', 1200),
(308, 'VIEJON POR LAGUNA VERDE', 1150),
(309, 'VIGAS LAS', 340),
(310, 'VILLA ALDAMA', 480),
(312, 'VILLA NUEVA POR ACTOPAN', 360),
(313, 'VILLA HERMOSA, TABASCO', 5800),
(314, 'VISTA HERMOSA', 165),
(315, 'XICO', 210),
(316, 'XICOTITLAN POR ACAZONICA', 1000),
(317, 'XOLOSTLA POR LUZ DEL BARRIO', 100),
(318, 'XOMOTLA POR ALTO LUCERO', 500),
(319, 'YECUATLA', 750),
(320, 'ZEMPOALA', 830),
(321, 'ZENTLA POR HUATUSCO', 1000),
(322, 'ZIMPIZAHUA', 150),
(323, 'ZONA MILITAR', 100),
(324, 'ZONCUANTLA', 100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntos`
--

CREATE TABLE `puntos` (
  `idPunto` int(11) NOT NULL,
  `Nombre` varchar(45) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL,
  `roles` text COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`idRol`, `roles`) VALUES
(1, 'ADMIN'),
(2, 'VENTAS');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unidades`
--

CREATE TABLE `unidades` (
  `idUnidad` int(11) NOT NULL,
  `idConcesionario` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `placas` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `modelo` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `seguroIni` date NOT NULL,
  `seguroFin` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `unidades`
--

INSERT INTO `unidades` (`idUnidad`, `idConcesionario`, `numero`, `placas`, `modelo`, `seguroIni`, `seguroFin`) VALUES
(2, 1, 2085, '7188XDA', 'Tsuru 2016', '2018-01-09', '2018-01-31');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `IdUsuario` int(11) NOT NULL,
  `idRol` int(11) NOT NULL,
  `Usuario` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `Correo` varchar(40) COLLATE utf8_spanish2_ci NOT NULL,
  `Password` varchar(10) COLLATE utf8_spanish2_ci NOT NULL,
  `FechaCreacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`IdUsuario`, `idRol`, `Usuario`, `Correo`, `Password`, `FechaCreacion`) VALUES
(1, 1, 'Garrido', 'juan_fresh20@hotmail.com', '123456', '2017-04-18'),
(2, 2, 'Brian', 'brian@gmail.com', '123456', '2017-10-15'),
(3, 1, 'Fernando', 'fercho_duy9@hotmail.com', 'fercho2', '2017-10-20'),
(4, 2, 'Jose Ramon', 'jose_ramon@hotmail.com', '123456', '2017-11-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idVenta` int(11) NOT NULL,
  `idConductor` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idUnidad` int(11) NOT NULL,
  `idZona` int(11) DEFAULT NULL,
  `idForanea` int(11) DEFAULT NULL,
  `fechaHora` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idVenta`, `idConductor`, `idUsuario`, `idUnidad`, `idZona`, `idForanea`, `fechaHora`) VALUES
(3, 6, 3, 2, NULL, 4, '2018-01-27 16:00:00'),
(4, 1, 4, 2, NULL, 35, '2018-01-28 18:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas`
--

CREATE TABLE `zonas` (
  `idZona` int(11) NOT NULL,
  `local` varchar(45) COLLATE utf8_spanish2_ci NOT NULL,
  `zona` text COLLATE utf8_spanish2_ci NOT NULL,
  `montoLocal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `zonas`
--

INSERT INTO `zonas` (`idZona`, `local`, `zona`, `montoLocal`) VALUES
(2, 'LUCAS MARTIN', 'A', 35);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `concesionarios`
--
ALTER TABLE `concesionarios`
  ADD PRIMARY KEY (`idConcesionario`),
  ADD UNIQUE KEY `idx_concesionarios_idConcesionario` (`idConcesionario`);

--
-- Indices de la tabla `conductores`
--
ALTER TABLE `conductores`
  ADD PRIMARY KEY (`idConductor`),
  ADD UNIQUE KEY `idConductores_UNIQUE` (`idConductor`),
  ADD UNIQUE KEY `CodigoB_UNIQUE` (`codigo`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `idUnidad` (`idUnidad`);

--
-- Indices de la tabla `foraneas`
--
ALTER TABLE `foraneas`
  ADD PRIMARY KEY (`idForanea`),
  ADD UNIQUE KEY `Lugar_UNIQUE` (`Lugar`);

--
-- Indices de la tabla `puntos`
--
ALTER TABLE `puntos`
  ADD PRIMARY KEY (`idPunto`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`idRol`),
  ADD KEY `idRol` (`idRol`);

--
-- Indices de la tabla `unidades`
--
ALTER TABLE `unidades`
  ADD PRIMARY KEY (`idUnidad`),
  ADD UNIQUE KEY `idUnidades_UNIQUE` (`idUnidad`),
  ADD UNIQUE KEY `Numero_UNIQUE` (`numero`),
  ADD UNIQUE KEY `Placas_UNIQUE` (`placas`),
  ADD KEY `numero` (`numero`),
  ADD KEY `idConcesionario` (`idConcesionario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`IdUsuario`),
  ADD UNIQUE KEY `IdUsuario_UNIQUE` (`IdUsuario`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idVenta`),
  ADD UNIQUE KEY `idVenta_UNIQUE` (`idVenta`),
  ADD KEY `idConductor_idx` (`idConductor`),
  ADD KEY `idUsuario_idx` (`idUsuario`),
  ADD KEY `idUnidad_idx` (`idUnidad`),
  ADD KEY `idPunto_idx` (`idZona`),
  ADD KEY `id_Foranea_idx` (`idForanea`),
  ADD KEY `idUnidad` (`idUnidad`);

--
-- Indices de la tabla `zonas`
--
ALTER TABLE `zonas`
  ADD PRIMARY KEY (`idZona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `concesionarios`
--
ALTER TABLE `concesionarios`
  MODIFY `idConcesionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `conductores`
--
ALTER TABLE `conductores`
  MODIFY `idConductor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT de la tabla `foraneas`
--
ALTER TABLE `foraneas`
  MODIFY `idForanea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=325;
--
-- AUTO_INCREMENT de la tabla `puntos`
--
ALTER TABLE `puntos`
  MODIFY `idPunto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `unidades`
--
ALTER TABLE `unidades`
  MODIFY `idUnidad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `IdUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `zonas`
--
ALTER TABLE `zonas`
  MODIFY `idZona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `conductores`
--
ALTER TABLE `conductores`
  ADD CONSTRAINT `idUnidad` FOREIGN KEY (`idUnidad`) REFERENCES `unidades` (`idUnidad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `unidades`
--
ALTER TABLE `unidades`
  ADD CONSTRAINT `unidades_ibfk_1` FOREIGN KEY (`idConcesionario`) REFERENCES `concesionarios` (`idConcesionario`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `id_Conductor` FOREIGN KEY (`idConductor`) REFERENCES `conductores` (`idConductor`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_Foranea` FOREIGN KEY (`idForanea`) REFERENCES `foraneas` (`idForanea`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_Unidad` FOREIGN KEY (`idUnidad`) REFERENCES `unidades` (`idUnidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_Usuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`IdUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `id_Zona` FOREIGN KEY (`idZona`) REFERENCES `zonas` (`idZona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
