package techconditions.parameters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("phaseBean")
@Scope("prototype")
public class Phase {
    private String phase;

    public String getPhase() {
        return phase;
    }

    public Phase() {
        this.phase = findPhase(PdfToStringTranslator.getFullDocumentString());
    }

    private String findPhase(String stringForParsing) {
        String phase;
        String point = parsePoint10(stringForParsing);
        if (point.indexOf("днофазный") > 0) {
            phase = "1";
        } else if (point.indexOf("рехфазный") > 0) {
            phase = "3";
        } else {
            phase = "нет данных";
        }
        return phase;
    }

    private static String parsePoint10(String stringForParsing) {
        int beginIndex = (stringForParsing.indexOf("10.1. "));
        int endIndex = stringForParsing.substring(beginIndex).indexOf("11. ");
        String findPoint10_3_1 = stringForParsing.substring(beginIndex, beginIndex + endIndex);
        return findPoint10_3_1;
    }
}
