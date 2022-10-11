package techconditions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {

    private static String currentDirectory = "C:\\Users\\dvn\\Projects\\Technical Conditions\\Test folder";

    private static List<File> documents = new ArrayList<>();

    private static List<TechConditionDocument>  techConditionDocuments = new ArrayList<>();

    private static String fullDocumentString;
    public static void main(String[] args) {

        for (File file: FileSearcher.addAllFilesInThisDirectory(currentDirectory)) {
            if (file.getName().endsWith(".pdf")) {
                documents.add(file);
            }
        }

    }
}
