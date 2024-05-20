package org.example.pages;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
