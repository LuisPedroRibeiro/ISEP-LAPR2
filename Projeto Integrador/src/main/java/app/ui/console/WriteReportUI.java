package app.ui.console;

import app.controller.WriteReportController;
import app.utils.Utils;

/**
 * Allows the System to run the function (User Story) of the Specialist Doctor, that allows him to write a report
 * for one or more Tests that are waiting for it.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class WriteReportUI implements Runnable {

    /**
     * String that contains a question relative to a confirmation of the chosen Test.
     */
    private static final String CONFIRMATION = "Do you confirm the selected Test?";

    /**
     * String that contains a question relative to a confirmation of the data.
     */
    private static final String DATA_CONFIRMATION = "Do you confirm the shown data?";

    /**
     * String that contains a declaration of an error.
     */
    private static final String ERROR = String.format("%nERROR: OPERATION TERMINATED%n " +
            "Motive: The Test Report is invalid.");

    /**
     * String that contains a declaration of the end of the function.
     */
    private static final String FINISHED = "OPERATION FINISHED";

    /**
     * String that contains a declaration relative to the non-existence of a Test to do a Report on.
     */
    private static final String NO_TEST = "\nWARNING: There are no tests waiting for a Report.";

    public WriteReportUI(){
        //Constructs a WriteReportUI with no attributes.
    }

    /**
     * Allows the System to run the function (User Story) that allows a Specialist Doctor to write a Report
     * about a Test.
     */
    @Override
    public void run() {
        boolean loopBoolean = true;

        WriteReportController controller = new WriteReportController();
        controller.generateTestsWithResultList();

        if(controller.getTestsWithResultList().isEmpty()) {
            Utils.printLineToConsole(NO_TEST);
        }
        else{
            while (loopBoolean){
                if(controller.getTestsWithResultList().isEmpty()){
                    Utils.printLineToConsole(NO_TEST);
                    loopBoolean = false;
                }
                else {
                    try{
                        int index = Utils.showAndSelectIndexForTestsWithoutReport(controller.getTestsWithResultList(),
                                "\nTESTS WITHOUT REPORT");
                        if(index == -1) {
                            Utils.printLineToConsole(FINISHED);
                            loopBoolean = false;
                        }
                        else if(Utils.confirm(CONFIRMATION)){
                            createTestReport(controller, index);
                            if(controller.getTestsWithResultList().isEmpty()){
                                Utils.printLineToConsole(NO_TEST);
                                loopBoolean = false;
                            }
                            else{
                                loopBoolean = Utils.confirm("Do you want to write another report?");
                            }

                        }
                    } catch (IllegalArgumentException exception){
                        Utils.printLineToConsole(ERROR);
                        String exceptionMessage = String.format(" Error Description: %s%n", exception.getMessage());
                        Utils.printLineToConsole(exceptionMessage);
                    }
                }

            }
        }
        Utils.printLineToConsole(FINISHED);
    }

    /**
     * Allows the System, to permit the Specialist Doctor, its function of writing a Report, and to save or
     * associate that Report to the Test.
     *
     * @param controller Controller through which the function is being ran.
     * @param index The index of the selected Test.
     */
    public void createTestReport(WriteReportController controller, int index){
        controller.getTestByIndex(index);

        Utils.printLineToConsole("RESULTS OF THE TEST");
        Utils.printLineToConsole(controller.showResults());

        String testReport = Utils.readLineFromConsole("Write the Test Report (Limit: 400 words):");

        controller.generateTestReport(testReport);

        Utils.printLineToConsole(controller.showTestReport());

        if(Utils.confirm(DATA_CONFIRMATION)){
            if(controller.saveTestReport()){
                Utils.printLineToConsole("OPERATION SUCCESSFUL");
            }
            else{Utils.printLineToConsole("ERROR: OPERATION UNSUCCESSFUL");}
        }
        else{
            Utils.printLineToConsole(FINISHED);
        }
    }
}
