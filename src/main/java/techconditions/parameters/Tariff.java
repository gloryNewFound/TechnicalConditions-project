package techconditions.parameters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("tariffBean")
@Scope("prototype")
public class Tariff {

    private String tariffFrom10;
    private String tariffFrom19;

    public String getTariffFrom10() {
        return tariffFrom10;
    }

    public String getTariffFrom19() {
        return tariffFrom19;
    }

    public Tariff() {
        this.tariffFrom10 = findTariffFromPoint10(PdfToStringTranslator.getFullDocumentString());
        this.tariffFrom19 = findTariffFromPoint19(PdfToStringTranslator.getFullDocumentString());
    }

    private static String findTariffFromPoint10(String stringForParsing) {
        String point10 = parsePoint10(stringForParsing);
        String tariff;
        if (point10.indexOf("днотарифный") > 0) {
            tariff = "1";
        } else if (point10.indexOf("ноготарифный") > 0) {
            if (point10.indexOf("двум") > 0) {
                tariff = "2";
            } else if (point10.indexOf("трем") > 0) {
                tariff = "3";
            } else {
                tariff = "нет данных";
            }

        } else {
            tariff = "нет данных";
        }
        return tariff;
    }

    private static String parsePoint10(String stringForParsing) {
        int beginIndex = (stringForParsing.indexOf("10.1. "));
        if (beginIndex < 0) return "отсутствует";
        int endIndex = stringForParsing.substring(beginIndex).indexOf("11. ");
        if (endIndex < 0) return "отсутствует";
        String findPoint10_3_1 = stringForParsing.substring(beginIndex, beginIndex + endIndex);
        return findPoint10_3_1;
    }

    private static String findTariffFromPoint19(String stringForParsing){
        String point19 = findPoint19(stringForParsing);
        String tariff;
        if (point19.equals("отсутствует")) {
            tariff = "19 Пункт отсутствует";
        } else {
            if ( (point19.indexOf("без дифференц.") > 0) || (point19.indexOf("1 ценовая категория") > 0) ){
                tariff = "1";
            } else if ( (point19.indexOf("двум") > 0) || (point19.indexOf("2 ценовая категория") > 0) ) {
                tariff = "2";
            } else if ( (point19.indexOf("трем") > 0) || (point19.indexOf("3 ценовая категория") > 0 ) ) {
                tariff = "3";
            } else {
                tariff = "нет данных";
            }
        }

        return tariff;
    }

    private static String findPoint19(String stringForParsing) {
        String point19;
        if (stringForParsing.indexOf("19. ") > 0) {
            int beginIndex = (stringForParsing.indexOf("19. "));
            if (beginIndex < 0) return "отсутствует";
            int endIndex = stringForParsing.substring(beginIndex).indexOf("19.1. ");
            if (endIndex < 0) return "отсутствует";
            point19 = stringForParsing.substring(beginIndex, beginIndex + endIndex);
        } else {
            point19 = "отсутствует";
        }

        return point19;
    }

}
