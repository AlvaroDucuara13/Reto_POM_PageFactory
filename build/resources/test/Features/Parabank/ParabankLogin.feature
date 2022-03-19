Feature: Login de usuario
  Yo como usuario de Parabank
  deseo autenticarme en la plataforma web de Parabank
  Para acceder al balance de mi cuenta bancaria


  Background:
    Given el usuario accede a la opcion Customer Login del home principal de la plataforma Parabank

  Scenario: el usuario ingresa sus credenciales para acceder a los servicios que ofrece Parabank
    When  el cliente ingresa sus credenciales usuario y password
    Then  el cliente accede a los servicios que ofrece Parabank

  Scenario: el usuario ingresa sus credenciales para acceder a los servicios que ofrece Parabank
    When  el cliente no ingresa ninguna credencial de autentificacion
    Then  el cliente recibira un mensaje de advertencia sobre los campos vacios de la seccion Login

