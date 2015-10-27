Feature: Administrar Actividad

  Scenario: Verificar seccion de administracion de actividades
    Given Usuario ingresa a la aplicacion
    When Ingresa a la seccion de administracion de "Actividades"
    Then Se muestra la seccion de administracion de "Agregar Actividad"

  Scenario: Crear Actividad
    Given Usuario ingresa a la aplicacion
    When Ingresa a la seccion de administracion de "Actividades"
    And Abre la ventana para "Agregar Actividad"
    And Ingreso los datos del formulario
      | Entidad    			| Actividad        |  	
      | Field     			| Value            |
      | Nombre Actividad    | Parches 110 años |
      | Fecha Inicio 		| 11/25/2014       |
      | Fecha Fin 			| 12/25/2014       |
      | Role 	  			| Coordinador      |
    And Guardo los datos
    Then La Actividad creada se debe visualizar en la tabla de roles.
