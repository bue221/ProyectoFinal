
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

create table Vehiculos
(
Id int auto_increment primary key,
NombrePropietario varchar(40),
placa varchar(10),
foto varchar(400),
tipo varchar(20),
fecha dateTime default now()
);

select*from Vehiculos
insert into Vehiculos (NombrePropietario,placa, foto) values ("Camilo Plaza", "OBH222", "C:\Users\USER\OneDrive\Fotos\Fondos\fondo2.jpg", "carro")

create table Usuario
(
Id int auto_increment primary key,
Nombre varchar(50),
Apellido varchar(50),
Correo varchar(90),
Contraseña varchar(20)
);

select*from Usuario;

create table Sede
(
Id int auto_increment primary key,
Nombre varchar(50),
Espacios int,
Tarifa double
)

select * from Sede