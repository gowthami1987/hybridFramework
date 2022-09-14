import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SnapDeal {
    WebDriver driver = null;
    @Test
    public void Test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.snapdeal.com");
        this.takeSnapShot(driver, "/Users/ini/Documents/HybridFramework/test.png") ;

    }
    public void takeSnapShot(WebDriver webdriver,String fileWithPath) {
        try {


            TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File(fileWithPath);
            FileUtils.copyFile(SrcFile, DestFile);
        }
        catch (Exception e){}
    }
}
