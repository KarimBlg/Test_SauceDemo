package com.logwire;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginTest 
{
    WebDriver driver;
    LoginPage saucePage;
    
    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        saucePage = new LoginPage(driver);
        driver.get("https://www.saucedemo.com/");
        
    }

    @AfterEach
    public void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "./users.csv", numLinesToSkip = 0)
    @Tag("TC-CC")
    public void TestCC(String user){
        saucePage.saisirUsername(user);
        saucePage.saisirPassword("secret_sauce");
        saucePage.clicButton();

        String swagText = driver.findElement(By.className("app_logo")).getText();

        assertEquals("Swag Labs", swagText);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "./users.csv", numLinesToSkip = 0)
    @Tag("TC-CI")
    public void TestCI(String user){
        saucePage.saisirUsername(user);
        saucePage.saisirPassword("secre_sauce");
        saucePage.clicButton();

        String errorText = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();

        assertEquals("Epic sadface: Username and password do not match any user in this service", errorText);
    }

    @Test
    @Tag("TC-IC")
    public void TestIC(){
        saucePage.saisirUsername("userrrrr");
        saucePage.saisirPassword("secret_sauce");
        saucePage.clicButton();

        String errorText = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();

        assertEquals("Epic sadface: Username and password do not match any user in this service", errorText);
    }


}
