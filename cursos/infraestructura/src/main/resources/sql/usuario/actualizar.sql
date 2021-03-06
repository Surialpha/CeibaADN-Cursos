update usuario
set nombre = :nombre,
	fecha_creacion = :fechaCreacion,
	fecha_nacimiento = :fecha_nacimiento,
	cedula = :cedula
where id = :id