package com.hepsiburada.pages;

import com.hepsiburada.base.TestBase;
import com.hepsiburada.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends TestBase {

    TestUtils testUtils = new TestUtils();

    @FindBy(className = "cart-proceed-container")
    WebElement cartProceedContainer;

    @FindBy(xpath = "//li[@class = 'item']//h4[@class = 'product-name']//a")
    List<WebElement> productNames;

    @FindBy(xpath = "//li[@class = 'item']//div[@class = 'merchant']//a")
    List<WebElement> merchantNames;

    @FindBy(xpath = "//li[@class = 'item']//div[@class = 'price']//span")
    List<WebElement> productPrices;

    @FindBy(xpath = "//a[contains(@class, 'btn-delete')]")
    List<WebElement> deleteButtons;

    @FindBy(xpath = "//div[@class = 'undo-container']//div//span")
    WebElement deletedProductNotificationText;

    @FindBy(xpath = "//i[@class = 'icon-undo-close']")
    WebElement deletedProductNotificationCloseButton;

    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    public String verifyPageAndGetTitle(){
        testUtils.waitUntilElementVisible(cartProceedContainer);
        return driver.getTitle();
    }

    public String[] getProductNames(){
        String productNameAtIndex0, productNameAtIndex1;
        productNameAtIndex0 = productNames.get(0).getText();
        productNameAtIndex1 = productNames.get(1).getText();
        return new String[]{productNameAtIndex0, productNameAtIndex1};
    }

    public String[] getMerchantNames(){
        String merchantNameAtIndex0, merchantNameAtIndex1;
        merchantNameAtIndex0 = merchantNames.get(0).getText();
        merchantNameAtIndex1 = merchantNames.get(1).getText();
        return new String[]{merchantNameAtIndex0, merchantNameAtIndex1};
    }

    public String[] getProductPrices(){
        String productPriceAtIndex0, productPriceAtIndex1;
        productPriceAtIndex0 = productPrices.get(0).getText();
        productPriceAtIndex1 = productPrices.get(1).getText();
        return new String[]{productPriceAtIndex0, productPriceAtIndex1};
    }

    public void deleteProductsFromCart() throws InterruptedException {
        testUtils.waitUntilElementVisible(deleteButtons.get(0));
        deleteButtons.get(0).click();
        testUtils.waitUntilElementVisible(deletedProductNotificationText);
        deletedProductNotificationCloseButton.click();
        testUtils.waitUntilJSComplete();
        testUtils.waitUntilElementVisible(deleteButtons.get(0));
        deleteButtons.get(0).click();
        testUtils.waitUntilElementVisible(deletedProductNotificationText);

    }




}
