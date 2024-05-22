package org.example.pages.config;

public class GlobalConfig {

    public ApplicationType applicationType;
    public BrowserType browserType;
    public OSType osType;
    public ExecutionProvider executionProvider;
    public ExecutionEnvironment executionEnvironment;
    public int DriverTimeout;
    public int WaitTimeOut;
    public int FluentWaitTimeOut;


    public GlobalConfig getGlobalConfigData(){
        GlobalConfig objConfig = new GlobalConfig();
        objConfig.applicationType=GetApplicationType();
        objConfig.browserType=GetBrowserType();
        objConfig.osType=GetOSType();
        objConfig.executionProvider=GetExecutionProvider();
        objConfig.executionEnvironment=GetExecutionEnvironment();
        return objConfig;
    }

    public enum ApplicationType{
        WEB,
        ANDROID_APP,
        IOS_APP;
    }

    public enum BrowserType{
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI;
    }

    public enum OSType{
        Windows,
        Linux,
        Mac;
    }

    public enum ExecutionProvider{
        Local,
        Grid,
        Browserstack;

    }

    public enum ExecutionEnvironment{
        Stage,
        Prod;
    }

}
