package com.hepsiburada.pages;

import com.hepsiburada.base.TestBase;
import com.hepsiburada.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends TestBase {

    TestUtils testUtils = new TestUtils();

    @FindBy(id = "product-name")
    WebElement productNameHeading;

    @FindBy(xpath = "//span[@class = 'price-text']")
    List<WebElement> productPricesFromOtherBuyOptions;

    @FindBy(xpath = "//a[@class = 'merchantStore small']")
    List<WebElement> merchantNamesFromOtherBuyOptions;

    @FindBy(xpath = "//button[@class ='add-to-basket button small']")
    List<WebElement> addToBasketButtonsFromOtherBuyOptions;

    @FindBy(className = "deny-text")
    WebElement denyServiceText;

    @FindBy(id="notification")
    WebElement notificationPopup;


    public ProductPage(){
        PageFactory.initElements(driver,this);
    }

    public String getProductName(){
        String productName;
        productName = productNameHeading.getText();
        return productName;
    }

    public String[] getMerchantNamesFromList() {
        String merchantName1, merchantName2;
        int listCount;
        listCount = merchantNamesFromOtherBuyOptions.size();
        merchantName1 = merchantNamesFromOtherBuyOptions.get(listCount-1).getText();
        merchantName2 = merchantNamesFromOtherBuyOptions.get(listCount-2).getText();
        return new String[]{merchantName1, merchantName2};
    }

    public String[] getProductPricesFromList(){
        String productPrice1, productPrice2;
        int listCount;
        listCount = productPricesFromOtherBuyOptions.size();
        productPrice1 = productPricesFromOtherBuyOptions.get(listCount-1).getText();
        productPrice2 = productPricesFromOtherBuyOptions.get(listCount-2).getText();
        return new String[]{productPrice1, productPrice2};
    }

    public void addProductsToCart(){
        int listCount;
        listCount = productPricesFromOtherBuyOptions.size();
        addToBasketButtonsFromOtherBuyOptions.get(listCount-1).click();
        // testUtils.waitUntilElementVisible(denyServiceText);
        // denyServiceText.click();
        testUtils.waitUntilElementVisible(notificationPopup);
        testUtils.waitUntilElementInvisible(notificationPopup);

        addToBasketButtonsFromOtherBuyOptions.get(listCount-2).click();
        // testUtils.waitUntilElementVisible(denyServiceText);
        // denyServiceText.click();
        testUtils.waitUntilElementVisible(notificationPopup);
        testUtils.waitUntilElementInvisible(notificationPopup);
    }
}
