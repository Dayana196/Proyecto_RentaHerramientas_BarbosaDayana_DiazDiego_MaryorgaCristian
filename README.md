# TOOLSX

Plataforma de Renta de Herramientas y Equipos de Construccion (Backend).

## Tecnologias
- Java 17
- Spring Boot (version del proyecto)
- Spring Security + JWT
- Spring Data JPA
- MySQL

## Configuracion
Variables de entorno (opcionales):
- `DB_URL` (default: `jdbc:mysql://localhost:3306/toolsx_container?serverTimezone=UTC`)
- `DB_USER` (default: `root`)
- `DB_PASSWORD` (default: vacio)
- `JWT_SECRET` (default: `toolsx_super_secret_key_2026_seguridad_jwt`)
- `JWT_EXPIRATION_MS` (default: `86400000`)
- `SERVER_PORT` (default: `8080`)

Perfiles:
- `dev` usa `toolsx_container_dev`
- `prod` usa `toolsx_container_prod`

## Ejecutar
```bash
mvn spring-boot:run
```

## Endpoints principales
- `POST /auth/login`
- `POST /auth/register`
- `GET /api/herramientas`
- `GET /api/herramientas/disponibles`
- `CRUD /api/proveedores`
- `CRUD /api/clientes`
- `CRUD /api/categorias`
- `CRUD /api/reservas`
- `CRUD /api/pagos`
