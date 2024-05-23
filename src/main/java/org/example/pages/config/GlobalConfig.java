package org.example.pages.config;

import org.example.pages.FileUtilities;

public class GlobalConfig {

    public ApplicationType applicationType;
    public BrowserType browserType;
    public OSType osType;
    public ExecutionProvider executionProvider;
    public ExecutionEnvironment executionEnvironment;
    public String AppiumServer;
    public String AppiumPort;
    public int DriverTimeout;
    public int WaitTimeOut;
    public int FluentWaitTimeOut;
    public boolean StartAppiumServer;


    public GlobalConfig getGlobalConfigData(){
        GlobalConfig objConfig = new GlobalConfig();
        objConfig.applicationType=GetApplicationType();
        objConfig.browserType=GetBrowserType();
        objConfig.osType=GetOSType();
        objConfig.executionProvider=GetExecutionProvider();
        objConfig.executionEnvironment=GetExecutionEnvironment();
        objConfig.AppiumServer=GetAppiumServer();
        objConfig.AppiumPort=GetAppiumPort();
        objConfig.StartAppiumServer=StartAppiumServer();
        return objConfig;
    }
    public static boolean StartAppiumServer(){
        String strValue = FileUtilities.GetValueFromPropOrPOM("startAppiumServer");
        if(!strValue.isEmpty())
            return Boolean.parseBoolean(strValue);
        else
            return true;
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

    public static String GetAppiumServer(){
        String strValue = FileUtilities.GetValueFromPropOrPOM("AppiumServer");
        if(!strValue.isEmpty())
            return strValue;
        else return "LocalHost";
    }

    public static String GetAppiumPort(){
        String strValue = FileUtilities.GetValueFromPropOrPOM("AppiumPort");
        if(!strValue.isEmpty())
            return strValue;
        else return "4723";
    }

    public int GetWaitTimeOut(){
        String strValue = FileUtilities.GetValueFromPropOrPOM("WaitTimeOut");
        if(!strValue.isEmpty())
            return Integer.parseInt(strValue);
        else
            return 20;
    }



    public int GetFluentWaitTimeOut(){
        String strValue = FileUtilities.GetValueFromPropOrPOM("FluentWaitTimeOut");
        if(!strValue.isEmpty())
            return Integer.parseInt(strValue);
        else
            return 20;
    }

    public ExecutionEnvironment GetExecutionEnvironment(){
        String strValue=FileUtilities.GetValueFromPropOrPOM("ExecutionEnvironment");
        if (strValue.toLowerCase().startsWith("prod"))
            return ExecutionEnvironment.Prod;
        else if (strValue.toLowerCase().startsWith("stage"))
            return ExecutionEnvironment.Stage;
        else return ExecutionEnvironment.Prod;
    }

    public ExecutionProvider GetExecutionProvider(){
        String strValue=FileUtilities.GetValueFromPropOrPOM("ExecutionProvider");
        if (strValue.toLowerCase().contains("grid"))
            return ExecutionProvider.Grid;
        else if (strValue.toLowerCase().contains("browserstack")) {
            return ExecutionProvider.Browserstack;
        } else return ExecutionProvider.Local;

        }
    }


}
