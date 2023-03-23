package app.ui.console;

import app.controller.CreateTestTypeController;

import app.list.AdapterEnum;
import app.mappers.dto.ParameterCategoryDto;
import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André Soares
 */


public class CreateTestTypeUI implements  Runnable {

    /**
     * String for suggesting the user to try again, for use in run method
     */
    private static final String TRY_AGAIN = "Please, Try Again.";


    /**
     * String used for reporting a error to the user
     */
    private static final String ERROR = String.format("%nERROR: OPERATION TERMINATED%n " +
            "Motive: An inserted attribute is invalid. %n");

    /**
     * Constructor of the class CreateTestTypeUI executed when creating an object
     */
    public CreateTestTypeUI() {
        // no need for a completed constructor in a ui,because all it needs in the user input and the controller
    }

    /**
     * Run method from the interface Runnable,executes the interaction between the controller  and the User and vice-versa
     */
    public void run() {
        CreateTestTypeController testTypeController = new CreateTestTypeController();
        List<ParameterCategoryDto> pcStore = new ArrayList<>(testTypeController.getParameterCategoryStoreDto());
        if (pcStore.isEmpty()) {
            Utils.printLineToConsole("Cannot create test types while there isn´t a parameter category in the system.");
            Utils.printLineToConsole("Please create one");
        } else {
            Utils.printLineToConsole("###NEW TEST TYPE###");
            String code = getCorrectCode();
            String description = getCorrectDescription();
            String collectionMethod = getCorrectCollectionMethod();
            String toPrint = String.format("%n###TEST TYPE###%n%n - Code: %s%n - Description : %s%n - " +
                    "Collection Method : %s%n", code, description, collectionMethod);
            Utils.printLineToConsole(toPrint);
            if (Utils.confirm("Are you sure you want to create a Test Type with these data?")) {

                try {
                    if (testTypeController.createTestType(code, collectionMethod, description)) {
                        insertParameterCategories(testTypeController, pcStore);
                        int index = Utils.showAndSelectIndex(AdapterEnum.getTexts(), "List of external module in the system");
                        if (index == -1) {
                            Utils.printLineToConsole("A test type should have a module associated with it");
                        } else {
                            testTypeController.setAdapterByCode(index);
                            if (testTypeController.saveTestType()) {
                                Utils.printLineToConsole("Test type created successfully.");
                                showListOfTestTypesInTheSystem(testTypeController);
                            }
                        }
                    }
                } catch(Exception e){
                    Utils.printLineToConsole(ERROR);
                    String exceptionMessage = String.format(" %s", e.getMessage());
                    Utils.printLineToConsole(exceptionMessage);
                }
            }
        }
    }

    /**
     * Asks the administrator for a code string while returning the validated one
     *
     * @return the validated description method
     */
    public String getCorrectCode() {
        boolean codeError = true;
        String code = null;
        do {
            try {
                code = Utils.readLineFromConsole("Code:");
                codeError = false;
            } catch (Exception e) {
                Utils.printLineToConsole(e.getMessage());
                Utils.printLineToConsole(TRY_AGAIN);
            }
        } while (codeError);
        return code;
    }

    /**
     * Asks the administrator for a description string while returning the validated one
     *
     * @return the validated description method
     */
    public String getCorrectDescription() {
        boolean descriptionError = true;
        String description = null;
        do {
            try {
                description = Utils.readLineFromConsole("Description:");
                descriptionError = false;
            } catch (Exception e) {
                Utils.printLineToConsole(e.getMessage());
                Utils.printLineToConsole(TRY_AGAIN);
            }
        } while (descriptionError);
        return description;
    }

    /**
     * Asks the administrator for a collection method string while returning the validated one
     *
     * @return the validated collection method
     */
    public String getCorrectCollectionMethod() {
        boolean collectionMethodError = true;
        String collectionMethod = null;
        do {
            try {
                collectionMethod = Utils.readLineFromConsole("Collection Method:");
                collectionMethodError = false;
            } catch (Exception e) {
                Utils.printLineToConsole(e.getMessage());
                Utils.printLineToConsole(TRY_AGAIN);
            }
        } while (collectionMethodError);
        return collectionMethod;
    }

    /**
     * Allows the user to chose from a list of ParameterCategoryDto objects and add the ParameterCategory with the same data of the chosen Dto
     * to the test type being created in the controller
     *
     * @param controller The controller currently being used in the run method
     * @param pcStore the list where all the ParameterCategoryDto are stored
     */
    public void insertParameterCategories(CreateTestTypeController controller,List<ParameterCategoryDto> pcStore) {
       int option=-2;
        while(option !=-1&&!pcStore.isEmpty()) {
        option = Utils.showAndSelectIndex(pcStore, "List of categories available in the system for this test type");
        if (option != -1) {
            Utils.printLineToConsole(pcStore.get(option).toString());
            if (Utils.confirm("Are you sure you want to add this Parameter Category to your test type")
                    && controller.saveParameterCategory(pcStore.get(option).getCode())) {
                pcStore.remove(option);
            }
        }
    }
}

    /**
     * Prints the list of existing test types in the system
     *
     * @param controller The controller currently being used in the run method
     */
    public void showListOfTestTypesInTheSystem(CreateTestTypeController controller){
        if(Utils.confirm("Do you wanna see the list of Test Types that exist in the system?")){
            Utils.showList(controller.getTestTypeDto(),"##LIST OF EXISTING TEST TYPES##");
        }
    }
}