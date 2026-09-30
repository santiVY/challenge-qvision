Feature: Compra de un producto en Bon-Bonite

  Como usuario registrado en Bon-Bonite
  Quiero comprar un producto del catálogo
  Para completar una orden de compra exitosa

  Background:
    Given que el usuario se encuentra en la página principal de Bon-Bonite
    And el usuario ingresas sus credenciales
      | campo    | valor      |
      | cedula   | 1216765765 |
      | password | 123456789  |

  @compra @smoke
  Scenario: Compra exitosa de un producto del módulo Zapatos
    When el usuario navega al módulo "Zapatos"
    And el usuario realiza la compra de un producto disponible
      | campo        | valor          |
      | talla        | 35             |
      | genero       | Mujer          |
      | telefono     | 3509003456     |
      | pais         | Colombia       |
      | departamento | Antioquia      |
      | ciudad       | Medellín       |
      | direccion    | cr 94 # 108-23 |
    Then el sistema debería ver la pasarela de pagos activa para la compra

