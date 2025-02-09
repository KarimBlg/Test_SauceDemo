package com.logwire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Hello world!
 *
 */
public class LoginPage
{

    //locators
    @FindBy(name="user-name")
    private WebElement usernameField;

    @FindBy(name="password")
    private WebElement passwordField;

    @FindBy(name="login-button")
    private WebElement buttonField;

    @FindBy(css=".inventory_item")
    private List<WebElement> produits;


    LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //actions
    public void saisirUsername(String username){
        usernameField.sendKeys(username);
    }

    public void saisirPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clicButton(){
        buttonField.click();
    }

   

    

    
}
