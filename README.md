# 🛠️ ToolsX - Plataforma de Renta de Herramientas y Equipos de Construcción

**ToolsX** es una solución integral desarrollada con **Spring Boot** para digitalizar el proceso de alquiler de maquinaria y herramientas. La plataforma permite a los proveedores gestionar su inventario y a los clientes realizar reservas seguras con confirmación de pago y facturación automática.

---

## 👥 Equipo 
* **Dayana Barbosa**
* **Diego Diaz**
* **Cristian Mayorga**

---

## 🚀 Tecnologías Implementadas

### **Backend**
* **Lenguaje:** Java 21
* **Framework:** Spring Boot
* **Seguridad:** Spring Security con autenticación basada en **JWT (JSON Web Tokens)**
* **Persistencia:** Spring Data JPA
* **Base de Datos:** MySQL
* **Documentación:** Swagger / OpenAPI

### **Frontend**
* **Lenguaje:** HTML5, CSS3, JavaScript (Vanilla)

---

## Perfiles de Usuario y Funcionalidades

### 1️⃣ Administrador (Rol: Admin)
* **Gestión de Usuarios:** Registro y administración de proveedores y clientes.
* **Supervisión de Equipos:** Verificación del estado físico de las herramientas.
* **Control de Alquileres:** Acceso al historial global y reportes de daños.
* **Métricas:** Estadísticas de ingresos y equipos con mayor rentabilidad.

### 2️⃣ Proveedor de Equipos (Rol: Proveedor)
* **Gestión de Inventario:** CRUD completo de herramientas (precios, descripción).
* **Gestión de Reservas:** Aceptar/Rechazar solicitudes y confirmar devoluciones.
* **Facturación:** Generación automática de facturas por servicios prestados.

### 3️⃣ Cliente (Rol: Cliente)
* **Exploración:** Catálogo con búsqueda por categoría y disponibilidad.
* **Reservas:** Selección de fechas y confirmación de alquiler.
* **Pagos:** Registro de pagos en línea y descarga de comprobantes.
* **Historial:** Seguimiento de herramientas rentadas anteriormente.

---

## 🗃️ Modelo de Datos

La base de datos está normalizada y diseñada para garantizar la trazabilidad de cada herramienta. Incluye módulos de seguridad, inventario, transacciones financieras y control de daños.

---

## ⚙️ Configuración e Instalación

### **Requisitos**
* JDK 21 o superior.
* MySQL Server.
* Maven instalado.

### **Pasos para ejecución**

1. **Clonar el repositorio:**
   ```bash
   git clone [https://github.com/tu-usuario/Proyecto_RentaHerramientas_ToolsX.git](https://github.com/tu-usuario/Proyecto_RentaHerramientas_ToolsX.git)