package General;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;

public class WebDriverWaits {
    private static WebDriver jsWaitDriver;
    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;
    public static WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(),20);


    public static WebElement waitUntilElementIsClickable( WebElement webElement)
    {
        webElement = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return webElement;
    }

    public static void visibilityOfElementLocated( By locator )
    {
         wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitUntilElementNotDisplayed(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), TIMEOUT);
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    webElement.isDisplayed();
                    return true;
                }
                catch (NoSuchElementException e ) {
                    return false;
                }
            }
        };
        wait.until(elementIsDisplayed);
        return webElement;
    }


    public static void waitForPageReadyByJquery() {
        int counter = 0;
        if(!(Boolean) ((JavascriptExecutor) WebDriverFactory.getDriver()).executeScript("return (window.jQuery != null) && (jQuery.active === 0);"))
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void waitUntilElementVisible(){
        new WebDriverWait(WebDriverFactory.getDriver(), 50).until(ExpectedConditions.invisibilityOfElementLocated(By.className("vj-animated-svg-icon"))); // wait for Loading panel to close
    }

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean waitForElToBeAppeared(String element) {
        try {
            WebDriverFactory.getDriver().manage().timeouts()
                    .implicitlyWait(0, TimeUnit.SECONDS);

            WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 1000, 7000);

            return wait
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id(element))).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }


    public static WebElement waitFor(ExpectedCondition<WebElement> webElementExpectedCondition) {

        return wait.until(webElementExpectedCondition);
    }
}
