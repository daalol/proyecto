-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-05-2013 a las 23:15:26
-- Versión del servidor: 5.5.25a
-- Versión de PHP: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `cafeteria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contrasenas`
--

CREATE TABLE IF NOT EXISTS `contrasenas` (
  `password` varchar(8) NOT NULL,
  `id_mesa` int(3) NOT NULL,
  PRIMARY KEY (`password`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Tabla que almacenara las contraseñas de las mesas del local';

--
-- Volcado de datos para la tabla `contrasenas`
--

INSERT INTO `contrasenas` (`password`, `id_mesa`) VALUES
('12345678', 1),
('1253478', 4),
('56781234', 3),
('87654321', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historico_pedidos`
--

CREATE TABLE IF NOT EXISTS `historico_pedidos` (
  `pedido` varchar(10000) NOT NULL,
  `id_mesa` int(3) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Registro historico de pedidos';

--
-- Volcado de datos para la tabla `historico_pedidos`
--

INSERT INTO `historico_pedidos` (`pedido`, `id_mesa`, `fecha`) VALUES
('*** Horchata Mixta Mediano. Cantidad: 1 ||| Fartons, Cantidad:2', 1, '2013-05-28 11:20:38'),
('*** Tarrina, Mediano, Fresa Limon. Cantidad: 1 ||| Gofre, Nata. Cantidad: 1', 2, '2013-05-28 11:20:38');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE IF NOT EXISTS `pedidos` (
  `pedido` varchar(10000) NOT NULL,
  `estado` varchar(10) NOT NULL,
  `id_mesa` int(3) NOT NULL,
  `id_pedido` int(6) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COMMENT='Tabla que controlara los pedidos de las mesas' AUTO_INCREMENT=17 ;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`pedido`, `estado`, `id_mesa`, `id_pedido`) VALUES
('*** Gofre, Chocolate y Helado de Nutella. Cantidad: 1 ||| Cortado , natural , Cantidad: 1', 'nuevo', 3, 15),
('*** Ensaimada, Cantidad:1 ||| Cafe con leche , del tiempo , Cantidad: 1', 'servido', 1, 16);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
