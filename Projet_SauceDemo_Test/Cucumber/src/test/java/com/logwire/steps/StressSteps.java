package com.logwire.steps;

import org.junit.jupiter.api.Assertions;

import com.logwire.pages.StressPage;
import com.logwire.tools.WebdriverTool;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StressSteps {

    StressPage stressPage;

    @Given("Je suis connecte a l application")
    public void Je_suis_connecte_a_l_application() {
        // Write code here that turns the phrase above into concrete actions
        stressPage = new StressPage(WebdriverTool.getDriver());
    }


    @When("J ajoute et supprime rapidement {int} fois un produit")
    public void J_ajoute_et_supprime_rapidement_fois_un_produit() {
        // Write code here that turns the phrase above into concrete actions
        this.stressPage.cliqueSurAjouter();
        this.stressPage.cliqueSurSupprimer();
    }

    @Then("Le panier doit rester vide")
    public void Le_panier_doit_rester_vide() {
        // Write code here that turns the phrase above into concrete actions
        Assertions.assertTrue(this.stressPage.panier().getText().isEmpty(), "Le panier ne doit pas contenir d'articles !");
    }

    
    
}
