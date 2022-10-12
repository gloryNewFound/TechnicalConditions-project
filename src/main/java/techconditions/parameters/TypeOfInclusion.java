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
        if (point10_3_1.indexOf("прямо") > 0) {
            return "прямого включения";
        } else if (point10_3_1.indexOf("косвен") > 0) {
            return "косвенного включения";
        } else {
            return "нет данных";
        }
//        int beginIndex = point10_3_1.indexOf("фазный") + 7;
//        int endIndex = point10_3_1.substring(beginIndex).indexOf("включения") + 9;
//        String result = point10_3_1.substring(beginIndex, beginIndex + endIndex);

    }

    private String findPoint10_3_1(String stringForParsing){
        int beginIndex = (stringForParsing.indexOf("10.3.1. "));
        if (beginIndex < 0) return "";
        int endIndex = stringForParsing.substring(beginIndex).indexOf("11. ");
        if (endIndex < 0) return "";
        return stringForParsing.substring(beginIndex, beginIndex + endIndex);
    }
}
