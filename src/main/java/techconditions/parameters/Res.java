package techconditions.parameters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("resBean")
@Scope("prototype")
public class Res {

    private String RES;

    public String getRES() {
        return RES;
    }

    public Res() {
        this.RES = findRES(PdfToStringTranslator.getFullDocumentString()); //It is a string which was get from PDF by PDFParser class
    }

    private static String findRES(String string){

        int endIndex = string.indexOf(" РЭС ");
        String substr = string.substring(0, endIndex);
        int beginIndex = (string.indexOf(" ")) + 1;
        String[] stringsArray = substr.substring(beginIndex).split(" ");
        String result = stringsArray[stringsArray.length - 1];
        return result;
    }
}
