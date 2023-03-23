package app.ui.console;
import app.controller.RegisterTestController;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.ParameterDto;
import app.mappers.dto.TestTypeDto;
import app.utils.Utils;
import java.util.List;


/**
 * This class allows the creation of a Register Test User Interface object.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class RegisterTestUI implements Runnable {

    private static final String TRY_AGAIN = "Invalid Format. Please try again.";

    private static final String CANCEL_MSG = "Operation Canceled.";

    public RegisterTestUI() {
        //Constructs a RegisterTestUI with no parameters
    }

    /**
     * Method to run this UI
     */
    @Override
    public void run() {
        String taxIdentificationNumber;
        String nhsCode;
        RegisterTestController registerTestController = ChooseLabUI.getRegisterTestController();
        if (!registerTestController.verifyIfClientListIsEmpty()) {
            do {
                taxIdentificationNumber = Utils.getTaxIdentificationNumber();
                nhsCode = getCorrectNhsCode();
                String print = String.format(" %n Tax Identification Number (TIN) : %s%n NHS Code: %s%n", taxIdentificationNumber, nhsCode);
                Utils.printLineToConsole(print);
            } while (!Utils.confirm("Do you want to confirm this data? (s|n)"));

            if (registerTestController.verifyClientByTin(taxIdentificationNumber)) {
                createTest(registerTestController, nhsCode, taxIdentificationNumber);
            } else {
                Utils.printLineToConsole("Does not exist a Client registered with the typed Tax Identification Number.");
            }
        } else {
            Utils.printLineToConsole("Please register a Client before register a test.");
        }
    }


    /**
     * Method to create the Test object
     *
     * @param registerTestController  the controller used for the Test creation
     * @param nhsCode                 the National Healthcare Service Number of the Test
     * @param taxIdentificationNumber the  Tax Identification Number of the Client the Test will be associated to
     */
    public void createTest(RegisterTestController registerTestController, String nhsCode, String taxIdentificationNumber) {
        try {
            if (registerTestController.createTest(nhsCode)) {
                if (!registerTestController.getClinicalAnalysisLaboratoryListToDto().isEmpty()) {
                    if (!registerTestController.getTestTypeListToDto().isEmpty()) {
                        int testTypeIdx = setTestType(registerTestController);
                        if (testTypeIdx != -1) {
                            if (!registerTestController.verifyIfListParameterCategoryListIsNull()) {
                                setParameters(registerTestController);
                                if (registerTestController.verifyIfTestParametersWereAdded()) {
                                    if (Utils.confirm("Are you sure you want to create this Test? (s|n)")) {
                                        if (registerTestController.saveTest()) {
                                            registerTestController.addTestToClient(taxIdentificationNumber);
                                            Utils.printLineToConsole("The Test was created successfully.");
                                        }
                                    }
                                }
                            } else {
                                Utils.printLineToConsole("The selected Test Type does not have any Parameter Category associated.");
                            }
                        }
                    } else {
                        Utils.printLineToConsole("The selected Clinical Analysis Laboratory does not have any Test Type associated.");
                    }
                } else {
                    Utils.printLineToConsole("There is no Clinical Analysis Laboratories registered in the System.");
                }

            }
        } catch (Exception e) {
            String exceptionMessage = String.format(" %s", e.getMessage());
            Utils.printLineToConsole(exceptionMessage);
        }

    }


    /**
     * Asks the receptionist for a NHS code string while returning the validated one
     *
     * @return the validated NHS code method
     */
    public String getCorrectNhsCode() {
        boolean nhsCodeError = true;
        String nhsCode = null;
        do {
            try {
                nhsCode = Utils.readLineFromConsole("NHS Code:");
                nhsCodeError = false;
            } catch (Exception e) {
                Utils.printLineToConsole(e.getMessage());
                Utils.printLineToConsole(TRY_AGAIN);
            }
        } while (nhsCodeError);
        return nhsCode;
    }

    /**
     * Method to set the Test Type of the Test
     *
     * @param registerTestController the controller associated to the UI
     */
    public int setTestType(RegisterTestController registerTestController) {
        List<TestTypeDto> testTypeList = registerTestController.getTestTypeListToDto();
        int testType;
        testType = Utils.showAndSelectIndex(testTypeList, "Test Types:");
        if (testType != -1) {
            registerTestController.saveTestType(registerTestController.getTestTypeListToDto().get(testType).getCode());
        } else {
            Utils.printLineToConsole(CANCEL_MSG);
        }
        return testType;
    }

    /**
     * Method to set the Parameters of the Test
     *
     * @param registerTestController the controller associated to the UI
     */
    public void setParameters(RegisterTestController registerTestController) {
        List<ParameterCategoryDto> paramCatList = registerTestController.getParameterCategoryListToDto();
        int paramCat = Utils.showAndSelectIndexForParameterAndCategories(paramCatList, "Parameter Category List:");
        while (paramCat != -1 && !paramCatList.isEmpty()) {
            registerTestController.setParameterCategory(paramCatList.get(paramCat).getCode());
            List<ParameterDto> paramList = registerTestController.getParameterListToDto();
            int param;
            do {
                param = Utils.showAndSelectIndexForParameterAndCategories(paramList, "Parameters List:");
                if (param != -1) {
                    registerTestController.addParameter(paramList.get(param).getCode());
                    paramList.remove(param);
                }
            } while (param != -1 && !paramList.isEmpty());
            paramCatList.remove(paramCat);
            paramCat = Utils.showAndSelectIndexForParameterAndCategories(paramCatList, "Parameter Category List:");
        }
    }
}

