package General;

import Objects.loginPage;
import Objects.*;
import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

import static Config.configProperties.Environment;

public class MainCall {

    static ExtentReports extent;
    public static String emailToLogin = "";

    public static ExtentReports startReport()
    {
        extent = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReport.html", true);
        //extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));

        extent.addSystemInfo("Environment", Environment);
        return extent;
    }

    public static ExtentReports getExtentReport()
    {
        if (extent != null) {
            return extent;
        } else {
            throw new IllegalStateException("Extent Report object not initialized");
        }
    }

    public final static loginPage loginPage = new loginPage();
    public final static dashboardPage dashboardPage = new dashboardPage();

}
