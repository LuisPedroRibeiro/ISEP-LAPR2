package app.domain.model;

import app.controller.App;
import app.domain.shared.EmailSMS;
import app.list.EmployeeRolesList;
import app.utils.Utils;
import auth.AuthFacade;
import auth.domain.model.Email;
import org.apache.commons.lang3.StringUtils;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class Employee {

    /**
     * Name of the Employee (Can not be empty, according to acceptance criteria).
     */
    private final String name;

    /**
     * Organization role of the Employee (Can not be empty, according to acceptance criteria).
     */
    private final String organizationRole;

    /**
     * Address of the Employee (Can not be empty, according to acceptance criteria).
     */
    private final String address;

    /**
     * Employee ID of the Employee (Generated automatically by the System, according to acceptance criteria).
     */
    private String employeeID;

    /**
     * Phone Number of the Employee (Is composed by eleven numbers, according to client criteria).
     */
    private final String phoneNumber;

    /**
     * SOC code of the Employee (Can not be empty and it is always composed by four characters, according
     * to acceptance criteria).
     */
    private final String socCode;

    /**
     * E-mail of the Employee (Can not be empty, according to acceptance criteria).
     */
    private final Email email;

    /**
     * Password of the Employee (Generated automatically, should have three capital letters and two digits,
     * according to acceptance criteria).
     */
    private String password;

    /**
     * Authentication Facade of the Application.
     */
    private final AuthFacade authFacade = App.getInstance().getCompany().getAuthFacade();

    /**
     * Number of Employees working for the Company.
     */
    private static int numberOfEmployees = 0;

    /**
     * Generates an instance of the class Employee.
     *
     * @param name Name of the Employee.
     * @param phoneNumber Phone Number of the Employee.
     * @param email E-mail of the Employee.
     * @param socCode SOC code of the Employee.
     * @param organizationRole Organization role of the Employee.
     * @param address Address of the Employee.
     */
    public Employee(String name, String phoneNumber, Email email, String socCode, String organizationRole,
                    String address){
        checkName(name);
        checkPhoneNumber(phoneNumber);
        checkSOCCode(socCode);
        checkOrganizationRole(organizationRole);
        checkAddress(address);

        numberOfEmployees ++;

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.socCode = socCode;
        this.organizationRole = organizationRole;
        this.address = address;
    }


    /**
     * Allows the System to confirm if the given Name is correct according to the acceptance criteria.
     * Verifies if the Name is blank/empty.
     * Verifies if the Name has more than thirty five characters.
     *
     * @param name Name of the Employee.
     */
    public void checkName(String name){
        if(StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name can not be blank.");
        }
        if(name.length() > 35){
            throw new IllegalArgumentException("Name can not have more than 35 characters.");
        }
    }

    /**
     * Allows the System to confirm if the given Phone Number is correct according to the acceptance criteria.
     * Verifies if the Phone Number is blank/empty.
     * Verifies if the Phone Number does not have eleven digits.
     *
     * @param phoneNumber Phone Number of the Employee.
     */
    public void checkPhoneNumber(String phoneNumber){
        if(StringUtils.isBlank(phoneNumber)){
            throw new IllegalArgumentException("Phone Number can not be blank.");
        }
        if(phoneNumber.length() != 11){
            throw new IllegalArgumentException("Phone Number must have 11 characters.");
        }
    }

    /**
     * Allows the System to confirm if the given SOC Code is correct according to the acceptance criteria.
     * Verifies if the SOC Code is blank/empty.
     * Verifies if the SOC Code does not have four digits.
     *
     * @param socCode SOC Code of the Employee.
     */
    public void checkSOCCode(String socCode){
        if(StringUtils.isBlank(socCode)){
            throw new IllegalArgumentException("SOC Code can not be blank.");
        }
        if(socCode.length() != 4){
            throw new IllegalArgumentException("SOC Code needs to have 4 numbers.");
        }
    }

    /**
     * Allows the System to confirm if the given Organization Role is correct according to the acceptance
     * criteria.
     * Verifies if the Organization Role is blank/empty.
     * Verifies if the Organization Role exists within the System.
     * Verifies if the Organization Role has more that thirty five characters.
     *
     * @param organizationRole Organization Role of the Employee.
     */
    public void checkOrganizationRole(String organizationRole){
        if(StringUtils.isBlank(organizationRole)){
            throw new IllegalArgumentException("The Employee needs to have one Organization Role.");
        }

        if(organizationRole.length() > 30){
            throw new IllegalArgumentException("The Organization Role can not have more than 30 characters.");
        }

        EmployeeRolesList employeeRolesList = new EmployeeRolesList();


        if(! employeeRolesList.getList().contains(organizationRole)){
            throw new IllegalArgumentException("The inserted Organization Role does not exist.");
        }
    }

    /**
     * Allows the System to confirm if the given Address is correct according to the acceptance criteria.
     * Verifies if the Address is blank/empty.
     *
     * @param address Address of the Employee.
     */
    public void checkAddress(String address){
        if(StringUtils.isBlank(address)){
            throw new IllegalArgumentException("Address can not be blank.");
        }
    }

    /**
     * Allows the System to register an automatically generated password to the Employee.
     * Uses a method that creates a random password, that contains three capital letters, two digits and
     * five lower case letters.
     */
    public void setPassword(){
        this.password = Utils.randomPassword();
    }

    /**
     * Allows the System to register an automatically generated Employee ID to the Employee.
     * Has according to the acceptance criteria, the System starts by getting the Employee's name initials
     * and generating a five digit number according to the number of employees registered on the Employee
     * Store.
     */
    public void setEmployeeID(){
        StringBuilder nameInitials = Utils.getStringInitials(this.name);
        String employeeNumberID = getEmployeeNumber();
        this.employeeID = String.format("%s%s", nameInitials, employeeNumberID);
    }

    /**
     * Obtains the number of the Employee in the format that it should appear in the Employee ID, according
     * to the acceptance criteria (always 5 numbers).
     * Returns the number of the Employee in the needed format.
     *
     * @return Number of the Employee.
     */
    private String getEmployeeNumber(){
        int quantityOfZeros = 5 - Utils.quantityOfDigits(numberOfEmployees);
        StringBuilder employeeNumberID = new StringBuilder();
        for (int i = 1; i <= quantityOfZeros ; i++) {
            employeeNumberID.append("0");
        }
        employeeNumberID = new StringBuilder(String.format("%s%d", employeeNumberID.toString(), numberOfEmployees));
        return employeeNumberID.toString();
    }

    /**
     * Allows the System to register the Employee to the Authentication Facade of the Application and
     * sends an automatic E-mail to the Employee (containing the information that he needs to use the
     * application).
     * The E-mail will be sent to a File.
     *
     * @throws FileNotFoundException Exception to be thrown in case the File is not found.
     */
    public void registerUserAndSendEmail() throws IOException {
        this.authFacade.addUserWithRole(this.name, this.email.toString(), this.password, this.organizationRole);
        EmailSMS.sendRegistrationEmail(this.email, this.name, this.password);
    }

    /**
     * Allows the System to reduce the number of registered Employees, if the last Employee did not pass
     * the validation.
     */
    public static void reduceNumberOfEmployees(){
        numberOfEmployees --;
    }

    /**
     * Allows the System to get the Name of the Employee.
     *
     * @return Name of the Employee.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Allows the System to get the Organization Role of the Employee.
     *
     * @return Organization Role of the Employee.
     */
    public String getOrganizationRole(){
        return this.organizationRole;
    }

    /**
     * Allows the System to get the Address of the Employee.
     *
     * @return Address of the Employee.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * Allows the System to get the Employee ID of the Employee.
     *
     * @return Employee ID of the Employee.
     */
    public String getEmployeeID(){
        return this.employeeID;
    }

    /**
     * Allows the System to get the Phone Number of the Employee.
     *
     * @return Phone Number of the Employee.
     */
    public String getPhoneNumber(){return this.phoneNumber;}

    /**
     * Allows the System to get the E-mail of the Employee.
     *
     * @return E-mail of the Employee.
     */
    public String getEmail(){return this.email.toString();}

    /**
     * Allows the System to get the SOC Code of the Employee.
     *
     * @return SOC Code of the Employee.
     */
    public String getSocCode(){return this.socCode;}

    /**
     * Allows to do the comparison between two Employees.
     *
     * @param otherEmployee Other Employee to be compared to the Employee.
     * @return Boolean value according to the comparison (true = Employees are equal | false = Employees
     * are not equal).
     */
    public boolean equals(Employee otherEmployee){
        return (this.phoneNumber.equals(otherEmployee.phoneNumber) || this.socCode.equals(otherEmployee.socCode) ||
                this.email.equals(otherEmployee.email));
    }

    /**
     * Allows the System to get a String that contains most of the information relative to the Employee.
     * Information contained in the String: Name, Address, Phone Number, E-mail, Organization Role, Employee ID,
     * SOC Code.
     *
     * @return String that contains information of the Employee.
     */
    @Override
    public String toString() {
        return String.format("%n1. NAME AND ADDRESS %n - Name: %s %n - Address: %s %n%n" +
                "2. CONTACTS %n - Phone Number: %s %n - E-mail: %s %n%n3. COMPANY INFORMATION %n - Role: %s %n " +
                "- Employee ID: %s %n - SOC Code: %s %n", name, address, phoneNumber, email, organizationRole,
                employeeID, socCode);
    }
}