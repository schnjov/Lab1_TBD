-- Limpieza
TRUNCATE TABLE eme_habilidad CASCADE;
TRUNCATE TABLE emergencia CASCADE;
TRUNCATE TABLE habilidad CASCADE;
TRUNCATE TABLE institucion CASCADE;
TRUNCATE TABLE logs CASCADE;
TRUNCATE TABLE ranking CASCADE;
TRUNCATE TABLE tarea CASCADE;
TRUNCATE TABLE tarea_habilidad CASCADE;
TRUNCATE TABLE usuario CASCADE;
TRUNCATE TABLE vol_habilidad CASCADE;
TRUNCATE TABLE voluntario CASCADE;
ALTER SEQUENCE eme_habilidad_id_seq RESTART WITH 1;
ALTER SEQUENCE emergencia_id_seq RESTART WITH 1;
ALTER SEQUENCE habilidad_id_seq RESTART WITH 1;
ALTER SEQUENCE institucion_id_seq RESTART WITH 1;
ALTER SEQUENCE logs_id_seq RESTART WITH 1;
ALTER SEQUENCE ranking_id_seq RESTART WITH 1;
ALTER SEQUENCE tarea_id_seq RESTART WITH 1;
ALTER SEQUENCE tarea_habilidad_id_seq RESTART WITH 1;
ALTER SEQUENCE usuario_id_seq RESTART WITH 1;
ALTER SEQUENCE vol_habilidad_id_seq RESTART WITH 1;
ALTER SEQUENCE voluntario_id_seq RESTART WITH 1;


-- INSERT DATA INTO usuario
INSERT INTO usuario(id, email, password, rol) VALUES
(1, 'usuario1@example.com', 'password1', 'VOLUNTARIO'),
(2, 'usuario2@example.com', 'password2', 'INSTITUCION'),
(3, 'usuario3@example.com', 'password3', 'VOLUNTARIO'),
(4, 'usuario4@example.com', 'password4', 'INSTITUCION'),
(5, 'usuario5@example.com', 'password5', 'VOLUNTARIO'),
(6, 'usuario6@example.com', 'password6', 'INSTITUCION'),
(7, 'usuario7@example.com', 'password7', 'VOLUNTARIO'),
(8, 'usuario8@example.com', 'password8', 'INSTITUCION'),
(9, 'usuario9@example.com', 'password9', 'VOLUNTARIO'),
(10, 'usuario10@example.com', 'password10', 'INSTITUCION'),
(11, 'usuario11@example.com', 'password11', 'VOLUNTARIO'),
(12, 'usuario12@example.com', 'password12', 'INSTITUCION'),
(13, 'usuario13@example.com', 'password13', 'VOLUNTARIO'),
(14, 'usuario14@example.com', 'password14', 'INSTITUCION'),
(15, 'usuario15@example.com', 'password15', 'VOLUNTARIO'),
(16, 'usuario16@example.com', 'password16', 'INSTITUCION'),
(17, 'usuario17@example.com', 'password17', 'VOLUNTARIO'),
(18, 'usuario18@example.com', 'password18', 'INSTITUCION'),
(19, 'usuario19@example.com', 'password19', 'VOLUNTARIO'),
(20, 'usuario20@example.com', 'password20', 'INSTITUCION');

-- INSERT DATA INTO habilidad
INSERT INTO habilidad(habilidad) VALUES
('Habilidad 1'), ('Habilidad 2'), ('Habilidad 3'), ('Habilidad 4'), ('Habilidad 5'),
('Habilidad 6'), ('Habilidad 7'), ('Habilidad 8'), ('Habilidad 9'), ('Habilidad 10'),
('Habilidad 11'), ('Habilidad 12'), ('Habilidad 13'), ('Habilidad 14'), ('Habilidad 15'),
('Habilidad 16'), ('Habilidad 17'), ('Habilidad 18'), ('Habilidad 19'), ('Habilidad 20');

