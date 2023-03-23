package app.controller;

import app.domain.model.Company;
import app.domain.model.Employee;
import app.store.EmployeeStore;
import auth.domain.model.Email;

import java.io.IOException;

/**
 * Allows the System to control the creation of a new Employee.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class RegisterNewEmployeeController {

    /**
     * Employee that will be created.
     */
    private Employee employee;

    /**
     * Company that has got the controller.
     */
    private final Company company;

    /**
     * Store where the Employees are stored.
     */
    private EmployeeStore employeeStore;

    /**
     * Constructs an instance of RegisterNewEmployeeController with no parameters.
     */
    public RegisterNewEmployeeController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Allows the creation of a Controller that uses a certain Company.
     *
     * @param company Company to be used by the Controller.
     */
    public  RegisterNewEmployeeController(Company company){
        this.company = company;
        this.employee = null;
    }

    /**
     * Permits the creation of an Employee.
     *
     * @param name Name of the Employee.
     * @param phoneNumber Phone Number of the Employee.
     * @param emailString E-mail of the Employee.
     * @param socCode SOC Code of the Employee.
     * @param organizationRole Organization Role of the Employee.
     * @param address Address of the Employee.
     * @return Boolean Value that represents if the Employee was created or not (true = Employee was created |
     * false = Employee was not created).
     */
    public boolean registerNewEmployee(String name, String phoneNumber, String emailString, String socCode,
                                       String organizationRole, String address){

        identifyStore();

        Email email = new Email(emailString);

        this.employee = this.employeeStore.registerNewEmployee(name, phoneNumber, email, socCode,
                organizationRole, address);

        return this.employeeStore.validateEmployee(employee);
    }

    /**
     * Permits the creation of an Employee (Specialist Doctor).
     *
     * @param name Name of the Employee.
     * @param phoneNumber Phone Number of the Employee.
     * @param emailString E-mail of the Employee.
     * @param socCode SOC Code of the Employee.
     * @param organizationRole Organization Role of the Employee.
     * @param address Address of the Employee.
     * @return Boolean Value that represents if the Employee was created or not (true = Employee was created |
     * false = Employee was not created).
     */
    public boolean registerNewEmployee(String name, String phoneNumber, String emailString, String socCode,
                                       String organizationRole, String address, String doctorIndexNumber){
        identifyStore();

        Email email = new Email(emailString);

        this.employee = this.employeeStore.registerNewEmployee(name, phoneNumber, email, socCode, organizationRole,
                address, doctorIndexNumber);

        return this.employeeStore.validateEmployee(employee);
    }

    /**
     * Allows the addition of an Employee to the Employee Store.
     * If the Employee is not validated, the returned boolean value will be false, if not, the value will be true.
     *
     * @return Boolean value considering the addition of an Employee to the Store.
     */
    public boolean saveEmployee() throws IOException {
        return this.employeeStore.saveEmployee(employee);
    }

    /**
     * Allows the Controller to identify the store to be used in the creation, validation and saving of an Employee.
     */
    private void identifyStore(){
        employeeStore = this.company.getEmployeeStore();
    }

    /**
     * Allows the Controller to get the Employee Store and send it to the User Interface.
     *
     * @return Employee Store that has all the registered employees.
     */
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    /**
     * Allows the System to verify if the given Phone Number does already exist in the Employee Store.
     * This is a needed confirmation has there should not be two equal Phone Numbers.
     *
     * @param phoneNumber E-mail of the Employee.
     * @return Boolean value according to the confirmation (true = Phone Number already exists in the Employee
     * Store | false = Phone Number does not exist in the Employee Store).
     */
    public boolean containsPhoneNumber(String phoneNumber){
        identifyStore();
        return employeeStore.containsPhoneNumber(phoneNumber);
    }

    /**
     * Allows the System to verify if the given E-mail does already exist in the Employee Store.
     * This is a needed confirmation has there should not be two equal E-mails.
     *
     * @param email E-mail of the Employee.
     * @return Boolean value according to the confirmation (true = E-mail already exists in the Employee
     * Store | false = E-mail does not exist in the Employee Store).
     */
    public boolean containsEmail(String email){
        identifyStore();
        return employeeStore.containsEmail(email);
    }

    /**
     * Allows the System to verify if the given SOC Code does already exist in the Employee Store.
     * This is a needed confirmation has there should not be two equal SOC Codes.
     *
     * @param socCode E-mail of the Employee.
     * @return Boolean value according to the confirmation (true = SOC Code already exists in the Employee
     * Store | false = SOC Code does not exist in the Employee Store).
     */
    public boolean containsSocCode(String socCode){
        identifyStore();
        return employeeStore.containsSocCode(socCode);
    }

    /**
     * Allows the System to verify if the given Doctor Index Number does already exist in the Employee Store.
     * This is a needed confirmation has there should not be two equal Doctor Index Numbers.
     *
     * @param doctorIndexNumber Doctor Index Number of the Employee.
     * @return Boolean value according to the confirmation (true = Doctor Index Numbers already exists in
     * the Employee Store | false = Doctor Index Number does not exist in the Employee Store).
     */
    public boolean containsDoctorIndexNumber(String doctorIndexNumber){
        identifyStore();
        return employeeStore.containsDoctorIndexNumber(doctorIndexNumber);
    }
}
