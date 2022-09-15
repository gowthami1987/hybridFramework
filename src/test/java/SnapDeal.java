import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
     Logger log = Logger.getLogger(String.valueOf(SnapDeal.class));
    @Test
    public void Test1() {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/"+"src/test/java/objects/log4j.properties");

        WebDriverManager.chromedriver().setup();

      /*  DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("something", true);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        System.out.println("open browser");*/
        log.info("open browser");
        driver=new ChromeDriver();
        driver.get("https://www.snapdeal.com");
        this.takeSnapShot(driver, System.getProperty("user.dir")+"/"+"test.png") ;
        driver.close();

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
