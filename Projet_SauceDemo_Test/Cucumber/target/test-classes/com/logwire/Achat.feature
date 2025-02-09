Feature: Test d'Achat Complet (E2E)

  @achat_E2E
  Scenario: Achat d'un produit avec succès
    Given Je suis connecte a l application
    When J ajoute un produit au panier
    And Je procede au paiement
    Then La commande est validee avec succes

