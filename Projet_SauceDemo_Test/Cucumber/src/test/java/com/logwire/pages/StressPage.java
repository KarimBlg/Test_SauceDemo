package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StressPage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement ajoutProduit;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement supprimeProduit;

    @FindBy(css = ".shopping_cart_link")
    private WebElement panier;


    public StressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public void cliqueSurAjouter() {
        for (int i = 0; i < 50; i++) {
            ajoutProduit.click();

        }
    }

    public void cliqueSurSupprimer() {
        for (int i = 0; i < 50; i++) {
            supprimeProduit.click();
        }
    }

    public WebElement panier() {
        return this.panier;
    }
    
}
