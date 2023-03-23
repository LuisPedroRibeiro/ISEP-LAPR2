package app.ui.console;

import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/***
 * @author Pedro Graça
 */
public class RecepUI implements Runnable {


    public RecepUI() {
        // Constructs a RecepUI with no parameters
    }

    /**
     * Method to run this UI
     */
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Register a Client", new RegisterClientUI()));
        options.add(new MenuItem("Register a Test", new RegisterTestUI()));
        options.add(new MenuItem("Non Defined ", new ShowTextUI("This option is non defined.")));

        int option;
        do {
            option = Utils.showAndSelectIndex(options, "\n\nReceptionist Menu:");

            if ((option >= 0) && (option < options.size())) {
                options.get(option).run();
            }
        }
        while (option != -1);
    }
}
