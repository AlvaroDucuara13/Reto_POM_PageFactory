Feature: Registrarse en la pagina web Parabank
  Yo como cliente de Parabank
  deseo registrarme en la pagina web
  Para acceder a los servicios que ofrece la plataforma


  Background:
    Given el cliente accede a la opcion Register de la pagina Parabank

  Scenario: El cliente ingresa los datos personales a registrar
    When  el cliente registra sus datos personales para acceder a los servicios que ofrece parabank
    Then  el cliente recibira un mensaje de confirmacion en la seccion register

  Scenario: El cliente ingresa los datos personales a registrar
    When  el cliente registra sus datos personales, pero no ingresa el numero SSN
    Then  el cliente recibira un mensaje de advertencia por campo vacio en la seccion register

