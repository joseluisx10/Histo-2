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




