package com.hepsiburada.pages;

import com.hepsiburada.base.TestBase;
import com.hepsiburada.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    TestUtils testUtils = new TestUtils();

    @FindBy(id = "myAccount")
    WebElement myAccount;

    @FindBy(id = "login")
    WebElement loginLink;

    @FindBy(xpath = "//a[contains(text(), 'Çıkış Yap')]")
    WebElement logoutLink;

    @FindBy(xpath = "//input[contains(@placeholder, 'Ürün, kategori veya marka ara')]")
    WebElement searchInput;

    @FindBy(className = "SearchBoxOld-buttonContainer")
    WebElement searchButtonContainer;

    @FindBy(id = "shoppingCart")
    WebElement shoppingCart;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyPageAndGetTitle(){
        testUtils.waitUntilElementVisible(myAccount);
        return driver.getTitle();
    }

    public void navigateToLoginPage(){
        testUtils.moveToElement(myAccount);
        testUtils.waitUntilElementVisible(loginLink);
        loginLink.click();
    }

    public void verifyLogin(){
        testUtils.moveToElement(myAccount);
        testUtils.waitUntilElementVisible(logoutLink);
    }




    public void searchForItem(String value){
        searchInput.sendKeys(value);
        testUtils.moveToElementAndClick(searchButtonContainer);
    }

    public void navigateToCartPage(){
        testUtils.waitUntilElementVisible(shoppingCart);
        shoppingCart.click();
    }



}