-- INSERT DATA INTO institucion
INSERT INTO institucion(nombre, fecha, direccion, telefono, id_usuario) VALUES
('Institución 1', '2023-01-01', 'Dirección 1', '1234567890', 1),
('Institución 2', '2023-01-01', 'Dirección 2', '1234567891', 2),
('Institución 3', '2023-01-01', 'Dirección 3', '1234567892', 3),
('Institución 4', '2023-01-01', 'Dirección 4', '1234567893', 4),
('Institución 5', '2023-01-01', 'Dirección 5', '1234567894', 5),
('Institución 6', '2023-01-01', 'Dirección 6', '1234567895', 6),
('Institución 7', '2023-01-01', 'Dirección 7', '1234567896', 7),
('Institución 8', '2023-01-01', 'Dirección 8', '1234567897', 8),
('Institución 9', '2023-01-01', 'Dirección 9', '1234567898', 9),
('Institución 10', '2023-01-01', 'Dirección 10', '1234567899', 10),
('Institución 11', '2023-01-01', 'Dirección 11', '1234567800', 11),
('Institución 12', '2023-01-01', 'Dirección 12', '1234567801', 12),
('Institución 13', '2023-01-01', 'Dirección 13', '1234567802', 13),
('Institución 14', '2023-01-01', 'Dirección 14', '1234567803', 14),
('Institución 15', '2023-01-01', 'Dirección 15', '1234567804', 15),
('Institución 16', '2023-01-01', 'Dirección 16', '1234567805', 16),
('Institución 17', '2023-01-01', 'Dirección 17', '1234567806', 17),
('Institución 18', '2023-01-01', 'Dirección 18', '1234567807', 18),
('Institución 19', '2023-01-01', 'Dirección 19', '1234567808', 19),
('Institución 20', '2023-01-01', 'Dirección 20', '1234567809', 20);

-- INSERT DATA INTO voluntario
INSERT INTO voluntario(nombre, apellido, telefono, direccion, id_usuario, ubicacion) VALUES
('Nombre1', 'Apellido1', '1234567810', 'Dirección 21', 1, ST_SetSRID(ST_MakePoint(-70.64827, -33.45923), 4326)),
('Nombre2', 'Apellido2', '1234567811', 'Dirección 22', 2, ST_SetSRID(ST_MakePoint(-70.65056, -33.43722), 4326)),
('Nombre3', 'Apellido3', '1234567812', 'Dirección 23', 3, ST_SetSRID(ST_MakePoint(-70.65256, -33.43832), 4326)),
('Nombre4', 'Apellido4', '1234567813', 'Dirección 24', 4, ST_SetSRID(ST_MakePoint(-70.65326, -33.43942), 4326)),
('Nombre5', 'Apellido5', '1234567814', 'Dirección 25', 5, ST_SetSRID(ST_MakePoint(-70.65436, -33.44012), 4326)),
('Nombre6', 'Apellido6', '1234567815', 'Dirección 26', 6, ST_SetSRID(ST_MakePoint(-70.65546, -33.44192), 4326)),
('Nombre7', 'Apellido7', '1234567816', 'Dirección 27', 7, ST_SetSRID(ST_MakePoint(-70.65646, -33.44282), 4326)),
('Nombre8', 'Apellido8', '1234567817', 'Dirección 28', 8, ST_SetSRID(ST_MakePoint(-70.65756, -33.44372), 4326)),
('Nombre9', 'Apellido9', '1234567818', 'Dirección 29', 9, ST_SetSRID(ST_MakePoint(-70.65856, -33.44462), 4326)),
('Nombre10', 'Apellido10', '1234567819', 'Dirección 30', 10, ST_SetSRID(ST_MakePoint(-70.65966, -33.44552), 4326)),
('Nombre11', 'Apellido11', '1234567820', 'Dirección 31', 11, ST_SetSRID(ST_MakePoint(-70.66066, -33.44662), 4326)),
('Nombre12', 'Apellido12', '1234567821', 'Dirección 32', 12, ST_SetSRID(ST_MakePoint(-70.66176, -33.44772), 4326)),
('Nombre13', 'Apellido13', '1234567822', 'Dirección 33', 13, ST_SetSRID(ST_MakePoint(-70.66276, -33.44872), 4326)),
('Nombre14', 'Apellido14', '1234567823', 'Dirección 34', 14, ST_SetSRID(ST_MakePoint(-70.66376, -33.44982), 4326)),
('Nombre15', 'Apellido15', '1234567824', 'Dirección 35', 15, ST_SetSRID(ST_MakePoint(-70.66486, -33.45092), 4326)),
('Nombre16', 'Apellido16', '1234567825', 'Dirección 36', 16, ST_SetSRID(ST_MakePoint(-70.66586, -33.45202), 4326)),
('Nombre17', 'Apellido17', '1234567826', 'Dirección 37', 17, ST_SetSRID(ST_MakePoint(-70.66686, -33.45302), 4326)),
('Nombre18', 'Apellido18', '1234567827', 'Dirección 38', 18, ST_SetSRID(ST_MakePoint(-70.66786, -33.45412), 4326)),
('Nombre19', 'Apellido19', '1234567828', 'Dirección 39', 19, ST_SetSRID(ST_MakePoint(-70.66896, -33.45522), 4326)),
('Nombre20', 'Apellido20', '1234567829', 'Dirección 40', 20, ST_SetSRID(ST_MakePoint(-70.66996, -33.45632), 4326));

