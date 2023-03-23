package app.ui.console;

import app.controller.CreateParameterController;
import app.mappers.dto.ParameterCategoryDto;
import app.utils.Utils;

import java.util.List;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class CreateParameterUI implements Runnable {

    /**
     * String that contains a question relative to a confirmation of the data.
     */
    private static final String CONFIRMATION = "Do you confirm this data?";
    /**
     * String that contains a declaration of an error.
     */
    private static final String ERROR = String.format("%nERROR: OPERATION TERMINATED%n " +
            "Motive: An inserted attribute is invalid. %n");

    /**
     * Constructor with no parameters.
     */
    public CreateParameterUI() {
        //Constructs a CreateParameterUI with no parameters.
    }

    /**
     * Permits the system to run the Administrator function of creating a new Parameter Category.
     */
    public void run() {
        CreateParameterController controller = new CreateParameterController();
        List<ParameterCategoryDto> parameterCategoryDtoList = controller.getParameterCategoryStoreDto();
        if (!parameterCategoryDtoList.isEmpty()) {
            boolean codeError;


            Utils.printLineToConsole("###NEW PARAMETER###");
            String shortName = Utils.readLineFromConsole("Parameter Short Name:");
            String code;

            do {
                code = Utils.readLineFromConsole("Parameter Code:");
                assert code != null;
                codeError = Utils.onlyDigits(code);
                if (!Utils.onlyDigits(code)) {
                    Utils.printLineToConsole("ERROR: Parameter Code can only have numbers.");
                }
            } while (!codeError);

            String description = Utils.readLineFromConsole("Parameter Description:");

            try {
                if (controller.createParameter(code, shortName, description)) {
                    int option = Utils.showAndSelectIndex(parameterCategoryDtoList, "PARAMETER CATEGORY LIST:");
                    if (option != -1) {
                        String toPrint = String.format("%n###PARAMETER CATEGORY###%n%n - Code: %s%n - Name: %s%n", code,
                                parameterCategoryDtoList.get(option).getName());
                        Utils.printLineToConsole(toPrint);
                        if (Utils.confirm(CONFIRMATION) && controller.saveParameter(parameterCategoryDtoList.get(option).getCode())) {
                            Utils.printLineToConsole("OPERATION SUCCESSFUL");
                        } else {
                            Utils.printLineToConsole("ERROR: OPERATION UNSUCCESSFUL");
                        }
                    }
                }
            } catch (Exception exception) {
                Utils.printLineToConsole(ERROR);
                String exceptionMessage = String.format(" %s", exception.getMessage());
                Utils.printLineToConsole(exceptionMessage);
            }
        } else {
            Utils.printLineToConsole("Cannot create a parameter without at least a parameter category in the system ");
            Utils.printLineToConsole("Please create one");
        }
    }
}
