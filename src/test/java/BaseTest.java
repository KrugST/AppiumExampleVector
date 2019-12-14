import PageObjects.MainActivity;
import PageObjects.VectorApp;
import Utils.Utilities;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public AndroidDriver driver;
    private AppiumDriverLocalService service;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    @BeforeClass
    private void getTheDriver() throws IOException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/apk");

        System.out.println(appDir);

        // general capabilities for both Android and iOS
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5200);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);

        File app = new File(appDir.getCanonicalPath(), "app-debug.apk");
        capabilities.setCapability("deviceName", "Memver_device");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.convoy.ssodemo");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("appActivity", ".MainActivity");

        driver = new AndroidDriver<WebElement>(capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void CloseDriver() throws InterruptedException {
        //This is just to physically see what is last app on screen, i will remove it later
        Thread.sleep(5000);
        driver.quit();

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
