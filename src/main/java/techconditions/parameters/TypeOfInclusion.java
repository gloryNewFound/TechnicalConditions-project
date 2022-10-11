package techconditions.parameters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("typeOfInclusionBean")
@Scope("prototype")
public class TypeOfInclusion {

    private String typeOfInclusion;

    public String getTypeOfInclusion() {
        return typeOfInclusion;
    }

    public TypeOfInclusion() {
        this.typeOfInclusion = findTypeOfInclusion(PdfToStringTranslator.getFullDocumentString());
    }

    private String findTypeOfInclusion(String stringForParsing){
        String point10_3_1 = findPoint10_3_1(stringForParsing);
        int beginIndex = point10_3_1.indexOf("фазный") + 7;
        int endIndex = point10_3_1.substring(beginIndex).indexOf("включения") + 9;
        String result = point10_3_1.substring(beginIndex, beginIndex + endIndex);
        return result;
    }

    private String findPoint10_3_1(String stringForParsing){
        int beginIndex = (stringForParsing.indexOf("10.3.1. "));
        int endIndex = stringForParsing.substring(beginIndex).indexOf("11. ");
        String point10_3_1 = stringForParsing.substring(beginIndex, beginIndex + endIndex);
        return point10_3_1;
    }
}
