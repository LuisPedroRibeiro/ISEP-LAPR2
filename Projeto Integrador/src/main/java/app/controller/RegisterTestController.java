package app.controller;
import app.domain.model.*;
import app.mappers.ClinicalAnalysisLaboratoryMapper;
import app.mappers.ParameterCategoryMapper;
import app.mappers.ParameterMapper;
import app.mappers.TestTypeMapper;
import app.mappers.dto.ClinicalAnalysisLaboratoryDto;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.ParameterDto;
import app.mappers.dto.TestTypeDto;
import app.store.*;
import java.util.List;

/**
 * This class allows the creation of a Test Controller.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class RegisterTestController {

    /**
     * Company that will have the controller
     */
    private final Company company;

    /**
     * Test that will be controlled
     */
    private Test test;

    /**
     * Store the Tests
     */
    private TestStore testStore;

    /**
     * Store that contains the Clients
     */
    private ClientStore clientStore;

    /**
     * Store that contains the Clinical Analysis Laboratories
     */
    private ClinicalAnalysisLaboratoryStore clinicalAnalysisLaboratoryStore;

    /**
     * The Clinical Analysis Laboratory chosen by the Receptionist
     */
    private ClinicalAnalysisLaboratory clinicalAnalysisLaboratory;

    /**
     * Store that contains the Test Types
     */
    private TestTypeStore testTypeStore;

    /**
     * The Test Type chosen by the Receptionist
     */
    private TestType testType;

    /**
     * Store that contains the Parameters
     */
    private ParameterStore parameterStore;

    /**
     * Store that contains the Parameter Categories
     */
    private ParameterCategoryStore parameterCategoryStore;

    /**
     * The Parameter Category chosen by the Receptionist
     */
    private ParameterCategory parameterCategory;

    /**
     * * Constructs an instance of RegisterTestController with no parameters
     */
    public RegisterTestController()  {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructs an instance of RegisterTestController receiving the Company
     *
     * @param company the Company that will be on the controller
     */
    public RegisterTestController(Company company) {
        this.company = company;
        this.test = null;
    }

    /**
     * Returns the boolean value of the Test construction with the nhsCode
     *
     * @param nhsCode the National Healthcare Service code of the Test;
     * @return the boolean value of the creation of the Test
     */
    public boolean createTest(String nhsCode) {
        setTestStore();
        this.test = this.testStore.createTest(nhsCode);
        if(this.testStore.containsNhsCode(nhsCode)){
            throw new IllegalArgumentException("There is already a test with the same NHS code registered in the System.");
        }
        return this.testStore.validateTest(test);
    }

    /**
     * Method to identify the Client Store
     */
    public void setClientStore() {
        clientStore = this.company.getClientStore();
    }

    /**
     * Method to identify the Test Store
     */
    public void setTestStore() {
        testStore = this.company.getTestStore();
    }

    /**
     * Method to identify the Clinical Analysis Laboratory Store
     */
    public void setClinicalAnalysisLaboratoryStore() {
        clinicalAnalysisLaboratoryStore = this.company.getClinicalAnalysisLaboratoryStore();
    }

    /**
     * Method to identify the Test Type Store
     */
    public void setTestTypeStore() {
        testTypeStore = this.company.getTestTypeStore();
    }

    /**
     * Method to identify the Parameter Store
     */
    public void setParameterStore() {
        parameterStore = this.company.getParameterStore();
    }

    /**
     * Method to identify the Parameter Category Store
     */
    public void setParameterCategoryStore() {
        this.parameterCategoryStore = this.company.getParameterCategoryStore();
    }

    /**
     * Method to verify if the Client exists
     */
    public boolean verifyClientByTin(String taxIdentificationNumber) {
        setClientStore();
        return clientStore.verifyClientByTin(taxIdentificationNumber);
    }

    /**
     * Method that returns the list of the Clinical Analysis Laboratories that belong to the Company
     *
     * @return the list of the Clinical Analysis Laboratories
     */
    private List<ClinicalAnalysisLaboratory> getClinicalAnalysisLaboratoryList() {
        setClinicalAnalysisLaboratoryStore();
        return clinicalAnalysisLaboratoryStore.getClinicalAnalysisLaboratoryList();
    }

    /**
     * Method that returns the list of Test Types associated to the selected Clinical Analysis Laboratory
     * @return the List of Test Types
     */
    private List<TestType> getTestTypeList(){
       return this.clinicalAnalysisLaboratory.getClinicalTestTypeList();
    }

    /**
     * Method that returns the list of Parameter Categories associated to the selected Test Type
     * @return the List of Parameter Categories
     */
    private List<ParameterCategory> getParameterCategoryList(){
        return this.testType.getParameterCategoryList();
    }

    /**
     * Method that returns the list of Parameter Categories associated to the selected Test Type
     * @return the List of Parameter Categories
     */
    private List<Parameter> getParameterList(){
        return this.parameterCategory.getParameterList();
    }

    /**
     * Allows the creation of a list Clinical Analysis Laboratory Dto objects from the list of Clinical Analysis Laboratory
     *
     * @return list composed by ClinicalAnalysisLaboratoryDTO objects
     */
    public List<ClinicalAnalysisLaboratoryDto> getClinicalAnalysisLaboratoryListToDto() {
        ClinicalAnalysisLaboratoryMapper clinicalAnalysisLaboratoryMapper = new ClinicalAnalysisLaboratoryMapper();
        return clinicalAnalysisLaboratoryMapper.toDTO(getClinicalAnalysisLaboratoryList());
    }

    /**
     * Allows the creation of a list of Test Type Dto objects from the list of Test Types
     *
     * @return list composed by TestTypeDTO objects
     */
    public List<TestTypeDto> getTestTypeListToDto() {
       TestTypeMapper testTypeMapper = new TestTypeMapper();
       return  testTypeMapper.listDTO(getTestTypeList());
    }

    /**
     * Allows the creation of a list of Parameter Category Dto objects from the list of Parameter Categories
     *
     * @return list composed by ParameterCategoryDTO objects
     */
    public List<ParameterCategoryDto> getParameterCategoryListToDto() {
        ParameterCategoryMapper parameterCategoryMapper = new ParameterCategoryMapper();
        return  parameterCategoryMapper.toDTO(getParameterCategoryList());
    }

    /**
     * Allows the creation of a list of Parameter  Dto objects from the list of Parameters
     *
     * @return list composed by ParameterDTO objects
     */
    public List<ParameterDto> getParameterListToDto() {
        ParameterMapper parameterMapper = new ParameterMapper();
        return  parameterMapper.toDTO(getParameterList());
    }

    /**
     * Method that saves the selected Clinical Analysis Laboratory
     *
     * @param laboratoryId the Laboratory ID
     * @return the boolean value of the operation
     */
    public boolean saveClinicalAnalysisLaboratory(String laboratoryId) {
        this.clinicalAnalysisLaboratory = this.clinicalAnalysisLaboratoryStore.getClinicalAnalysisLaboratoryById(laboratoryId);
        return true;
    }

    /**
     * Method that saves the selected Test Type
     *
     * @param code the Test Type code
     * @return the boolean value of the operation
     */
    public boolean saveTestType(String code) {
        setTestTypeStore();
        this.testType = this.testTypeStore.getTestTypeByCode(code);
        this.test.saveTestType(testType);
        return true;
    }

    /**
     * Method that add Parameters that will be Test Parameters
     *
     * @param code the code of the Parameter
     * @return the boolean value of the operation
     */
    public boolean addParameter(String code){
        setParameterStore();
        Parameter parameter = this.parameterStore.getParameterByCode(code);
        this.test.addTestParameter(parameter);
        return true;
    }

    /**
     * Method to set the Parameter Category selected by the Receptionist
     * @param code the code that identifies the Parameter Category
     */
    public void setParameterCategory(String code) {
        setParameterCategoryStore();
        this.parameterCategory = parameterCategoryStore.getParameterCategoryByCode(code);
    }

    /**
     * Method that returns the boolean value of the addition of a Test to a certain Client
     *
     * @param taxIdentificationNumber the TIN of the Client
     * @return the Boolean Value of the operation
     */
    public boolean addTestToClient(String taxIdentificationNumber) {
        Client client = this.clientStore.getClientByTin(taxIdentificationNumber);
        return this.testStore.addTestToClient(client, this.test);
    }

    /**
     * Method that save the created Test
     * @return the boolean value of the operation
     */
    public boolean saveTest(){
        setTestStore();
        this.test.saveClinicalAnalysisLaboratory(clinicalAnalysisLaboratory);
       return this.testStore.saveTest(test);
    }

    /**
     * Method to verify if the list of Parameter Categories associated to the Test Type is null
     * @return the boolean value of the operation
     */
    public boolean verifyIfListParameterCategoryListIsNull(){
        return testType.getCl() == null;
    }

    /**
     * Method that check if the Client List is empty.
     *
     * @return True if the Client list is Empty, false if not.
     */
    public boolean verifyIfClientListIsEmpty(){
        setClientStore();
        return  this.clientStore.getClientList().isEmpty();
    }

    /**
     * Method to verify if Test Parameters were added to the test
     * @return the boolean value of the operation
     */
    public boolean verifyIfTestParametersWereAdded(){
        return !test.getTestParameterList().isEmpty();
    }

    /**
     * Method to return the Clinical Analysis Laboratory associated to the Controller
     */
    public ClinicalAnalysisLaboratory getClinicalAnalysisLaboratory() {
        return clinicalAnalysisLaboratory;
    }
}