-- INSERT DATA INTO emergencia
INSERT INTO emergencia(asunto, descripcion, direccion, fecha, activa, id_institucion, region, ubicacion) VALUES
('Asunto 1', 'Descripción 1', 'Dirección 41', '2023-01-02', TRUE, 1, 1, ST_SetSRID(ST_MakePoint(-33.04580, -71.62725), 4326)),
('Asunto 2', 'Descripción 2', 'Dirección 42', '2023-01-03', FALSE, 2, 2, ST_SetSRID(ST_MakePoint(-33.45694, -70.64827), 4326)),
('Asunto 3', 'Descripción 3', 'Dirección 43', '2023-01-04', TRUE, 3, 3, ST_SetSRID(ST_MakePoint(-23.65093, -70.39148), 4326)),
('Asunto 4', 'Descripción 4', 'Dirección 44', '2023-01-05', FALSE, 4, 4, ST_SetSRID(ST_MakePoint(-33.03932, -71.61368), 4326)),
('Asunto 5', 'Descripción 5', 'Dirección 45', '2023-01-06', TRUE, 5, 5, ST_SetSRID(ST_MakePoint(-33.48583, -70.65614), 4326)),
('Asunto 6', 'Descripción 6', 'Dirección 46', '2023-01-07', FALSE, 6, 6, ST_SetSRID(ST_MakePoint(-23.64489, -70.40942), 4326)),
('Asunto 7', 'Descripción 7', 'Dirección 47', '2023-01-08', TRUE, 7, 7, ST_SetSRID(ST_MakePoint(-33.04738, -71.60751), 4326)),
('Asunto 8', 'Descripción 8', 'Dirección 48', '2023-01-09', FALSE, 8, 8, ST_SetSRID(ST_MakePoint(-33.42202, -70.57730), 4326)),
('Asunto 9', 'Descripción 9', 'Dirección 49', '2023-01-10', TRUE, 9, 9, ST_SetSRID(ST_MakePoint(-23.65836, -70.36774), 4326)),
('Asunto 10', 'Descripción 10', 'Dirección 50', '2023-01-11', FALSE, 10, 10, ST_SetSRID(ST_MakePoint(-33.03659, -71.61669), 4326)),
('Asunto 11', 'Descripción 11', 'Dirección 51', '2023-01-12', TRUE, 11, 11, ST_SetSRID(ST_MakePoint(-33.43722, -70.65056), 4326)),
('Asunto 12', 'Descripción 12', 'Dirección 52', '2023-01-13', FALSE, 12, 12, ST_SetSRID(ST_MakePoint(-33.39289, -70.78578), 4326)),
('Asunto 13', 'Descripción 13', 'Dirección 53', '2023-01-14', TRUE, 13, 13, ST_SetSRID(ST_MakePoint(-33.52028, -70.66667), 4326)),
('Asunto 14', 'Descripción 14', 'Dirección 54', '2023-01-15', FALSE, 14, 14, ST_SetSRID(ST_MakePoint(-33.45598, -70.59552), 4326)),
('Asunto 15', 'Descripción 15', 'Dirección 55', '2023-01-16', TRUE, 15, 15, ST_SetSRID(ST_MakePoint(-33.60000, -70.71667), 4326)),
('Asunto 16', 'Descripción 16', 'Dirección 56', '2023-01-17', FALSE, 16, 16, ST_SetSRID(ST_MakePoint(-33.41667, -70.53333), 4326)),
('Asunto 17', 'Descripción 17', 'Dirección 57', '2023-01-18', TRUE, 17, 17, ST_SetSRID(ST_MakePoint(-33.59229, -70.69960), 4326)), 
('Asunto 18', 'Descripción 18', 'Dirección 58', '2023-01-19', FALSE, 18, 18, ST_SetSRID(ST_MakePoint(-33.39842, -70.60358), 4326)), 
('Asunto 19', 'Descripción 19', 'Dirección 59', '2023-01-20', TRUE, 19, 19, ST_SetSRID(ST_MakePoint(-33.38796, -70.51283), 4326)),
('Asunto 20', 'Descripción 20', 'Dirección 60', '2023-01-21', FALSE, 20, 20, ST_SetSRID(ST_MakePoint(-33.45694, -70.64827), 4326));

