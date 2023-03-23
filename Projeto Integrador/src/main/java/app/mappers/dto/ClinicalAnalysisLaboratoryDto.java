package app.mappers.dto;

/**
 * This class allows to create a Clinical Analysis Laboratory Dto.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratoryDto {

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
     * Constructs an instance of Clinical Analysis Laboratory Data Transfer Object receiving laboratoryId, address,
     * name, phoneNumber, taxIdentificationNumber.
     *
     * @param laboratoryId the ID of the Laboratory
     * @param address the address of the Laboratory
     * @param name the name of the Laboratory
     * @param phoneNumber the phone number of the laboratory
     * @param taxIdentificationNumber the tax Identification Number of the Laboratory
     */
    public ClinicalAnalysisLaboratoryDto(String laboratoryId, String address, String name, String phoneNumber, String taxIdentificationNumber) {
        this.laboratoryId = laboratoryId;
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    /**
     * Return the Laboratory Id.
     *
     * @return the Laboratory Id.
     */
    public String getLaboratoryId() {
        return laboratoryId;
    }

    /**
     * The method that allows to see all the attributes of a Clinical Analysis Laboratory in a organised way.
     *
     * @return All parameters of a Clinical Analysis Laboratory Dto with a specific format.
     */
    @Override
    public String toString() {
        return String.format("##Clinical Analysis Laboratory## %n LaboratoryId: %s %n " +
                        "Address: %s %n Name: %s %n Phone Number: %s %n Tax Identification Number: %s ",
                laboratoryId, address , name, phoneNumber,taxIdentificationNumber);
    }
}
