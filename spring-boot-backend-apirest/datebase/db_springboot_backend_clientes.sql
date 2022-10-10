CREATE SCHEMA `db_springboot_backend` ;

USE `db_springboot_backend`;

CREATE TABLE `clientes` (
  `id` INTEGER NOT NULL PRIMARY KEY,
  `nombre` varchar(12),
  `apellido` varchar(255),
  `create_at` date,
  `email` varchar(255));

/*los inssert en la tabla se realizan en el archivo import.sql*/ 
