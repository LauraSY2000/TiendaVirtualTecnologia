# TechStore – Tienda Online

TechStore es una aplicación web de comercio electrónico desarrollada con arquitectura en capas, que permite la gestión y visualización de productos tecnológicos.  
Incluye un sistema básico de autenticación para la administración y soporte para carga masiva de imágenes desde archivo CSV.  

## Características Principales
- Catálogo de productos con nombre, precio, categoría e imagen asociada.
- Backend desarrollado en **Spring Boot** con API REST.
- Base de datos **MySQL** con relaciones entre productos, categorías, imágenes y usuarios.
- Carga masiva de imágenes desde CSV usando **OpenCSV**.
- Frontend responsive con **HTML5**, **JavaScript** y **TailwindCSS**.
- Sistema de login básico para administración.

---

## Objetivos

### Objetivo General
Desarrollar una plataforma web que permita la gestión, almacenamiento y visualización de productos, integrando funcionalidades de autenticación y carga de imágenes.

### Objetivos Específicos
- Implementar un backend con API REST para la gestión de datos.
- Diseñar un frontend responsive e interactivo.
- Integrar una base de datos MySQL con relaciones entre entidades.
- Implementar un módulo de carga masiva de imágenes mediante CSV.
- Configurar un sistema de login para control de acceso.

---

## Arquitectura del Sistema

La aplicación está basada en una **arquitectura en tres capas**:

1. **Frontend (Presentación)**
   - Interfaz de usuario desarrollada con HTML5, JavaScript y TailwindCSS.
   - Peticiones HTTP mediante `fetch()` al backend.
   
2. **Backend (Lógica de Negocio)**
   - Desarrollado en **Spring Boot**.
   - Capas organizadas en controladores, servicios y repositorios.
   
3. **Base de Datos (Persistencia)**
   - **MySQL** con tablas para productos, categorías, imágenes y usuarios.
   - Relaciones 1:N entre categorías-productos y productos-imágenes.
---

## Tecnologías Utilizadas

| Tecnología | Uso |
|------------|-----|
| Java 17 | Lenguaje principal del backend |
| Spring Boot | Framework para el backend REST |
| Spring Data JPA | Acceso a datos con repositorios |
| MySQL | Base de datos relacional |
| Maven | Gestión de dependencias |
| HTML5 | Estructura de la interfaz |
| JavaScript (ES6) | Interactividad en el frontend |
| TailwindCSS | Diseño y estilos responsive |
| OpenCSV | Lectura de CSV para carga de imágenes |
| Postman | Pruebas de API |
| Git/GitHub | Control de versiones |

---

## Estructura del Proyecto
src/main/java/com/tienda
│── controller/ → Controladores REST
│── model/ → Entidades JPA
│── repository/ → Repositorios de datos
│── services/ → Lógica de negocio
│── config/ → Configuración del proyecto
src/main/resources
│── application.properties → Configuración de conexión
│── imagenes.csv → Archivo CSV para imágenes
frontend/
│── HTML, CSS y JS de la interfaz

## Flujo de Datos

1. El usuario accede al **frontend** desde el navegador.
2. El frontend realiza una petición `fetch()` al backend.
3. El backend recibe la solicitud en un **controlador**.
4. El controlador llama a un **servicio** que contiene la lógica.
5. El servicio usa un **repositorio JPA** para acceder a la base de datos.
6. La base de datos devuelve la información solicitada.
7. El backend responde en **JSON**.
8. El frontend procesa y muestra los datos.
## Endpoints de la API

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/api/productos` | Listar todos los productos |
| POST | `/api/productos` | Crear un nuevo producto |
| PUT | `/api/productos/{id}` | Actualizar un producto |
| DELETE | `/api/productos/{id}` | Eliminar un producto |
| POST | `/login` | Login de usuario |
| POST | `/api/imagenes/cargar` | Cargar imágenes desde CSV |

---

## 🗄 Modelo de Base de Datos

**Relaciones:**
- Una **categoría** tiene muchos **productos**.
- Un **producto** puede tener muchas **imágenes**.
- Los **usuarios** gestionan el sistema.

**Diagrama ER:**
![Diagrama ER](er_diagrama.png)

---

## Diccionario de Datos

**Tabla: productos**
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | BIGINT | ID único |
| nombre | VARCHAR | Nombre del producto |
| precio | DECIMAL | Precio en COP |
| categoria_id | BIGINT | FK a categorías |

**Tabla: imagenes**
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | BIGINT | ID único |
| producto_id | BIGINT | FK a productos |
| direccion | VARCHAR | URL o ruta de imagen |
| alt_text | VARCHAR | Texto alternativo |
| orden | INT | Orden de visualización |

**Tabla: categorias**
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | BIGINT | ID único |
| nombre | VARCHAR | Nombre de categoría |

**Tabla: usuarios**
| Campo | Tipo | Descripción |
|-------|------|-------------|
| id | BIGINT | ID único |
| username | VARCHAR | Nombre de usuario |
| password | VARCHAR | Contraseña sin cifrar |

---

## 🖥 Manual de Usuario

### Iniciar Sesión
1. Acceder a la página de login.
2. Ingresar usuario y contraseña.
3. Si las credenciales son correctas, se concede acceso a funciones administrativas.

### Visualizar Productos
1. Entrar a la sección "Productos".
2. Los datos se cargan automáticamente desde la API.
3. Se muestran nombre, precio, categoría e imagen.


000C:\Users\USER\OneDrive - Universidad de los andes\Escritorio\SENA\Formación lectiva\Etapa 5\Proyecto_tienda
