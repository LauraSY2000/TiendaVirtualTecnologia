SELECT * FROM imagenes;
SHOW CREATE TABLE producto;
SHOW tables;
CREATE TABLE imagenes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    producto_id BIGINT,
    direccion VARCHAR(255),
    alt_text VARCHAR(255),
    orden INT, 
    FOREIGN KEY (producto_id) REFERENCES producto(id)
);
