Feature: Compra de un producto en Bon-Bonite

  Como usuario registrado en Bon-Bonite
  Quiero iniciar sesion con mis credenciales
  Para completar un login de forma exitosa

  Background:
    Given que el usuario se encuentra en la página principal de Bon-Bonite

  @login @smoke
  Scenario: Login exitoso del cliente
    When el usuario ingresas sus credenciales
    Then el usuario vera el menu de inicio con su nombre de usuario

