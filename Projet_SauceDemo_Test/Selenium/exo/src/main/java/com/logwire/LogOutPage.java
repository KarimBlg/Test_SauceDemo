package com.logwire;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {   

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOut;

    @FindBy(id = "login-button")
    private WebElement login;


    LogOutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public void clicMenu(){
        menu.click();
    }

    public void clicLogOut(){
        logOut.click();
    }

    public WebElement getButtonLogin(){
        return this.login;
    }







    
}
