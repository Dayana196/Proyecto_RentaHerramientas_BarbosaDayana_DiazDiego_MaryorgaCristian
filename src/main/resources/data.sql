-- Elimina el usuario si existe
DROP USER IF EXISTS 'toolsx_user'@'localhost';

-- Crea el usuario de nuevo
CREATE USER 'toolsx_user'@'localhost'
IDENTIFIED BY 'Kaneki#G1317';

-- Dale permisos TOTALES sobre la base
GRANT ALL PRIVILEGES ON toolsx_container_prod.* 
TO 'toolsx_user'@'localhost';

-- Aplica cambios
FLUSH PRIVILEGES;

MERGE INTO roles (nombre) KEY(nombre) VALUES('ADMIN');
MERGE INTO roles (nombre) KEY(nombre) VALUES('CLIENTE');
MERGE INTO roles (nombre) KEY(nombre) VALUES('PROVEEDOR');

