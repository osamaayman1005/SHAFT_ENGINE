package testPackage.LambdaTest;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_LTWebAppIOS {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    private final By noThanks = By.xpath("//*[@resource-id='com.apple.mobilesafari:id/negative_button']");
    private final By appleMenuIcon = By.id("globalnav-menutrigger-button");
    private final By macTab = By.className("globalnav-link-mac");
    private final By elementToValidate = By.xpath("(//div[contains(@class,'globalnav-submenu-group-elevated')]//ul//li//a[@class='globalnav-submenu-link'])[7]");
    private final String exploreAllMacText = "Explore All Mac";
    private final String appleUrl = "https://www.apple.com/";

    @Test
    public void LT_Test_IOS_WebApp_V11() {
        driver.browser().navigateToURL(appleUrl);
        driver.element().click(appleMenuIcon);
        driver.element().click(macTab);
        Assert.assertEquals(driver.element().getText(elementToValidate), exploreAllMacText);
    }


    @BeforeMethod
    public void beforeMethod() {
        testData = new SHAFT.TestData.JSON("credentials.json");
        // common attributes
        SHAFT.Properties.lambdaTest.set().deviceName("iPhone 13 Pro Max");
        SHAFT.Properties.lambdaTest.set().platformVersion("15");
        SHAFT.Properties.platform.set().targetPlatform("ios");
        SHAFT.Properties.platform.set().executionAddress("lambdatest");
        SHAFT.Properties.web.set().targetBrowserName("safari");
        SHAFT.Properties.mobile.set().browserName("safari");
        SHAFT.Properties.lambdaTest.set().selenium_version("4.8.0");
        SHAFT.Properties.lambdaTest.set().isRealMobile(true);
        SHAFT.Properties.lambdaTest.set().username(testData.getTestData("LambdaTestUserName"));
        SHAFT.Properties.lambdaTest.set().accessKey(testData.getTestData("LambdaTestAccessKey"));
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.quit();
    }
}