package app.domain.model;

import app.utils.Utils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class allows the initialization of the Test and its attributes.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class Test {

    /**
     * Code/Number of the Test.
     */
    private String code;

    /**
     * NHS Code of the Test.
     */
    private final String nhsCode;

    /**
     * Date of the day when the Receptionist registered the Test.
     */
    private String createdAt;

    /**
     * Date of the day when the Sample was created.
     */
    private String sampleDate;

    /**
     * Date of the day when the Result of the Test was created.
     */
    private String resultDate;

    /**
     * Date of the day when the Test Report was created.
     */
    private String reportDate;

    /**
     * Test Report of the Test.
     */
    private TestReport testReport;

    /**
     * Test Validation of the Test (represents the validation of the Test).
     */
    private TestValidation testValidation;

    /**
     * Clinical Analysis Laboratory where the Test was performed.
     */
    private ClinicalAnalysisLaboratory clinicalAnalysisLaboratory;

    /**
     * Test Type of the Test.
     */
    private TestType testType;

    /**
     * Code by omission of the Test.
     */
    private static final String CODE_BY_OMISSION = "Unknown";

    /**
     * Date of the creation of the Test by omission.
     */
    private static final String CREATED_AT_BY_OMISSION = "Unknown";

    /**
     * Constant that allows the System to check if the NHS Code is within the rules.
     */
    private static final int NHS_RULE = 12;

    /**
     * List of the Test Parameters of the Test.
     */
    private final List<TestParameter> testParameterList = new ArrayList<>();

    /**
     * List of the Samples used by the Test.
     */
    private final List<Sample> sampleList = new ArrayList<>();

    /**
     * Allows to create a Test by using its NHS Code.
     *
     * @param nhsCode NHS Code of the Test.
     */
    public Test(String nhsCode) {
        checkNhsCodeRules(nhsCode);
        this.nhsCode = nhsCode;
        this.code = CODE_BY_OMISSION;
        this.createdAt = CREATED_AT_BY_OMISSION;
        this.sampleDate = null;
        this.reportDate = null;
        this.testValidation = null;
        this.resultDate = null;
    }

    /**
     * Method to check if the National Healthcare Service code given as a parameter is valid
     *
     * @param nhsCode the National Healthcare Service Number that will be checked
     */
    public void checkNhsCodeRules(String nhsCode) {
        if (StringUtils.isBlank(nhsCode))
            throw new IllegalArgumentException("NHS Code cannot be blank.");
        if ((nhsCode.length() != NHS_RULE))
            throw new IllegalArgumentException("NHS Code must have 12 characters.");
        if (!checkRulesCodeAlphaNumeric(nhsCode))
            throw new IllegalArgumentException("NHS Code must be Alphanumeric.");
    }

    /**
     * Allows the verification if there is only letters and numbers in a String
     *
     * @param nhsCode string containing a nhsCode that identifies a Test
     * @return boolean statement,true if there is only letters and numbers in the code false if not
     */
    public boolean checkRulesCodeAlphaNumeric(String nhsCode) {
        for (int i = 0; i < nhsCode.length(); i++) {
            if (!Character.isLetterOrDigit(nhsCode.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Allows the System to set the code/number of the Test.
     *
     * @param code Code/Number of the Test.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Allows the System to set the date of creation/registration of the Test.
     *
     * @param createdAt Date of creation of the Test.
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Allows the System to set the date of the creation of the sample(s).
     *
     */
    public void setSampleDate(){
        this.sampleDate= Utils.currentDate();
    }

    /**
     * Allows the System to get the NHS Code of the Test, if needed.
     *
     * @return NHS Code of the Test.
     */
    public String getNhsCode() {
        return nhsCode;
    }

    /**
     * Allows the System to get the Sample of the Test, if needed.
     *
     * @return Sample of the Test.
     */
    public List<Sample> getSampleList(){
        return sampleList;
    }

    /**
     * Allows the System to obtain one of the Test Parameters of the Test, by its code.
     *
     * @param index Position of the Test Parameter on the list of Test Parameters.
     * @return Test Parameter of the Test that was requested.
     */
    public TestParameter getTestParameterByCode(int index) {
        return testParameterList.get(index);
    }

    /**
     * Allows the System to obtain the list of Test Parameters associated with the Test.
     *
     * @return List of the Test Parameters associated with the Test.
     */
    public List<TestParameter> getTestParameterList() {
        return testParameterList;
    }

    /**
     * Allows the System to verify if the Test has got Results, by the verification of the Test Result date.
     *
     * @return Boolean value referent to the existence or non-existence of the Test Results.
     */
    public boolean hasResults() {
        return resultDate != null;
    }

    /**
     * Allows the System to verify if the Test has got a Report, by the verification of the Test Report date.
     *
     * @return Boolean value referent to the existence or non-existence of the Test Report.
     */
    public boolean hasReport() {
        return reportDate != null;
    }

    /**
     * Allows the verification of the existence of a validation in a Test class object
     *
     * @return boolean statement,true if testValidation object is different from  null false if not
     */
    public boolean hasValidation() {
        return testValidation != null;
    }

    /**
     * Allows the System to verify if the Test has got Samples, by the verification of the Sample date.
     *
     * @return Boolean value referent to the existence or non-existence of the Samples.
     */
    public boolean hasSamples() {
        return sampleDate != null;
    }

    /**
     * Allows the System to get the Parameters that are associated with the Test.
     *
     * @return List of the Parameters associated with the Test.
     */
    public List<Parameter> getParametersAssociatedWithTest(){
       List<Parameter> p=new ArrayList<>();
        for(TestParameter tp:testParameterList){
            p.add(tp.getParameter());
        }
        return p;
    }

    /**
     * Allows the validation of a Test object by creating a object of the TestValidation class
     */
    public void validateTest() {
        testValidation = new TestValidation();
    }

    /**
     * Allows the System to add the Test Report to the Test.
     *
     * @param testReport Test Report to be associated to the Test.
     */
    public void addTestReport(TestReport testReport) {
        this.testReport = testReport;
    }

    /**
     * Allows the System to add the Test Report creation date to the Test.
     */
    public void addReportDate() {
        this.reportDate = Utils.currentDate();
    }

    /**
     * Allows the System to get the date of when the Results where created.
     *
     * @return Date of the creation of the Results.
     */
    public String getResultDate() {
        return resultDate;
    }

    /**
     * Allows the System to get the date of when the Report was created.
     *
     * @return Date of the creation of the Report.
     */
    public String getReportDate() {
        return reportDate;
    }

    /**
     * Allows the System to get the date of when the Test was created.
     *
     * @return Date of the creation of the Test.
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Allows the System to get the date of when the Samples were created.
     *
     * @return Date of when the Samples were created.
     */
    public String getSampleDate() {
        return sampleDate;
    }

    /**
     * Allows the System to obtain the Test Type of the Test.
     *
     * @return Test Type of the Test.
     */
    public TestType getTestType() {
        return testType;
    }

    /**
     * Allows the System to obtain the Clinical Analysis Laboratory associated to the Test.
     *
     * @return Clinical Analysis Laboratory of the Test.
     */
    public ClinicalAnalysisLaboratory getClinicalAnalysisLaboratory() {
        return clinicalAnalysisLaboratory;
    }

    /**
     * Method to save the Clinical Analysis Laboratory
     *
     * @param clinicalAnalysisLaboratory the laboratory received as a parameter
     */
    public void saveClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory) {
        this.clinicalAnalysisLaboratory = clinicalAnalysisLaboratory;
    }

    /**
     * Method to save the Test Type
     *
     * @param testType the Test Type received as a parameter
     */
    public void saveTestType(TestType testType) {
        this.testType = testType;
    }

    /**
     * Method to add a test parameter to the Test
     *
     * @param parameter the parameter that will be taken
     */
    public void addTestParameter(Parameter parameter) {
        testParameterList.add(new TestParameter(parameter));
    }

    /**
     * Allows the System to add a Sample to the Sample List of the Test.
     *
     * @param sample Sample to be added to the List.
     */
    public void addSampleToTest(Sample sample) {
        this.sampleList.add(sample);
    }

    /**
     * Allows the System to obtain the Code/Number of the Test.
     *
     * @return Code of the Test.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Allows for the search of the TestParameter that is associated with a Parameter that has the code received as parameter
     *
     * @param parameterCode A code that identifies a Parameter class object
     * @return the TestParameter object if found,null if not
     */
    private TestParameter getTestParameterFor(String parameterCode) {
        for (TestParameter testParameter : testParameterList) {
            if (testParameter.getParameter().getCode().equals(parameterCode)) {
                return testParameter;
            }
        }
        return null;
    }

    /**
     * Allows the System to verify if a Barcode (number) is present on the Sample List.
     *
     * @param barcode Barcode Number to be searched.
     * @return Boolean value referent to the barcode being present or not on the Sample List.
     */
    public boolean isBarcodeInSampleList(String barcode) {
        for (Sample s : sampleList) {
            if (s.getBarcodeNumber().equals(barcode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Allows the System to add a Test Result to a Parameter of the Test.
     *
     * @param parameterCode Code of the Parameter.
     * @param result Result of the Test Parameter.
     * @throws ClassNotFoundException Exception to be thrown if the Class is not found.
     * @throws InstantiationException Exception to be throw if the Constructor is not available.
     * @throws IllegalAccessException Exception to be throw if the Method does not have access to the wanted Class.
     */
    public void addTestResult(String parameterCode, double result) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        TestParameter testParameter=getTestParameterFor(parameterCode);
        Parameter p=testParameter.getParameter();
        ExternalModule em=testType.getExternalModule();
        ReferenceValue refValue= em.getReferenceValue(p);
        String metric=em.getMetric(p);
        testParameter.addTestResult(result,metric,refValue);

    }

    /**
     * Allows the System to add the date of when the Results were obtained, to the Test.
     */
    public void addTestResultDate(){
        resultDate=Utils.currentDate();
    }

    /**
     * Allows the System to obtain the Test Report, if needed.
     *
     * @return Test Report of the Test.
     */
    public TestReport getTestReport(){return this.testReport;}
}
