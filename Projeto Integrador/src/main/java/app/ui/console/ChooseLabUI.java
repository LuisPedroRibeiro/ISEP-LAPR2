package app.ui.console;

import app.controller.App;
import app.controller.RegisterTestController;
import app.domain.shared.Constants;
import app.mappers.dto.ClinicalAnalysisLaboratoryDto;
import app.store.EmployeeStore;
import app.utils.Utils;
import auth.domain.model.Email;

import java.util.List;

public class ChooseLabUI implements Runnable {
    private static final String CANCEL_MSG = "Operation Canceled.";

    private static final RegisterTestController registerTestController = new RegisterTestController();

    public ChooseLabUI() {
        //Constructs a ChooseLabUI with no parameters
    }

    /**
     * Method to run the ChooseLabUI
     */
    public void run() {
        setClinicalAnalysisLaboratory();
    }

    /**
     * Method to set the Clinical Analysis Laboratory where the Employee will work
     */
    public void setClinicalAnalysisLaboratory() {
        List<ClinicalAnalysisLaboratoryDto> labList = registerTestController.getClinicalAnalysisLaboratoryListToDto();
        int lab = Utils.showAndSelectIndex(labList, "Laboratories");
        if (lab != -1) {
            try {
                registerTestController.saveClinicalAnalysisLaboratory(labList.get(lab).getLaboratoryId());
                Email email = App.getInstance().getCurrentUserSession().getUserId();
                EmployeeStore employeeStore = App.getInstance().getCompany().getEmployeeStore();
                String role = employeeStore.getRoleByEmail(email);
                if (role.equals(Constants.ROLE_RECEP)) {
                    new RecepUI().run();
                }
                if (role.equals(Constants.ROLE_MEDTECH)) {
                    new LabTechUI().run();
                }

            } catch (IllegalArgumentException e) {
                Utils.printLineToConsole("The user does not have permission to access the next functionalities.");
            }
        } else {
            Utils.printLineToConsole(CANCEL_MSG);
        }
    }

    public static RegisterTestController getRegisterTestController() {
        return registerTestController;
    }
}


