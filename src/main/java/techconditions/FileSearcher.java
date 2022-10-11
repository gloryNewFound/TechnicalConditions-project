package techconditions;

import java.io.File;


public abstract class FileSearcher {

    //Searches all the files to be added into the list
    public static File[] addAllFilesInThisDirectory(String path) {
            File directory = new File(path);
            File[] files = directory.listFiles();
            return files;
    }

//    public static boolean ifItIsTechConditionFile(String text) {
//            return text.toLowerCase().indexOf("технические условия") > 0 ? true : false;
//    }

}

