package app.list;

import app.domain.model.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for holding all the Test objects chosen to be validated by the laboratory coordinator.
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class TestToBeValidatedList {

    /**
     * A list designed to contain objects of the Test class,where the chosen tests will be saved.
     */
    private final List<Test> testToBeValidated;

    /**
     * Allows the initialization of an object of the TestToBeValidatedList class,while also creating an empty array.
     */
    public TestToBeValidatedList() {
        this.testToBeValidated = new ArrayList<>();
    }

    /**
     * Check if the testToBeValidated is empty throwing the appropriate exception if it is.
     */
    public void checkTestToBeValidatedList() {
        if (testToBeValidated.isEmpty()) {
            throw new IllegalArgumentException("For the validation process to occur at least a test must be chosen from the list ");
        }
    }

    /**
     * Allows the  copying of the Test objects  from the array list received as parameter to the list the testToBeValidated list.
     *
     * @param testsWithReportList list of objects of the Test class.
     */
    public void createListWithAllTestsAvailableToBeValidated(List<Test> testsWithReportList) {
        for (Test t : testsWithReportList) {
            saveTestToTestToBeValidatedList(t);
        }
    }

    /**
     * Allows for the validation of a test object before being added to the testToBeValidated list.
     *
     * @param t A object of Test class.
     * @return boolean statement,true if the Test object does not exist in the testToBeValidated list ,false if not.
     */
    public boolean validateTest(Test t) {
        return !testToBeValidated.contains(t);
    }

    /**
     * Allows the addition of an object of the Test class to the testToBeValidated list.
     *
     * @param test An object of the Test class.
     * @return boolean statement,true if the Test object does not exist in the testToBeValidated list,false if not.
     */
    public boolean saveTestToTestToBeValidatedList(Test test) {
        if (validateTest(test)) {
            return testToBeValidated.add(test);
        }
        return false;
    }

    /**
     * Allows the return of a list of Test objects.
     *
     * @return A list containing Test objects.
     */
    public List<Test> getTestToBeValidated() {
        return testToBeValidated;
    }
}