-- INSERT DATA INTO vol_habilidad
INSERT INTO vol_habilidad(id_voluntario, id_habilidad) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 6), (7, 7), (8, 8), (9, 9), (10, 10),
(11, 11), (12, 12), (13, 13), (14, 14), (15, 15),
(16, 16), (17, 17), (18, 18), (19, 19), (20, 20);

-- INSERT DATA INTO tarea
INSERT INTO tarea(asunto_tarea, id_emergencia, estado_tarea) VALUES
('Incendio 1', 1, TRUE),
('Limpieza 1', 2, FALSE),
('Rescate 1', 3, TRUE),
('Incendio 2', 4, FALSE),
('Limpieza 2', 5, TRUE),
('Rescate 2', 6, FALSE),
('Incendio 3', 7, TRUE),
('Limpieza 3', 8, FALSE),
('Rescate 3', 9, TRUE),
('Incendio 4', 10, FALSE),
('Limpieza 4', 11, TRUE),
('Rescate 4', 12, FALSE),
('Incendio 5', 13, TRUE),
('Limpieza 5', 14, FALSE),
('Rescate 5', 15, TRUE),
('Incendio 6', 16, FALSE),
('Limpieza 6', 17, TRUE),
('Rescate 6', 18, FALSE),
('Incendio 7', 19, TRUE),
('Limpieza 7', 20, FALSE),
('Rescate 7', 1, TRUE),
('Incendio 8', 2, FALSE),
('Limpieza 8', 3, TRUE),
('Rescate 8', 4, FALSE),
('Incendio 9', 5, TRUE),
('Limpieza 9', 6, FALSE),
('Rescate 9', 7, TRUE),
('Incendio 10', 8, FALSE),
('Limpieza 10', 9, TRUE),
('Rescate 10', 10, FALSE),
('Incendio 11', 11, TRUE),
('Limpieza 11', 12, FALSE),
('Rescate 11', 13, TRUE),
('Incendio 12', 14, FALSE),
('Limpieza 12', 15, TRUE),
('Rescate 12', 16, FALSE),
('Incendio 13', 17, TRUE),
('Limpieza 13', 18, FALSE),
('Rescate 13', 19, TRUE),
('Incendio 14', 20, FALSE),
('Limpieza 14', 1, TRUE),
('Rescate 14', 2, FALSE),
('Incendio 15', 3, TRUE),
('Limpieza 15', 4, FALSE),
('Rescate 15', 5, TRUE),
('Incendio 16', 6, FALSE),
('Limpieza 16', 7, TRUE),
('Rescate 16', 8, FALSE),
('Incendio 17', 9, TRUE),
('Limpieza 17', 10, FALSE),
('Rescate 17', 11, TRUE),
('Incendio 18', 12, FALSE),
('Limpieza 18', 13, TRUE),
('Rescate 18', 14, FALSE),
('Incendio 19', 15, TRUE),
('Limpieza 19', 16, FALSE),
('Rescate 19', 17, TRUE),
('Incendio 20', 18, FALSE),
('Limpieza 20', 19, TRUE),
('Rescate 20', 20, FALSE);

-- INSERT DATA INTO eme_habilidad
INSERT INTO eme_habilidad(id_emergencia, id_habilidad) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 6), (7, 7), (8, 8), (9, 9), (10, 10),
(11, 11), (12, 12), (13, 13), (14, 14), (15, 15),
(16, 16), (17, 17), (18, 18), (19, 19), (20, 20);

-- INSERT DATA INTO ranking
INSERT INTO ranking(id_tarea, id_voluntario, puntaje) VALUES
(1, 1, 5), (2, 2, 4), (3, 3, 5), (4, 4, 3), (5, 5, 4),
(6, 6, 5), (7, 7, 3), (8, 8, 4), (9, 9, 5), (10, 10, 2),
(11, 11, 4), (12, 12, 5), (13, 13, 2), (14, 14, 4), (15, 15, 5),
(16, 16, 1), (17, 17, 4), (18, 18, 5), (19, 19, 1), (20, 20, 4);

-- INSERT DATA INTO tarea_habilidad
INSERT INTO tarea_habilidad(id_tarea, id_habilidad) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
(6, 6), (7, 7), (8, 8), (9, 9), (10, 10),
(11, 11), (12, 12), (13, 13), (14, 14), (15, 15),
(16, 16), (17, 17), (18, 18), (19, 19), (20, 20);
