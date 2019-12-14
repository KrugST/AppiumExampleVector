package PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity {
    AppiumDriver driver;
    String appPackage = "com.convoy.ssodemo";

    public MainActivity(AppiumDriver driver) {
        this.driver = driver;
    }

    public void clickSsoLoginButton() {
        driver.findElement(By.id(appPackage + ":id/sso_button")).click();

    }

    public void clickSsoLogountButton() {
        driver.findElement(By.id(appPackage + ":id/sso_button2")).click();
    }

    public String getMessageText() throws InterruptedException {
        //I need better sleep
       Thread.sleep(2000);
       String messageText = driver.findElement(By.id(appPackage + ":id/sso_status_text")).getText();
       return messageText;
    }

    //this thing i was trying to use to Assert equals for msgs, but its ok i used assert true, dont need that anymore.
    public String getTimeAzazaThatIsFunny() throws InterruptedException {
        String time = SimpleDateFormat.getTimeInstance().format(new Date(System.currentTimeMillis() - 1000));
        System.out.println(time);
        return time;
    }


}
