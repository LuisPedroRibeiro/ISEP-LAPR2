package app.ui.console;

import app.controller.RecordSamplesController;
import app.utils.Utils;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;

/**
 * This Class allows all the communication between Medical Lab Technician and the System.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class RecordSamplesUI implements Runnable{

    private static final String ERROR_SAMPLES = "An error has occurred creating the Samples.";

    private static final String ERROR_BARCODE = "An error on barcode generator has occurred, try again.";

    private static final String ERROR_MODULE = "Module not found please try again";

    /**
     * Method that allows the communication between Medical Lab Technician and the System, with all of client
     * specifications.
     */
    @Override
    public void run() {
        try {
            RecordSamplesController controller = new RecordSamplesController();
            if(controller.listDto().isEmpty()){
                Utils.printLineToConsole("There are no Test that currently need Samples.");
            } else {
                Utils.showListOfTestsWithoutSamples(controller.listDto(),"List of Tests without Samples");
                int index = Utils.readIntegerFromConsole("What is the Test that you want to add the Samples?");
                index = index - 1;
                if (index >= 0) {
                    controller.getTestToBeSampledByIndex(index);
                    int numberSamples = Utils.readIntegerFromConsole("How many Samples do you want to create?");
                    if (numberSamples > 0) {
                        Utils.printLineToConsole("Creating Samples...");
                        for (int i = 0; i < numberSamples; i++) {
                            controller.createSample();
                        }
                        controller.setCurrentDate();
                        controller.saveTestWithSamples();
                        Utils.printLineToConsole("OPERATION SUCCESS");
                        Utils.printLineToConsole("Test was saved with all Samples.");
                    }
                } else {
                    Utils.printLineToConsole("Test was not saved.");
                }
            }
        } catch (IndexOutOfBoundsException | NumberFormatException | NullPointerException e){
            Utils.printLineToConsole(ERROR_SAMPLES);
        } catch (OutputException | BarcodeException | IOException e) {
            Utils.printLineToConsole(ERROR_BARCODE);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Utils.printLineToConsole(ERROR_MODULE);
        }
    }
}