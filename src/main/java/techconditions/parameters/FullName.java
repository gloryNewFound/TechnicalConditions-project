package techconditions.parameters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("fullNameBean")
@Scope("prototype")
public class FullName {
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public FullName() {
        this.fullName = findFullName(PdfToStringTranslator.getFullDocumentString());
    }

    private static String findFullName(String string){
        String stringWithFullName = findPartWithFullName(string);
        String[] stringsArray = stringWithFullName.split(" ");
        String result = stringsArray[stringsArray.length - 3] +
                " " + stringsArray[stringsArray.length - 2] +
                " " + stringsArray[stringsArray.length - 1];
        return result;
    }

    private static String findPartWithFullName(String string){
        int beginIndex = (string.indexOf("ПАО «Россети Московский регион»")) + ("ПАО «Россети Московский регион»").length();
        int endIndex = string.substring(beginIndex).indexOf("1. ");
        //System.out.println(beginIndex + " " + endIndex);
        String result = string.substring(beginIndex, beginIndex + endIndex);
        return result;
    }
}
