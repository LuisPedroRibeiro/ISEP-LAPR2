package app.ui.console;

import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows the connection between RecordSamplesUI and Medical Lab Technician.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */

public class LabTechUI implements Runnable {

    public LabTechUI() {
        //This method is empty because only the run method is used.
    }

    /**
     * Method that implements all the interface that Medical Lab Technician have access.
     */
    public void run() {
        try {
            List<MenuItem> options = new ArrayList<>();
            options.add(new MenuItem("Select a Test to associate Samples", new RecordSamplesUI()));
            options.add(new MenuItem("Non Defined", new ShowTextUI("This option is non defined.")));

            int option;
            do {
                option = Utils.showAndSelectIndex(options, "\n\nMedical Lab Technician Menu:");

                if ((option >= 0) && (option < options.size())) {
                    options.get(option).run();
                }
            }
            while (option != -1);
        } catch (NumberFormatException e) {
            Utils.printLineToConsole("Introduce a number");
        }
    }
}

