
create database ProyectoFinal;

use ProyectoFinal;

create table Trabajador
(
Id int auto_increment primary key,
Nombre varchar(40),
Cargo varchar(20),
Turno varchar(60)
);

select*from Trabajador;
insert into Trabajador (Nombre, Cargo, Turno) values ("Camilo Plaza","Administrador","Lun-Vie: 7:00am-2:00pm");
insert into Trabajador (Nombre, Cargo, Turno) values ("David Castellanos","Vigilante","Lun-Vie: 5:00am-3:00pm");

