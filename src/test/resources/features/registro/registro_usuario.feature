Feature: Registro de nuevo usuario en Bon-Bonite

  Como visitante del sitio web de Bon-Bonite
  Quiero registrarme con mis datos personales
  Para poder iniciar sesión y realizar compras en el sitio

  Background:
    Given que el usuario se encuentra en la página principal de Bon-Bonite

  @registro @smoke
  Scenario: Registro exitoso de un nuevo usuario con datos válidos
    When el usuario accede al formulario de registro
    And el usuario completa el formulario de registro con los siguientes datos
      | campo    | valor    |
      | cedula   | DINAMICO |
      | nombre   | DINAMICO |
      | apellido | DINAMICO |
      | correo   | DINAMICO |
      | password | DINAMICO |
    And el usuario confirma el registro
    Then el usuario verá la pagina de inicio con su usuario registrado
