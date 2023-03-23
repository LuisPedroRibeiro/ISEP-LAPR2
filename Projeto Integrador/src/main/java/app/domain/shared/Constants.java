package app.domain.shared;

/**
 * Constants to be used by the System.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Constants {

    private Constants(){
        //This method is empty because don't only need to be inicialized.
    }

    /**
     * Constant representative of the Employee Role: Administrator.
     */
    public static final String ROLE_ADMIN = "ADMINISTRATOR";

    /**
     * Constant representative of the Employee Role: Receptionist.
     */
    public static final String ROLE_RECEP = "RECEPTIONIST";

    /**
     * Constant representative of the Employee Role: Specialist Doctor.
     */
    public static final String ROLE_SPECDOC = "SPECIALIST DOCTOR";

    /**
     * Constant representative of the Employee Role: Laboratory Coordinator.
     */
    public static final String ROLE_LABCO = "LABORATORY COORDINATOR";

    /**
     * Constant representative of the Employee Role: Medical Laboratory Technician.
     */
    public static final String ROLE_MEDTECH = "MEDICAL LABORATORY TECHNICIAN";

    /**
     * Constant representative of the Employee Role: Chemical Analysis Technician.
     */
    public static final String ROLE_CHEMTECH = "CHEMICAL ANALYSIS TECHNICIAN";

    /**
     * Constant representative of the Configuration File for all of the Adapters.
     */
    public static final String PARAMS_FILENAME = "config.properties";

    /**
     * Constant representative of the Designation for Configuration File for all of the Adapters.
     */
    public static final String PARAMS_COMPANY_DESIGNATION = "Company.Designation";
}
