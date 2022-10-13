package techconditions;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TestClass {

    private static String currentDirectory = "C:\\Users\\dvn\\Downloads\\Telegram Desktop\\2022.09.14-1";

    private static List<File> documents = new ArrayList<>();

    private static List<TechConditionDocument>  techConditionDocuments = new ArrayList<>();

    private static String fullDocumentString;

    public static void main(String[] args) {

        for (File file: FileSearcher.addAllFilesInThisDirectory(currentDirectory)) {
            if (file.getName().endsWith(".pdf")) {
                documents.add(file);
            }
        }

        XLSFileCreator.createXLSXFile(currentDirectory); //Creation of Excel file

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        //Create TechConditionDocumentBean for each found file
        int counter = 0;
        for (File file: documents) {
            fullDocumentString = PdfToStringTranslator.getFullDocumentString(file);
//            System.out.println(fullDocumentString);
            System.out.println("Checking: " + file.getName());
            if (PdfToStringTranslator.ifItIsTechConditionFile(fullDocumentString)) {
                TechConditionDocument document = context.getBean("techConditionDocumentBean", TechConditionDocument.class);
                document.setFile(file);
                document.setCounter(++counter); //Counting of the parsed documents
                techConditionDocuments.add(document);
                System.out.println("Row number " + XLSFileCreator.getRowNumber() + " written");
                XLSFileCreator.fillFields(document, currentDirectory); //Fill a row in the Excel file with the TechConditionDocument
            }
        }
        context.close();

    }
}
