package co.sample.tests;

import co.sample.pages.Actions.AmazonActionClass;
import co.sample.utils.BaseClass;
import org.openqa.selenium.ScreenOrientation;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Login to amazon mobile application and search for an item and add to cart and purchase it.
 * @author : Gurukiran H N
 */
public class LoginToAmazonSearchForItemAndAddToCart extends BaseClass {

    public AmazonActionClass getAmazonActionClass() {
        return new AmazonActionClass();
    }

    @Test(enabled = true, description = "Login to amazon mobile application and search for an item and add to cart and purchase it ")
    public void verifyUserAbleToStreamContentsOnline() throws Exception {
        getAmazonActionClass().tapOnSkipSignIn();
        getAmazonActionClass().searchForParticularModel(getAmazonActionClass().getCellData("TestData",1,1));
        String textInSearchScreen = getAmazonActionClass().getTextOfSearchedItem();
        getAmazonActionClass().tapOnSearchedItem();
        driver.rotate(ScreenOrientation.LANDSCAPE);
        driver.rotate(ScreenOrientation.PORTRAIT);
        String textInItemSelectedScreen = getAmazonActionClass().getTextOfSelectedItem();
        Assert.assertEquals(textInItemSelectedScreen,textInSearchScreen,"Item name is matching in both searched screen and checkout screen");
        getAmazonActionClass().tapOnAddToCartBtn();
        getAmazonActionClass().tapOnProceedToCheckoutBtn();
    }
}
