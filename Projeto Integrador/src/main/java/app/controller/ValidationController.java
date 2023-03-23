package app.controller;

import app.domain.model.Company;
import app.domain.model.Test;
import app.list.TestToBeValidatedList;
import app.mappers.TestMapper;
import app.mappers.dto.TestDto;

import java.io.IOException;
import java.util.List;

/**
 * Allows the System to control the action of validating a Test.
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */

public class ValidationController {

    /**
     * Object of the Company class,where the store objects are saved
     */
    private final Company company;

    /**
     * Object of the class TestToBeValidatedList where the tests to be validated will be stored
     */
    private final TestToBeValidatedList testToBeValidatedList;

    /**
     * Allows the initialization of an ValidationController with the company returned from "App.getInstance().getCompany()"
     * while also initializing a
     */
    public ValidationController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Allows the initialization of an ValidationController using the parameter company while also initializing a new
     * testToBeValidatedList object where the test to be validated will be stored
     *
     * @param company Object of the Company class
     */
    public ValidationController(Company company) {
        this.company = company;
        this.testToBeValidatedList = new TestToBeValidatedList();
    }

    /**
     * Allows the insertion of all the tests available to be validated in the system in a testToBeValidatedList object
     */
    public void createListWithAllTestsAvailableToBeValidated() {
        testToBeValidatedList.createListWithAllTestsAvailableToBeValidated(company.getTestStore().getTestsWithReportList());
    }

    /**
     * Allows the save of test object in a testToBeValidatedList object using only nhsCode
     * that identifies a Test object
     *
     * @param nhsCode nhs code that identifies a certain test
     * @return boolean statement,true if the save of the test in the testToBeValidatedList was successful ,false if not
     */
    public boolean saveTestInListByNhsCode(String nhsCode) {
        Test t = this.company.getTestStore().getTestByNhsCode(nhsCode);
        return testToBeValidatedList.saveTestToTestToBeValidatedList(t);
    }

    /**
     * Allows the validation of all the Test class object inside a valid testToBeValidatedList object,while also sending
     * a text to the txt file emailAndSMSMessages.txt
     * containing some information about the test being validated(NHSCODE) and the client the test belongs too(Email,Name).
     */
    public void validateTestsInsideTestsToBeValidatedList() throws IOException {
        testToBeValidatedList.checkTestToBeValidatedList();
        for (Test test : testToBeValidatedList.getTestToBeValidated()) {
            test.validateTest();
            company.getClientStore().sendEmail(company.getClientStore().getClientByTest(test), test);
        }
    }

    /**
     * Allows the creation of a list of TestDto objects from the a list of Test objects that are available to be validated
     *
     * @return list composed by TestDTO objects
     */
    public List<TestDto> getListOfUnvalidatedTestsDto() {
        TestMapper m = new TestMapper();
        return m.toDTOWithDate(company.getTestStore().getTestsWithReportList());
    }
}

