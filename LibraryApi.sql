
-- Tabla de autores
CREATE TABLE autor
(
    id               BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre           VARCHAR(50) NOT NULL,
    apellido         VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE,
    nacionalidad     VARCHAR(30)
);

-- Tabla de categorías / géneros
CREATE TABLE genero
(
    id     BIGINT      NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Tabla de editoriales
CREATE TABLE editorial
(
    id        BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre    VARCHAR(100) NOT NULL,
    direccion VARCHAR(250),
    telefono  VARCHAR(20),
    pais      VARCHAR(30)
);

-- Tabla de libros
CREATE TABLE libro
(
    id               BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo           VARCHAR(150) NOT NULL,
    anio_publicacion INT,
    disponible       BOOLEAN,
    autor_id         BIGINT       NOT NULL,
    genero_id        BIGINT       NOT NULL,
    editorial_id     BIGINT       NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autor (id),
    FOREIGN KEY (genero_id) REFERENCES genero (id),
    FOREIGN KEY (editorial_id) REFERENCES editorial (id)
);

-- ======================
-- INSERTAR DATOS DE PRUEBA
-- ======================

-- Autores
INSERT INTO autor (nombre, apellido, fecha_nacimiento, nacionalidad)
VALUES ('Gabriel', 'García Márquez', '1927-03-06', 'Colombiana'),
       ('John Ronald Reuel', 'Tolkien', '1892-01-03', 'Británica'),
       ('George', 'Orwell', '1903-06-25', 'Británica'),
       ('Isaac', 'Asimov', '1920-01-02', 'Estadounidense');

-- Géneros
INSERT INTO genero (nombre)
VALUES ('Realismo Mágico'),
       ('Fantasía'),
       ('Distopía'),
       ('Fábula Política'),
       ('Ciencia Ficción');

-- Editoriales
INSERT INTO editorial (nombre, direccion, telefono, pais)
VALUES ('Editorial Sudamericana', 'Buenos Aires, Argentina', '+54 11 4567 8901',
        'Argentina'),
       ('Allen & Unwin', 'London, UK', '+44 20 1234 5678', 'Reino Unido'),
       ('Secker & Warburg', 'London, UK', '+44 20 8765 4321', 'Reino Unido'),
       ('Gnome Press', 'New York, USA', '+1 212 555 7890', 'Estados Unidos');

-- Libros
INSERT INTO libro (titulo, anio_publicacion, disponible, autor_id, genero_id, editorial_id)
VALUES ('Cien años de soledad', 1967, TRUE, 1, 1, 1),
       ('El Señor de los Anillos', 1954, TRUE, 2, 2, 2),
       ('1984', 1949, TRUE, 3, 3, 3),
       ('Rebelión en la Granja', 1945, FALSE, 3, 4, 3),
       ('Fundación', 1951, TRUE, 4, 5, 4),
       ('Yo, Robot', 1950, FALSE, 4, 5, 4);