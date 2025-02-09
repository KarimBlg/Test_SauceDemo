package com.logwire.steps;

import org.junit.jupiter.api.Assertions;

import com.logwire.pages.LogOutPage;
import com.logwire.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogOutSteps {
    LogOutPage logOutPage;
    LoginPage loginPage;

    @Given("Je suis connecte a l application")
    public void Je_suis_connecte_a_l_application() {
        this.loginPage.saisirUserName("standard_user");
        this.loginPage.saisirPassword("secret_sauce");
        this.loginPage.cliqueSurLogin();

    }
    
    @When("Je clique sur le menu latéral")
    public void Je_clique_sur_le_menu_lat_ral() {
        this.logOutPage.clicMenu();
        
    }

    @When("Je clique sur le bouton de déconnexion")
    public void Je_clique_sur_le_bouton_de_d_connexion() {
        this.logOutPage.clicLogOut();
    }

    @Then("Je devrais être redirigé vers la page de connexion")
    public void Je_devrais_tre_redirig_vers_la_page_de_connexion() {
        Assertions.assertTrue(logOutPage.getButtonLogin().isDisplayed());
    }

    

   

    

    

    
    
}
