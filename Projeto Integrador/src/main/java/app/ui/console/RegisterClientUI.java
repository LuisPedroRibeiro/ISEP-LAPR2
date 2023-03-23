package app.ui.console;

import app.controller.RegisterClientController;
import app.mappers.dto.ClientDto;
import app.utils.Utils;
import auth.domain.model.Email;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * @author Pedro Graça
 */
public class RegisterClientUI implements Runnable {

    private static final String TRY_AGAIN = "Invalid Format. Please try again.";

    public RegisterClientUI() {
        //Constructs a RegisterClientUI with no parameters
    }


    /**
     * Method to run this UI
     */
    public void run() {

        RegisterClientController clientController = new RegisterClientController();

        String name = Utils.readLineFromConsole("Name:");
        Email email = getEmail(clientController);
        String taxIdentificationNumber =Utils.getTaxIdentificationNumber();
        String citizenCardNumber =getCitizenCardNumber();
        String nhsNumber = getNhsNumber();
        String birthDate = getBirthDate();
        String gender = Utils.readLineFromConsole("Gender (Male/Female):");
        String phoneNumber = getPhoneNumber(clientController);
        ClientDto clientDto;


        if (Objects.equals(gender, "")) {
            clientDto = new ClientDto(name, email, taxIdentificationNumber, citizenCardNumber, nhsNumber, birthDate, phoneNumber);
        } else {
            clientDto = new ClientDto(name, email, taxIdentificationNumber, citizenCardNumber, nhsNumber, birthDate, gender, phoneNumber);
        }


        try {
            if ((clientController.createClient(clientDto))) {
                Utils.printLineToConsole(clientDto.toString());
                if (Utils.confirm("Are you sure you want to create a Client with these data? (s/n)") && clientController.saveClient()) {
                    Utils.printLineToConsole("The Client was registered with success.");
                }
            }
        } catch (IllegalArgumentException | IOException e) {
            Utils.printLineToConsole("##ERROR## - Some Attribute was invalid.");
        }
        Utils.printLineToConsole("--------------------------------------");
        if (!clientController.getStore().getClientList().isEmpty())
            Utils.showList(clientController.getStore().getClientList(), "##CLIENTS##");
    }


    /**
     * Method to get a Email from the console
     *
     * @param ctrl RegisterClientController to do some validations
     * @return a valid Email
     */
    public Email getEmail(RegisterClientController ctrl) {
        boolean emailError = true;
        Email email = null;
        do {
            try {
                email = new Email(Utils.readLineFromConsole("Email:"));
                emailError = ctrl.containsEmail(email);
            } catch (Exception e) {
                Utils.printLineToConsole(e.getMessage());
            }
        } while (emailError);
        return email;
    }

    /**
     * Method to get the Citizen Card Number from the console
     *
     * @return the Citizen Card Number
     */
    public String getCitizenCardNumber() {
        boolean citizenCardNum;
        String citizenCardNumber;
        do {
            citizenCardNumber = Utils.readLineFromConsole("Citizen Card Number:");
            assert citizenCardNumber != null;
            citizenCardNum = onlyDigits(citizenCardNumber);
            if (!citizenCardNum)
                Utils.printLineToConsole(TRY_AGAIN);
        } while (!citizenCardNum);
        return citizenCardNumber;
    }

    /**
     * Method to get the National Healthcare Service Number from the console
     *
     * @return the NHS number
     */
    public String getNhsNumber() {
        boolean nhsNum;
        String nhsNumber;
        do {
            nhsNumber = Utils.readLineFromConsole("National Healthcare Service (NHS) Number:");
            assert nhsNumber != null;
            nhsNum = onlyDigits(nhsNumber);
            if (!nhsNum)
                Utils.printLineToConsole(TRY_AGAIN);
        } while (!nhsNum);
        return nhsNumber;
    }


