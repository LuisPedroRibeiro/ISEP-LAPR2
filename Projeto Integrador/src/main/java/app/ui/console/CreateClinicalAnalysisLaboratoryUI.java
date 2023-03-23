package app.ui.console;

import app.controller.CreateClinicalAnalysisLaboratoryController;
import app.domain.model.TestType;
import app.mappers.dto.TestTypeDto;
import app.utils.Utils;

import java.util.ArrayList;
import java.util.List;


/**
 * This class allows the connection between Controller and Admin
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class CreateClinicalAnalysisLaboratoryUI implements Runnable {

    /**
     * String used for reporting a error to the user
     */
    private static final String ERROR = String.format("%nERROR: OPERATION TERMINATED%n " +
            "Motive: An inserted attribute is invalid. %n");

    /**
     * The method that need to be there.
     */
    public CreateClinicalAnalysisLaboratoryUI() {
        //This method is empty because only the run() method will be used.
    }

    /**
     * The method that allows all the Interface between the Client and the Data.
     * It envolves all the requirements for the client and all the confirmations that client needs.
     */
    @Override
    public void run() {
        CreateClinicalAnalysisLaboratoryController controller = new CreateClinicalAnalysisLaboratoryController();
        String laboratoryId= getLaboratoryId();
        String address= getAddress();
        String name= getName();
        String phoneNumber= getPhoneNumber();
        String tin= getTaxIdentificationNumber();
        try {
            List<TestTypeDto> ttd = new ArrayList<>(controller.listDto());
            if (ttd.isEmpty()) {
                Utils.printLineToConsole("Cannot create Clinical Analysis Laboratory while there isn´t a " +
                        "test type in the system.");
                Utils.printLineToConsole("Please create one");
            } else {
                if (controller.createClinicalAnalysisLaboratory(laboratoryId, address, name, phoneNumber, tin)) {
                    boolean choice = true;
                    while (controller.getTypeStore().isEmpty() || choice) {
                        int code = -2;
                        while (code != -1 && !ttd.isEmpty()) {
                            code = Utils.showAndSelectIndex(ttd, "What is the Test Type " +
                                    "that do you want?");
                            if (code != -1) {
                                TestType testType = controller.getTestTypeCode(code);
                                Utils.printLineToConsole(ttd.get(code).toString());
                                if (Utils.confirm("Are you sure you want to add this Test Type to your Clinical " +
                                        "Analysis Laboratory?")
                                        && controller.saveClinicalTestType(testType)) {
                                    Utils.printLineToConsole("Test Type was saved in Clinical Test Type List " +
                                            "with Success.");
                                    ttd.remove(ttd.get(code));
                                } else {
                                    Utils.printLineToConsole("Test Type was not saved in Clinical Test Type " +
                                            "List with Success.");
                                }
                            }
                        }
                        choice = Utils.confirm("Do you want to save another Type of Test in Clinical " +
                                "Analysis Laboratory? (s/n) ");
                    }
                    controller.saveTestTypeListToClinicalAnalysisLaboratory();
                }
                if (controller.saveClinicalAnalysisLaboratory()) {
                    Utils.printLineToConsole("Clinical Analysis Laboratory was saved.");
                } else {
                    Utils.printLineToConsole("Clinical Analysis Laboratory was not saved.");
                }
                boolean want = Utils.confirm("Do you want to see the Clinical Analysis Laboratory Store? (s/n)");
                if (want) {
                    Utils.printLineToConsole("##Clinical Analysis Laboratory Store##");
                    Utils.printLineToConsole(controller.getClinicalAnalysisLaboratoryStore().toString());
                }
            }
        } catch (IllegalArgumentException e) {
            Utils.printLineToConsole(ERROR);
            String exceptionMessage = String.format(" %s", e.getMessage());
            Utils.printLineToConsole(exceptionMessage);
        }
    }
    public String getLaboratoryId(){
        String laboratoryId = null;
        try {
            laboratoryId = Utils.readLineFromConsole("Laboratory Id: ");
            assert laboratoryId != null;
        } catch (IllegalArgumentException e) {
            Utils.printLineToConsole(e.getMessage());
        }
        return laboratoryId;
    }

    public String getAddress(){
        String address = null;
        try {
            address = Utils.readLineFromConsole("Adress: ");
            assert address != null;
        } catch (IllegalArgumentException e) {
            Utils.printLineToConsole(e.getMessage());
        }
        return address;
    }

    public String getName(){
        String name = null;
        try {
            name = Utils.readLineFromConsole("Name: ");
            assert name != null;
        } catch (IllegalArgumentException e) {
            Utils.printLineToConsole(e.getMessage());
        }
        return name;
    }

    public String getPhoneNumber(){
        String phoneNumber = null;
        try {
            phoneNumber = Utils.readLineFromConsole("Phone Number: ");
            assert phoneNumber != null;
        } catch (IllegalArgumentException e) {
            Utils.printLineToConsole(e.getMessage());
        }
        return phoneNumber;
    }

    public String getTaxIdentificationNumber(){
        String tin = null;
        try {
            tin = Utils.readLineFromConsole("Tax Identification Number (TIN): ");
            assert tin != null;
        } catch (IllegalArgumentException e) {
            Utils.printLineToConsole(e.getMessage());
        }
        return tin;
    }
}