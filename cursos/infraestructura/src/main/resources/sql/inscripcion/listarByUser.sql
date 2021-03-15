select i.*,u.nombre,u.creditos
from inscripcion i
join usuario u on i.usuario = u.id
where i.usuario = :usuario