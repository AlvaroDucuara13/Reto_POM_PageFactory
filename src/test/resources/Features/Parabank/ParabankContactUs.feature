Feature: Contactarse con Parabank
  Yo como usuario de parabank
  deseo contactar a la empresa bancaria
  Para enviar un mensaje


  Background:
    Given el cliente selecciona la opcion ContacUs de la pagina Parabank

  Scenario: El cliente ingresa los datos para contactarse con Parabank
    When  el cliente registra un nombre, un email, un numero de telefono, un mensaje y culmina la accion
    Then  el cliente recibira un mensaje de confirmacion

  Scenario: El cliente ingresa los datos para contactarse con Parabank
    When  el cliente registra un nombre, un email, un numero de telefono, pero no ingresa el mensaje a enviar
    Then  el cliente recibira un mensaje de advertencia por campo vacio

