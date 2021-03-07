insert into usuario(cedula,nombre,fecha_creacion,fecha_nacimiento,creditos)
values(123456,'test',now(),'2002-01-01',200);

insert into inscripcion(usuario,curso,valor,fecha_inscripcion)
values (1,1,100,now());