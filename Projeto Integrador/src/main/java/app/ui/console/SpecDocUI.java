package app.ui.console;

import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows the System to run the Menu for the Specialist Doctors and for the User to select the option that they
 * want to run.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class SpecDocUI implements Runnable {
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Write a Report ", new WriteReportUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nSpecialist Doctor Menu:");

            if ( (option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1 );
    }
}
