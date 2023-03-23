package app.controller;

import app.domain.model.Company;

import app.domain.model.Test;
import app.mappers.ParameterMapper;
import app.mappers.dto.ParameterDto;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.util.List;

/**
 * This class controls the creation of a new Result for a Test.
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class RecordResultsController {

    /**
     * The Test that is getting the test results.
     */
    private Test test;

    /**
     * The Company that has the controller.
     */
    private final Company company;

    /**
     * Allows the creation of a Empty Constructor.
     *
     */
    public RecordResultsController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Allows the creation of a Controller that uses a certain Company.
     *
     * @param company Company to be used by the Controller.
     */
    public RecordResultsController(Company company){
        this.company = company;
        this.test = null;
    }

    /**
     * Method that allows to save a test by a barcode.
     *
     * @param barcode The barcode that will be used.
     * @exception OutputException Exception to be thrown.
     * @exception BarcodeException Exception to be thrown.
     * @exception IOException Exception to be thrown.
     */
    public void getTestByBarcode(String barcode) throws OutputException, BarcodeException, IOException{
       this.test = company.getTestStore().getTestByBarcode(barcode);
    }

    /**
     * Method that allows to get a List of ParameterDto.
     *
     * @return A List of ParameterDto.
     */
    public List<ParameterDto> getParameterList(){
       ParameterMapper m=new ParameterMapper();
       return m.toDTO(test.getParametersAssociatedWithTest());
    }

    /**
     * The method that allows the addiction of a Test Result to a test.
     *
     * @param parameterCode The Parameter Code of the Test Result.
     * @param result The Result of Test Result.
     * @throws ClassNotFoundException Exception to be thrown if the Class is not found.
     * @throws InstantiationException Exception to be throw if the Constructor is not available.
     * @throws IllegalAccessException Exception to be throw if the Method does not have access to the wanted Class.
     */
    public void addTestResult(String parameterCode, double result) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        test.addTestResult(parameterCode,result);
    }

    /**
     * The method that allows the addiction of the current date to Test Result of the Test.
     *
     */
    public void validateTestResult(){
        test.addTestResultDate();
    }
}
