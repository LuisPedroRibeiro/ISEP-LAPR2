package app.ui.console;

import app.controller.RecordResultsController;
import app.mappers.dto.ParameterDto;
import app.utils.Utils;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.util.List;

/**
 * User Interface for the User Story 12 (Record the Results of a Test).
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class RecordResultsUI implements Runnable {

    /**
     * String that contains a declaration of an error.
     */
    private static final String ERROR = String.format("%nERROR: OPERATION TERMINATED%n " +
            "Motive: Some error has occurred.");
    /**
     * String that contains a declaration of the end of the function.
     */
    private static final String FINISHED = "OPERATION FINISHED";

    public RecordResultsUI(){
        //Constructs a RecordResultsUI with no attributes.
    }

    /**
     * Allows the System to run the function of the Chemical Analysis Technologist of recording the results of
     * a given Test.
     */
    @Override
    public void run() {
        boolean cancel = false;
        boolean barcodeLoop = true;

        RecordResultsController controller = new RecordResultsController();

        try{
            do {
                String barcodeNumber = Utils.readLineFromConsole("Barcode of the Test:");
                try {
                    controller.getTestByBarcode(barcodeNumber);
                    barcodeLoop = false;
                } catch (OutputException | BarcodeException | IOException e) {
                    Utils.printLineToConsole("Barcode not found please insert a new one");
                }
            }while (barcodeLoop);

            List<ParameterDto> list = controller.getParameterList();

           while(!list.isEmpty() && !cancel){
                int index = Utils.showAndSelectIndex(list, "\nLIST OF PARAMETERS");
                if(index == -1){
                    cancel = true;
                } else{
                    double value = Utils.readDoubleFromConsole("Result Value:");

                    while(value < 0){
                        Utils.printLineToConsole("The Result value can not be negative.");
                        value = Utils.readDoubleFromConsole("Result value:");
                    }

                    try {
                        controller.addTestResult(list.get(index).getCode(), value);
                        list.remove(index);
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                        Utils.printLineToConsole("Operation Unsuccessful.");
                        Utils.printLineToConsole("Please try again.");
                    }
                }
           }

           if(cancel){
               Utils.printLineToConsole(FINISHED);
           } else {
               controller.validateTestResult();
               Utils.printLineToConsole("OPERATION SUCCESSFUL");
           }
        } catch (Exception exception){
            Utils.printLineToConsole(ERROR);
            String exceptionMessage = String.format(" Error Description: %s", exception.getMessage());
            Utils.printLineToConsole(exceptionMessage);
        }
    }
}
