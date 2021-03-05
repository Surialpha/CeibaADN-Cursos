create table usuario (
 id int(11) not null auto_increment,
 cedula int(11) not null,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table inscripcion (
 id int(11) not null auto_increment,
 usuario int(11) not null,
 curso varchar(100) not null,
 valor varchar(45) not null,
 fecha_inscripcion datetime null,
 primary key (id),
 FOREIGN KEY (usuario) REFERENCES usuario(id)	
);  