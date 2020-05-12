package com.hepsiburada.tests;

import com.hepsiburada.base.TestBase;
import com.hepsiburada.pages.*;
import com.hepsiburada.utils.TestUtils;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC_002_AddProductToCartWithoutLogin extends TestBase {

    TestUtils testUtils;
    HomePage homePage;
    LoginPage loginPage;
    SearchPage searchPage;
    ProductPage productPage;
    CartPage cartPage;

    public final static String expectedHomePageTitle = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";
    public final static String expectedLoginPageTitle = "Üye Giriş Sayfası – Hepsiburada.com";
    public final static String searchValue = "monitör";
    public final static String expectedCartPageTitle = "Sepetim";

    public TC_002_AddProductToCartWithoutLogin(){
        super();
    }

    @BeforeTest
    public void setUp(){
        init();
        testUtils = new TestUtils();
        homePage = new HomePage();
        loginPage = new LoginPage();
        searchPage = new SearchPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
    }

    @Test
    public void verify_addProductToCartWithoutLogin() throws InterruptedException {

        String homePageTitle, cartPageTitle, categorySearchSuggestionHeading, productNameOnProductPage;
        String[] merchantNamesOnProductPage, productPricesOnProductPage;
        String[] productNamesOnCartPage, merchantNamesOnCartPage, productPricesOnCartPage;

        /* Step 1 - User visits hepsiburada.com  */
        homePageTitle = homePage.verifyPageAndGetTitle();
        Assert.assertEquals(homePageTitle, expectedHomePageTitle);
        /* Step 1 - User visits hepsiburada.com  */


        /* Step 2 - User searches the product */
        homePage.searchForItem(searchValue);
        /* Step 2 - User searches the product */

        /* Step 3 - User selects a product from list of search results  */
        categorySearchSuggestionHeading = searchPage.validateSearch();
        Assert.assertEquals(categorySearchSuggestionHeading,searchValue);
        searchPage.selectProductFromListedProducts();
        /* Step 3 - User selects a product from list of search results  */

        /* Step 4 - Products from two different merchant are selected and added to cart */
        productNameOnProductPage = productPage.getProductName();
        merchantNamesOnProductPage = productPage.getMerchantNamesFromList();
        productPricesOnProductPage = productPage.getProductPricesFromList();
        productPage.addProductsToCart();
        /* Step 4 - Products from two different merchant are selected and added to cart */

        /* Step 5 - Verification of correct products added to cart */
        homePage.navigateToCartPage();
        cartPageTitle = cartPage.verifyPageAndGetTitle();
        Assert.assertEquals(cartPageTitle,expectedCartPageTitle);

        productNamesOnCartPage = cartPage.getProductNames();
        Assert.assertEquals(productNamesOnCartPage[0],productNameOnProductPage);
        Assert.assertEquals(productNamesOnCartPage[1],productNameOnProductPage);

        merchantNamesOnCartPage = cartPage.getMerchantNames();
        Assert.assertEquals(merchantNamesOnCartPage[0], merchantNamesOnProductPage[0]);
        Assert.assertEquals(merchantNamesOnCartPage[1], merchantNamesOnProductPage[1]);

        productPricesOnCartPage = cartPage.getProductPrices();
        Assert.assertEquals(productPricesOnCartPage[0], productPricesOnProductPage[0]);
        Assert.assertEquals(productPricesOnCartPage[1], productPricesOnProductPage[1]);
        /* Step 5 - Verification of correct products added to cart */
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
