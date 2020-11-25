
create database ProyectoFinal;

use ProyectoFinal;

create table Usuario
(
Id int auto_increment primary key,
Nombre varchar(50),
Apellidos varchar(50),
Cargo int,
Turno varchar(60),
Correo varchar(90),
Contraseña varchar(15)
);

create table Vehiculos
(
Id int auto_increment primary key,
NombrePropietario varchar(40),
placa varchar(10),
foto varchar(400),
tipo varchar(20),
fecha dateTime default now()
);

select*from Vehiculos;
insert into Vehiculos (NombrePropietario,placa, foto) values ("Camilo Plaza", "OBH222", "C:\Users\USER\OneDrive\Fotos\Fondos\fondo2.jpg", "carro");

create table Sede
(
Id int auto_increment primary key,
Nombre varchar(50),
Espacios int,
Tarifa double
)

select * from Sede