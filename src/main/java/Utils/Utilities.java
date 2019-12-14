package Utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Utilities {
    AppiumDriver driver;

    public Utilities(AppiumDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String path_screenshot) throws IOException {
        File srcFile = driver.getScreenshotAs(OutputType.FILE);

        String time = SimpleDateFormat.getDateTimeInstance().format(new Date());
        File targetFile = new File(path_screenshot + time + ".jpg");
        FileUtils.copyFile(srcFile, targetFile);
    }
}
