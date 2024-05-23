package org.example.pages.driverFactory;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.example.pages.config.GlobalConfig;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class LocalAppiumEngine {

    public static URL fnStartAppiumServerLocal(int intPortNumber) {
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().withIPAddress("127.0.0.1"))
                .usingPort(intPortNumber)
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(System.getProperty("user.dir") + "\\appiumLogs.txt"));
        service.start();
        System.out.println("****************************************************");
        System.out.println("Local Appium is started URL: " + service.getUrl());
        System.out.println("****************************************************");
        return service.getUrl();
    }

    public static RemoteWebDriver fnOpenAndroidApp(GlobalConfig objConfig) throws MalformedURLException{
        URL strAppiumURL = new URL(objConfig.AppiumServer+";"+objConfig.AppiumPort);
        if(objConfig.StartAppiumServer){
            strAppiumURL = fnStartAppiumServerLocal(1234);
        }
        UiAutomator2Options options = GetAndr
    }
}
