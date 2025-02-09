Feature: Produits

  Scenario: verification de la liste des produits
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisi le username "standard_user"
    And je saisi le password "secret_sauce"
    And je clique sur Login
    Then j accede mon dashboard
    Then la liste n est pas vide
