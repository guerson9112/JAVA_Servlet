-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-01-2019 a las 22:23:38
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `colegio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `id` int(11) NOT NULL,
  `ISBN` varchar(20) NOT NULL,
  `titulo` varchar(20) NOT NULL,
  `nombre_autor` varchar(20) NOT NULL,
  `apellido_autor` varchar(20) NOT NULL,
  `precio` double NOT NULL,
  `categoria` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`id`, `ISBN`, `titulo`, `nombre_autor`, `apellido_autor`, `precio`, `categoria`) VALUES
(1, '23213214', 'afd', 'fhfjhfhj', 'sdfgfdgfd', 34, 'fssd'),
(2, '123214', 'asfdfdsa', 'dfgjhgjgh', 'sfhgfgkhg', 67, 'sdfgsdf'),
(3, 'libro 3', 'asfdsf', 'dsfdsafasd', 'hjhgjhg', 9, 'asffsaf'),
(4, 'libro 3', 'asfdsf', 'dsfdsafasd', 'hjhgjhg', 9, 'asffsaf'),
(5, 'libro 3', 'asfdsf', 'dsfdsafasd', 'hjhgjhg', 9, 'asffsaf'),
(6, 'libro 3', 'asfdsf', 'dsfdsafasd', 'hjhgjhg', 9, 'asffsaf'),
(7, 'libro 3', 'asfdsf', 'dsfdsafasd', 'hjhgjhg', 9, 'asffsaf'),
(8, '1232', 'Eragon', 'Christopher', 'Paolini', 34, 'FantasÃ­a'),
(9, 'ghfghg', 'tewrwq', 'fdghfd', 'fsdgf', 3, 'dfgfdgfd'),
(10, 'dgfda', 'asfddas', 'fdasfd', 'fdfds', 21, 'dfdf'),
(11, '12324656', 'Harry Potter', 'J.K.', 'Rowling', 56, 'Fantasia'),
(12, '12324656', 'Harry Potter', 'J.K.', 'Rowling', 56, 'Fantasia'),
(13, 'ewrew', 'rwerweq', 'fdgfd', 'hgkjhgk', 34, 'sdfds'),
(14, '132432', 'hgjkhf', 'dsgfd', 'fdgfdgfd', 11, 'sdfgfsd'),
(15, '123233244233', 'qewq', 'sfdsfds', 'fgfdgdf', 45, 'fasfsfd'),
(16, '67678678', 'gjgjkgl', 'jljlÃ±', 'kjkjklj', 11, 'FantasÃ­a');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `libro`
--
ALTER TABLE `libro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
