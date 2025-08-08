-- Eliminar base de datos si existe
DROP DATABASE IF EXISTS tienda;

-- Crear base de datos
CREATE DATABASE tienda CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- Usar base de datos
USE tienda;

-- Tabla: categoria
CREATE TABLE categoria (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Tabla: producto
CREATE TABLE producto (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DOUBLE NOT NULL,
    categoria_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_producto_categoria FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- Tabla: usuario
CREATE TABLE usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

-- Insertar categorías de ejemplo
INSERT INTO categoria (nombre) VALUES ('Tecnologia'), ('Ropa');

-- Insertar producto de ejemplo
INSERT INTO producto (nombre, precio, categoria_id) VALUES ('Laptop HP', 2800000, 1);

-- Insertar usuario de ejemplo
INSERT INTO usuario (username, password) VALUES ('admin', 'admin');