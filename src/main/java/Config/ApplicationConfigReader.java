package Config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

@Classpath({"ApplicationConfig.properties"})
public class ApplicationConfigReader {
    @Property("baseUrl")
    private String Url;

    @Property("username")
    private String UserName;

    @Property("password")
    private String Password;

    @Property("Environment")
    private String Environment;

    @Property("Device")
    private String Device;

    @Property("Browser")
    private String Browser;

    @Property("isEnableReporting")
    private String isEnableReporting;


    @Property("dbUrl")
    private String dbUrl;

    @Property("dbUserName")
    private String dbUserName;

    @Property("grantType")
    private String grantType;

    @Property("clientId")
    private String clientId;

    @Property("dbPassword")
    private String dbPassword;


    public ApplicationConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }

    public String getUrl() {
        return this.Url;
    }

    public String getUserName() {
        return this.UserName;
    }

    public String getPassword() {
        return this.Password;
    }

    public String getEnvironment() {
        return this.Environment;
    }

    public String getDevice() {
        return this.Device;
    }

    public String getBrowser() {
        return this.Browser;
    }

    public String getIsEnableReporting() {
        return this.isEnableReporting;
    }

    public String getGrantType() {
        return grantType;
    }

    public String getClientId() {
        return clientId;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUsername() {
        return dbUserName;
    }

    public String getDbPassword() {
        return dbPassword;
    }
}
