package app.ui.console;

import app.controller.RegisterNewEmployeeController;
import app.domain.shared.Constants;
import app.list.EmployeeRolesList;
import app.utils.Utils;
import auth.domain.model.Email;

import java.io.IOException;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class RegisterNewEmployeeUI implements Runnable{

    /**
     * String that contains a question relative to a confirmation of the data.
     */
    private static final String CONFIRMATION = "Do you confirm the shown data?";
    /**
     * String that contains a declaration of an error.
     */
    private static final String ERROR = String.format("%nERROR: OPERATION TERMINATED%n " +
            "Motive: An inserted attribute is invalid.");

    /**
     * Constructor with no parameters.
     */
    public RegisterNewEmployeeUI() {
        //Constructs a RegisterNewEmployeeUI with no parameters.
    }

    /**
     * Permits the system to run the Administrator function of creating a new Employee.
     */
    public void run(){
        boolean emailError = true;
        boolean phoneNumberError;
        boolean socCodeError;

        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        EmployeeRolesList employeeRolesList = new EmployeeRolesList();
        Utils.showList(employeeRolesList.getList(), "##EMPLOYEE ROLES##");
        String role = Utils.readLineFromConsole("Select the role:");

        while(!(role.equalsIgnoreCase(Constants.ROLE_ADMIN) || role.equalsIgnoreCase(Constants.ROLE_CHEMTECH) ||
                role.equalsIgnoreCase(Constants.ROLE_LABCO) || role.equalsIgnoreCase(Constants.ROLE_RECEP) ||
                role.equalsIgnoreCase(Constants.ROLE_SPECDOC) || role.equalsIgnoreCase(Constants.ROLE_MEDTECH))){
            Utils.printLineToConsole("ERROR: Selected role does not exist.");
            role = Utils.readLineFromConsole("Select the role:");
        }

        String name = Utils.readLineFromConsole("Name:");
        String phoneNumber;
        String email = null;
        String socCode;
        String address;

        do{
            phoneNumber = Utils.readLineFromConsole("Phone Number:");
            assert phoneNumber != null;
            phoneNumberError = Utils.onlyDigits(phoneNumber);
            if(! phoneNumberError){
                Utils.printLineToConsole("ERROR: The Phone Number can not have letters.");
            }
            if(controller.containsPhoneNumber(phoneNumber)){
                phoneNumberError = false;
                Utils.printLineToConsole("ERROR: Inserted Phone Number is already in use.");
            }
        } while(! phoneNumberError);

        do{
            try{
                Email emailInObject = new Email(Utils.readLineFromConsole("E-mail:"));
                emailError = controller.containsEmail(emailInObject.toString());
                if(emailError){
                    Utils.printLineToConsole("ERROR: Inserted E-mail is already in use.");
                }
                email = emailInObject.toString();
            } catch (Exception exception){
                Utils.printLineToConsole(exception.getMessage());
            }
        } while (emailError);

        do{
            socCode = Utils.readLineFromConsole("SOC Code:");
            assert socCode != null;
            socCodeError = Utils.onlyDigits(socCode);
            if(! socCodeError){
                Utils.printLineToConsole("ERROR: The SOC Code can not have letters.");
            }
            if(controller.containsSocCode(socCode)){
                socCodeError = false;
                Utils.printLineToConsole("ERROR: Inserted SOC Code is already in use.");
            }
        } while(! socCodeError);

        address = Utils.readLineFromConsole("Address:");

        if(role.equalsIgnoreCase(Constants.ROLE_SPECDOC)){
            runForSpecialistDoctor(name, phoneNumber, email, socCode, address, controller);
        } else{
            runForOtherTypeOfEmployee(name, phoneNumber, email, socCode, address, controller, role);
        }

        Utils.printLineToConsole("");
        Utils.showList(controller.getEmployeeStore().getEmployeeList(), "EMPLOYEES LIST");
    }

    /**
     * Permits the System to run the Administrator function of creating a new Employee, when he asks to create a
     * Specialist Doctor.
     *
     * @param name Name that was typed by the Administrator.
     * @param phoneNumber Phone Number that was typed by the Administrator.
     * @param email E-mail that was typed by the Administrator.
     * @param socCode SOC Code that was typed by the Administrator.
     * @param address Address that was typed by the Administrator.
     * @param controller Controller that allows the Administrator function to work.
     */
    private void runForSpecialistDoctor(String name, String phoneNumber, String email, String socCode, String address,
                                        RegisterNewEmployeeController controller){
        boolean doctorIndexNumberError;

        String organizationRole = Constants.ROLE_SPECDOC;
        String doctorIndexNumber;

        do{
            doctorIndexNumber = Utils.readLineFromConsole("Doctor Index Number:");
            assert doctorIndexNumber != null;
            doctorIndexNumberError = Utils.onlyDigits(doctorIndexNumber);
            if(! doctorIndexNumberError){
                Utils.printLineToConsole("ERROR: Doctor Index Number can not have letters.");
            }
            if(controller.containsDoctorIndexNumber(doctorIndexNumber)){
                doctorIndexNumberError = false;
                Utils.printLineToConsole("ERROR: Inserted Doctor Index Number is already in use.");
            }
        } while(! doctorIndexNumberError);

        try{
            if(controller.registerNewEmployee(name, phoneNumber, email, socCode, organizationRole, address,
                    doctorIndexNumber)){

                String print = String.format("%n##EMPLOYEE## %n%n Name: %s %n Phone Number: %s %n E-mail: %s %n " +
                                "Address: %s %n Organization Role: %s %n SOC Code: %s %n " +
                                "Doctor Index Number: %s %n", name, phoneNumber, email, address,
                        organizationRole, socCode, doctorIndexNumber);
                Utils.printLineToConsole(print);

                if(Utils.confirm(CONFIRMATION)){
                    if(controller.saveEmployee()){
                        Utils.printLineToConsole("OPERATION SUCCESSFUL");
                    }
                    else{Utils.printLineToConsole("ERROR: OPERATION UNSUCCESSFUL");}
                }
                else if(! Utils.confirm(CONFIRMATION)){
                    Utils.printLineToConsole("OPERATION FINISHED");
                }
            }
        } catch (IllegalArgumentException | IOException exception){
            Utils.printLineToConsole(ERROR);
            String exceptionMessage = String.format(" Error Description: %s", exception.getMessage());
            Utils.printLineToConsole(exceptionMessage);
        }
    }

    /**
     * Permits the System to run the Administrator function of creating a new Employee, when he asks to create an
     * Employee that is not a Specialist Doctor.
     *
     * @param name Name that was typed by the Administrator.
     * @param phoneNumber Phone Number that was typed by the Administrator.
     * @param email E-mail that was typed by the Administrator.
     * @param socCode SOC Code that was typed by the Administrator.
     * @param address Address that was typed by the Administrator.
     * @param controller Controller that allows the Administrator function to work.
     */
    private void runForOtherTypeOfEmployee(String name, String phoneNumber, String email, String socCode, String address,
                                           RegisterNewEmployeeController controller, String role){
        String organizationRole;

        if(role.equalsIgnoreCase(Constants.ROLE_CHEMTECH)){
            organizationRole = Constants.ROLE_CHEMTECH;
        } else if(role.equalsIgnoreCase(Constants.ROLE_LABCO)){
            organizationRole = Constants.ROLE_LABCO;
        } else if(role.equalsIgnoreCase(Constants.ROLE_MEDTECH)){
            organizationRole = Constants.ROLE_MEDTECH;
        } else if(role.equalsIgnoreCase(Constants.ROLE_ADMIN)){
            organizationRole = Constants.ROLE_ADMIN;
        } else {
            organizationRole = Constants.ROLE_RECEP;
        }

        try{
            if(controller.registerNewEmployee(name, phoneNumber, email, socCode, organizationRole, address)){

                String print = String.format("%n##EMPLOYEE## %n%n Name: %s %n Phone Number: %s %n E-mail: %s %n " +
                                "Address: %s %n Organization Role: %s %n SOC Code: %s", name, phoneNumber, email,
                        address, organizationRole, socCode);
                Utils.printLineToConsole(print);

                if(Utils.confirm(CONFIRMATION)){
                    if(controller.saveEmployee()){
                        Utils.printLineToConsole("OPERATION SUCCESSFUL");
                    }
                    else{
                        Utils.printLineToConsole("OPERATION UNSUCCESSFUL");
                    }
                }
                else{
                    Utils.printLineToConsole("OPERATION FINISHED");
                }

            }
        } catch (IllegalArgumentException | IOException exception){
            Utils.printLineToConsole(ERROR);
            String exceptionMessage = String.format(" Error Description: %s", exception.getMessage());
            Utils.printLineToConsole(exceptionMessage);
        }
    }
}