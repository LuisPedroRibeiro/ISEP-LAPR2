package app.controller;

import app.domain.model.*;
import app.mappers.TestMapper;
import app.mappers.dto.TestDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Allows the System to control the action of writing a Test Report and associating that one to a Test.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class WriteReportController {

    /**
     * The Test that is getting a Test Report.
     */
    private Test test;

    /**
     * The Test Report that was written by the Specialist Doctor.
     */
    private  TestReport testReport;

    /**
     * The Company that has the controller.
     */
    private final Company company;

    /**
     * The List that contains all the Tests without Report to be shown to the Specialist Doctor.
     */
    private List<Test> testsWithResultList = new ArrayList<>();

    /**
     * Constructs an instance of WriteReportController with no parameters.
     */
    public WriteReportController(){
        this(App.getInstance().getCompany());
    }

    /**
     * Allows the creation of a Controller that uses a certain Company.
     *
     * @param company Company to be used by the Controller.
     */
    public WriteReportController(Company company){
        this.company = company;
        this.test = null;
    }

    /**
     * Allows the System to generate a List of Tests that have Results and are waiting for a Report.
     */
    public void generateTestsWithResultList(){
        this.testsWithResultList = this.company.getTestStore().getTestWithResultList();
    }

    /**
     * Allows the System to get the List of Tests that are waiting for a Report.
     *
     * @return List of Tests that are waiting for a Report.
     */
    public List<TestDto> getTestsWithResultList(){
        TestMapper mapper = new TestMapper();
        return mapper.toDTOForReport(this.testsWithResultList);
    }

    /**
     * Allows the System to obtain a Test through its NHS Code.
     *
     * @param index Index of the Test to get a report, on the list of the Tests without Report.
     */
    public void getTestByIndex(int index){
        this.test = this.company.getTestStore().getTestByNhsCode(testsWithResultList.get(index).getNhsCode());
    }


    /**
     * Allows the System to generate a String that contains all the Test Parameters of the chosen Test.
     *
     * @return String that contains all the Test Parameters of the Test.
     */
    public String showResults(){
        String results = "";
        for(int index = 0; index < test.getTestParameterList().size(); index ++){
            TestParameter testParameter = test.getTestParameterByCode(index);
            results = String.format("%s%s%n Reference Values: %s%n%n", results, testParameter.toString(),
                    testParameter.getTestResult().getRefValue().toString());
        }
        return results;
    }

    /**
     * Allows the System to generate a Test Report.
     *
     * @param text Text that was inputted by the Specialist Doctor.
     */
    public void generateTestReport(String text){
        this.testReport = new TestReport(text, this.test.getCode(), getSpecialistDoctorName(),
                getSpecialistDoctorEmail());
    }


    /**
     * Allows the System to show the Test Report to the Specialist Doctor, in order for this one to validate the
     * data that was inserted.
     *
     * @return The Test Report in a String.
     */
    public String showTestReport(){
        return String.format("%n%s", testReport.toString());
    }

    /**
     * Allows the System to associate the Test Report to the Test.
     */
    public boolean saveTestReport(){
        if(this.company.getTestStore().saveTestReport(this.test, this.testReport)){
            removeTestFromList();
            return true;
        }
        else return false;
    }

    /**
     * Permits the System to remove the Test that got the Report from the List if the Specialist Doctor wishes to
     * do more Test Reports.
     */
    private void removeTestFromList(){
        testsWithResultList.remove(this.test);
    }

    /**
     * Allows the System to get the Specialist Doctor's name.
     *
     * @return Specialist Doctor's name.
     */
    private String getSpecialistDoctorName(){
        return this.company.getAuthFacade().getCurrentUserSession().getUserName();
    }

    /**
     * Allows the System to get the Specialist Doctor's e-mail.
     *
     * @return Specialist Doctor's e-mail.
     */
    private String getSpecialistDoctorEmail(){
        return this.company.getAuthFacade().getCurrentUserSession().getUserId().toString();
    }
}
