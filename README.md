# CensarAPP
<h3>Descripcion : Esta APP permite realizar un Censo de ciudadanos , los guarda en una base de datos FireStore.</h3>

<strong>Trate de ir implementando los nuevos conocimientos que adquiri<br></strong>
    -ESTRUCTURA MVVM<br>
		-SPLASH SCREEN<br>
		-FRAGMENTS<br>
    -RECYCLER VIEW<br>
    -ADAPTERS<br>
		-ABM CON FIRESTORE<br>
		-AL IMPLEMENTAR FIRESTORE , CUALQUIER PERSONA QUE DESCARGUE LA APP PUEDE VER LAS PERSONAS CENSADAS <br>
		-FILTRADO EN FIRESTORE (POR APELLIDO ,+18 DESOCUPADOS,DEBAJO LIMITE POBREZA)<br>
		-MATERIAL DESIGN COMPONENTS<br>
		-UNIT TEST<br>
		-IMPLEMENTATION TEST<br>
		-DIALOGS<br>
<h2>ENUNCIADO</H2>

A pesar de la pandemia, se ha decidido llevar a cabo el censo 2021 en Argentina.<br>
Para ello, se solicita realizar una aplicación movil que sea capaz de gestionar la información obtenida de cada persona.<br>
Dichos datos son:<br>

Tipo y número de documento (obligatorio).<br>
Nombre y apellido (obligatorio).<br>
Fecha de nacimiento (obligatorio).<br>
Sexo (obligatorio).<br>
Dirección.<br>
Teléfono.<br>
Ocupación.<br>
Ingreso económico mensual (obligatorio).<br>

<h3>Requerimientos</h3><br>
Los datos deberán ser almacenados en una base de datos y la aplicación debe permitir hacer el alta, baja, modificación y consulta de personas censadas.<br>
Queda a criterio del desarrollador qué modelo de base de datos utilizar y qué tipo de datos.<br>
Luego de cada operación, el usuario de la aplicación debe obtener una respuesta que le permita saber si el proceso ha salido bien o no.<br>
El redireccionamiento de páginas es una opción.<br>

Con fines estadísticos, nuestro programa debe ser capaz de crear un reporte y mostrarlos en una pantalla con la siguiente información:<br>

Lista de todas las personas, mostrando toda su información, ordenadas de forma ascendente según su apellido.<br>
Lista de todas las personas mayores de 18 años que están desocupadas.<br>
Lista de todas las personas que están por debajo de la línea de pobreza. Se considera pobre a una persona cuyos ingresos son inferiores a cinco mil pesos mensuales.<br>
Cantidad de mujeres y cantidad de hombres entre la población.<br>

La aplicación movil  debe ser capaz  a futuro de conectarse a algun servidor para poder descargar la informacion de la base de datos<br>
