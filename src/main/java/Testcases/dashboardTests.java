package Testcases;

import General.WebDriverFactory;
import General.baseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static PageObject.dashboardPage.byDashboardText;

public class dashboardTests extends baseTest {

    @Test()
    public static void dashboardPageOpen() throws InterruptedException {
        try {
            Assert.assertEquals(WebDriverFactory.getDriver().findElement(byDashboardText).isDisplayed(), "Test test failed for reporting purpose");

        } catch (Exception e) {
            System.out.println("Login failed");
        }
    }
}