package techconditions.parameters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("powerBean")
@Scope("prototype")
public class Power {

    private String power;

    public String getPower() {
        return power;
    }

    public Power() {
        this.power = findPower(PdfToStringTranslator.getFullDocumentString());
    }

    private static String findPower(String string){
        int beginIndex = (string.indexOf("устройств заявителя составляет: ")) + ("устройств заявителя составляет: ").length();
        int endIndex = string.substring(beginIndex).indexOf("4. ");
        String result = string.substring(beginIndex, beginIndex + endIndex);
        return result;
    }
}
