package com.hepsiburada.utils;

import com.hepsiburada.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 60;
    public static long IMPLICIT_WAIT = 30;
    public static long EXPLICIT_WAIT = 30;
    public static WebDriverWait wait;


    public void switchToFrame(String frame){
        driver.switchTo().frame(frame);
    }

    public void switchToDefaultContent(){
        driver.switchTo().defaultContent();
    }

    public void scrollToEnd(WebElement element){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void waitUntilElementVisible(WebElement element){
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilElementInvisible(WebElement element){
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void moveToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void moveToElementAndClick(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }

    public void waitUntilJSComplete() throws InterruptedException {
        while(true){

            Boolean isJSCompleted = ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");

            if(isJSCompleted){
                break;
            }
            Thread.sleep(1000);
        }
    }

}
