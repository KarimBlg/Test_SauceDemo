package com.logwire;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProduitsTest 
{
    WebDriver driver;
    LoginPage saucePage;
    ProduitsPage produitsPage;
    
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        saucePage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        saucePage.saisirUsername("standard_user");
        saucePage.saisirPassword("secret_sauce");
        saucePage.clicButton();
        produitsPage = new ProduitsPage(driver);
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }


    @Test    
    @Tag("TC-ProduitsList")
    public void TestProduits(){
        
        assertTrue(produitsPage.getProduitsList().size() > 0);     
    }


    @Test    
    @Tag("TC-Ajout")
    public void TestAjout(){

        WebElement buttonAdd = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        buttonAdd.click();

        WebElement buttonRemove = driver.findElement(By.id("remove-sauce-labs-backpack"));
        assertTrue(buttonRemove.isDisplayed());

        String buttonRemov = driver.findElement(By.id("remove-sauce-labs-backpack")).getText();
        assertEquals("Remove", buttonRemov);
    }

    @Test    
    @Tag("TC-Panier")
    public void TestPanier(){

        WebElement buttonAdd = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        buttonAdd.click();

        String nbArticle = driver.findElement(By.className("shopping_cart_badge")).getText();
        assertEquals("1", nbArticle);

        WebElement buttonPanier = driver.findElement(By.className("shopping_cart_link"));
        buttonPanier.click();

        String nomArticle = driver.findElement(By.className("inventory_item_name")).getText();
        assertEquals("Sauce Labs Backpack", nomArticle);

    }

    @Test
    @Tag("TC-TriProduits")
    public void TestTriProduits(){
        produitsPage.clicButtonTri();
        produitsPage.clicButtonTriPrix();

         List<String> extractedNames = produitsPage.getProduitsList().stream()
        .map(WebElement::getText)
        .toList();

    // Vérifier si la liste triée est égale à la liste originale
    List<String> sortedNames = new ArrayList<>(extractedNames);
    Collections.sort(sortedNames);

    Assertions.assertEquals(sortedNames, extractedNames, "Le tri des produits par nom n'est pas correct");

    }

}
    


