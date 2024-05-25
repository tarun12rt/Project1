package org.example.pages.driverFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.example.pages.config.GlobalConfig;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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
        UiAutomator2Options options = GetAndroidCapabilitiesForApp(objConfig);
        AndroidDriver driver = new AndroidDriver(strAppiumURL,options);
        try{
            Thread.sleep(10000);
        }catch (Exception e){}
        System.out.println("********************************************************************");
        System.out.println("Battery Status ==> "+driver.getBatteryInfo().getState());
        System.out.println("Current Activity ==> "+driver.currentActivity());
        System.out.println("Wifi Enabled ==> "+driver.getConnection().isWiFiEnabled());
        System.out.println("********************************************************************");
        return driver;
    }

    public static UiAutomator2Options GetAndroidCapabilitiesForApp(GlobalConfig objConfig){
        String androidAppUrl="";
        if(objConfig.AppPath.toLowerCase().contains("local")){
            String app_path = System.getProperty("user.dir");
            androidAppUrl = app_path+ "//App_Path//"+objConfig.AndroidAppName;
        } else if (objConfig.AppPath.toLowerCase().contains("/")) {
            String app_path= objConfig.AppPath;
            androidAppUrl=app_path+"/"+objConfig.AndroidAppName;
        }
        UiAutomator2Options options= new UiAutomator2Options().setApp(androidAppUrl)
                .setUdid(objConfig.DeviceName)
                .autoGrantPermissions()
                .setNewCommandTimeout(Duration.ofSeconds(60));
        return options;
    }

    public static RemoteWebDriver fnOpenAndroidChrome(GlobalConfig objConfig) throws MalformedURLException{
        URL strAppiumURL = new URL(objConfig.AppiumServer+";"+objConfig.AppiumPort);
        if(objConfig.StartAppiumServer){
            strAppiumURL=fnStartAppiumServerLocal(1234);
        }
        UiAutomator2Options options = GetAndroidCapabilitiesForChrome(objConfig);
        AndroidDriver driver = new AndroidDriver(strAppiumURL,options);
        try {
            Thread.sleep(10000);
            driver.hideKeyboard();
        }catch (Exception e){}
        System.out.println("********************************************************************");
        System.out.println("Battery Status ==> "+driver.getBatteryInfo().getState());
        System.out.println("Current Activity ==> "+driver.currentActivity());
        System.out.println("Wifi Enabled ==> "+driver.getConnection().isWiFiEnabled());
        System.out.println("********************************************************************");
        return driver;
    }

    public static UiAutomator2Options GetAndroidCapabilitiesForChrome(GlobalConfig objConfig){
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(objConfig.DeviceName)
                .autoGrantPermissions()
                .withBrowserName("chrome")
                .setNewCommandTimeout(Duration.ofSeconds(60));
        return options;
    }

    public static RemoteWebDriver fnOpenIOSApp(GlobalConfig objConfig) throws MalformedURLException{
        URL strAppiumURL = new URL(objConfig.AppiumServer+";"+objConfig.AppiumPort);
        if(objConfig.StartAppiumServer){
            strAppiumURL = fnStartAppiumServerLocal(1234);
        }
        UiAutomator2Options options = GeIOSDesiredCapabilitiesForApp(objConfig);
        IOSDriver driver = new IOSDriver(strAppiumURL,options);
        try{
            Thread.sleep(10000);
        }catch (Exception e){}
        System.out.println("********************************************************************");
        System.out.println("Battery Status ==> "+driver.getBatteryInfo().getState());
        System.out.println("Get SessionId ==> "+driver.getSessionId());
        System.out.println("********************************************************************");
        return driver;

    }

    public static UiAutomator2Options GeIOSDesiredCapabilitiesForApp(GlobalConfig objConfig){
        String iosAppUrl="";
        if(objConfig.AppPath.toLowerCase().contains("local")){
            String app_path = System.getProperty("user.dir");
            iosAppUrl = app_path+ "//App_Path//"+objConfig.AndroidAppName;
        }
        else if (objConfig.AppPath.toLowerCase().contains("/")) {
            String app_path= objConfig.AppPath;
            iosAppUrl=app_path+"/"+objConfig.AndroidAppName;
        }
        UiAutomator2Options options= new UiAutomator2Options().setApp(iosAppUrl)
                .setAutomationName("XCUITest")
                .setUdid(objConfig.DeviceName)
                .autoGrantPermissions()
                .setNewCommandTimeout(Duration.ofSeconds(60));
        return options;
    }

    public static RemoteWebDriver fnOpenIOSSafari(GlobalConfig objConfig) throws MalformedURLException{
        URL strAppiumURL = new URL(objConfig.AppiumServer+";"+objConfig.AppiumPort);
        if(objConfig.StartAppiumServer){
            strAppiumURL=fnStartAppiumServerLocal(1234);
        }
        UiAutomator2Options options = GetIOSDesiredCapabilitiesForSafari(objConfig);
        IOSDriver driver = new IOSDriver(strAppiumURL,options);
        try {
            Thread.sleep(10000);
            driver.hideKeyboard();
        }catch (Exception e){}
        System.out.println("********************************************************************");
        System.out.println("Battery Status ==> "+driver.getBatteryInfo().getState());
        System.out.println("Get SessionId  ==> "+driver.getSessionId());
        System.out.println("Get Browser Name  ==> "+driver.getCapabilities().getBrowserName());
        System.out.println("********************************************************************");
        return driver;
    }
    public static UiAutomator2Options GetIOSDesiredCapabilitiesForSafari(GlobalConfig objConfig){
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(objConfig.UDID)
                .autoGrantPermissions()
                .withBrowserName("safari")
                .setNewCommandTimeout(Duration.ofSeconds(60));
        return options;
    }





}
