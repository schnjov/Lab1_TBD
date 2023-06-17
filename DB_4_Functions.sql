CREATE OR REPLACE FUNCTION obtener_total_tareas_activas(id_emergencia_in bigint)
    RETURNS integer AS
$BODY$
DECLARE
    total_tareas integer;
BEGIN
    SELECT COUNT(*) INTO total_tareas
    FROM tarea
    WHERE id_emergencia = id_emergencia_in AND estado_tarea = true;

    RETURN total_tareas;
END;
$BODY$
    LANGUAGE plpgsql;
