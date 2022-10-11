package techconditions.parameters;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("numberOfContractBean")
@Scope("prototype")
public class NumberOfContract {

    private String numberOfContract;

    public String getNumberOfContract() {
        return numberOfContract;
    }

    public NumberOfContract() {
        this.numberOfContract = findNumberOfContract(PdfToStringTranslator.getFullDocumentString());
    }

    private static String findNumberOfContract(String string){
        int beginIndex = (string.indexOf("РЭС № ")) + ("РЭС № ").length();
        int endIndex = string.substring(beginIndex).indexOf("«");
        String result = string.substring(beginIndex, beginIndex + endIndex);
        int checkIndex = result.toLowerCase().indexOf("технич");
        if (checkIndex > 0) {
            result = result.substring(0, checkIndex);
        }
        return result;
    }
}
