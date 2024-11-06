-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-11-2024 a las 23:39:49
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
CREATE DATABASE IF NOT EXISTS `nutricionista` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `nutricionista`;

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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `ID_Dieta` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `pesoFinal` float DEFAULT NULL,
  `fechaFin` date NOT NULL,
  `fechaIni` date NOT NULL,
  `totalCalorias` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
('Ajo', 149),
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
('Bowl de quinoa', 487.4),
('Bowl proteico', 512),
('cafe con leche', 22.3),
('Cena de salmon', 583.1),
('Desayuno energético', 403.7),
('Desayuno saludable', 400.75),
('Ensalada de lentejas', 352.1),
('ensalada de palta', 58.5),
('Ensalada mediterranea', 306.6),
('Mix de frutos secos', 483.2),
('Pasta integral vegetariana', 560.05),
('Pechuga y ensalada', 155.2),
('Pollo con vegetales', 554.6),
('Snack proteico', 324.7),
('Tostadas con aguacate', 338.7),
('Wrap de atún', 403.1),
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
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`dni`, `nombre`, `apellido`, `pesoBuscado`, `pesoActual`, `altura`, `edad`) VALUES
(46041451, 'simon', 'perez', 80, 85, 1.83, 20),
(77999888, 'martin', 'perez', 80, 89, 1.8, 20);

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
('ensalada de palta', 'Aceite de oliva', 5),
('Pechuga y ensalada', 'Pechuga de pollo', 65),
('Pechuga y ensalada', 'Lechuga', 25),
('Pechuga y ensalada', 'Aceite de oliva', 5),
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
('Ensalada mediterranea', 'Aceite de oliva', 15),
('Ensalada mediterranea', 'Atún en agua', 100),
('Bowl de quinoa', 'Quinoa', 100),
('Bowl de quinoa', 'Aguacate', 50),
('Bowl de quinoa', 'Pechuga de pollo', 100),
('Bowl de quinoa', 'Brócoli', 100),
('Bowl de quinoa', 'Aceite de oliva', 10),
('Cena de salmon', 'Salmon', 150),
('Cena de salmon', 'Espinaca', 100),
('Cena de salmon', 'Papa', 150),
('Cena de salmon', 'Aceite de oliva', 15),
('Snack proteico', 'yogurt', 150),
('Snack proteico', 'Arándanos', 50),
('Snack proteico', 'Almendras', 20),
('Snack proteico', 'Miel', 10),
('Tostadas con aguacate', 'Tostadas', 60),
('Tostadas con aguacate', 'Aguacate', 100),
('Tostadas con aguacate', 'Tomate', 50),
('Tostadas con aguacate', 'Huevo', 50),
('Tostadas con aguacate', 'Aceite de oliva', 5),
('Bowl proteico', 'Arroz blanco', 100),
('Bowl proteico', 'Pechuga de pollo', 150),
('Bowl proteico', 'Aguacate', 50),
('Bowl proteico', 'Zanahoria', 50),
('Bowl proteico', 'Brócoli', 100),
('Ensalada de lentejas', 'Lentejas', 150),
('Ensalada de lentejas', 'Cebolla', 30),
('Ensalada de lentejas', 'Tomate', 100),
('Ensalada de lentejas', 'Aceite de oliva', 15),
('Ensalada de lentejas', 'Pimiento rojo', 50),
('Pasta integral vegetariana', 'Pasta', 100),
('Pasta integral vegetariana', 'Tomate', 150),
('Pasta integral vegetariana', 'Champiñones', 100),
('Pasta integral vegetariana', 'Aceite de oliva', 15),
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
('Pollo con vegetales', 'Aceite de oliva', 15),
('Wrap de atún', 'Atún en agua', 120),
('Wrap de atún', 'Lechuga', 50),
('Wrap de atún', 'Tomate', 50),
('Wrap de atún', 'Aguacate', 50),
('Wrap de atún', 'Pan integral', 60);

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
  MODIFY `ID_Dieta` int(11) NOT NULL AUTO_INCREMENT;

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
