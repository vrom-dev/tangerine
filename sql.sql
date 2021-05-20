drop database if exists proyectogeneration2;
CREATE DATABASE  IF NOT EXISTS `proyectogeneration2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyectogeneration2`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectogeneration2
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargos` (
  `idcargo` int(11) NOT NULL AUTO_INCREMENT,
  `cargo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'CEO'),(2,'Backend Engineer'),(3,'Frontend Engineer'),(4,'UX/UI'),(5,'Marketing'),(6,'CTO');
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `logo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Accenture','Tu consultora de confianza2','logoaccenture'),(2,'Indra','Tu consultora de confianza','logoindra'),(3,'Santander','Banco líder presente en multitud de países','logosantander');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensajes`
--

DROP TABLE IF EXISTS `mensajes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensajes` (
  `idmensaje` int(11) NOT NULL AUTO_INCREMENT,
  `remitente` varchar(100) DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `mensaje` varchar(512) DEFAULT NULL,
  `respuesta` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`idmensaje`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensajes`
--

LOCK TABLES `mensajes` WRITE;
/*!40000 ALTER TABLE `mensajes` DISABLE KEYS */;
INSERT INTO `mensajes` VALUES (1,'Autoescuela Pepe','2021-02-17 12:12:21','Aplicacion test online','Estamos muy satisfechos con la aplicación, queremos aumentar algunas funcionalidades','Cuando concretamos la reunion'),(2,'Generation Spain','2021-03-17 12:12:21','Presupuesto','Nos gustaría consultar un presupuesto para una web interactiva con contenido audiovisual',null),(3,'Banco Santander','2021-04-17 11:12:21','Nueva pagina para empresas','Queremos extender la funcionalidad bizum de la banca personal a la banca empresas en la web',NULL),(4,'Netflix','2021-05-17 11:12:21','Investigación Moviflix','Queremos concertar una cita lo antes posible',NULL);
/*!40000 ALTER TABLE `mensajes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `resumen` varchar(512) DEFAULT NULL,
  `foto` varchar(128) DEFAULT NULL,
  `cargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  KEY `cargo` (`cargo`),
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`cargo`) REFERENCES `cargos` (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Alvaro','Cañas','Desarrollador especializado en Java y SQL','img/alvaro.jpg',2),(2,'Victor','Romero','Desarrollador especializado en React','img/victor.jpg',4),(3,'Alberto','Sayavera','Desarrollador especializado en Java Spring-Boot','img/alberto.jpg',2),(4,'Luis','Rojo','Desarrollador especializado en Python y Scala','img/luis.jpg',1);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyectos`
--

DROP TABLE IF EXISTS `proyectos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyectos` (
  `idproyecto` int(11) NOT NULL AUTO_INCREMENT,
  `proyecto` varchar(45) DEFAULT NULL,
  `fechafin` varchar(45) DEFAULT NULL,
  `resumen` varchar(200) DEFAULT NULL,
  `descripcion` varchar(1024) DEFAULT NULL,
  `imagen` varchar(128) DEFAULT NULL,
  `idcliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproyecto`),
  KEY `proyectos_ibfk_1` (`idcliente`),
  CONSTRAINT `proyectos_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `clientes` (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyectos`
--

LOCK TABLES `proyectos` WRITE;
/*!40000 ALTER TABLE `proyectos` DISABLE KEYS */;
INSERT INTO `proyectos` VALUES 
(null,'Movieflix','Marzo 2021','Gestión de un sistema de vídeo en streaming','Este proyecto desarrolla la plataforma para gestionar y administrar, tanto las películas a visionar vía streaming como los usuarios inscritos.\r\nEs por ello, que el proyecto se centra en la zona de administración donde se ofrece la gestión de usuario y de películas, proporcionando una serie de informes.\r\n\r\n\r\n','img/proyectos/movieflix.jpg',1),
(null,'Quiz','Abril 2021','Juego tipo quiz de preguntas y respuestas','Este proyecto consiste en la creación de un juego tipo quiz de preguntas y respuestas.\r\nEl juego puede ser de hasta 10 preguntas y éstas serán aleatorias.\r\nAl finalizar el juego, el jugador obtiene la puntuación obtenida, el número de aciertos y el tiempo empleado.\r\nPara el desarrollo del proyecto se ha utilizado principalmente las tecnologías de html y JavaScript.\r\n','img/proyectos/quiz.jpg',2),
(null,'Ant Design Pro','Mayo 2020','Interfaz de administración para aplicaciones','Interfaz de administración para aplicaciones basado en React recién salido del horno que cuenta con más de 4.300 estrellas en el último mes de la empresa china Ant Design. Responsive, con tests unitarios, temas customizables, soporte de internacionalización... muy completo.','img/proyectos/Ant.jpg',2),
(null,'Windy','Junio 2020','Aplicación para el pronóstico de viento más preciso en el mundo!','Windy es una aplicación útil para las personas adictas al viento que proporciona un preciso y claro pronóstico de viento mundial. Una aplicación imperdible para kiteboarders, windsurfers, navegantes, paracaidistas, parapentes, ciclistas y pescadores.','img/proyectos/Windy.jpg',1),
(null,'Unfold','Abril 2021','Unfold es un kit de herramientas para tus Stories. Crea hermosas historias con plantillas.','• Crea tu historia con más de 250 plantillas de colecciones como Film Frames y Ripped Paper\r\n• Usa herramientas de texto avanzadas con cuidadas tipografías y añade pegatinas únicas\r\n• Captura tu contenido con la Cámara Unfold y edítalo con 10 filtros y efectos\r\n• Exporta tus historias en alta resolución para compartirlas en otras plataformas sin problemas\r\n','img/proyectos/Unfold.jpg',2),
(null,'Indomio','Enero 2021','¡La app de Indomio, es la mejor forma de buscar tu casa perfecta!','Encuentra miles de anuncios de casas en venta, en alquiler, y casas de bancos en todas las grandes ciudades de Europa como Madrid, Barcelona, Roma, Berlin, Paris, etc.\r\nGracias a los buscadores que proporciona la app será muy facial hacer filtros que se adapten a las necesidades del cliente.','img/proyectos/indomio.jpg',1),
(null,'Camy','Agosto 2020','Aplicación que hará de su teléfono una cámara de vigilancia.','Camy convierte sus teléfonos y tabletas en los sistemas video de vigilancia en tiempo real. Puede conectarse a otro teléfono desde cualquier lugar si tiene acceso a Internet. Camy le permite monitorear su casa u oficina sin tener que comprar algún equipo especial. Camy le ayudará a monitorear a sus hijos, a rastrear a su gato o perro, o simplemente le mostrará quién está en casa. Un detector de movimiento protegerá su casa contra la intrusión y lo notificará a usted instantáneamente.','img/proyectos/camy.jpg',2),
(null,'Aprende Aleman','Diciembre 2020','Aplicación móvil para aprender Alemán.','Esta aplicación fue desarrollada para aquellos que quieran estudiar Alemán obtener conocimientos básicos de Alemán Conversacional con rapidez, memoriza palabras y de forma gratuita!\r\nEl contenido está siendo desarrollado por los principales especialistas en metodología y lingüistas, que enseñan en universidades.\r\n','img/proyectos/aprender aleman.jpg',1),
(null,'Linio','Febrero 2021','La tienda online más completa que puedas encontrar.','Es tu mejor opción para tus compras en línea. Contamos con las mejores marcas originales en la tienda más grande y confiable de todo el mundo. Busca tus tiendas favoritas en cualquier momento y recibe tú producto donde quieras.\r\n\r\nExplora entre todas las categorías de productos que tenemos y descubre exclusivos descuentos en la aplicación. Navega en la app y encuentra los productos que buscas. Escoge lo que más te gusta entre las ofertas que tenemos para ti. \r\n','img/proyectos/linio.jpg',3),
(null,'CaixaBankiAbanCajamarLiberbankinterBanestOpen','Abril 2025','Web unificada de los bancos de España','Web que centraliza todos los servicios de todos los bancos de España. El usuario puede acceder a todos los productos que ofrecen los diferentes bancos, además de realizar operaciones a través de una capa segura para cada api de cada banco','img/proyectos/5.jpg',3),
(null,'Grace Whopper','Abril 2021','Web interactiva para iniciarse en la programación ','La web gracewhooper.com es una web-red social de iniciación en la programación con soporte para JavaScript, Java y C#. \r\nLos usuario pueden practicar resolviendo retos reales de codigo que proponen los propios usuarios. \r\nAdemás de un entorno de desarrollo real también hay video tutoriales a disposición de la comunidad.  Existen planes gratuítos y de pago.','img/proyectos/6.jpg',1),
(null,'FaceTwitter','Septiembre 2020','Popular Red Social con mensajes muy largos, de no menos de 140 caracteres','Desarrollado durante los meses de cuarentena, FaceTwitter es un proyecto OpenSource desarrollado por Tangerine y la comunidad que da respuesta a la necesidad de tener una red social con artículos e historias muy largos, especialmente pensado para creadores de contenido que quieren publicar aquí sus cuentos cortos, novelas por capítulos, artículos de investigación, etc...','img/proyectos/4.jpg',2);
/*!40000 ALTER TABLE `proyectos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-19 13:24:29