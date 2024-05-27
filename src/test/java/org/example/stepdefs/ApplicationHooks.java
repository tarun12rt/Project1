/*
package org.example.stepdefs;

import io.cucumber.java.After;
import org.example.pages.config.GlobalConfig;
import org.example.pages.driverFactory.DriverFactory;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private RemoteWebDriver driver;
    public GlobalConfig objConfig;

    @Before(order=0)
    public void getProperty(){
        this.objConfig=new GlobalConfig();
    }

    @Before(order=1)
    public void launchBrowser(){
        driverFactory = new DriverFactory();
        this.objConfig=this.objConfig.getGlobalConfigData();
        driver=driverFactory.init_Driver(this.objConfig);
    }

    @After(order=0)
    public void quitBrowser(){
        driver.quit();
    }

}
*/
