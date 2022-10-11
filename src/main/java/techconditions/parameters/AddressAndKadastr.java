package techconditions.parameters;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.PdfToStringTranslator;

@Component("addressAndKadastrBean")
@Scope("prototype")
public class AddressAndKadastr {
    private String address;
    private String kadastr;

    public AddressAndKadastr() {
        String addressAndKadastr = findAddressAndKadastr(PdfToStringTranslator.getFullDocumentString()); //It is a string which was get from PDF by PDFParser class
        this.kadastr = findKadastr(addressAndKadastr);
        this.address = findAddress(addressAndKadastr, kadastr.length());

    }

    public String getAddress() {
        return address;
    }

    public String getKadastr() {
        return kadastr;
    }

    private String findAddressAndKadastr(String documentText){
        String point = findPoint(documentText);
        int beginIndex = (point.indexOf("заявителя: ")) + ("заявителя: ").indexOf(" ") + 1;
        String addressAndKadastr = point.substring(beginIndex);
        return addressAndKadastr;
    }

    private String findPoint(String string) {
        int beginIndex = (string.indexOf("2. Наименование"))
                + ("2. Наименован").indexOf(":") + 1;
        int endIndex = string.substring(beginIndex).indexOf(". 3");
        String point = string.substring(beginIndex, beginIndex + endIndex);
        return point;
    }



    public String findAddress(String documentText, int kadastrSize) {
        String addressWithoutKadastr = documentText.replaceAll(" кадастровый номер:", "");
        String address = addressWithoutKadastr.substring(0, addressWithoutKadastr.length() - kadastrSize - 1);
        return address;

    }

    public String findKadastr(String addressAndKadastr) {
        String[] strings = addressAndKadastr.split(" ");
        String kadastr = strings[strings.length - 1];
        return kadastr;
    }

}
