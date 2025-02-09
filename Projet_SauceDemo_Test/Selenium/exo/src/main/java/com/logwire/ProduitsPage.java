package com.logwire;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProduitsPage {

    @FindBy(css=".inventory_item")
    private List<WebElement> produitsList;

    @FindBy(css=".product_sort_container")
    private WebElement buttonTri;

    @FindBy(xpath = "//option[@value='az']")
    private WebElement buttonTriAZ;

    
    ProduitsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProduitsList() {
        return this.produitsList;
    }
    
    public void clicButtonTri(){
        buttonTri.click();
    }

    public void clicButtonTriPrix(){
        buttonTriAZ.click();
    }


}
