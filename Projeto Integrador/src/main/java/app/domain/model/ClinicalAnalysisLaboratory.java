package app.domain.model;

import app.list.ClinicalTestTypeList;
import app.utils.Utils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * This class allows to create a Clinical Analysis Laboratory.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratory {

    /**
     * A string with five alphanumeric characters.
     */
    private final String laboratoryId;

    /**
     * A string with no more than 30 characters.
     */
    private final String address;

    /**
     * A string with no more than 20 characters.
     */
    private final String name;

    /**
     * A number with 11 digit.
     */
    private final String phoneNumber;

    /**
     * A number with 10 digit.
     */
    private final String taxIdentificationNumber;

    /**
     * A list of Test Type connected to Clinical Analysis Laboratory.
     */
    private ClinicalTestTypeList clinicalTestTypeList;


    /**
     * A Constructor with all parameters of a Clinical Analysis Laboratory.
     * Allows the creation of a Clinical Analysis Laboratory with all parameters.
     *
     * @param laboratoryId A string that contains an id that identifies the Clinical Analysis Laboratory.
     * @param address A string that contains the full address of Clinical Analysis Laboratory.
     * @param name A string that contains the name of Clinical Analysis Laboratory.
     * @param phoneNumber A long that contains the phone number of Clinical Analysis Laboratory.
     * @param taxIdentificationNumber A long that contains the Tax Identification Number (TIN) of Clinical
     *                                Analysis Laboratory.
     */
    public ClinicalAnalysisLaboratory(String laboratoryId, String address, String name, String phoneNumber,
                                      String taxIdentificationNumber){
        checkLaboratoryIdRules(laboratoryId);
        this.laboratoryId= laboratoryId;

        checkAddressRules(address);
        this.address=address;

        checkNameRules(name);
        this.name=name;

        checkPhoneNumberRules(phoneNumber);
        this.phoneNumber=phoneNumber;

        checkTaxIdentificationNumberRules(taxIdentificationNumber);
        this.taxIdentificationNumber=taxIdentificationNumber;

        this.clinicalTestTypeList= new ClinicalTestTypeList();
    }

    /**
     * Method that return Laboratory Id.
     * @return Laboratory Id.
     */
    public String getLaboratoryId() {
        return laboratoryId;
    }

    /**
     * Method that return Address.
     * @return Address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method that return Name.
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method that return Phone Number.
     * @return Phone Number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method that return TIN.
     * @return TIN.
     */
    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    /**
     * Allows the verification of laboratory id restrictions throwing an exception if the operation fails.
     *
     * @param laboratoryId The parameter that will be checked (five alphanumeric characters).
     */
    public void checkLaboratoryIdRules(String laboratoryId){
        if(StringUtils.isBlank(laboratoryId))
            throw new IllegalArgumentException("Laboratory Id cannot be blank.");
        if(laboratoryId.length()!=5){
            throw new IllegalArgumentException("Laboratory Id should have 5 alphanumeric numbers.");
        }
    }

    /**
     * Allows the verification of address restrictions throwing an exception if the operation fails.
     *
     * @param address The parameter that will be checked (no more than 30 characters).
     */
    public void checkAddressRules(String address){
        if(StringUtils.isBlank(address))
            throw new IllegalArgumentException("Address cannot be blank.");
        if(address.length()>20){
            throw new IllegalArgumentException("Address should have 30 characters or fewer.");
        }
    }

    /**
     * Allows the verification of address restrictions throwing an exception if the operation fails.
     *
     * @param name The parameter that will be checked. (no more than 20 characters).
     */
    public static void checkNameRules(String name){
        if(StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if(name.length()>30){
            throw new IllegalArgumentException("Name should have 20 characters or fewer.");
        }
    }

    /**
     * Allows the verification of address restrictions throwing an exception if the operation fails.
     *
     * @param phoneNumber The parameter that will be checked (11 digit number).
     */
    public void checkPhoneNumberRules(String phoneNumber){
        if(!Utils.onlyDigits(phoneNumber))
            throw new IllegalArgumentException("Phone Number cannot have letters.");
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone Number cannot be blank.");
        if(phoneNumber.length()!=11){
            throw new IllegalArgumentException("Phone Number should have 11 digit number.");
        }
    }

    /**
     * Allows the verification of address restrictions throwing an exception if the operation fails.
     *
     * @param taxIdentificationNumber The parameter that will be checked (10 digit number).
     */
    public void checkTaxIdentificationNumberRules(String taxIdentificationNumber){
        if(!Utils.onlyDigits(taxIdentificationNumber))
            throw new IllegalArgumentException("TIN cannot have letters.");
        if (StringUtils.isBlank(taxIdentificationNumber))
            throw new IllegalArgumentException("TIN cannot be blank.");
        if(taxIdentificationNumber.length()!=10){
            throw new IllegalArgumentException("TIN should have 10 digit number.");
        }
    }

    /**
     * Allows the creation of Clinical Test Type List with all Test Types selected by admin, and saves him.
     *
     * @param clinicalTestTypeList The List that will be saved.
     * @return Assignment of the Test Type List that receives as a parameter to the Test Type List of the Clinical
     * Analysis Laboratory.
     */
    public void saveTestTypeListToClinicalAnalysisLaboratory(ClinicalTestTypeList clinicalTestTypeList){
        if(clinicalTestTypeList.getSize()==0){
            throw new IllegalArgumentException("You need to have at least 1 Test Type in that List to save that");
        }
        this.clinicalTestTypeList = clinicalTestTypeList;
    }

    /**
     * The method that allows the comparation of two ClinicalAnalysisLaboratory by laboratoryId.
     *
     * @param clinicalAnalysisLaboratory The parameter that will be compared.
     * @return A boolean that compare two Clinical Analysis Laboratory by laboratoryId, return true
     * if they have the same laboratoryId, return false if not.
     */
    @Override
    public boolean equals(Object clinicalAnalysisLaboratory){
        if (this == clinicalAnalysisLaboratory)
            return true;
        if (clinicalAnalysisLaboratory == null || getClass() != clinicalAnalysisLaboratory.getClass())
            return false;
        ClinicalAnalysisLaboratory cals= (ClinicalAnalysisLaboratory) clinicalAnalysisLaboratory;
        return this.laboratoryId.equals(cals.laboratoryId) || this.address.equals(cals.address) ||
                this.phoneNumber.equals(cals.phoneNumber) ||
                this.taxIdentificationNumber.equals(cals.taxIdentificationNumber);
    }

    /**
     * The method that allows seeing all the parameters of a Clinical Analysis Laboratory in a organised way.
     *
     * @return All parameters of a Clinical Analysis Laboratory with a specific format.
     */
    @Override
    public String toString(){
        return String.format("##Clinical Analysis Laboratory## %n Laboratory Id: %s %n Address: %s %n Name: %s %n " +
                        "Phone number: %s %n TIN: %s %n", laboratoryId,address,name,
                phoneNumber,taxIdentificationNumber);
    }

    /**
     * Method that returns the list of Test Types associated to the Laboratory.
     *
     * @return the list of the Test Type
     */
    public List<TestType> getClinicalTestTypeList() {
        return clinicalTestTypeList.getClinicalTestType();
    }
}

