-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-11-2024 a las 01:16:46
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nutricionista`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `colacion`
--

CREATE TABLE `colacion` (
  `ID_Dieta` int(11) NOT NULL,
  `NombreM` varchar(50) NOT NULL,
  `dia` varchar(15) NOT NULL,
  `momentoDelDia` varchar(15) NOT NULL,
  `porciones` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `colacion`
--

INSERT INTO `colacion` (`ID_Dieta`, `NombreM`, `dia`, `momentoDelDia`, `porciones`) VALUES
(8, 'Bowl proteico', 'Lunes', 'Desayuno', 1),
(8, 'guiso de pollo', 'Lunes', 'Almuerzo', 1),
(8, 'Desayuno saludable', 'Lunes', 'Merienda', 1),
(8, 'Mix de frutos secos', 'Lunes', 'Cena', 1),
(8, 'Yogurt con cereal', 'Lunes', 'Snack', 1),
(8, 'Desayuno saludable', 'Martes', 'Desayuno', 1),
(8, 'Ensalada de lentejas', 'Martes', 'Almuerzo', 1),
(8, 'Yogurt con cereal', 'Martes', 'Snack', 1),
(8, 'Desayuno energético', 'Martes', 'Merienda', 1),
(8, 'Tostadas con aguacate', 'Martes', 'Cena', 1),
(8, 'cafe con leche', 'Miercoles', 'Desayuno', 1),
(8, 'Pasta integral vegetariana', 'Miercoles', 'Almuerzo', 1),
(8, 'Yogurt con cereal', 'Miercoles', 'Snack', 1),
(8, 'Pasta integral vegetariana', 'Miercoles', 'Merienda', 1),
(8, 'Wrap de atún', 'Miercoles', 'Cena', 1),
(10, 'Bowl proteico', 'Lunes', 'Desayuno', 1),
(10, 'Bowl proteico', 'Miercoles', 'Desayuno', 1),
(10, 'Bowl proteico', 'Viernes', 'Desayuno', 1),
(10, 'Bowl de quinoa', 'Lunes', 'Merienda', 1),
(10, 'Bowl de quinoa', 'Miercoles', 'Merienda', 1),
(10, 'Bowl de quinoa', 'Viernes', 'Merienda', 1),
(10, 'Pasta integral vegetariana', 'Lunes', 'Almuerzo', 1),
(10, 'Pasta integral vegetariana', 'Miercoles', 'Almuerzo', 1),
(10, 'Pasta integral vegetariana', 'Viernes', 'Almuerzo', 1),
(10, 'guiso de pollo', 'Lunes', 'Cena', 1),
(10, 'guiso de pollo', 'Miercoles', 'Cena', 1),
(10, 'guiso de pollo', 'Viernes', 'Cena', 1),
(6, 'Bowl proteico', 'Lunes', 'Desayuno', 1),
(6, 'Bowl proteico', 'Miercoles', 'Desayuno', 1),
(6, 'Bowl proteico', 'Viernes', 'Desayuno', 1),
(6, 'Bowl de quinoa', 'Lunes', 'Merienda', 1),
(6, 'Bowl de quinoa', 'Miercoles', 'Merienda', 1),
(6, 'Bowl de quinoa', 'Viernes', 'Merienda', 1),
(6, 'Bowl proteico', 'Lunes', 'Almuerzo', 1),
(6, 'Bowl proteico', 'Miercoles', 'Almuerzo', 1),
(6, 'Bowl proteico', 'Viernes', 'Almuerzo', 1),
(6, 'guiso de pollo', 'Lunes', 'Cena', 1),
(6, 'guiso de pollo', 'Miercoles', 'Cena', 1),
(6, 'guiso de pollo', 'Viernes', 'Cena', 1),
(6, 'cafe con leche', 'Lunes', 'Snack', 1),
(6, 'cafe con leche', 'Miercoles', 'Snack', 1),
(6, 'cafe con leche', 'Viernes', 'Snack', 1),
(13, 'cafe con leche', 'Lunes', 'Desayuno', 1),
(13, 'cafe con leche', 'Miercoles', 'Desayuno', 1),
(13, 'cafe con leche', 'Viernes', 'Desayuno', 1),
(13, 'cafe con leche', 'Lunes', 'Merienda', 1),
(13, 'cafe con leche', 'Miercoles', 'Merienda', 1),
(13, 'cafe con leche', 'Viernes', 'Merienda', 1),
(13, 'Desayuno saludable', 'Lunes', 'Almuerzo', 1),
(13, 'Desayuno saludable', 'Miercoles', 'Almuerzo', 1),
(13, 'Desayuno saludable', 'Viernes', 'Almuerzo', 1),
(13, 'Desayuno saludable', 'Lunes', 'Cena', 1),
(13, 'Desayuno saludable', 'Miercoles', 'Cena', 1),
(13, 'Desayuno saludable', 'Viernes', 'Cena', 1),
(13, 'Mix de frutos secos', 'Lunes', 'Snack', 1),
(13, 'Mix de frutos secos', 'Miercoles', 'Snack', 1),
(13, 'Mix de frutos secos', 'Viernes', 'Snack', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `ID_Dieta` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `detalle` varchar(200) NOT NULL,
  `pesoFinal` float DEFAULT NULL,
  `fechaFin` date NOT NULL,
  `fechaIni` date NOT NULL,
  `totalCalorias` float DEFAULT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`ID_Dieta`, `dni`, `detalle`, `pesoFinal`, `fechaFin`, `fechaIni`, `totalCalorias`, `estado`) VALUES
(1, 46041451, 'ganar peso', NULL, '2024-11-11', '2024-11-07', 0, 0),
(2, 77999888, 'ganar peso', NULL, '2024-11-15', '2024-11-07', 0, 0),
(4, 33333333, 'subise', NULL, '2024-11-21', '2024-11-14', 0, 1),
(5, 38777616, 'bajar', NULL, '2024-11-08', '2024-11-07', 0, 0),
(6, 35877616, 'bajarpeso', NULL, '2024-11-22', '2024-11-15', 7628.96, 1),
(7, 34555666, 'low', 0, '2024-11-13', '2024-11-06', NULL, 1),
(8, 35444555, 'low', NULL, '2024-11-11', '2024-11-04', 5401.79, 0),
(9, 20333222, 'subir', NULL, '2024-11-18', '2024-11-16', NULL, 1),
(10, 38419063, 'bajar de peso', NULL, '2024-11-27', '2024-11-20', NULL, 0),
(12, 38419062, 'bajar', NULL, '2024-11-20', '2024-11-14', NULL, 1),
(13, 38419061, 'bajar', NULL, '2024-11-20', '2024-11-14', 3987.9, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingrediente`
--

