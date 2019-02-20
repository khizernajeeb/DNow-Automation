package Objects;

        import General.MainCall;
        import General.WebDriverFactory;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;
        import org.testng.Assert;

/**
 * Created by VD on 5/28/2018.
 */
public class loginPage
{
    public loginPage() {}

    //Login Page Functions
    public static By byEmail = By.id("username");
    public static By byPassword = By.id("password");
    public static By byLoginButton = By.className("login-form-button");
    public static By by_logout = By.className("signout");

    public void enterUserDetails(String userMail, String pwd)
    {
        WebDriverFactory.getDriver().findElement(byEmail).sendKeys(userMail);
        WebDriverFactory.getDriver().findElement(byPassword).sendKeys(pwd);
    }


    public void clickLogin()
    {
        WebDriverFactory.getDriver().findElement(byLoginButton).click();

        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));

        boolean status= element.isDisplayed();
        if(status)
        {
            System.out.println("User is logged in successfully");
        }
        else
        {
            System.out.println("User is not logged in");
        }
    }

    public void login(String username, String password) throws InterruptedException {
        //Thread.sleep(4000);
        enterUserDetails(username, password);
        clickLogin();
    }
}
