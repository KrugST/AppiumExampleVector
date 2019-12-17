package Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DriverSetup {
    public AndroidDriver driver;
    private AppiumDriverLocalService service;
    private DesiredCapabilities capabilities = new DesiredCapabilities();

    public void getTheDriver() throws IOException {
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

    public void closeDriver() throws InterruptedException {
        //This is just to physically see what is last app on screen, i will remove it later
        Thread.sleep(5000);
        driver.quit();

    }
}