CREATE TABLE `ingrediente` (
  `NombreI` varchar(50) NOT NULL,
  `valorCD100g` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingrediente`
--

INSERT INTO `ingrediente` (`NombreI`, `valorCD100g`) VALUES
('Aceite de oliva', 884),
('Acelga', 19),
('Aguacate', 160),
('Ajo', 140),
('Alcachofa', 47),
('Almendras', 579),
('Arándanos', 57),
('Arroz blanco', 130),
('Atún en agua', 132),
('Avena', 389),
('azucar', 30),
('Brócoli', 34),
('Cacahuates', 567),
('cafe', 115),
('Calabacin', 17),
('Camarones', 99),
('Carne de res', 250),
('Cebolla', 40),
('Cereales', 160),
('Champiñones', 22),
('Chocolate negro', 598),
('chuker', 10),
('Ciruela', 46),
('Espinaca', 23),
('Fideo', 15),
('Frijoles', 347),
('Frutilla', 32),
('Garbanzos', 164),
('Higos', 74),
('Huevo', 155),
('Jengibre', 80),
('Leche entera', 61),
('Lechuga', 15),
('Lentejas', 116),
('Maíz', 96),
('Mantequilla', 717),
('Manzana', 52),
('Masitas secas', 200),
('Miel', 304),
('Naranja', 47),
('Pan integral', 247),
('Papa', 77),
('Pasta', 371),
('Pavo', 189),
('Pechuga de pollo', 165),
('Pepino', 16),
('Pepitas de calabaza', 559),
('Pimiento rojo', 31),
('Piña', 50),
('Plátano', 89),
('Queso', 103),
('Queso cheddar', 402),
('Quinoa', 120),
('Salmon', 208),
('tofu', 76),
('Tomate', 18),
('Tostadas', 80),
('uvas', 69),
('yogurt', 100),
('Zanahoria', 41);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE `menu` (
  `NombreM` varchar(50) NOT NULL,
  `valorTotal` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menu`
--

INSERT INTO `menu` (`NombreM`, `valorTotal`) VALUES
('Almuerzo Express', 407.4),
('Almuerzo Fitness', 513.6),
('Bowl Andino', 306.6),
('Bowl de quinoa', 487.4),
('Bowl Energético', 633.8),
('Bowl Mediterráneo', 391.8),
('Bowl Mediterraneo Plus', 433.6),
('Bowl Mexicano', 328),
('Bowl proteico', 512),
('Bowl Proteico Plus', 411.8),
('Bowl Quinoa Salmon', 472.4),
('Bowl Tropical', 421),
('Bowl Vegetariano', 268.9),
('cafe con leche', 22.3),
('Cena de salmon', 583.1),
('Cena Ligera', 251.2),
('Desayuno Campestre', 472.6),
('Desayuno Continental', 491.2),
('Desayuno energético', 403.7),
('Desayuno Mediterráneo', 450.2),
('Desayuno Power', 533.2),
('Desayuno Proteico', 618.6),
('Desayuno saludable', 400.75),
('Ensalada Cesar Light', 294),
('Ensalada de lentejas', 352.1),
('ensalada de palta', 58.5),
('Ensalada Marina', 187.6),
('Ensalada mediterranea', 306.6),
('Ensalada Otoñal', 342.1),
('Ensalada Primaveral', 186),
('Ensalada Proteica', 312.8),
('Ensalada Verde', 202.9),
('guiso de pollo', 473.09),
('guisoo', NULL),
('Merienda Saludable', 347.55),
('Mix de frutos secos', 483.2),
('Mix Energético', 385.65),
('Pasta integral vegetariana', 560.05),
('Pasta Marina', 519.1),
('Pasta Primavera', 551.3),
('Pechuga y ensalada', 155.2),
('Pollo al Curry', 404.3),
('Pollo con vegetales', 554.6),
('Power Bowl', 323.7),
('Smoothie Bowl', 400.4),
('Snack proteico', 324.7),
('Tostada Fitness', 397.3),
('Tostadas con aguacate', 338.7),
('Wrap de atún', 403.1),
('Wrap de Pavo', 388.9),
('Wrap Proteico', 397.7),
('Wrap Vegetal', 255.9),
('Yogurt con cereal', 164);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `dni` int(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `pesoBuscado` float NOT NULL,
  `pesoActual` float NOT NULL,
  `altura` float NOT NULL,
  `edad` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`dni`, `nombre`, `apellido`, `pesoBuscado`, `pesoActual`, `altura`, `edad`, `estado`) VALUES
(20333222, 'junco', 'asdas', 78, 70, 1.68, 30, 1),
(33333333, 'martin', 'asdas', 75, 70, 1.6, 30, 1),
(34555666, 'john', 'doe', 85, 90, 1.83, 37, 1),
(35444555, 'john', 'doe', 85, 90, 1.83, 37, 1),
(35877616, 'martin', 'lucero', 75, 78, 1.84, 78, 1),
(38419061, 'maria', 'lola', 71, 84, 1.84, 30, 1),
(38419062, 'maria', 'lola', 71, 84, 1.84, 30, 1),
(38419063, 'maria', 'lola', 71, 84, 1.8, 30, 1),
(38777616, 'mayra', 'gatica', 70, 84, 1.72, 34, 0),
(40400400, 'juan', 'jon', 60, 90, 1.42, 55, 0),
(44444444, 'mama', 'asdas', 70, 80, 1.7, 50, 0),
(46041451, 'simon', 'perez', 80, 85, 1.83, 20, 0),
(54877619, 'jujuy', 'jojjo', 90, 65, 1.89, 33, 0),
(77999888, 'martin', 'perez', 80, 89, 1.8, 20, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `NombreM` varchar(50) NOT NULL,
  `NombreI` varchar(50) NOT NULL,
  `cantidadIng` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`NombreM`, `NombreI`, `cantidadIng`) VALUES
('ensalada de palta', 'Lechuga', 10),
('ensalada de palta', 'Aguacate', 8),
('Pechuga y ensalada', 'Pechuga de pollo', 65),
('Pechuga y ensalada', 'Lechuga', 25),
('Yogurt con cereal', 'yogurt', 40),
('Yogurt con cereal', 'Cereales', 15),
('Yogurt con cereal', 'Masitas secas', 50),
('cafe con leche', 'cafe', 8),
('cafe con leche', 'Leche entera', 20),
('cafe con leche', 'azucar', 3),
('Desayuno saludable', 'Avena', 50),
('Desayuno saludable', 'Miel', 10),
('Desayuno saludable', 'Plátano', 100),
('Desayuno saludable', 'Almendras', 15),
('Ensalada mediterranea', 'Lechuga', 100),
('Ensalada mediterranea', 'Tomate', 150),
('Ensalada mediterranea', 'Atún en agua', 100),
('Bowl de quinoa', 'Quinoa', 100),
('Bowl de quinoa', 'Aguacate', 50),
('Bowl de quinoa', 'Pechuga de pollo', 100),
('Bowl de quinoa', 'Brócoli', 100),
('Cena de salmon', 'Salmon', 150),
('Cena de salmon', 'Espinaca', 100),
('Cena de salmon', 'Papa', 150),
('Snack proteico', 'yogurt', 150),
('Snack proteico', 'Arándanos', 50),
('Snack proteico', 'Almendras', 20),
('Snack proteico', 'Miel', 10),
('Tostadas con aguacate', 'Tostadas', 60),
('Tostadas con aguacate', 'Aguacate', 100),
('Tostadas con aguacate', 'Tomate', 50),
('Tostadas con aguacate', 'Huevo', 50),
('Bowl proteico', 'Arroz blanco', 100),
('Bowl proteico', 'Pechuga de pollo', 150),
('Bowl proteico', 'Aguacate', 50),
('Bowl proteico', 'Zanahoria', 50),
('Bowl proteico', 'Brócoli', 100),
('Ensalada de lentejas', 'Lentejas', 150),
('Ensalada de lentejas', 'Cebolla', 30),
('Ensalada de lentejas', 'Tomate', 100),
('Ensalada de lentejas', 'Pimiento rojo', 50),
('Pasta integral vegetariana', 'Pasta', 100),
('Pasta integral vegetariana', 'Tomate', 150),
('Pasta integral vegetariana', 'Champiñones', 100),
('Pasta integral vegetariana', 'Ajo', 5),
('Desayuno energético', 'Pan integral', 60),
('Desayuno energético', 'Huevo', 100),
('Desayuno energético', 'Espinaca', 50),
('Desayuno energético', 'Tomate', 50),
('Desayuno energético', 'Aguacate', 50),
('Mix de frutos secos', 'Almendras', 30),
('Mix de frutos secos', 'Cacahuates', 30),
('Mix de frutos secos', 'Pepitas de calabaza', 20),
('Mix de frutos secos', 'uvas', 40),
('Pollo con vegetales', 'Pechuga de pollo', 200),
('Pollo con vegetales', 'Brócoli', 100),
('Pollo con vegetales', 'Zanahoria', 100),
('Pollo con vegetales', 'Calabacin', 100),
('Wrap de atún', 'Atún en agua', 120),
('Wrap de atún', 'Lechuga', 50),
('Wrap de atún', 'Tomate', 50),
('Wrap de atún', 'Aguacate', 50),
('Wrap de atún', 'Pan integral', 60),
('Bowl de quinoa', 'Aceite de oliva', 10),
('guiso de pollo', 'Pechuga de pollo', 200),
('guiso de pollo', 'Arroz blanco', 50),
('guiso de pollo', 'Aceite de oliva', 5),
('guiso de pollo', 'Tomate', 180),
('guiso de pollo', 'ajo', 1),
('Desayuno Campestre', 'Huevo', 120),
('Desayuno Campestre', 'Pan integral', 80),
('Desayuno Campestre', 'Aguacate', 50),
('Desayuno Campestre', 'Tomate', 50),
('Ensalada Primaveral', 'Lechuga', 100),
('Ensalada Primaveral', 'Tomate', 80),
('Ensalada Primaveral', 'Zanahoria', 60),
('Ensalada Primaveral', 'Atún en agua', 100),
('Bowl Mediterráneo', 'Quinoa', 100),
('Bowl Mediterráneo', 'Garbanzos', 80),
('Bowl Mediterráneo', 'Pepino', 50),
('Bowl Mediterráneo', 'Aceite de oliva', 15),
('Wrap Vegetal', 'Pan integral', 60),
('Wrap Vegetal', 'Lechuga', 30),
('Wrap Vegetal', 'Tomate', 40),
('Wrap Vegetal', 'Aguacate', 60),
('Pasta Primavera', 'Pasta', 100),
('Pasta Primavera', 'Brócoli', 80),
('Pasta Primavera', 'Zanahoria', 50),
('Pasta Primavera', 'Aceite de oliva', 15),
('Pollo al Curry', 'Pechuga de pollo', 150),
('Pollo al Curry', 'Arroz blanco', 100),
('Pollo al Curry', 'Cebolla', 40),
('Pollo al Curry', 'Tomate', 60),
('Bowl Proteico Plus', 'Quinoa', 100),
('Bowl Proteico Plus', 'Pechuga de pollo', 120),
('Bowl Proteico Plus', 'Aguacate', 50),
('Bowl Proteico Plus', 'Espinaca', 60),
('Ensalada Marina', 'Atún en agua', 120),
('Ensalada Marina', 'Lechuga', 80),
('Ensalada Marina', 'Tomate', 60),
('Ensalada Marina', 'Pepino', 40),
('Mix Energético', 'Almendras', 30),
('Mix Energético', 'Cacahuates', 30),
('Mix Energético', 'Arándanos', 25),
('Mix Energético', 'uvas', 40),
('Bowl Vegetariano', 'tofu', 120),
('Bowl Vegetariano', 'Arroz blanco', 100),
('Bowl Vegetariano', 'Brócoli', 80),
('Bowl Vegetariano', 'Zanahoria', 50),
('Desayuno Power', 'Avena', 60),
('Desayuno Power', 'Plátano', 100),
('Desayuno Power', 'yogurt', 150),
('Desayuno Power', 'Miel', 20),
('Ensalada Otoñal', 'Lechuga', 100),
('Ensalada Otoñal', 'Manzana', 80),
('Ensalada Otoñal', 'Almendras', 30),
('Ensalada Otoñal', 'Pepitas de calabaza', 20),
('Pasta Marina', 'Pasta', 100),
('Pasta Marina', 'Camarones', 120),
('Pasta Marina', 'Tomate', 80),
('Pasta Marina', 'Ajo', 10),
('Bowl Tropical', 'Quinoa', 100),
('Bowl Tropical', 'Piña', 80),
('Bowl Tropical', 'Aguacate', 60),
('Bowl Tropical', 'Pechuga de pollo', 100),
('Wrap Proteico', 'Pan integral', 60),
('Wrap Proteico', 'Pechuga de pollo', 100),
('Wrap Proteico', 'Aguacate', 50),
('Wrap Proteico', 'Lechuga', 30),
('Ensalada Proteica', 'Lechuga', 100),
('Ensalada Proteica', 'Huevo', 100),
('Ensalada Proteica', 'Atún en agua', 100),
('Ensalada Proteica', 'Tomate', 60),
('Bowl Andino', 'Quinoa', 100),
('Bowl Andino', 'Lentejas', 80),
('Bowl Andino', 'Aguacate', 50),
('Bowl Andino', 'Espinaca', 60),
('Desayuno Mediterráneo', 'Pan integral', 60),
('Desayuno Mediterráneo', 'Aceite de oliva', 15),
('Desayuno Mediterráneo', 'Tomate', 80),
('Desayuno Mediterráneo', 'Huevo', 100),
('Smoothie Bowl', 'Plátano', 100),
('Smoothie Bowl', 'Arándanos', 80),
('Smoothie Bowl', 'yogurt', 150),
('Smoothie Bowl', 'Almendras', 20),
('Bowl Mexicano', 'Garbanzos', 100),
('Bowl Mexicano', 'Garbanzos', 100),
('Bowl Quinoa Salmon', 'Quinoa', 100),
('Bowl Quinoa Salmon', 'Salmon', 120),
('Bowl Quinoa Salmon', 'Aguacate', 50),
('Bowl Quinoa Salmon', 'Espinaca', 60),
('Bowl Quinoa Salmon', 'Tomate', 50),
('Tostada Fitness', 'Pan integral', 60),
('Tostada Fitness', 'Huevo', 100),
('Tostada Fitness', 'Aguacate', 50),
('Tostada Fitness', 'Tomate', 40),
('Tostada Fitness', 'Espinaca', 30),
('Ensalada Cesar Light', 'Lechuga', 100),
('Ensalada Cesar Light', 'Pechuga de pollo', 100),
('Ensalada Cesar Light', 'Tomate', 50),
('Ensalada Cesar Light', 'Pan integral', 30),
('Ensalada Cesar Light', 'Queso', 30),
('Desayuno Proteico', 'Avena', 60),
('Desayuno Proteico', 'yogurt', 150),
('Desayuno Proteico', 'Plátano', 100),
('Desayuno Proteico', 'Almendras', 20),
('Desayuno Proteico', 'Miel', 10),
('Power Bowl', 'Quinoa', 100),
('Power Bowl', 'tofu', 100),
('Power Bowl', 'Brócoli', 80),
('Power Bowl', 'Zanahoria', 50),
('Power Bowl', 'Aguacate', 50),
('Almuerzo Fitness', 'Pechuga de pollo', 150),
('Almuerzo Fitness', 'Arroz blanco', 100),
('Almuerzo Fitness', 'Brócoli', 80),
('Almuerzo Fitness', 'Zanahoria', 50),
('Almuerzo Fitness', 'Aceite de oliva', 10),
('Cena Ligera', 'Atún en agua', 100),
('Cena Ligera', 'Lechuga', 80),
('Cena Ligera', 'Tomate', 60),
('Cena Ligera', 'Pepino', 50),
('Cena Ligera', 'Aceite de oliva', 10),
('Bowl Mexicano', 'Arroz blanco', 100),
('Bowl Mexicano', 'Frijoles', 100),
('Bowl Mexicano', 'Aguacate', 50),
('Bowl Mexicano', 'Tomate', 50),
('Bowl Mexicano', 'Lechuga', 30),
('Desayuno Continental', 'Pan integral', 80),
('Desayuno Continental', 'Huevo', 100),
('Desayuno Continental', 'Queso', 40),
('Desayuno Continental', 'Tomate', 50),
('Desayuno Continental', 'Aceite de oliva', 10),
('Merienda Saludable', 'yogurt', 150),
('Merienda Saludable', 'Cereales', 30),
('Merienda Saludable', 'Miel', 15),
('Merienda Saludable', 'Arándanos', 30),
('Merienda Saludable', 'Almendras', 15),
('Wrap de Pavo', 'Pan integral', 60),
('Wrap de Pavo', 'Pechuga de pollo', 100),
('Wrap de Pavo', 'Lechuga', 30),
('Wrap de Pavo', 'Tomate', 40),
('Wrap de Pavo', 'Aguacate', 40),
('Bowl Mediterraneo Plus', 'Quinoa', 100),
('Bowl Mediterraneo Plus', 'Garbanzos', 100),
('Bowl Mediterraneo Plus', 'Tomate', 50),
('Bowl Mediterraneo Plus', 'Pepino', 50),
('Bowl Mediterraneo Plus', 'Aceite de oliva', 15),
('Ensalada Verde', 'Lechuga', 100),
('Ensalada Verde', 'Espinaca', 50),
('Ensalada Verde', 'Pepino', 50),
('Ensalada Verde', 'Aguacate', 50),
('Ensalada Verde', 'Aceite de oliva', 10),
('Almuerzo Express', 'Atún en agua', 100),
('Almuerzo Express', 'Arroz blanco', 100),
('Almuerzo Express', 'Maíz', 50),
('Almuerzo Express', 'Tomate', 50),
('Almuerzo Express', 'Aceite de oliva', 10),
('Bowl Energético', 'Avena', 60),
('Bowl Energético', 'Plátano', 100),
('Bowl Energético', 'Almendras', 20),
('Bowl Energético', 'Miel', 15),
('Bowl Energético', 'yogurt', 150);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `colacion`
--
ALTER TABLE `colacion`
  ADD KEY `ID_Dieta` (`ID_Dieta`),
  ADD KEY `NombreM` (`NombreM`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`ID_Dieta`),
  ADD KEY `dni` (`dni`);

--
-- Indices de la tabla `ingrediente`
--
ALTER TABLE `ingrediente`
  ADD PRIMARY KEY (`NombreI`);

--
-- Indices de la tabla `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`NombreM`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD KEY `NombreM` (`NombreM`,`NombreI`),
  ADD KEY `NombreI` (`NombreI`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `ID_Dieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `dni` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87654322;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `colacion`
--
ALTER TABLE `colacion`
  ADD CONSTRAINT `colacion_ibfk_1` FOREIGN KEY (`ID_Dieta`) REFERENCES `dieta` (`ID_Dieta`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `colacion_ibfk_2` FOREIGN KEY (`NombreM`) REFERENCES `menu` (`NombreM`);

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`dni`) REFERENCES `paciente` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `receta`
--
ALTER TABLE `receta`
  ADD CONSTRAINT `receta_ibfk_1` FOREIGN KEY (`NombreM`) REFERENCES `menu` (`NombreM`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `receta_ibfk_2` FOREIGN KEY (`NombreI`) REFERENCES `ingrediente` (`NombreI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
