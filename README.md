# README

## Descripción del Proyecto

Este sistema de gestión permite a los administradores y tutores gestionar la información de los profesores y alumnos, así como las calificaciones de los estudiantes. Los usuarios pueden cambiar sus contraseñas, agregar y eliminar tutores y alumnos, y gestionar las notas de los alumnos.

## Tecnologías Utilizadas

- **Frontend**:
  - **JSP (Java Server Pages)**: Para las vistas y plantillas dinámicas del lado del servidor.
  - **Bootstrap 5**: Para el diseño responsivo y la interfaz de usuario.
  - **JavaScript (JS)**: Para la funcionalidad interactiva, incluida la validación AJAX.

- **Backend**:
  - **Java EE 7**: Para la implementación del servidor y la lógica del negocio.
  - **Java 11**: Versión de Java para el desarrollo del backend.
  - **Hibernate**: Para la gestión de la base de datos y la persistencia de los datos.
  - **MySQL 8**: Base de datos para almacenar toda la información de tutores, alumnos, y calificaciones.

## Funcionalidades

### Administrador (usuario predeterminado: **final@gmail.com**, contraseña predeterminada: **123**)

El administrador tiene los siguientes privilegios:

- **Dar de alta a nuevos tutores**:
  - Introducir un email y un ciclo asignado al tutor.
  - La contraseña inicial será **123**.
  - Sólo podrá existir un tutor por ciclo.
  - El sistema detectará mediante AJAX si el email ya está registrado.

- **Eliminar profesores**:
  - El administrador puede eliminar un tutor siempre que no tenga alumnos asignados.
  
- **Listar los tutores existentes**:
  - Visualizar una lista con todos los tutores.
  - En este listado, se muestran tanto los tutores que tienen alumnos como los que no tienen.

### Tutor

Los tutores tienen las siguientes funcionalidades:

- **Acceso inicial**:
  - Los tutores deben ingresar por primera vez en la web para cambiar su contraseña y completar sus datos personales.
  
- **Cambiar datos personales**:
  - Los tutores pueden modificar sus datos personales en cualquier momento.

- **Dar de alta a nuevos alumnos**:
  - Los tutores pueden dar de alta a alumnos mediante la introducción de su email.
  - La contraseña inicial será **123**.
  - El ciclo asignado al alumno será el mismo que el del tutor.
  - Se detecta mediante AJAX si el email ya está registrado.

- **Eliminar alumnos**:
  - Los tutores pueden eliminar a los alumnos y todos sus datos asociados.

- **Gestionar notas de los alumnos**:
  - Los tutores pueden introducir o modificar las notas de sus alumnos, enviándolas por AJAX para su actualización.

- **Listar los alumnos existentes**:
  - Los tutores pueden ver un listado de los alumnos bajo su tutela.
  - El listado incluye la nota media y la media ponderada de los alumnos, ordenada de mayor a menor por la media ponderada.

### Alumnos

Los alumnos tienen acceso a las siguientes funcionalidades:

- **Acceso inicial**:
  - Los alumnos deben acceder por primera vez a la web para cambiar su contraseña e introducir sus datos personales.

- **Cambiar datos personales**:
  - Los alumnos pueden modificar sus datos en cualquier momento.

- **Ver sus notas**:
  - Los alumnos pueden consultar sus calificaciones actuales.

- **Ver los módulos que cursan**:
  - Los alumnos pueden visualizar los módulos que están cursando, especificando el tutor asignado, el nombre de la familia, el curso y el nombre del módulo.

## Requisitos del Sistema

### Backend

- **Java 11**
- **Java EE 7**
- **Hibernate** para la gestión de la persistencia
- **MySQL 8** como base de datos

### Frontend

- **JSP (Java Server Pages)** para las vistas
- **Bootstrap 5** para el diseño responsivo
- **JavaScript (AJAX)** para la funcionalidad interactiva y la validación de datos en tiempo real

## Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/zkj0n/RuizHJFinalHib
   cd proyecto
   ```

2. **Configurar la base de datos**:
   - Asegúrate de tener **MySQL 8** instalado y configurado.
   - Crea una base de datos para el proyecto.
   - Ejecuta los scripts de base de datos necesarios para crear las tablas y relaciones correspondientes.

3. **Configurar Hibernate**:
   - Configura Hibernate en el archivo `hibernate.cfg.xml` para conectarse a tu base de datos MySQL.

4. **Configuración del servidor**:
   - Asegúrate de tener un servidor compatible con **Java EE 7** (por ejemplo, Apache Tomcat o GlassFish).
   - Configura el servidor para que apunte a los archivos del proyecto.

5. **Acceso inicial**:
   - Inicia sesión como administrador con el email **final@gmail.com** y la contraseña **123**.
   - Modifica tu contraseña y configura los datos del sistema.

## Contribución

1. Haz un fork del repositorio.
2. Crea una rama con el nombre de la funcionalidad o el bug que estás solucionando.
3. Realiza los cambios y haz commit de los mismos.
4. Crea un pull request con una descripción clara de tus cambios.

## Licencia

Este proyecto está licenciado bajo la **MIT License**. Consulta el archivo `LICENSE` para más detalles.