    /**
     * Method to get a date from the console
     *
     * @return a valid date on format DD/MM/YYY
     */
    public String getBirthDate() {
        boolean birthDateError = true;
        String birthDate = null;
        do {
            try {

                birthDate = Utils.readLineFromConsole("Birth Date (DD/MM/YYYY):");
                assert birthDate != null;
                if (birthDate.length() == 10) {
                    birthDateError = verifyDate(birthDate);
                    if (!verifyAge(birthDate)) {
                        birthDateError = false;
                        Utils.printLineToConsole("The Client cannot be more than 150 years old.");
                    }
                    if (!dateIsValid(birthDate)) {
                        birthDateError = false;
                        Utils.printLineToConsole("The inputted date is in the future.");
                    }
                } else {
                    birthDateError = false;
                    Utils.printLineToConsole("Invalid Format.");
                }
            } catch (Exception e) {
                Utils.printLineToConsole(TRY_AGAIN);
            }
        } while (!birthDateError);
        return birthDate;
    }


    /**
     * Method to get a Phone Number from the console
     *
     * @param ctrl RegisterClientController to do some validations
     * @return the phone number
     */
    public String getPhoneNumber(RegisterClientController ctrl) {
        boolean phoneNum;
        String phoneNumber;
        do {
            phoneNumber = Utils.readLineFromConsole("Phone Number:");
            assert phoneNumber != null;
            phoneNum = onlyDigits(phoneNumber);
            if (ctrl.containsPhoneNumber(phoneNumber)) {
                phoneNum = false;
            }
            if (!phoneNum)
                Utils.printLineToConsole("Try again.");
        } while (!phoneNum);
        return phoneNumber;
    }


    /**
     * Method to verify if a String is only constituted by digits
     *
     * @param str the String that is pretended to test in
     * @return the boolean result of the operation of checking if the String is only constituted by digits
     */
    public boolean onlyDigits(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                p++;
        }
        return p == str.length();
    }


    /**
     * Method to verify if the Birth Date of the Client is on the correct format and if it is valid
     *
     * @param date the String written by the Receptionist
     * @return the boolean value of the operation
     */
    public boolean verifyDate(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dateObj = dateFormat.parse(date);
            if (!date.equals(dateFormat.format(dateObj))) {
                Utils.printLineToConsole("The inputted date does not exist.");
                return false;
            }
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


    /**
     * Method to verify the age of the Client
     *
     * @param date the Birth Date of the Client
     * @return the boolean value of the operation
     */
    public boolean verifyAge(String date) {
        int maxAge = 150;
        int birthYear = Integer.parseInt(date.substring(6, 10));
        int birthMonth = Integer.parseInt(date.substring(3, 5));
        int birthDay = Integer.parseInt(date.substring(0, 2));
        int actualYear = LocalDate.now().getYear();
        int actualMonth = LocalDate.now().getMonthValue();
        int actualDay = LocalDate.now().getDayOfMonth();
        int differenceYears = actualYear - birthYear;
        if (differenceYears < maxAge) {
            return true;
        }
        if (differenceYears == maxAge) {
            if (birthMonth == actualMonth) {
                return birthDay > actualDay;
            }
            return birthMonth >= actualMonth;
        }
        return false;
    }


    /**
     * Method to check if the Birth Date is possible in the Present
     *
     * @param date the Birth Date of the Client
     * @return the boolean value of the operation
     */
    public boolean dateIsValid(String date) {
        int birthYear = Integer.parseInt(date.substring(6, 10));
        int birthMonth = Integer.parseInt(date.substring(3, 5));
        int birthDay = Integer.parseInt(date.substring(0, 2));
        int actualYear = LocalDate.now().getYear();
        int actualMonth = LocalDate.now().getMonthValue();
        int actualDay = LocalDate.now().getDayOfMonth();
        if (actualYear < birthYear) {
            return false;
        }
        if (actualYear == birthYear) {
            if (actualMonth == birthMonth) {
                return actualDay >= birthDay;
            }
            return actualMonth >= birthMonth;
        }
        return true;
    }
}


