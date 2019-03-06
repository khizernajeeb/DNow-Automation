package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;

import static Config.configProperties.*;

public class WebDriverFactory {
    static WebDriver driver;
    static String device = Device; // Change to windows or mac accordingly

    static String chromeDriverPath = device.equals("Windows") ? "driver/chromedriver.exe" : "driver/chromedriver";
    static String geckoDriverPath = device.equals("Windows") ? "driver/geckodriver.exe" : "driver/geckodriver";

    public static WebDriver getInstance(){

        ChromeOptions op = new ChromeOptions();
        switch (Browser)
        {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                op.addArguments("--start-maximized");
                driver = new ChromeDriver(op);
                break;

            case "IE":
                driver = new InternetExplorerDriver();
                break;

            case "Firefox":
                System.setProperty("webdriver.gecko.driver", geckoDriverPath);
                op.addArguments("--start-maximized");
                driver = new FirefoxDriver();
                break;
        }


        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        else
        {
            throw new IllegalStateException("Driver has not been initialized");
        }
    }


    public static void finishDriver()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }

}
