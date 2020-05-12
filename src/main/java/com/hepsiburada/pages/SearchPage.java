package com.hepsiburada.pages;

import com.hepsiburada.base.TestBase;
import com.hepsiburada.utils.TestUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends TestBase {

    TestUtils testUtils = new TestUtils();



    @FindBy(xpath = "//div[@class = 'category-suggestion-title']/h1")
    WebElement categorySuggestionTitleHeading;

    @FindBy(className = "hb-pl-cn")
    List<WebElement> listedProducts;

    public SearchPage(){
        PageFactory.initElements(driver,this);
    }


    public String validateSearch(){
        return categorySuggestionTitleHeading.getText();
    }

    public void selectProductFromListedProducts() throws InterruptedException {
        testUtils.waitUntilJSComplete();
        listedProducts.get(3).click();
    }

}
