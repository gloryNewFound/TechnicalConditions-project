package techconditions;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public abstract class PdfToStringTranslator {

    private static String fullDocumentString;

    public static String getFullDocumentString() {
        return fullDocumentString;
    }

    //Returns PDF file in String format
    public static String getFullDocumentString(File file) {

        String text = null;

        try {
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            text = pdfTextStripper.getText(document);
        } catch (IOException e) {
            System.out.println("******************************************************************");
            System.out.println("Exception in pdf to string translation: " + e.getStackTrace());
            System.out.println("Exception in file: " + file.getName());
            System.out.println("******************************************************************");
            text = "";
        }
        //Deleting extra-spaces
        fullDocumentString = text.replaceAll("[\\s]{2,}", " ");

        return fullDocumentString;
    }

        public static boolean ifItIsTechConditionFile(String text) {
            return text.toLowerCase().indexOf("технические условия") > 0 ? true : false;
    }

}
