package app.ui.console;

import app.utils.Utils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class DevTeamUI implements Runnable{

    public DevTeamUI() {
        //This method is empty because only the run method is used.
    }
    public void run()
    {
        Utils.printLineToConsole("\n");
        Utils.printLineToConsole("Development Team:\n");
        Utils.printLineToConsole("\t Luís Ribeiro - 1201184@isep.ipp.pt \n");
        Utils.printLineToConsole("\t Pedro Graça - 1201188@isep.ipp.pt \n");
        Utils.printLineToConsole("\t Miguel Ramos - 1201247@isep.ipp.pt \n");
        Utils.printLineToConsole("\t André Soares - 1201314@isep.ipp.pt \n");
        Utils.printLineToConsole("\n");
    }
}
