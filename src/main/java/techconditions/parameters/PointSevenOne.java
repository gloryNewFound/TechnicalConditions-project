package techconditions.parameters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("pointSevenOneBean")
@Scope("prototype")
public class PointSevenOne {

    private String pointSevenOne;

    public String getPointSevenOne() {
        return pointSevenOne;
    }

    public PointSevenOne() {
        this.pointSevenOne = findPointSevenOne(PdfToStringTranslator.getFullDocumentString());
    }

    private static String findPointSevenOne(String string){
        int beginIndex = (string.indexOf("7.1. ")) + ("7.1. ").length();
        int endIndex = string.substring(beginIndex).indexOf(" 8. ");
        //System.out.println(beginIndex + " " + endIndex);
        String result = string.substring(beginIndex, beginIndex + endIndex);
        return result;
    }
}
