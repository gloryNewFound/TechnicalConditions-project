package techconditions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import techconditions.parameters.*;

import java.io.File;

@Component("techConditionDocumentBean")
@Scope("prototype")
public class TechConditionDocument {
    private int counter;
    private File file;
    private AddressAndKadastr addressAndKadastr;
    private Res res;
    private FullName fullName;
    private NumberOfContract numberOfContract;
    private PointSevenOne pointSevenOne;
    private AutomatCurrent automatCurrent;
    private Tariff tariff;
    private Phase phase;
    private TypeOfInclusion typeOfInclusion;
    private Power power;

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getFile() {
        return file.getName();
    }

    public void setFile(File file) {
        this.file = file;
    }


    public AddressAndKadastr getAddressAndKadastr() {
        return addressAndKadastr;
    }

    @Autowired
    @Qualifier("addressAndKadastrBean")
    public void setAddressAndKadastr(AddressAndKadastr addressAndKadastr) {
        this.addressAndKadastr = addressAndKadastr;
    }

    public String getRes() {
        return res.getRES();
    }

    @Autowired
    @Qualifier("resBean")
    public void setRes(Res res) {
        this.res = res;
    }

    public String getFullName() {
        return fullName.getFullName();
    }

    @Autowired
    @Qualifier("fullNameBean")
    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public String getNumberOfContract() {
        return numberOfContract.getNumberOfContract();
    }

    @Autowired
    @Qualifier("numberOfContractBean")
    public void setNumberOfContract(NumberOfContract numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    public String getPointSevenOne() {
        return pointSevenOne.getPointSevenOne();
    }

    @Autowired
    @Qualifier("pointSevenOneBean")
    public void setPointSevenOne(PointSevenOne pointSevenOne) {
        this.pointSevenOne = pointSevenOne;
    }

    public String getAutomatCurrent() {
        return automatCurrent.getAutomatCurrent();
    }

    @Autowired
    @Qualifier("automatCurrentBean")
    public void setAutomatCurrent(AutomatCurrent automatCurrent) {
        this.automatCurrent = automatCurrent;
    }

    public String getTariffFrom10() {
        return tariff.getTariffFrom10();
    }


    public String getTariffFrom19() {
        return tariff.getTariffFrom19();
    }

    @Autowired
    @Qualifier("tariffBean")
    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public String getPhase() {
        return phase.getPhase();
    }

    @Autowired
    @Qualifier("phaseBean")
    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public String getTypeOfInclusion() {
        return typeOfInclusion.getTypeOfInclusion();
    }

    @Autowired
    @Qualifier("typeOfInclusionBean")
    public void setTypeOfInclusion(TypeOfInclusion typeOfInclusion) {
        this.typeOfInclusion = typeOfInclusion;
    }

    public String getPower() {
        return power.getPower();
    }

    @Autowired
    @Qualifier("powerBean")
    public void setPower(Power power) {
        this.power = power;
    }
}
