CREATE TABLE IF  NOT EXISTS artistas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    generos VARCHAR(255),
    pais_origen VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE,
    fecha_fallecimineto DATE,
    instrumentos TEXT,
    bibliografia VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS discos(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_lanzamiento DATE,
    generos TEXT,
    artista_id BIGINT,
    FOREIGN KEY (artista_id) REFERENCES artistas(id)
);

CREATE TABLE IF NOT EXISTS canciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    letra VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL,
    disco_id BIGINT,
    FOREIGN KEY (disco_id) REFERENCES discos(id)
);


-- Insertar datos en la tabla canciones
INSERT INTO canciones (nombre, letra, genero) VALUES
('Canción 1', 'Letra de la canción 1', 'ROCK'),
('Canción 2', 'Letra de la canción 2', 'JAZZ'),
('Canción 3', 'Letra de la canción 3', 'JAZZ'),
('Canción 4', 'Letra de la canción 4', 'ROCK'),
('Canción 5', 'Letra de la canción 5', 'ROCK');


