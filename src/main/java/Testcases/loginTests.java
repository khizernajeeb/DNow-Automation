package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import Objects.loginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Config.configProperties;
import static Objects.loginPage.by_logout;

public class loginTests extends baseTest {

    @Test()
    public static void LoginIntoApplication() throws InterruptedException {
        try {
            MainCall.loginPage.login(configProperties.UserName, configProperties.Password);
            Assert.assertTrue(WebDriverFactory.getDriver().findElement(by_logout).isDisplayed(), "Sign Out");

        } catch (Exception e) {
            System.out.println("Login failed");
        }
    }
}