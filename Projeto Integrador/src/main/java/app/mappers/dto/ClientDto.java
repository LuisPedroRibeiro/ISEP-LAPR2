package app.mappers.dto;
import auth.domain.model.Email;

/**
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ClientDto {

        /**
         * Name of the Client
         */
        private final String name;

        /**
         * Email of the Client
         */
        private final Email email;

        /**
         * Tax Identification Number of the Client (must have 10 digits)
         */
        private final String taxIdentificationNumber;

        /**
         * Citizen Card Number of the Client (must have 16 digits)
         */
        private final String citizenCardNumber;

        /**
         * National Healthcare Service Number of the Client (must have 10 digits)
         */
        private final String nhsNumber;

        /**
         * Birth Date of the Client (must be in DD/MM/YY format)
         */
        private final String birthDate;

        /**
         * Gender of the Client (must be Male/Female) (is not mandatory)
         */
        private final String gender;

        /**
         * Phone Number of the Client (must have 16 digits)
         */
        private final String phoneNumber;

        /**
         * Gender of the Client by omission
         */
        private static final String GENDER_BY_OMISSION = "(Unknown)";

        /**
         * Constructs an instance of Client receiving the name, the email, the Tax Identification Number,
         * the Citizen Card Number, the National Healthcare Service Number, the Birth Date, the Gender and
         * the Phone Number.
         *
         * @param name                    the Name of the Client
         * @param email                   the Email of the Client
         * @param taxIdentificationNumber the Tax Identification Number of the Client
         * @param citizenCardNumber       the Citizen Card Number of the Client
         * @param nhsNumber               the National Healthcare Service Number of the Client
         * @param birthDate               the Birth Date of the Client
         * @param gender                  the Gender of the Client
         * @param phoneNumber             the Phone Number of the Client
         */
        public ClientDto(String name, Email email, String taxIdentificationNumber, String citizenCardNumber,
                      String nhsNumber, String birthDate, String gender, String phoneNumber) {
            this.name = name;
            this.email = email;
            this.taxIdentificationNumber = taxIdentificationNumber;
            this.citizenCardNumber = citizenCardNumber;
            this.nhsNumber = nhsNumber;
            this.birthDate = birthDate;
            this.gender = gender;
            this.phoneNumber = phoneNumber;
        }

        /**
         * Constructs an instance of Client receiving the name, the email, the Tax Identification Number,
         * the Citizen Card Number, the National Healthcare Service Number, the Birth Date and the Phone Number.
         * Assigns the Gender by omission.
         *
         * @param name                    the Name of the Client
         * @param email                   the Email of the Client
         * @param taxIdentificationNumber the Tax Identification Number of the Client
         * @param citizenCardNumber       the Citizen Card Number of the Client
         * @param nhsNumber               the National Healthcare Service Number of the Client
         * @param birthDate               the Birth Date of the Client
         * @param phoneNumber             the Phone Number of the Client
         */
        public ClientDto(String name, Email email, String taxIdentificationNumber, String citizenCardNumber, String nhsNumber,
                      String birthDate, String phoneNumber) {
            this.name = name;
            this.email = email;
            this.taxIdentificationNumber = taxIdentificationNumber;
            this.citizenCardNumber = citizenCardNumber;
            this.nhsNumber = nhsNumber;
            this.birthDate = birthDate;
            this.phoneNumber = phoneNumber;
            gender = GENDER_BY_OMISSION;
        }

    /**
     * Returns the Name of the Client.
     *
     * @return the Name of the Client.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Email of the Client.
     *
     * @return the Email of the Client.
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Returns the Tax Identification Number of the Client.
     *
     * @return the Tax Identification Number of the Client.
     */
    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    /**
     * Returns the Citizen Card Number of the Client.
     *
     * @return the Tax Identification Number of the Client.
     */
    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Returns the National Healthcare Number of the Client.
     *
     * @return the National Healthcare Number of the Client.
     */
    public String getNhsNumber() {
        return nhsNumber;
    }

    /**
     * Returns the Birth Date of the Client.
     *
     * @return the Birth Date of the Client.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Returns the Gender of the Client.
     *
     * @return the Gender of the Client.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Returns the Phone Number of the Client.
     *
     * @return the Phone Number of the Client.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the textual description of the Client.
     *
     * @return attributes of the Client.
     */
    @Override
    public String toString() {
        return String.format("Client %n Name: %s %n Email: %s %n Tax Identification Number: %s %n Citizen Card Number: %s %n" +
                        " National Healthcare Service Number: %s %n Birth Date: %s %n Gender: %s %n Phone Number: %s",
                name, email.toString(),taxIdentificationNumber, citizenCardNumber, nhsNumber, birthDate, gender, phoneNumber);
    }
}
