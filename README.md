# api_tpo

Trabajo final de la materia Aplicaciones Interactivas

## Table Persona

CREATE TABLE `personas` (
`documento` varchar(20) NOT NULL,
`nombre` varchar(100) NOT NULL,
`mail` varchar(100) DEFAULT NULL,
`contrasenia` varchar(100) DEFAULT NULL,
PRIMARY KEY (`documento`)
)
