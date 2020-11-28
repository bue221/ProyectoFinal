create database ProyectoFinal;

Use ProyectoFinal;

#Login

create table Usuario
(
Id int auto_increment primary key,
IdCargo int,
Nombre varchar(50),
Apellido varchar(50),
Correo varchar(60),
Clave varchar(15)
);
select*from Usuario;

create table Factura
(
Id int auto_increment primary key,
IdVehiculo int,
IdSede int,
Placa varchar(50),
FechaIngreso datetime,
FechaSalida datetime default now(),
ValorPago double
);


create table Vehiculo
(
Id int auto_increment primary key,
IdUsuario int,
TipoVehiculo int,
Propietario varchar(50),
Placa varchar(50)
);

create table Estacionamiento
(
Id int auto_increment primary key,
DisponibilidadMoto int,
DisponibilidadCarro int
);

create table Sede
(
Id int auto_increment primary key,
NombreSede varchar(50),
IdEstacionamiento int,
TarifaM Double,
TarifaC Double,
Ubicacion varchar(50)
);

create table Cargo
(
Id int auto_increment primary key,
Cargo varchar(60),
Turno varchar(90)
);
insert into Cargo(Cargo,Turno) values ('Administrador','Lun-Vier: 7:00am-2:00pm');

create Table TipoVehiculo
(
Id int auto_increment primary key,
TipoVehiculo varchar(50)
);

ALTER TABLE Vehiculo
ADD CONSTRAINT FK_VehiculoTipo
FOREIGN KEY (TipoVehiculo) REFERENCES TipoVehiculo(Id);

ALTER TABLE Sede
ADD CONSTRAINT FK__SedeEstacionamiento
FOREIGN KEY (IdEstacionamiento) REFERENCES Estacionamiento(Id);

ALTER TABLE Vehiculo
ADD CONSTRAINT FK_VehiculoUsuario
FOREIGN KEY (IdUsuario) REFERENCES Usuario(Id);

ALTER TABLE Usuario
ADD CONSTRAINT FK_UsuarioCargo
FOREIGN KEY (IdCargo) REFERENCES Cargo(Id);

ALTER TABLE Factura
ADD CONSTRAINT FK_FacturaVehiculo
FOREIGN KEY (IdVehiculo) REFERENCES Vehiculo(Id);

ALTER TABLE Factura
ADD CONSTRAINT FK_FacturaSede
FOREIGN KEY (IdSede) REFERENCES Sede(Id);

Select u.Id,u.Nombre,u.Apellido,u.Correo,c.Cargo,c.Turno From Usuario As u
inner join Cargo As c ON u.IdCargo=c.Id;

CREATE VIEW 
vista_usuario AS 
Select u.Id,u.Nombre,u.Apellido,u.Correo,c.Cargo,c.Turno From Usuario As u
inner join Cargo As c ON u.IdCargo=c.Id;

select*from vista_usuario;

select Turno from Cargo;

CREATE VIEW 
vista_sede AS 
Select s.id, s.NombreSede, TarifaM, TarifaC, s.Ubicacion, e.DisponibilidadMoto, e.DisponibilidadCarro From Sede As s
inner join Estacionamiento As e ON s.IdEstacionamiento =e.Id;

select * from vista_sede 

select*from Cargo where Cargo='Administrador' and Turno='Lun-Vier: 7:00am-2:00pm';







