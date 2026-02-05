
DELETE FROM usuarios_roles;
DELETE FROM usuarios;

-- Reiniciar los IDs
ALTER TABLE usuarios ALTER COLUMN id RESTART WITH 1;

MERGE INTO roles (nombre) KEY(nombre) VALUES('ADMIN');
MERGE INTO roles (nombre) KEY(nombre) VALUES('CLIENTE');
MERGE INTO roles (nombre) KEY(nombre) VALUES('PROVEEDOR');

