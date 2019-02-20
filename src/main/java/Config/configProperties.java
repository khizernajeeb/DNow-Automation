package Config;

public class configProperties {
    public static ApplicationConfigReader appConfig = new ApplicationConfigReader();

    public static String Environment = appConfig.getEnvironment();
    public static String Url = appConfig.getUrl();
    public static String UserName = appConfig.getUserName();
    public static String Password = appConfig.getPassword();
    public static String Device = appConfig.getDevice();
    public static String Browser = appConfig.getBrowser();
    public static String IsEnableReporting = appConfig.getIsEnableReporting();

}
