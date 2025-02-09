Feature: Test de Stress sur le Panier

  @stress
  Scenario: Ajouter et supprimer rapidement plusieurs produits dans le panier
    Given Je suis connecte a l application
    When J ajoute et supprime rapidement 50 fois un produit
    Then Le panier doit rester vide