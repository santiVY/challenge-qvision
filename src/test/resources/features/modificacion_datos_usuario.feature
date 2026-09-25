Feature: Modificación de datos del usuario registrado

  Como usuario registrado en Bon-Bonite
  Quiero modificar mis datos personales en la sección "Mi cuenta"
  Para mantener mi información actualizada

  Background:
    Given que el usuario se encuentra en la página principal de Bon-Bonite
    And el usuario ha iniciado sesión con una cuenta registrada

  @cuenta @smoke
  Scenario: Modificación exitosa de los datos del usuario
    When el usuario accede a la sección "Mi cuenta"
    And el usuario actualiza su información de perfil con los siguientes datos
      | campo      | valor_nuevo        |
      | nombre     | Juana               |
      | teléfono   | 3001234567          |
      | dirección  | Calle 45 # 12-30     |
    And el usuario guarda los cambios
    Then el sistema debería mostrar un mensaje de actualización exitosa
    And los datos actualizados deberían reflejarse en la sección "Mi cuenta"
