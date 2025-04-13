# Gestor de Gastos Personales

Aplicación web para gestionar ingresos y gastos personales, desarrollada con **Java**, **Spring Boot** y **PostgreSQL**.

## Tabla de Contenidos
- [Descripción](#descripción)
- [Características](#características)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Requisitos Previos](#requisitos-previos)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Descripción
El **Gestor de Gastos Personales** es una aplicación que permite a los usuarios registrar, consultar y analizar sus ingresos y gastos. Proporciona un resumen financiero por fechas y categorías, ayudando a los usuarios a gestionar mejor sus finanzas personales.

## Características
- Registro y autenticación de usuarios.
- Añadir ingresos y gastos con categorías personalizadas.
- Consultar una lista detallada de movimientos.
- Resumen financiero por fechas y categorías.
- Interfaz amigable y responsiva.

## Tecnologías Utilizadas
- **Lenguaje**: Java 21
- **Framework Backend**: Spring Boot
- **Base de Datos**: PostgreSQL
- **Frontend**: HTML, CSS, JavaScript
- **Gestión de dependencias**: Maven

## Requisitos Previos
Antes de comenzar, asegúrate de tener instalado lo siguiente:
- **Java 21** o superior
- **Maven** (para gestionar dependencias)
- **PostgreSQL** (configurado y en ejecución)
- **Git** (opcional, para clonar el repositorio)

## Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/gestor-gastos.git
   cd gestor-gastos

   2. Configura la base de datos PostgreSQL:
      - Crea una base de datos llamada `gestor_gastos`.
      - Configura el archivo `application.properties` con tus credenciales de PostgreSQL.
      ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/gestor_gastos
        spring.datasource.username=tu_usuario
        spring.datasource.password=tu_contraseña
        spring.jpa.hibernate.ddl-auto=update

## Uso
Regístrate como usuario.
Inicia sesión para acceder al panel principal.
Añade ingresos y gastos con sus respectivas categorías.
Consulta el resumen financiero y analiza tus movimientos.
## Estructura del Proyecto
```plaintext
src/main/java: Código fuente del backend.
src/main/resources: Archivos de configuración y plantillas.
src/main/resources/static: Archivos estáticos (CSS, JS, imágenes).
src/main/resources/templates: Plantillas HTML.
pom.xml: Archivo de configuración de Maven
README.md: Documentación del proyecto.
```
## Contribuciones
¡Las contribuciones son bienvenidas! Si deseas colaborar:

Haz un fork del repositorio.

Crea una rama para tu funcionalidad o corrección:

*git checkout -b feature/nueva-funcionalidad*

Realiza tus cambios y haz un commit:

*git commit -m "Añadida nueva funcionalidad"*

Envía un pull request.

## Licencia
Este proyecto está licenciado bajo la MIT License.
