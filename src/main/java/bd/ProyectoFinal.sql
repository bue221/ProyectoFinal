
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
select*from Usuario;

create table Vehiculos
(
Id int auto_increment primary key,
NombrePropietario varchar(40),
placa varchar(10),
foto varchar(400),
tipo varchar(20),
fecha dateTime default now()
);


select NombrePropietario,fecha from Vehiculos where placa='OBH222';
insert into Vehiculos (NombrePropietario,placa, foto) values ("Camilo Plaza", "OBH222", "C:\Users\USER\OneDrive\Fotos\Fondos\fondo2.jpg", "carro");

create table Sede
(
Id int auto_increment primary key,
Nombre varchar(50),
Espacios int,
TarifaC double,
TarifaM double,
Ubicacion varchar(10)
);

insert into Sede (Nombre,Espacios,Ubicacion, TarifaC, TarifaM) values ("Sede A", 20, "Norte", 800, 200 );

select * from Sede;

create table VehiculoRetirado
(
Id int auto_increment primary key,
NombrePropietario varchar(40),
placa varchar(10),
foto varchar(400),
tipo varchar(20),
fechaIngreso dateTime default now(),
fechaSalida dateTime default now(),
Pago double
);

Select*from VehiculoRetirado;