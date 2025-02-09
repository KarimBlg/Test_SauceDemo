package com.logwire.steps;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import com.logwire.pages.AchatPage;
import com.logwire.pages.LoginPage;
import com.logwire.tools.WebdriverTool;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AchatSteps {
    LoginPage loginPage;
    AchatPage achatPage;

    @Given("Je suis connecte a l application")
    public void Je_suis_connecte_a_l_application() {
        this.loginPage.saisirUserName("standard_user");
        this.loginPage.saisirPassword("secret_sauce");
        this.loginPage.cliqueSurLogin();

    }

    @When("J ajoute un produit au panier")
    public void J_ajoute_un_produit_au_panier() {
        this.achatPage.clicProduit();
        this.achatPage.clicAjouter();
        this.achatPage.clicPanier();
    }

    @When("Je procede au paiement")
    public void Je_procede_au_paiement() {
        this.achatPage.clicPayer();
        this.achatPage.saisirNom("kkk");
        this.achatPage.saisirPrenom("bbb");
        this.achatPage.saisirCodePostal("75000");
        this.achatPage.clicContinuer();
        this.achatPage.clicFinir();
    }

    @Then("La commande est validee avec succes")
    public void La_commande_est_validee_avec_succes() {
        Assertions.assertTrue(WebdriverTool.driver.findElement(By.className("complete-header")).isDisplayed());
    }
    
}
