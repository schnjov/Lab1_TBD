CREATE TABLE habilidad (
    id_habilidad SERIAL PRIMARY KEY,
    habilidad VARCHAR(255)
);

CREATE TABLE institucion (
    id_institucion SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    fecha DATE,
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

CREATE TABLE voluntario (
    id_voluntario SERIAL PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(20),
    direccion VARCHAR(255)
);

CREATE TABLE emergencia (
    id_emergencia SERIAL PRIMARY KEY,
    asunto VARCHAR(255),
    descripcion TEXT,
    direccion VARCHAR(255),
    fecha DATE,
    activa BOOLEAN,
    id_institucion BIGINT NOT NULL,
    FOREIGN KEY (id_institucion) REFERENCES institucion (id_institucion)
);

CREATE TABLE tarea (
    id_tarea SERIAL PRIMARY KEY,
    asunto_tarea VARCHAR(255),
    id_emergencia BIGINT NOT NULL,
    estado_tarea BOOLEAN,
    FOREIGN KEY (id_emergencia) REFERENCES emergencia (id_emergencia)
);

CREATE TABLE eme_habilidad (
    id_eme_habilidad SERIAL PRIMARY KEY,
    id_emergencia BIGINT NOT NULL,
    id_habilidad BIGINT NOT NULL,
    FOREIGN KEY (id_emergencia) REFERENCES emergencia (id_emergencia),
    FOREIGN KEY (id_habilidad) REFERENCES habilidad (id_habilidad)
);

CREATE TABLE ranking (
    id_ranking SERIAL PRIMARY KEY,
    id_tarea BIGINT NOT NULL,
    id_voluntario BIGINT NOT NULL,
    puntaje BIGINT NOT NULL,
    FOREIGN KEY (id_tarea) REFERENCES tarea (id_tarea),
    FOREIGN KEY (id_voluntario) REFERENCES voluntario (id_voluntario)
);

CREATE TABLE tarea_habilidad (
    id_tarea_habilidad SERIAL PRIMARY KEY,
    id_tarea BIGINT NOT NULL,
    id_habilidad BIGINT NOT NULL,
    FOREIGN KEY (id_tarea) REFERENCES tarea (id_tarea),
    FOREIGN KEY (id_habilidad) REFERENCES habilidad (id_habilidad)
);

CREATE TABLE vol_habilidad (
    id_vol_habilidad SERIAL PRIMARY KEY,
    id_voluntario BIGINT NOT NULL,
    id_habilidad BIGINT NOT NULL,
    FOREIGN KEY (id_voluntario) REFERENCES voluntario (id_voluntario),
    FOREIGN KEY (id_habilidad) REFERENCES habilidad (id_habilidad)
);