package com.logwire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StressPage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement ajouterArticle;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement supprimerArticle;

    @FindBy(css = ".shopping_cart_link")
    private WebElement panierr;


    StressPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void clicAjouterArticle(){
        ajouterArticle.click();
    }

    public void clicSupprimerArticle(){
        supprimerArticle.click();
    }

    public WebElement nbPanier(){
        return this.panierr;
    }



    
}
