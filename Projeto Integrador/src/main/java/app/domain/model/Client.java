package app.domain.model;

import app.controller.App;
import app.domain.shared.EmailSMS;
import app.mappers.dto.ClientDto;
import app.utils.Utils;
import auth.AuthFacade;
import auth.domain.model.Email;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This Class allows the Creation of a Client and all of the stuff related to him.
 *
 * @author Pedro Graça
 */
public class Client  {

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
     * The Password of the Client (must be random)
     */
    private String password;


    /**
     * List with the tests associated to the Client
     */
    protected final List<Test> testList = new ArrayList<>();

    /**
     * The Authentication Facade needed
     */
    private static final AuthFacade authFacade = App.getInstance().getCompany().getAuthFacade();

    /**
     * Receives a Client Data Transfer Object and get his attributes
     *
     * @param clientDto the Data Transfer Object that contains the Data of the Client
     */
    public Client(ClientDto clientDto) {
        checkNameRules(clientDto.getName());
        checkTaxIdentificationNumberRules(clientDto.getTaxIdentificationNumber());
        checkCitizenCardNumberRules(clientDto.getCitizenCardNumber());
        checkNhsNumberRules(clientDto.getNhsNumber());
        checkPhoneNumberRules(clientDto.getPhoneNumber());
        checkGenderRules(clientDto.getGender());
        this.name = clientDto.getName();
        this.email = clientDto.getEmail();
        this.taxIdentificationNumber = clientDto.getTaxIdentificationNumber();
        this.citizenCardNumber = clientDto.getCitizenCardNumber();
        this.nhsNumber = clientDto.getNhsNumber();
        this.birthDate = clientDto.getBirthDate();
        this.phoneNumber = clientDto.getPhoneNumber();
        this.gender = clientDto.getGender();
    }

    /**
     * Method to return the Email
     *
     * @return the Email of the Client
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Method to return the Phone Number
     *
     * @return the Phone Number of the Client
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * Method to return the Tax Identification Number
     *
     * @return the TIN of the Client
     */
    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    /**
     * Method to check the rules applied to Names
     *
     * @param name is the Client's name
     */
    public void checkNameRules(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > 35) {
            throw new IllegalArgumentException("Name cannot have more than 35 characters.");
        }
    }

    /**
     * Method to check the rules applied to Tax Identification Numbers
     *
     * @param taxIdentificationNumber is the Client's Tax Identification Number
     */
    public void checkTaxIdentificationNumberRules(String taxIdentificationNumber) {
        if (StringUtils.isBlank(taxIdentificationNumber))
            throw new IllegalArgumentException("Tax Identification Number cannot be blank.");
        if (taxIdentificationNumber.length() != 10)
            throw new IllegalArgumentException("Tax Identification Number must have 10 digits.");
        int taxIdNum = Integer.parseInt(taxIdentificationNumber);
        if (taxIdNum < 0)
            throw new IllegalArgumentException("Tax Identification Number cannot be negative.");
    }

    /**
     * Method to check the rules applied to Citizen Card Numbers
     *
     * @param citizenCardNumber is the Client's Citizen Card Number
     */
    public void checkCitizenCardNumberRules(String citizenCardNumber) {

        if (StringUtils.isBlank(citizenCardNumber))
            throw new IllegalArgumentException("Citizen Card Number cannot be blank.");
        if (citizenCardNumber.length() != 16)
            throw new IllegalArgumentException("Citizen Card Number must have 16 digits.");
        long citCardNum = Long.parseLong(citizenCardNumber);
        if (citCardNum < 0)
            throw new IllegalArgumentException("Citizen Card Number cannot be negative");
    }

    /**
     * Method to check the rules applied to National Healthcare Service Numbers
     *
     * @param nhsNumber is the Client's National Healthcare Service Number
     */
    public void checkNhsNumberRules(String nhsNumber) {
        if (StringUtils.isBlank(nhsNumber))
            throw new IllegalArgumentException("National Healthcare Service Number cannot be 0.");
        if (nhsNumber.length() != 10)
            throw new IllegalArgumentException("National Healthcare Service Number must have 10 digits.");
        int nhsNum = Integer.parseInt(nhsNumber);
        if (nhsNum < 0)
            throw new IllegalArgumentException("National Healthcare Service Number cannot be negative.");


    }

    /**
     * Method to check the rules applied to Genders
     *
     * @param gender is the Client's gender
     */
    public void checkGenderRules(String gender) {
            if (!(gender.equals("(Unknown)")||gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")))
                throw new IllegalArgumentException("Gender must be Male/Female.");
    }

    /**
     * Method to check the rules applied to Phone Numbers
     *
     * @param phoneNumber is the Client's phoneNumber
     */
    public void checkPhoneNumberRules(String phoneNumber) {
        if (StringUtils.isBlank(phoneNumber))
            throw new IllegalArgumentException("Phone Number cannot be blank.");
        if (phoneNumber.length() != 11)
            throw new IllegalArgumentException("Phone Number must have 11 digits.");
        long phoneNum = Long.parseLong(phoneNumber);
        if (phoneNum < 0)
            throw new IllegalArgumentException("Phone Number cannot be negative.");

    }

    /**
     * Method to set a Random Password to the Client
     */
    public void setPassword() {
        password = Utils.randomPassword();
    }

    /**
     * Method to add the Client as a User
     */
    public void addUserAndSendEmail() throws IOException {
        authFacade.addUser(name, email.toString(), password);
        EmailSMS.sendRegistrationEmail(email, name, password);
    }

    /**
     * Returns if this Client is equal to other Object
     *
     * @param o the Object received as a parameter
     * @return boolean value of the equality between the Client
     * and the Object received as a parameter
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return taxIdentificationNumber.equalsIgnoreCase(client.taxIdentificationNumber) &&
                citizenCardNumber.equalsIgnoreCase(client.citizenCardNumber) &&
                nhsNumber.equalsIgnoreCase(client.nhsNumber) &&
                phoneNumber.equalsIgnoreCase(client.phoneNumber) &&
                Objects.equals(name, client.name) &&
                Objects.equals(email, client.email) &&
                Objects.equals(birthDate, client.birthDate) &&
                Objects.equals(gender, client.gender);
    }

    /**
     * Returns the textual description of the Client
     *
     * @return attributes of the Client
     */
    @Override
    public String toString() {
        return String.format("Client %n Name: %s %n Email: %s %n Tax Identification Number: %s %n Citizen Card Number: %s %n" +
                        " National Healthcare Service Number: %s %n Birth Date: %s %n Gender: %s %n Phone Number: %s", name, email.toString(),
                taxIdentificationNumber, citizenCardNumber, nhsNumber, birthDate, gender, phoneNumber);
    }

    /**
     * Method that returns the list of the Tests of the Client
     * @return the boolean value of the operation
     */
    public boolean addTest(Test test) {
        return testList.add(test);
    }

    /**
     * Allows the verification if a certain test belongs to a certain client
     *
     * @param test A object of the Test class
     * @return boolean statement,true if in the testList belonging to a certain client exists the test received as parameter false if not
     */
    public boolean isTestInsideClientTestList(Test test){
        for(Test t:testList){
            if(test.equals(t))
                return true;
        }
        return false;
    }

    /**
     * Allows the return of a string containing the name of the client
     *
     * @return A string containing the name of the client
     */
    public String getName() {
        return name;
    }
}
