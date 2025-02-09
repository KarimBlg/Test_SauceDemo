package com.logwire;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AchatTest {
    WebDriver driver;
    LoginPage saucePage;
    ProduitsPage produitsPage;
    AchatPage achatPage;
    
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        saucePage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        saucePage.saisirUsername("standard_user");
        saucePage.saisirPassword("secret_sauce");
        saucePage.clicButton();
        achatPage = new AchatPage(driver);
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
    public void testAchatComplet(){
        
        achatPage.clicProduit();
        achatPage.clicAjouter();
        achatPage.clicPanier();
        achatPage.clicPayer();
        achatPage.saisirNom("syr");
        achatPage.saisirPrenom("ahf");
        achatPage.saisirCodePostal("52014");
        achatPage.clicContinuer();
        achatPage.clicFinir();


        Assertions.assertTrue(driver.findElement(By.className("complete-header")).isDisplayed());

    }

    @Test
    public void testPaiementSansArticle() {
        achatPage.clicPanier();
        achatPage.clicPayer();
        Assertions.assertTrue(achatPage.getErrorMessage().isDisplayed());
    }

    


    
}
