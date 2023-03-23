package app.controller;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.domain.model.TestType;
import app.list.ClinicalTestTypeList;
import app.mappers.TestTypeMapper;
import app.mappers.dto.TestTypeDto;

import java.util.List;

/**
 * This Class allows the connection between Company and Clinical Analysis Laboratory Store.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class CreateClinicalAnalysisLaboratoryController {

    /**
     * Object of the Company class.
     */
    private final Company company;

    /**
     * Object of Clinical Analysis Laboratory class.
     */
    private ClinicalAnalysisLaboratory lab;

    /**
     * Object of Clinical Test Type List class.
     */
    private ClinicalTestTypeList typeList;

    /**
     * Allows the initialization of an CreateTestTypeController with the company returned from
     * "App.getInstance().getCompany()."
     */
    public CreateClinicalAnalysisLaboratoryController()  {
        this(App.getInstance().getCompany());
    }


    /**
     * Constructor that allows the inicialization of Company with Clinical Test Type List and Clinical Analysis
     * Laboratory with a null value.
     *
     * @param company Company Class
     */
    public CreateClinicalAnalysisLaboratoryController(Company company) {
        this.company = company;
        this.lab = null;
        this.typeList = new ClinicalTestTypeList();
    }

    /**
     * The method that allows the creation of a Clinical Analysis Laboratory.
     *
     * @param laboratoryID            String that contains a laboratory Id.
     * @param address                 String that contains an address of Clinical Analysis Laboratory.
     * @param name                    String that contains a name of Clinical Analysis Laboratory.
     * @param phoneNumber             Integer that contains a phone number of Clinical Analysis Laboratory.
     * @param taxIdentificationNumber Integer that contains a Tax Identification Number (TIN) of Clinical Analysis
     *                                Laboratory.
     * @return The validation of the creation of the Clinical Analysis Laboratory.
     */
    public boolean createClinicalAnalysisLaboratory(String laboratoryID, String address, String name, String phoneNumber,
                                                    String taxIdentificationNumber) {
        this.lab = this.company.getClinicalAnalysisLaboratoryStore().createClinicalAnalysisLaboratory(laboratoryID,
                address, name, phoneNumber, taxIdentificationNumber);
        return this.company.getClinicalAnalysisLaboratoryStore().validatesClinicalAnalysisLaboratory(lab);
    }

    /**
     * Allows the save of a Clinical Analysis Laboratory in Clinical Analysis Laboratory Store, verifying if it is valid.
     *
     * @return The validation of the Clinical Analysis Laboratory save in Clinical Analysis Laboratory Store.
     */
    public boolean saveClinicalAnalysisLaboratory() {
        if (this.company.getClinicalAnalysisLaboratoryStore().validatesClinicalAnalysisLaboratory(lab)) {
            return this.company.getClinicalAnalysisLaboratoryStore().saveClinicalAnalysisLaboratory(lab);
        }
        return false;
    }

    /**
     * The method that allows to admin to see the Clinical Analysis Laboratory Store.
     *
     * @return The Clinical Analysis Laboratory Store.
     */
    public ClinicalAnalysisLaboratory getClinicalAnalysisLaboratoryStore() {
        return lab;
    }

    /**
     * The method that allows to catch a List of Test Type Store.
     *
     * @return The Test Type Store List.
     */
    public List<TestType> getTypeStore() {
        return this.company.getTestTypeStore().getTypeStore();
    }

    /**
     * The method that allows to catch the List of Test Type Store, created in Dto.
     *
     * @return The Test Type Store in a safe way.
     */
    public List<TestTypeDto> listDto() {
        TestTypeMapper testTypeMapper = new TestTypeMapper();
        return testTypeMapper.listDTO(getTypeStore());
    }

    /**
     * The method that allows to catch a Test Type in Test Type Store using the Test Type code.
     *
     * @param code The code that will be used to save a Test Type.
     * @return The Test Type that have the same parameter code.
     */
    public TestType getTestTypeCode(int code) {
        return this.company.getTestTypeStore().getTestTypeByCode(code);
    }

    /**
     * The Method that allows the save of a Test Type in Clinical Test Type List.
     *
     * @param testType The Test Type that will be saved.
     * @return The save of the Test Type in Clinical Test Type List.
     */
    public boolean saveClinicalTestType(TestType testType) {
        return typeList.saveClinicalTestType(testType);
    }

    /**
     * The Method that saves the Clinical Test Type List in Clinical Analysis Laboratory.
     *
     * @return The save of the Clinical Test Type in Clinical Analysis Laboratory.
     */
    public void saveTestTypeListToClinicalAnalysisLaboratory() {
        this.lab.saveTestTypeListToClinicalAnalysisLaboratory(typeList);
    }
}