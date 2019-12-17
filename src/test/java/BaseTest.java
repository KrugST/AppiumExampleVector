import PageObjects.MainActivity;
import PageObjects.VectorApp;
import Utils.DriverSetup;
import Utils.Utilities;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.UUID;

public class BaseTest extends DriverSetup {

    @BeforeClass
    void driverSetUp() throws IOException {
        getTheDriver();
    }

    @AfterClass
    void exitDriver() throws InterruptedException {
        closeDriver();
    }

    @Test (priority = 1)
    public void tapBroadcastSSOLogoutLoginScreenshotValidateMsgTest() throws InterruptedException, IOException {
        MainActivity mainActivity = new MainActivity(driver);
        Utilities utilities = new Utilities(driver);

        mainActivity.clickSsoLogountButton();
        //I was trying to use assert equals, but there is timestamp, and my timestamp is 1-2 sec late then yours.
        Assert.assertTrue(mainActivity.getMessageText().contains("LOGOUT"));

        mainActivity.clickSsoLoginButton();
        Assert.assertTrue(mainActivity.getMessageText().contains("LOGIN"));

        Assert.assertTrue(mainActivity.getMessageText().contains("[SSO Status]: type = login, message = ok, code = 0"));
        utilities.takeScreenshot("./screenshots/SSOapp");
    }


    //TO run this test you need to make sure that you are loged in
    @Test (priority = 2)
    public void mainAppTestCase() throws IOException {
        VectorApp vectorApp = new VectorApp(driver);
        Utilities utilities = new Utilities(driver);
        driver.startActivity(new Activity("com.convoy.loaddoc", ".MainActivity"));
        vectorApp.clickHamburgetMenuButton();

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@text, 'Murzik Cat')]")).isDisplayed());

        driver.navigate().back();

        vectorApp.clickPlusButton();
        vectorApp.clickPlusMenuItemByText("Bill of Lading");

        vectorApp.clickNextButton();

        vectorApp.setTextToLoadNumberField("Roman Sentsov-" + UUID.randomUUID().toString());

        vectorApp.clickScanOrTakePhoto();

        vectorApp.clickCaptureButton();

        vectorApp.clickNextButton();

        vectorApp.clickUploadButton();

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@text, 'Documents')]")).isDisplayed());

        utilities.takeScreenshot("./screenshots/VectorApp-");
    }
}
