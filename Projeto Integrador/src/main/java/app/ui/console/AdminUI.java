package app.ui.console;

import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */

public class AdminUI implements Runnable{

    public AdminUI() {
        //This method is empty because only the run method is used.
    }

    public void run()
    {
        List<MenuItem> options = new ArrayList<>();
        options.add(new MenuItem("Create New Parameter Category ", new CreateParameterCategoryUI()));
        options.add(new MenuItem("Create New Parameter ", new CreateParameterUI()));
        options.add(new MenuItem("Create a new Test Type ", new CreateTestTypeUI()));
        options.add(new MenuItem("Create Clinical Analysis Laboratory ",
                new CreateClinicalAnalysisLaboratoryUI()));
        options.add(new MenuItem("Register New Employee ", new RegisterNewEmployeeUI()));

        int option = 0;
        do
        {
            option = Utils.showAndSelectIndex(options, "\n\nAdmin Menu:");

            if ( (option >= 0) && (option < options.size()))
            {
                options.get(option).run();
            }
        }
        while (option != -1 );
    }
}
