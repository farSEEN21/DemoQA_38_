package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public interface AppManager {
    WebDriver wd =new ChromeDriver();


    @BeforeSuite
    default void init() {
        //        users = new HelperUser(wd);
        //wd.register(new WebDriverListener());
//        wd.manage().window().maximize();
        wd.navigate().to(" "+"https://demoqa.com/");
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

 @AfterSuite

default   void tearDown(){
//    driver.quit();
    }

}
