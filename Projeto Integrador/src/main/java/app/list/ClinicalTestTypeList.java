package app.list;

import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows for the construction of a Clinical Test Type List.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class ClinicalTestTypeList {

    /**
     * Creation of a Test Type List.
     */
    private final List<TestType> clinicalTestType;

    /**
     * Allows the creation of a new ArrayList starting from a Constructor to initialize the List of Clinical Test Type.
     */
    public ClinicalTestTypeList() {
        this.clinicalTestType = new ArrayList<>();
    }

    /**
     * Allows the save of the Test Type in Clinical Test Type list checking if Test Type is validated according to
     * saveClinicalTestType() method.
     *
     * @param testType Type of test introduced by the admin.
     * @return Confirmation if Test Type is added to Clinical Test Type list.
     */
    public boolean saveClinicalTestType(TestType testType) {
        if (validatesClinicalTestType(testType)) {
            return clinicalTestType.add(testType);
        }
        return false;
    }

    /**
     * Allows the validation of the Test Type in the Clinical Test Type list checking if Test Type is null and if
     * Test Type already exists in Clinical Test Type List.
     *
     * @param testType Type of test introduced by the admin.
     * @return Confirmation if Test Type doesn't exist in a duplicated way.
     */
    public boolean validatesClinicalTestType(TestType testType) {
        if (testType == null) {
            return false;
        }
        return !this.clinicalTestType.contains(testType);
    }

    /**
     * Allows to get the size of a Clinical Test Type List.
     *
     * @return The size of Clinical Test Type List.
     */
    public int getSize(){
        return clinicalTestType.size();
    }

    /**
     * Method that returns the Test Type list.
     *
     * @return the Test Type list.
     */
    public List<TestType> getClinicalTestType() {
        return clinicalTestType;
    }
}
