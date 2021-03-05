update usuario
set nombre = :nombre,
	clave = :clave,
	fecha_creacion = :fechaCreacion,
	cedula = :cedula
where id = :id