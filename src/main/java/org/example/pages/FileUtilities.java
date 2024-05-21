package org.example.pages;

import com.jayway.jsonpath.JsonPath;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileUtilities {

    public static String fnGetCurrentUserDir(){
        String dir = System.getProperty("user.dir");
        dir=dir.replaceAll("\\\\","/");
        return dir;
    }

    public static String fnGgetCurrentTimeStampAsString(){
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        Date now= new Date();
        String strDate = sdfDate.format(now);
        strDate=strDate.replace("-","").replace(" ","").replace(":","");
        return strDate;
    }

    public static boolean  fnCreateFolder(String Path, String folderName){
        boolean blnStatus = false;
        try{
            File newFolder = new File(Path+"/"+folderName);
            blnStatus = newFolder.mkdirs();
            if(blnStatus){
                System.out.println("Folder was created !");
            }
            else {
                System.out.println("Unable to create folder !!!");

            }
        }catch (Exception e){}
        return blnStatus;

    }

    public static boolean  fnDeleteFolder(String Path, String folderName){
        boolean blnStatus = false;
        try{
            File file  = new File(Path+"/"+folderName);
            if(!file.exists()){
                System.out.println("Folder was created !");
            }
            else {
               file.delete();
               blnStatus=true;

            }
        }catch (Exception e){}
        return blnStatus;

    }

    public static File  fnGetNewestFile(String filePath){
        File directory=new File(filePath);
        File[] files = directory.listFiles();
        if(files.length==0) return null;
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return new Long(o2.lastModified()).compareTo(o1.lastModified());
            }
        });
        return files[0];
    }

    public static boolean fnCopyToCICD(){
        boolean blnStatus = false;
        try {
            System.out.println("Copy to CICD Folder");
            String strSourcePath = FileUtilities.fnGetCurrentUserDir()+"/Reports";
            File objFile = FileUtilities.fnGetNewestFile(strSourcePath);
            String strFilePath = FileUtilities.fnGetCurrentUserDir()+"/Reports"+objFile.getName()+"/ExtentReport.html";
            String strDestination =  FileUtilities.fnGetCurrentUserDir()+"/CICDReport";
            FileUtilities.fnDeleteFolder(strDestination, "ExtentReport.html");
            FileUtils.copyFile(new File(strFilePath),new File(strDestination+"/ExtentReport.html"));
        }
        catch (Exception e){}
        return blnStatus;
    }

    public static String fnGetGlobalValueFromPOM(String strPOMProperties){
        try{
            return System.getProperty(strPOMProperties);
        }
        catch(Exception e) {
            return null;
        }
    }

    public static String fnGetGlobalValueFromGlobalConfig(String strGlobalConfig){
        try{
            Properties prop = new Properties();
            String strFilePath="./src/main/resources/GlobalConfig.properties";
            prop.load(new FileInputStream(strFilePath));
            return prop.getProperty(strGlobalConfig);
        } catch (Exception e) {
            return null;
        }
    }

    public static String GetValueFromPropOrPOM(String strData)
    {
        String strValue="";
        if(FileUtilities.fnGetGlobalValueFromPOM(strData)!=null)
            strValue=FileUtilities.fnGetGlobalValueFromPOM(strData);
        else
            strValue=FileUtilities.fnGetGlobalValueFromGlobalConfig(strData);
        return strValue;
    }

    public static void createJsonFile(String location, String jsonContent){
        try(FileWriter fileWriter = new FileWriter(location)) {
            fileWriter.write(jsonContent);
            System.out.println("JSON file created successfully at: " + location);
        } catch (IOException e){
            e.printStackTrace();
            System.err.println("Error creating JSON file at: "+ location);
        }
    }

    public static List<String> fnGetJSONData(String strJSONData, String strPath){
        List<String> arrList = new ArrayList<>();
        try{
            Object result = readJsonWithJsonPath(strJSONData, strPath);
            if(result instanceof Iterable){
                for (Object element : (Iterable<?>) result){
                    arrList.add(element.toString());
                }
            }
            else{
                arrList.add(result.toString());
            }
        }
        catch (Exception e){
            return arrList;
        }
        return arrList;
    }

    public static Object readJsonWithJsonPath (String jsonString, String jsonPathExpression){
        return JsonPath.read(jsonString, jsonPathExpression);
    }

}
