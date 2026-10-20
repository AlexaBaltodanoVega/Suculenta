# Suculenta
Estudiante: TU NOMBRE COMPLETO Curso: SC-403

Aplicación web CRUD en Spring Boot para administrar un catálogo de suculentas.

- Requisitos
JDK 21
MySQL Workbench
NetBeans

1. Crear la base de datos
Abrir MySQL Workbench con el usuario root.
Abrir y ejecutar completo el archivo sql/practica.sql.
Esto crea la base practica, la tabla suculenta, el usuario usuario_practica (clave la_Clave) y 6 registros de prueba.

2. Ejecutar la aplicación
Abrir el proyecto practica01 en NetBeans.
Clic derecho en el proyecto > Clean and Build.
Clic derecho > Run.
Abrir en el navegador: http://localhost:91

- Rutas principales
/:	Inicio con galería y consulta por familia
/consultas/{familia}:	Suculentas filtradas por familia
/suculenta/listado:	Listado, agregar y eliminar
/suculenta/modificar/{id}:	Actualizar una suculenta

- Configuración
Puerto: 91
Base de datos: practica (MySQL, localhost:3306)
Logs: nivel TRACE con día del mes, hora y minuto
Imágenes: URLs en la nube (Wikimedia Commons)
Idiomas: español e inglés
