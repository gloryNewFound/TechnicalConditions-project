package techconditions;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<File> documents = new ArrayList<>();

    private static List<TechConditionDocument>  techConditionDocuments = new ArrayList<>();

    private static String fullDocumentString;

    public static void main(String[] args) {

        String currentDirectory = ".";

        //Get all the files in this directory
        for (File file: FileSearcher.addAllFilesInThisDirectory(currentDirectory)) {
            if (file.getName().endsWith(".pdf")) {
                documents.add(file);
            }
        }

        XLSFileCreator.createXLSXFile(currentDirectory);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        //Create TechConditionDocumentBean for each found file
        int counter = 0;
        for (File file: documents) {
            fullDocumentString = PdfToStringTranslator.getFullDocumentString(file);

            if (PdfToStringTranslator.ifItIsTechConditionFile(fullDocumentString)) {
                TechConditionDocument document = context.getBean("techConditionDocumentBean", TechConditionDocument.class);
                document.setFile(file);
                document.setCounter(++counter);
                techConditionDocuments.add(document);
                System.out.println("Filling row number " + XLSFileCreator.getRowNumber());
                XLSFileCreator.fillFields(document, currentDirectory); //Fill Excel file with the TechConditionDocument
            }
        }
        context.close();
    }

}
