package app.store;

import app.domain.model.ClinicalAnalysisLaboratory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows for the construction of a Clinical Analysis Laboratory Store.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratoryStore {

    /**
     * Creation of a Clinical Analysis Laboratory Store.
     */
    private final List<ClinicalAnalysisLaboratory> analysisLaboratoryStore;

    /**
     * A constructor that allows the initialization of the Clinical Analysis Laboratory Store.
     */
    public ClinicalAnalysisLaboratoryStore() {
        this.analysisLaboratoryStore = new ArrayList<>();
    }

    /**
     * The method that allows the creation of a Clinical Analysis Laboratory.
     *
     * @param laboratoryId            A string that contains an id that identifies the Clinical Analysis Laboratory.
     * @param address                 A string that contains the full address of Clinical Analysis Laboratory.
     * @param name                    A string that contains the name of Clinical Analysis Laboratory.
     * @param phoneNumber             A integer that contains the phone number of Clinical Analysis Laboratory.
     * @param taxIdentificationNumber A integer that contains the Tax Identification Number (TIN) of Clinical
     *                                Analysis Laboratory.
     * @return The creation of a new Clinical Analysis Laboratory, with all parameters.
     */
    public ClinicalAnalysisLaboratory createClinicalAnalysisLaboratory(String laboratoryId, String address,
                                                                       String name, String phoneNumber,
                                                                       String taxIdentificationNumber) {
        return new ClinicalAnalysisLaboratory(laboratoryId, address, name, phoneNumber,
                taxIdentificationNumber);
    }

    /**
     * Allows the save of Clinical Analysis Laboratory.
     *
     * @param lab Clinical Analysis Laboratory that will be saved.
     * @return The addition of lab in Clinical Analysis Laboratory Store.
     */
    public boolean saveClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory lab) {
        if (!validatesClinicalAnalysisLaboratory(lab)) {
            return false;
        }
        return this.analysisLaboratoryStore.add(lab);
    }

    /**
     * Allows the validation of the Test Type in the Clinical Analysis Laboratory checking if Test Type is null and if
     * Test Type already exists in Clinical Test Type List.
     *
     * @param lab Clinical Analysis Laboratory that will be validated.
     * @return Confirmation if Clinical Analysis Laboratory doesn't exist in a duplicated way.
     */
    public boolean validatesClinicalAnalysisLaboratory(ClinicalAnalysisLaboratory lab) {
        if (lab == null) {
            return false;
        }
        return !this.analysisLaboratoryStore.contains(lab);
    }

    /**
     * Method that returns the list of Clinical Analysis Laboratories that belong to the Company
     *
     * @return the list of the Clinical Analysis Laboratories
     */
    public List<ClinicalAnalysisLaboratory> getClinicalAnalysisLaboratoryList() {
        return analysisLaboratoryStore;
    }

    /**
     * Method that returns the Clinical Analysis Laboratory with the LaboratoryID given as a parameter
     *
     * @param laboratoryId the Laboratory ID
     * @return the Clinical ANalysis Laboratory with the data given as a parameter
     */

    public ClinicalAnalysisLaboratory getClinicalAnalysisLaboratoryById(String laboratoryId){
        List<ClinicalAnalysisLaboratory> listClinicalAnalysisLaboratory = getClinicalAnalysisLaboratoryList();
        for (ClinicalAnalysisLaboratory clinicalAnalysisLaboratory:listClinicalAnalysisLaboratory) {
            if (laboratoryId.equals(clinicalAnalysisLaboratory.getLaboratoryId()))
                return clinicalAnalysisLaboratory;
        }
        return null;
    }
}