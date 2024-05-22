package org.example.pages.driverFactory;

import org.example.pages.config.GlobalConfig;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.MalformedParameterizedTypeException;

public class DriverFactory {
    public RemoteWebDriver driver;
    public static ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<>();
    public static ThreadLocal<GlobalConfig> objGlobalConfig = new ThreadLocal<>();

    public RemoteWebDriver init_Driver(GlobalConfig objConfig) throws MalformedParameterizedTypeException
    {
        objGlobalConfig.set(objConfig);
        String strAppiumURL="";
        if(objConfig.executionProvider==GlobalConfig.ExecutionProvider.Local)
        {
            if(objConfig.applicationType==GlobalConfig.ApplicationType.WEB){
                tlDriver.set(LocalBrowserEngine.GetLocalBrowserEngine(objConfig));
                getDriver().manage().window().maximize();
            } else if (objConfig.applicationType==GlobalConfig.ApplicationType.ANDROID_APP) {
                tlDriver.set(LocalApp);
            }

        }
    }

    public static synchronized RemoteWebDriver getDriver(){
        return tlDriver.get();
    }


}
