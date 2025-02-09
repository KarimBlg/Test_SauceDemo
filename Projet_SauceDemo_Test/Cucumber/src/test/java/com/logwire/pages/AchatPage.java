package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AchatPage {

    @FindBy(css = ".inventory_item")
    private WebElement produit;

    @FindBy(name = "add-to-cart-sauce-labs-backpack")
    private WebElement ajouter;

    @FindBy(css = ".shopping_cart_link")
    private WebElement panier;

    @FindBy(id = "checkout")
    private WebElement payer;

    @FindBy(id = "first-name")
    private WebElement nom;

    @FindBy(id="last-name")
    private WebElement prenom;

    @FindBy(id = "postal-code")
    private WebElement codePostal;

    @FindBy(id = "continue")
    private WebElement continuer;

    @FindBy(id = "finish")
    private WebElement finir;

    @FindBy(css = ".error-message-container")
    private WebElement errorMessage;


    AchatPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void clicProduit(){
        produit.click();
    }

    public void clicAjouter(){
        ajouter.click();
    }

    public void clicPanier(){
        panier.click();
    }

    public void clicPayer(){
        payer.click();
    }

    public void saisirNom(String nomm){
        nom.sendKeys(nomm);
    }

    public void saisirPrenom(String prenomm){
        prenom.sendKeys(prenomm);
    }

    public void saisirCodePostal(String codep){
        codePostal.sendKeys(codep);
    }

    public void clicContinuer(){
        continuer.click();
    }

    public void clicFinir(){
        finir.click();
    }

    public WebElement getErrorMessage(){
        return this.errorMessage;
    }
    
}