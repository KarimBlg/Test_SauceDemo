package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;


import com.logwire.pages.ProductsPage;
import com.logwire.tools.WebdriverTool;

// import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProduitsSteps {

    ProductsPage productsPage;

    @Then("la liste n est pas vide")
    public void la_liste_n_est_pas_vide() {
        // Write code here that turns the phrase above into concrete actions

        productsPage = new ProductsPage(WebdriverTool.getDriver());

        // System.out.println(s);
        assertTrue(productsPage.getProduitsList().size() > 0);

    }

}
