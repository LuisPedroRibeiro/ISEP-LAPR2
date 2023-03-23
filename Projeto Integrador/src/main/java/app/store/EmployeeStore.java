package app.store;

import app.domain.model.*;
import auth.domain.model.Email;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class EmployeeStore {

    /**
     * List of Employees working for the Company.
     */
    List<Employee> employeeList = new ArrayList<>();

    /**
     * Generates an instance of an Employee, having in consideration his/her role in the system.
     *
     * @param name Name of the Employee.
     * @param phoneNumber Phone Number of the Employee.
     * @param email E-mail of the Employee.
     * @param socCode SOC Code of the Employee.
     * @param organizationRole Organization role of the Employee.
     * @param address Address of the Employee.
     */
    public Employee registerNewEmployee(String name, String phoneNumber, Email email, String socCode,
                                        String organizationRole, String address){
        return new Employee(name, phoneNumber, email, socCode, organizationRole, address);
    }

    /**
     * Generates an instance of an Employee, considering that his/her role is Specialist Doctor.
     *
     * @param name Name of the Employee.
     * @param phoneNumber Phone Number of the Employee.
     * @param email E-mail of the Employee.
     * @param socCode SOC Code of the Employee.
     * @param organizationRole Organization role of the Employee.
     * @param address Address of the Employee.
     */
    public Employee registerNewEmployee(String name, String phoneNumber, Email email, String socCode,
                                        String organizationRole, String address, String doctorIndexNumber){
        return new SpecialistDoctor(name, phoneNumber, email, socCode, organizationRole, address,
                doctorIndexNumber);
    }

    /**
     * Allows the system to add an Employee to the List of Employees.
     *
     * @param employee Employee to be added to the List.
     * @return Boolean value relative to the addition of an Employee to the Employee Store.
     */
    public boolean saveEmployee(Employee employee) throws IOException {
        if(! validateEmployee(employee)){
            Employee.reduceNumberOfEmployees();
            return false;
        }
        else{
            employee.setPassword();
            employee.setEmployeeID();
            employee.registerUserAndSendEmail();
        }
        return this.employeeList.add(employee);
    }

    /**
     * Checks if an Employee can be added to the List of Employees.
     * Returns true if the Employee was validated.
     *
     * @param employee Employee to be validated.
     * @return Boolean that represents if the Employee was validated or not.
     */
    public boolean validateEmployee(Employee employee){
        if(employee == null){
            return false;
        }
        else{
            for(Employee employee1 : employeeList){
                if(employee.equals(employee1)){
                    return false;
                }
            }
        }
        return !this.employeeList.contains(employee);
    }

    /**
     * Allows the system to access the Employee Store and get the List that has all of the employees.
     *
     * @return List with all the registered Employees.
     */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Generates a String that represents the List that has all of the registered employees.
     *
     * @return String that represents all the Employees registered on the Store.
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Employee employee : employeeList){
            stringBuilder.append(employee.toString());
        }
        return stringBuilder.toString().trim();
    }

    /**
     * Allows the System to verify if the given Phone Number does already exist in the Employee Store.
     * This is a needed confirmation has there should not be two equal phone numbers.
     *
     * @param phoneNumber Phone Number of the Employee.
     * @return Boolean value according to the confirmation (true = Phone Number already exists in the Employee
     * Store | false = Phone Number does not exist in the Employee Store).
     */
    public boolean containsPhoneNumber(String phoneNumber){
        for(Employee employee : employeeList){
            if(phoneNumber.equals(employee.getPhoneNumber())){
                return true;
            }
        }
        return false;
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
        for(Employee employee : employeeList){
            if(email.equals(employee.getEmail())){
                return true;
            }
        }
        return false;
    }

    /**
     * Allows the System to verify if the given SOC Code does already exist in the Employee Store.
     * This is a needed confirmation has there should not be two equal SOC Codes.
     *
     * @param socCode SOC Code of the Employee.
     * @return Boolean value according to the confirmation (true = SOC Code already exists in the Employee
     * Store | false = SOC Code does not exist in the Employee Store).
     */
    public boolean containsSocCode(String socCode){
        for(Employee employee : employeeList){
            if(socCode.equals(employee.getSocCode())){
                return true;
            }
        }
        return false;
    }

    /**
     * Allows the System to verify if the given Doctor Index Number does already exist in the Employee Store.
     * This is a needed confirmation has there should not be two equal Doctor Index Number.
     *
     * @param doctorIndexNumber Doctor Index Number of the Employee.
     * @return Boolean value according to the confirmation (true = Doctor Index Number already exists in the
     * Employee Store | false = Doctor Index Number does not exist in the Employee Store).
     */
    public boolean containsDoctorIndexNumber(String doctorIndexNumber){
        for(Employee employee : employeeList){
            if(employee instanceof SpecialistDoctor && doctorIndexNumber.equals(((SpecialistDoctor) employee).getDoctorIndexNumber())){
                return true;
            }
        }
        return false;
    }

    /**
     * Method that returns the Role of a certain Employee giving his Email as a Parameter
     *
     * @param email the Email used to found the Employee
     * @return the Employee organization Role
     */
    public String getRoleByEmail(Email email){
        for(Employee employee: employeeList){
            if(employee.getEmail().equals(email.toString())){
                return employee.getOrganizationRole();
            }
        }
        throw new IllegalArgumentException("There is no employees with the given Email.");
    }
}
