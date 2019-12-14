package PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class VectorApp {
    AppiumDriver driver;

    public VectorApp(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickHamburgetMenuButton() {
        //There is not resource id? or text =(
        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickPlusButton() {
        //Ah
        String xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.support.v4.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickPlusMenuItemByText(String menuItemText) {
        driver.findElementByAccessibilityId(menuItemText).click();
    }

    public void clickNextButton() {
        driver.findElementByAccessibilityId("Next").click();
    }

    public void setTextToLoadNumberField(String textToINput) {
        driver.findElementByAccessibilityId("Load Number").sendKeys(textToINput);
    }

    public void clickScanOrTakePhoto() {
        //being lazy now
        driver.findElement(By.xpath("//*[contains(@text, 'SCAN PAGE OR TAKE A PHOTO')]")).click();
    }

    public void clickCaptureButton() {
        ////android.view.ViewGroup[@content-desc="captureButton"]/android.widget.ImageView
        String xpath = "//android.view.ViewGroup[@content-desc='captureButton']/android.widget.ImageView";
        driver.findElement(By.xpath(xpath)).click();
    }
    public void clickUploadButton() {
        driver.findElementByAccessibilityId("Upload").click();
    }

}
