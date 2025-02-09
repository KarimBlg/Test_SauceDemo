package com.logwire;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StressTest {

    WebDriver driver;
    LoginPage saucePage;
    StressPage stressPage;
    

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        saucePage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        saucePage.saisirUsername("standard_user");
        saucePage.saisirPassword("secret_sauce");
        saucePage.clicButton();
        stressPage = new StressPage(driver);
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
    public void testStressPanier() {
        for (int i = 0; i < 50; i++) {
            stressPage.clicAjouterArticle();
            stressPage.clicSupprimerArticle();
        }
        Assertions.assertTrue(stressPage.nbPanier().getText().isEmpty());
    }
    
}
