Feature: Modificación de datos del usuario registrado

  Como usuario registrado en Bon-Bonite
  Quiero modificar mis datos personales en la sección "Mi cuenta"
  Para mantener mi información actualizada

  Background:
    Given que el usuario se encuentra en la página principal de Bon-Bonite
    And el usuario ingresas sus credenciales
      | campo    | valor      |
      | cedula   | 1216765765 |
      | password | 123456789  |

  @cuenta @smoke
  Scenario: Modificación exitosa de los datos del usuario
    When el usuario accede a la sección "Mi cuenta"
    And el usuario actualiza su información de perfil con los siguientes datos
      | campo    | valor_nuevo |
      | teléfono | 3001234567  |
    And el usuario guarda los cambios
    Then el sistema debería mostrar un mensaje de actualización exitosa
