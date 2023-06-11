CREATE TABLE logs (
    id_log SERIAL PRIMARY KEY,
    nombre_tabla VARCHAR(255),
    operacion VARCHAR(255),
    timetamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_name VARCHAR(255),
    user_db TEXT,
    operacion_info TEXT
);

CREATE OR REPLACE FUNCTION log_operaciones()
RETURNS TRIGGER AS
$$
BEGIN
    INSERT INTO logs(nombre_tabla, operacion, user_name, user_db, operacion_info)
    VALUES (TG_TABLE_NAME, TG_OP, current_setting('tbd.usuario'), current_user, row_to_json(NEW)::text);
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER log_operaciones_emergencia
AFTER INSERT OR UPDATE OR DELETE ON emergencia
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE TRIGGER log_operaciones_habilidad
AFTER INSERT OR UPDATE OR DELETE ON habilidad
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE TRIGGER log_operaciones_tarea
AFTER INSERT OR UPDATE OR DELETE ON tarea
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE TRIGGER log_operaciones_tarea_habilidad
AFTER INSERT OR UPDATE OR DELETE ON tarea_habilidad
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE TRIGGER log_operaciones_vol_habilidad
AFTER INSERT OR UPDATE OR DELETE ON vol_habilidad
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE TRIGGER log_operaciones_institucion
AFTER INSERT OR UPDATE OR DELETE ON institucion
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE TRIGGER log_operaciones_eme_habilidad
AFTER INSERT OR UPDATE OR DELETE ON eme_habilidad
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE TRIGGER log_operaciones_voluntario
AFTER INSERT OR UPDATE OR DELETE ON voluntario
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE TRIGGER log_operaciones_ranking
AFTER INSERT OR UPDATE OR DELETE ON ranking
FOR EACH ROW EXECUTE PROCEDURE log_operaciones();

CREATE OR REPLACE PROCEDURE report_user_operaciones()
LANGUAGE plpgsql
AS $$
BEGIN
    -- Crear una tabla temporal para almacenar los conteos de operaciones
    CREATE TEMP TABLE IF NOT EXISTS operacion_counts AS
    SELECT user_name, operacion, COUNT(*) AS operacion_count
    FROM logs
    GROUP BY user_name, operacion;

    -- Devolver un reporte de los usuarios con la mayor cantidad de cada tipo de operación
    -- Inserción
    RAISE NOTICE 'Usuarios con más operaciones de inserción:';
    SELECT user_name, operacion_count
    FROM operacion_counts
    WHERE operacion = 'INSERT'
    ORDER BY operacion_count DESC
    LIMIT 25;

    -- Actualización
    RAISE NOTICE 'Usuarios con más operaciones de actualización:';
    SELECT user_name, operacion_count
    FROM operacion_counts
    WHERE operacion = 'UPDATE'
    ORDER BY operacion_count DESC
    LIMIT 25;

    -- Eliminación
    RAISE NOTICE 'Usuarios con más operaciones de eliminación:';
    SELECT user_name, operacion_count
    FROM operacion_counts
    WHERE operacion = 'DELETE'
    ORDER BY operacion_count DESC
    LIMIT 25;

    -- Limpiar la tabla temporal
    DROP TABLE operacion_counts;
END;
$$;