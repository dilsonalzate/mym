Feature: Crear Empleado
 
 Scenario: Usuario agrega un empleado 
 Given Nombre del empleado "Andres"
 And identification del empleado "713988754"
 When Doy click en el boton "Add"
 Then Se debe crear un empleado. 
