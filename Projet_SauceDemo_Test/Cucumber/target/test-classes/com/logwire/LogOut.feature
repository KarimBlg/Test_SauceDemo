Feature: Déconnexion (logout)
  
  @logout
  Scenario: Un utilisateur se déconnecte avec succès
    Given Je suis connecte a l application
    When Je clique sur le menu latéral
    And Je clique sur le bouton de déconnexion
    Then Je devrais être redirigé vers la page de connexion
