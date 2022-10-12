package techconditions.parameters;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("automatCurrentBean")
@Scope("prototype")
public class AutomatCurrent {

    private String automatCurrent;

    public String getAutomatCurrent() {
        return automatCurrent;
    }

    public AutomatCurrent() {
        this.automatCurrent = findAutomatCurrent(PdfToStringTranslator.getFullDocumentString());
    }

    private static String findAutomatCurrent(String string){

        //If automatCurrent is in point 10.3.1
        String point10_3_1 = findPoint10_3_1(string);
        if (findAutomatCurrentValue(point10_3_1) != null) {
            return findAutomatCurrentValue(point10_3_1);
        }

        //If automatCurrent is in point 10.1.2
        String point10_1_2 = findPoint10_1_2(string);
        if (findAutomatCurrentValue(point10_1_2) != null) {
            return findAutomatCurrentValue(point10_1_2);
        }

        //If automatCurrent is in point 10.3.2
        String point10_3_2 = findPoint10_3_2(string);
        if (findAutomatCurrentValue(point10_3_2) != null) {
            return findAutomatCurrentValue(point10_3_2);
        }

        //If automatCurrent is in point 10.2.1
        String point10_2_1 = findPoint10_2_1(string);
        if (findAutomatCurrentValue(point10_2_1) != null) {
            return findAutomatCurrentValue(point10_2_1);
        }

        return "нет данных";

    }

    private static String findPoint10_3_1(String string){
        int beginIndex = (string.indexOf("10.3.1.")) + ("10.3.1.").length();
        if (beginIndex < 0) {return "";}
        int endIndex = string.substring(beginIndex).indexOf(" 11. ");
        if (endIndex < 0) return "";
        String result = string.substring(beginIndex, beginIndex + endIndex);
        return result;
    }

    private static String findPoint10_1_2(String string){
        int beginIndex = (string.indexOf("10.1.2.")) + ("10.1.2.").length();
        if (beginIndex < 0) {return "";}
        int endIndex = string.substring(beginIndex).indexOf(" 10.2. ");
        if (endIndex < 0) return "";
        String result = string.substring(beginIndex, beginIndex + endIndex);
        return result;
    }

    private static String findPoint10_3_2(String string){
        int beginIndex = (string.indexOf("10.3.2.")) + ("10.3.2.").length();
        if (beginIndex < 0) {return "";}
        int endIndex = string.substring(beginIndex).indexOf(" 11. ");
        if (endIndex < 0) return "";
        String result = string.substring(beginIndex, beginIndex + endIndex);
        return result;
    }

    private static String findPoint10_2_1(String string){
        int beginIndex = (string.indexOf("10.2.1.")) + ("10.2.1.").length();
        if (beginIndex < 0) {return "";}
        int endIndex = string.substring(beginIndex).indexOf(" 10.3. ");
        if (endIndex < 0) return "";
        String result = string.substring(beginIndex, beginIndex + endIndex);
        return result;
    }

    private static String findAutomatCurrentValue(String point) {
        if(point.indexOf("на ток ") < 0) {
            return null;
        } else {
            int beginIndex = (point.indexOf("на ток ")) + ("на ток ").length();
            int endIndex = point.substring(beginIndex).indexOf("А");
            if (endIndex < 0) return "";
            String result = point.substring(beginIndex, beginIndex + endIndex + 1);
            return result;
        }
    }
}
