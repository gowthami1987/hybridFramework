import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;

public class SnapDeal {
    WebDriver driver = null;
    @Test
    public void Test1() {
        WebDriverManager.chromedriver().setup();
       /* DesiredCapabilities cap = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
         driver = new ChromeDriver(options);
        //driver = new ChromeDriver();*/
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("something", true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        System.out.println("open browser");
        driver.get("https://www.gmail.com");
        this.takeSnapShot(driver, System.getProperty("user.dir")+"/"+"test.png") ;

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
