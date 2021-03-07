select COUNT(*)
from inscripcion WHERE curso = :curso AND fecha_inscripcion = CURDATE()