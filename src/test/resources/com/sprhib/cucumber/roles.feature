Feature: Crear Role

  Scenario: Verificar seccion de administracion de roles
    Given Usuario ingresa a la aplicacion
    When Ingresa a la seccion de administracion de "Roles"
    Then Se muestra la seccion de administracion de "Agregar Role"

  Scenario: Crear Role
    Given Usuario ingresa a la aplicacion
    When Ingresa a la seccion de administracion de "Roles"
    And Abre la ventana para "Agregar Role"
    And Ingreso los datos del formulario
      | Field       | Value                                       |
      | Role        | Coordinador                                 |
      | Descripcion | Encargado de dirigir los diferentes eventos |
    And Guardo los datos
    Then El role creado se debe visualizar en la tabla de roles.
