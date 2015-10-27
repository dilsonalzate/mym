Feature: Agregar Doctor

  Scenario: Verificar seccion de agregar Doctor
    Given Usuario entra a la aplicacion
    When Ingresa a la seccion de " Agregar doctor"
    Then Se muestra la pantalla "Agregar doctor"

  Scenario: Crear Doctor
    Given Usuario entra a la aplicacion
    When Ingresa a la seccion de "Agregar doctor"
    And Ingresa los datos del formulario
      | Field                          | Value        |
      | Nombre completo                | Dilson2      |
      | Apellidos                      | Alzate Perez |
      | Teléfono                       | 3722022      |
      | Tipo de documento de identidad | Pasaportes   |
      | Documento de identidad         | 71387604     |
    And Guarda los datos
    Then Se muestra el mensaje de exito "No se pudo guardar".
    And El doctor creado se visualiza en la tabla
      | Field                          | Value        |
      | Nombre completo                | Dilson2      |
      | Apellidos                      | Alzate Perez |
      | Teléfono                       | 3722022      |
      | Tipo de documento de identidad | Pasaportes   |
      | Documento de identidad         | 71387604     |
