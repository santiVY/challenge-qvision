Feature: Smoke test Bon-Bonite

  @smoke
  Scenario: Validar que la página principal de Bon-Bonite carga correctamente
    Given que el usuario se encuentra en la página principal de Bon-Bonite
    Then debería visualizar correctamente la página principal
