package com.hepsiburada.pages;

import com.hepsiburada.base.TestBase;
import com.hepsiburada.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    TestUtils testUtils = new TestUtils();


    @FindBy(className = "box-header-title")
    WebElement loginPageHeader;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class, 'btn-login-submit')]")
    WebElement loginButton;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyPageAndGetTitle(){
        testUtils.waitUntilElementVisible(loginPageHeader);
        return driver.getTitle();
    }

    public void login() {
        emailInput.sendKeys(prop.getProperty("email"));
        passwordInput.sendKeys(prop.getProperty("password"));
        loginButton.click();

    }



}
