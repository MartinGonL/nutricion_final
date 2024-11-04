-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-11-2024 a las 21:12:06
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
('Brócoli', 34),
('Cacahuates', 567),
('cafe', 115),
('Calabacin', 17),
('Camarones', 99),
('Carne de res', 250),
('Cebolla', 40),
('Champiñones', 22),
('Chocolate negro', 598),
('Ciruela', 46),
('Espinaca', 23),
('Frutilla', 32),
('Garbanzos', 164),
('Higos', 74),
('Huevo', 155),
('Jengibre', 80),
('Leche entera', 61),
('Lechuga', 15),
('Lentejas8', 116),
('Maíz', 96),
('Mantequilla', 717),
('Manzana', 52),
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
('Queso cheddar', 402),
('Quinoa', 120),
('Salmon', 208),
('tofu', 76),
('Tomate', 18),
('uvas', 69),
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
('Cafe con leche', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `dni` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `pesoBuscado` float NOT NULL,
  `pesoActual` float NOT NULL,
  `altura` float NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
('Cafe con leche', 'Leche entera', 110),
('Cafe con leche', 'cafe', 5);

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
  MODIFY `dni` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=87654322;

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
