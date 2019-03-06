package Testcases;

import General.MainCall;
import General.WebDriverFactory;
import General.baseTest;
import dbConnection.dbConn;
import org.testng.Assert;
import org.testng.annotations.Test;
import Config.configProperties;

import java.sql.SQLException;

import static PageObject.loginPage.by_logout;

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

    @Test
    public static void DatabaseConnect() throws SQLException {
        String surveyID = dbConn.getActiveSurveyId();
        System.out.println(surveyID);
    }
}