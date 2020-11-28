# Proyecto Final de POO
## Requerimientos para el proyecto final de POO:

- Andrés Camilo Plaza Jiménez
- David Santiago Anacona Castellanos

## Parqueadero Park Soft:

Aplicación para el control de ingreso y salida de usuarios y su posterior cobro de acuerdo a las tarifas definidas por la sede donde se ocupe el servicio.
----

### Requerimientos negocio:

- El sistema debe validar la información suministrada por el usuario en la ventana de Login, permitiendo su ingreso si la información es válida o de lo contrario mostrando un mensaje de advertencia si las credenciales son incorrectas.
- El sistema deberá guardar la información del ingreso de un nuevo vehículo.
- El sistema deberá generar un registro con la información del vehículo que ingresó teniendo en cuenta la placa, el nombre del propietario, sede donde ingreso y tipo de vehículo además de la hora de ingreso.
- El sistema deberá permitir la búsqueda de información de un vehículo, mostrando una lista general de los vehículos que se encuentran en el parqueadero.
- El sistema en base a la búsqueda de un vehículo permitirá retirar el vehículo.
- El sistema generará una alerta mostrando lo hora de entrada, la hora de salida, el tiempo que duró, el valor a pagar. 
- El sistema utilizando el tiempo que duro por la tarifa establecida según la sede mostrará el total a pagar.

----
### Requerimientos vista:

- El programa deberá contar con una interfaz amigable para el usuario
- Una interfaz de login que le permita al usuario el ingreso a la aplicación
- Un menú el cual le permite navegar entre las vistas ingresar vehículo, listar vehículos, retirar vehículo y que incluya una opción de salir y cerrar sesión.
- La vista para ingresar al vehículo debe contar con 2 jTextField para para ingresar las placas y el nombre del propietario, al igual que con un jCheckbox para seleccionar el tipo de vehículo y un botón para enviar la información, por último se debe de tener un jcombobox para indicar la sede donde se ingresó el vehículo.
- La vista de listar vehículos deberá contar con un título, una tabla para listar los datos botones para cerrar y buscar la información y modificar esta misma.
- La vista retirar vehículo deberá contar con una jTextField para ingresar la placa del vehículo y un botón para confirmar el retiro del vehículo.

# UML
![imagen](https://github.com/bue221/ProyectoFinal/blob/main/umljava.png)

