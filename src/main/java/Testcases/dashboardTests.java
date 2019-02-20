package Testcases;

import Config.configProperties;
import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Objects.dashboardPage.byDashboardText;

public class dashboardTests extends baseTest {

    @Test()
    public static void dashboardPageOpen() throws InterruptedException {
        try {
            Assert.assertEquals(WebDriverFactory.getDriver().findElement(byDashboardText).isDisplayed(), "MyDashboard");

        } catch (Exception e) {
            System.out.println("Login failed");
        }
    }
}