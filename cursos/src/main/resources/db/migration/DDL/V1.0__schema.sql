create table usuario (
 id int(11) not null auto_increment,
 cedula int(11) not null,
 nombre varchar(100) not null,
 fecha_creacion datetime null,
 fecha_nacimiento date null,
 primary key (id)
); 

create table inscripcion (
 id int(11) not null auto_increment,
 usuario int(11) not null,
 curso varchar(100) not null,
 valor float not null, 
 fecha_inscripcion date null,
 primary key (id),
 FOREIGN KEY (usuario) REFERENCES usuario(id)	
);  