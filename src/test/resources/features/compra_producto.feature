Feature: Compra de un producto en Bon-Bonite

  Como usuario registrado en Bon-Bonite
  Quiero comprar un producto del catálogo
  Para completar una orden de compra exitosa

  Background:
    Given que el usuario se encuentra en la página principal de Bon-Bonite
    And el usuario ha iniciado sesión con una cuenta registrada

  @compra @smoke
  Scenario: Compra exitosa de un producto del módulo Zapatos
    When el usuario navega al módulo "Zapatos"
    And el usuario selecciona un producto disponible
    And el usuario agrega el producto al carrito de compras
    And el usuario procede al checkout
    And el usuario confirma la orden de compra
    Then el sistema debería mostrar un mensaje de confirmación de la compra
    And la orden debería aparecer registrada en el historial de compras del usuario
