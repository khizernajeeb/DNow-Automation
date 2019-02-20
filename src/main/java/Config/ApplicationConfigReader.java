package Config;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource.Classpath;

@Classpath({"ApplicationConfig.properties"})
public class ApplicationConfigReader {
    @Property("url")
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

    public String getIsEnableReporting() { return this.isEnableReporting; }

}
