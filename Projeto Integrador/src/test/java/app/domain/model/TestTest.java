package app.domain.model;

import app.domain.shared.Constants;
import app.list.AdapterEnum;
import app.store.TestStore;
import app.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

 /**
  * @author Luís Ribeiro <1201184@isep.ipp.pt>
  * @author Pedro Graça <1201188@isep.ipp.pt>
  * @author Miguel Ramos <1201247@isep.ipp.pt>
  * @author André Soares <1201314@isep.ipp.pt>
  */
public class TestTest {

    @Test
    public void checkNhsCodeRulesSuccess(){
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNhsCodeRulesBlank() {
        app.domain.model.Test test = new app.domain.model.Test("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNhsCodeRulesLess() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890a");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNhsCodeRulesGreat(){
        app.domain.model.Test test = new app.domain.model.Test("1234567890aaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNhsCodeRulesNotAlphanumeric(){
        app.domain.model.Test test = new app.domain.model.Test("1234567890a-");
    }

    @Test
    public void checkRulesCodeAlphaNumeric() {
    }

    @Test
    public void setCode() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        TestStore tStore= new TestStore();
        String code=tStore.nextCode(1);
        String expected = "000000000001";

        test.setCode(code);
        String result= test.getCode();

        assertEquals(expected,result);
    }

    @Test
    public void setCreatedAt() {
    }

    @Test
    public void setSampleDate() {
    }

    @Test
    public void getNhsCode() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        String expected = "1234567890aa";

        String result = test.getNhsCode();

        assertEquals(expected,result);
    }

    @Test
    public void getTestParameterByCode() {
    }

    @Test
    public void getTestParameterList() {
    }

    @Test
    public void hasResults() {
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        test.addTestResultDate();

        boolean result = test.hasResults();

        Assert.assertTrue(result);
    }

    @Test
    public void hasReport() {

        app.domain.model.Test t=new app.domain.model.Test("123456789012");
        t.addReportDate();

        boolean result=t.hasReport();

        Assert.assertTrue(result);
    }

    @Test
    public void hasValidation() {
        app.domain.model.Test t=new app.domain.model.Test("123456789012");
        t.validateTest();

        boolean result=t.hasValidation();

        Assert.assertTrue(result);
    }

    @Test
    public void hasSamples() {
        app.domain.model.Test t=new app.domain.model.Test("123456789012");
        t.setSampleDate();

        boolean result=t.hasSamples();

        Assert.assertTrue(result);
    }

    @Test
    public void getParametersAssociatedWithTest() {
    }

    @Test
    public void addTestReport() {
        String text = "This is a simulation of a Test Report.";
        String code = "000000000001";
        String name = "Specialist Doctor";
        String email = "specialistDoctor@test.com";

        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        test.addTestReport(new TestReport(text, code, name, email));


        String expected = String.format("%s%n %s%n Written by: %s | E-mail: %s", test.getTestReport().getHeader(), text,
                name, email);
        Assert.assertEquals(expected, test.getTestReport().toString());
    }

    @Test
    public void addReportDate() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        test.addReportDate();
        Assert.assertNotNull(test.getReportDate());
    }

    @Test
    public void getResultDate() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        test.addTestResultDate();
        String result=test.getResultDate();
        String expected= Utils.currentDate();
        Assert.assertEquals(result,expected);

    }

    @Test
    public void getReportDate() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        test.addReportDate();
        String result=test.getReportDate();
        String expected= Utils.currentDate();
        Assert.assertEquals(result,expected);
    }

    @Test
    public void getCreatedAt() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        test.setCreatedAt(Utils.currentDate());
        String result=test.getCreatedAt();
        String expected= Utils.currentDate();
        Assert.assertEquals(result,expected);
    }

    @Test
    public void getSampleDate() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        test.setSampleDate();
        String result=test.getSampleDate();
        String expected= Utils.currentDate();
        Assert.assertEquals(result,expected);
    }

    @Test
    public void getTestType() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        TestType testtype=new TestType("12345","method","description");
        test.saveTestType(testtype);
        TestType result=test.getTestType();

        Assert.assertEquals(result,testtype);
    }

    @Test
    public void saveClinicalAnalysisLaboratory() {
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Caxinas","LabCax",
                "12345678912","1234567891");
        test.saveClinicalAnalysisLaboratory(c);
        ClinicalAnalysisLaboratory result=test.getClinicalAnalysisLaboratory();

        Assert.assertEquals(result,c);


    }

    @Test
    public void saveTestType() {
    }

    @Test
    public void addTestParameter() {
    }

    @Test
    public void addSampleToTest() {
        Sample sample=new Sample();
        app.domain.model.Test test = new app.domain.model.Test("1234567890aa");
        test.addSampleToTest(sample);
        List<Sample> sampleList=test.getSampleList();
        boolean b=false;
        for (Sample s:sampleList) {
            if (s.equals(sample)) {
                b = true;
                break;
            }
        }
        Assert.assertTrue(b);
    }

    @Test
    public void getCode() {
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        String expected = "Unknown";

        Assert.assertEquals(expected, test.getCode());
    }

    @Test
    public void isBarcodeInSampleList() {
    }

    @Test
    public void addTestResult() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        app.domain.model.Test test = new app.domain.model.Test("123456789012");

        TestType tt=new TestType("12349","method","description");
        tt.setAdapterAddress(AdapterEnum.EXTERNAL_MODULE_BLOOD2.getAdapterAddress());
        test.saveTestType(tt);
        Parameter p3 = new Parameter("ESR00","ESR","paramESR");
        test.addTestParameter(p3);
        test.addTestResult("ESR00",2);
        TestParameter tp=test.getTestParameterByCode(0);
        Assert.assertNotNull(tp.getTestResult());

    }

    @Test
    public void addTestResultDate() {
    }
}