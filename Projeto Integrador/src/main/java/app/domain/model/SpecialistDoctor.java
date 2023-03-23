package app.domain.model;

import auth.domain.model.Email;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Luís Pedro Novo Ribeiro <1201184@isep.ipp.pt>
 */
public class SpecialistDoctor extends Employee {

    /**
     * Doctor Index Number of the Specialist Doctor (Can not be empty, according to acceptance criteria).
     */
    private final String doctorIndexNumber;

    /**
     * Generates an instance of the class Specialist Doctor.
     *
     * @param name Name of the Specialist Doctor.
     * @param phoneNumber Phone Number of the Specialist Doctor.
     * @param email E-mail of the Specialist Doctor.
     * @param socCode SOC code of the Specialist Doctor.
     * @param organizationRole Organization role of the Specialist Doctor.
     * @param address Address of the Specialist Doctor.
     * @param doctorIndexNumber Doctor Index Number of the Specialist Doctor.
     */
    public SpecialistDoctor(String name, String phoneNumber, Email email, String socCode, String organizationRole,
                            String address, String doctorIndexNumber){
        super(name, phoneNumber, email, socCode, organizationRole, address);
        checkDoctorIndexNumber(doctorIndexNumber);
        this.doctorIndexNumber = doctorIndexNumber;
    }

    /**
     * Allows the System to confirm if the given Doctor Index Number is correct according to the
     * acceptance criteria.
     * Verifies if the Doctor Index Number is blank/empty.
     * Verifies if the Doctor Index Number does not have six digits.
     *
     * @param doctorIndexNumber Doctor Index Number of the Specialist Doctor.
     */
    public void checkDoctorIndexNumber(String doctorIndexNumber){
        if(StringUtils.isBlank(doctorIndexNumber)){
            throw new IllegalArgumentException("Doctor Index Number can not be blank.");
        }
        if(doctorIndexNumber.length() != 6){
            throw new IllegalArgumentException("Doctor Index Number needs to be 6 characters long.");
        }
    }

    /**
     * Allows the System to get the Doctor Index Number of the Specialist Doctor.
     *
     * @return Doctor Index Number of the Specialist Doctor.
     */
    public String getDoctorIndexNumber(){return doctorIndexNumber;}

    /**
     * Allows to do the comparison between two Specialist Doctors.
     *
     * @param otherSpecialistDoctor Other Specialist Doctor to be compared to the Specialist Doctor.
     * @return Boolean value according to the comparison (true = Specialist Doctor are equal | false = Specialist
     * Doctor are not equal).
     */
    public boolean equals(SpecialistDoctor otherSpecialistDoctor){
        return super.equals(otherSpecialistDoctor) ||
                this.doctorIndexNumber.equals(otherSpecialistDoctor.doctorIndexNumber);
    }

    /**
     * Allows the System to get a String that contains most of the information relative to the Specialist Doctor.
     * Information contained in the String: Name, Address, Phone Number, E-mail, Organization Role, Employee ID,
     * SOC Code, Doctor Index Number.
     *
     * @return String that contains information of the Specialist Doctor.
     */
    @Override
    public String toString() {
        return String.format("%s - Doctor Index Number: %s %n", super.toString(), doctorIndexNumber);
    }
}
