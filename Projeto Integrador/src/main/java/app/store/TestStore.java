package app.store;

import app.domain.model.Client;
import app.domain.model.Test;
import app.domain.model.TestReport;
import app.ui.console.ChooseLabUI;
import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class allows the creation of a Test Store.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class TestStore {

    /**
     * A list designed to contain objects of the Test class
     */
    private final List<Test> testList;

    /**
     * The number that will initialize the sequential code
     */
    long n = 1;

    /**
     * Initializes a new testList, while also assigning it an empty array list where the tests will be stored
     */
    public TestStore() {
        this.testList = new ArrayList<>();
    }


    /**
     * Method that returns a new Test with the attribute given as a parameter
     *
     * @param nhsCode the National Healthcare Service Code of the Test
     * @return a Test with the attributes given by parameter
     */
    public Test createTest(String nhsCode) {
        return new Test(nhsCode);
    }

    /**
     * Method to validate the Test in a global way
     *
     * @param test the Test to be validated
     * @return the boolean result of the Test validation
     */
    public boolean validateTest(Test test) {
        if (test == null)
            return false;
        return !this.testList.contains(test);
    }

    /**
     * Allows the addition of an validated Test object to the the Test List
     *
     * @param test An existing Test object
     * @return a boolean statement, true if the test  was added successfully to the test list, false if not
     */
    public boolean saveTest(Test test) {
        if (validateTest(test)) {
            String code = nextCode(n);
            n++;
            String createdAt= Utils.currentDate();
            test.setCode(code);
            test.setCreatedAt(createdAt);
            return testList.add(test);
        }
        return false;
    }

    /**
     * The Method that returns the list of Tests without Samples.
     *
     * @return the Test List without Samples.
     */
    public List<Test> getTestsWithoutSamplesList() {
        List<Test> testWithoutSamples = new ArrayList<>();
        for (Test test : testList) {
            if (!test.hasSamples() &&
                    ChooseLabUI.getRegisterTestController().getClinicalAnalysisLaboratory().equals(test.getClinicalAnalysisLaboratory())) {
                testWithoutSamples.add(test);
            }
        }
        return testWithoutSamples;
    }

    /**
     * The method that returns the Test without Sample in that index.
     *
     * @param index index chosen by the User.
     * @return Test chosen by index.
     */
    public Test getTestToBeSampledByIndex(int index){
        return getTestsWithoutSamplesList().get(index);
    }

    /**
     * The method that save a Test With Samples, but return a boolean value.
     *
     * @param test Test that will be saved with Samples.
     * @return True if the Test is saved, false if not.
     */
    public boolean saveTestWithSamples(Test test){
        if(!validatesTestWithSamples(test)){
            return false;
        }
        return getTestsWithoutSamplesList().add(test);
    }

    /**
     * The method that validates a Test with Sample, but return a boolean value.
     *
     * @param test Test that will be saved with Samples.
     * @return rue if the Test is validated, false if not.
     */
    public boolean validatesTestWithSamples(Test test){
        if(test== null){
            return false;
        }
        return !test.hasSamples();
    }

    /**
     * The method that return the List of Tests that have already a result.
     *
     * @return The List of Tests that have a result.
     */
    public List<Test> getTestWithResultList(){
        List<Test> testsWithResultList = new ArrayList<>();
        for(Test test : testList){
            if(test.hasResults() && !test.hasReport()){
                testsWithResultList.add(test);
            }
        }
        return testsWithResultList;
    }

    /**
     * Method that returns the list of Tests with Report and without validation.
     *
     * @return the Test List with Report.
     */
    public List<Test> getTestsWithReportList() {
        List<Test> testWithReportList = new ArrayList<>();
        for (Test test : testList) {
            if (test.hasReport() && !test.hasValidation()) {
                testWithReportList.add(test);
            }
        }
        return testWithReportList;
    }

    /**
     * Method that returns the Test that contains the nhsCode given as parameter.
     *
     * @param nhsCode the National Healthcare Service Number of the Test.
     * @return the Test that contains the given nhsCode.
     */
    public Test getTestByNhsCode(String nhsCode) {
        for (Test test : testList) {
            if (test.getNhsCode().equals(nhsCode)) {
                return test;
            }
        }
        return null;
    }

    /**
     * Allows the Store to save a Test Report on the Test.
     * The Store will start by validating the Test Report, and after that, it will associate the Test Report to
     * the Test and set the Report Date to the current one.
     *
     * @param test Test that will contain the Test Report.
     * @param testReport Test Report that will be associated to the Test.
     * @return Boolean value that represents if the Test Report was saved or not.
     */
    public boolean saveTestReport(Test test, TestReport testReport){
        if(! validateTestReport(testReport)){
            return false;
        }
        else{
            test.addTestReport(testReport);
            test.addReportDate();
            return true;
        }
    }

    /**
     * Allows the Store to validate the Test Report that was made by the Specialist Doctor.
     *
     * @param testReport Test Report to be validated.
     * @return Boolean value that represents if the Test Report was validated or not.
     */
    private boolean validateTestReport(TestReport testReport){
        return testReport != null;
    }

    /**
     * Method that returns the boolean Value of the addition of a Test to a Client.
     *
     * @param client the Client that the test will be added to.
     * @param test the Test that will be added.
     * @return the Boolean value of the operation.
     */
    public boolean addTestToClient(Client client, Test test){
        return client.addTest(test);
    }

    /**
     * Method that returns the sequential code.
     *
     * @param n the test number.
     * @return the String with the code.
     */
    public String nextCode(long n){
        String s;
        s=String.format("%012d",n);
        return s;
    }

    /**
     * The method that return the Test Store.
     *
     * @return Test Store.
     */
    public List<Test> getStore(){
        List<Test> copy = this.testList;
        return copy;
    }

    /**
     * The method that return the Test by Barcode.
     *
     * @param barcode Barcode of the Test.
     * @return A Test by their barcode.
     */
    public Test getTestByBarcode(String barcode) {
        for (Test t : testList) {
            if (t.hasSamples() && !t.hasResults() && t.isBarcodeInSampleList(barcode)) {
                return t;
            }
        }
        throw new IllegalArgumentException("No test with a sample with the supplied barcode found");
    }

    /**
     * Method that returns if in the Client list exists someone with the Email given by parameter.
     *
     * @param nhsCode the NHS code given as a parameter.
     * @return the boolean result of the list containing this NHS code.
     */
    public boolean containsNhsCode(String nhsCode) {
        for (Test test : testList) {
            if (nhsCode.equals(test.getNhsCode())) {
                return true;
            }
        }
        return false;
    }
}
