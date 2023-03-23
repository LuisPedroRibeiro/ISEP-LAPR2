package app.domain.model;

import app.utils.Utils;
/**
 * Class responsible for conducting the process of the validation of a test
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class TestValidation {

    /**
     * A string containing the date of validation of a certain test
     */
    private final String validatedAt;

    /**
     * Constructor of the  TestValidation class,which allows the assignment of a string containing the current date
     */
    public TestValidation() {
        validatedAt = Utils.currentDate();
    }
}
