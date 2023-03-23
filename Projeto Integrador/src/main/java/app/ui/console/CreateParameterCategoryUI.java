package app.ui.console;

import app.controller.CreateParameterCategoryController;
import app.utils.Utils;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class CreateParameterCategoryUI implements Runnable {

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
    public CreateParameterCategoryUI(){
        //Constructs a CreateParameterCategoryUI with no parameters.
    }

    /**
     * Permits the system to run the Administrator function of creating a new Parameter Category.
     */
    public void run(){

        CreateParameterCategoryController controller = new CreateParameterCategoryController();

        boolean codeError;

        Utils.printLineToConsole("###NEW PARAMETER CATEGORY###");

        String code;

        do{
            code = Utils.readLineFromConsole("Parameter Category Code:");
            assert code != null;
            codeError = Utils.onlyDigits(code);
            if(!Utils.onlyDigits(code)){
                Utils.printLineToConsole("ERROR: Parameter Category Code can only have numbers.");
            }
        }while(! codeError);

        String name = Utils.readLineFromConsole("Parameter Category Name:");

        try{
            if(controller.createParameterCategory(code, name)){
                String toPrint = String.format("%n###PARAMETER CATEGORY###%n%n - Code: %s%n - Name: %s%n", code, name);
                Utils.printLineToConsole(toPrint);

                if(Utils.confirm(CONFIRMATION) && controller.saveParameterCategory()){
                    Utils.printLineToConsole("OPERATION SUCCESSFUL");
                }
                else{
                    Utils.printLineToConsole("OPERATION UNSUCCESSFUL");
                }
            }
        }catch (Exception exception){
            Utils.printLineToConsole(ERROR);
            String exceptionMessage = String.format(" %s", exception.getMessage());
            Utils.printLineToConsole(exceptionMessage);
        }
    }

}
