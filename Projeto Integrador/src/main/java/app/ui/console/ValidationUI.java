package app.ui.console;


import app.controller.ValidationController;
import app.mappers.dto.TestDto;
import app.utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ValidationUI implements Runnable {

    /**
     * String that contains a declaration of an error.
     */
    private static final String ERROR = String.format("%nERROR: OPERATION TERMINATED%n");

    /**
     * Constructor of the class ValidationUI executed when creating an object
     */
    public ValidationUI() {
        //This method is empty because only the run method is used.
    }

    /**
     * Run method from the interface Runnable,executes the interaction between the controller  and the User and vice-versa
     */
    @Override
    public void run() {
        boolean confirmation = false;
        List<String> options = new ArrayList<>();
        options.add("Validate all available tests currently in the system");
        options.add("Choose a subset of tests to validate");
        ValidationController validationController = new ValidationController();
        List<TestDto> testList = new ArrayList<>(validationController.getListOfUnvalidatedTestsDto());
        if (testList.isEmpty()) {
            Utils.printLineToConsole("There are not available tests to be validated in the system");
        } else {
            try {
                int option = Utils.showAndSelectIndex(options, "Please select a option:");
                if (option == 0) {
                    Utils.showList(testList, "List of tests that are currently available to be validated ");
                    confirmation = Utils.confirm("Would you like to validate all the shown tests?");
                    if (confirmation) {
                        validationController.createListWithAllTestsAvailableToBeValidated();
                    }
                } else if (option == 1) {
                    option = -2;
                    while (option != -1 && !testList.isEmpty()) {
                        option = Utils.showAndSelectIndex(testList, "List of tests that are currently available to be validated");
                        if (option != -1) {
                            Utils.printLineToConsole(testList.get(option).toString());
                            if (Utils.confirm("Are you sure you want to add this test to the list of tests being validated?")
                                    && validationController.saveTestInListByNhsCode(testList.get(option).getNhsCode())) {
                                testList.remove(option);
                            }
                        }
                    }
                    confirmation = Utils.confirm("Are you sure you want to validate all the chosen tests?");
                }

                if (confirmation) {
                    validationController.validateTestsInsideTestsToBeValidatedList();
                    Utils.printLineToConsole("Tests validation done with success");
                }
            } catch (IllegalArgumentException e) {
                Utils.printLineToConsole(ERROR);
                String message = String.format(" Error Description: %s", e.getMessage());
                Utils.printLineToConsole(message);
            }catch (IOException e){
                Utils.printLineToConsole(ERROR);
                Utils.printLineToConsole("The email was not sent successfully.%nPlease check.");
            } catch (Exception e) {
                Utils.printLineToConsole(ERROR);
            }
        }
    }
}
