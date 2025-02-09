package com.logwire;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogOutTest {

    WebDriver driver;
    LoginPage saucePage;
    LogOutPage logOutPage;
    
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        saucePage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        saucePage.saisirUsername("standard_user");
        saucePage.saisirPassword("secret_sauce");
        saucePage.clicButton();
        logOutPage = new LogOutPage(driver);
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
    public void logOutTest(){
        logOutPage.clicMenu();
        logOutPage.clicLogOut();

        Assertions.assertTrue(logOutPage.getButtonLogin().isDisplayed());
    }

    
    
}
