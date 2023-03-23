package app.ui.console;


import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class LabCoUI implements  Runnable {


    public LabCoUI() {
        //This method is empty because only the run method is used.
    }


    @Override
    public void run() {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Validate a Existent Test ", new ValidationUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nLaboratory Coordinator:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
