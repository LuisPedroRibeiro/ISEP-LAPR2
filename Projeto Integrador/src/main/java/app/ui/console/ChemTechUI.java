package app.ui.console;

import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ChemTechUI implements Runnable {
    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Record the Results of a Test ", new RecordResultsUI()));

        int option = 0;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nChemical Analysis Technician Menu:");

            if ( (option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        } while (option != -1 );
    }
}
