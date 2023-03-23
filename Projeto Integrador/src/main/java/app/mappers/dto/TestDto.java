package app.mappers.dto;

import app.domain.model.TestType;

import java.util.List;

/**
 * This Class allows the interaction between User and System in a safer way.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class TestDto {

    /**
     * The Dto of Test Type
     */
    private TestTypeDto testTypeDto;

    /**
     * The List of Parameters.
     */
    private List parameterList;

    /**
     * The List of Parameter Categories.
     */
    private List parameterCategoryList;

    /**
     * The Test Type associated to the test
     */
    private TestType testType;

    /**
     * The NHS code of the Test
     */
    private String nhsCode;

    /**
     * The sequential code attributed to the Test
     */
    private String code;

    /**
     * The Date of creation of the Test
     */
    private String createdAt;

    /**
     * The Date of the Collection of the Samples
     */
    private String sampleDate;

    /**
     * The Date of the addition of results to the Test
     */
    private String resultDate;

    /**
     * The Date of the addition of the Test report
     */
    private String reportDate;


    /**
     * Constructor of the Test Data Transfer Object.
     *
     * @param nhsCode the National Healthcare Service Number associated to the Test.
     * @param testType the Tes tType associated to the Test.
     */
    public TestDto(String nhsCode,TestType testType){
        this.nhsCode=nhsCode;
        this.testType=testType;
    }

    /**
     * Constructor of the Test Data Transfer Object.
     *
     * @param nhsCode the National Healthcare Service Number associated to the Test.
     * @param createdAt the Date of creation of the Test.
     * @param sampleDate the Date of the Samples Collection.
     * @param resultDate the Date of the Results addition.
     * @param reportDate the Date of the Report addition.
     */
    public TestDto(String code,String nhsCode, String createdAt, String sampleDate, String resultDate, String reportDate) {
        this.code=code;
        this.nhsCode = nhsCode;
        this.createdAt = createdAt;
        this.sampleDate = sampleDate;
        this.resultDate = resultDate;
        this.reportDate = reportDate;
    }

    /**
     * Constructor of the Test Data Transfer Object.
     *
     * @param nhsCode the National Healthcare Service Number associated to the Test.
     * @param code the Sequential Code attributed to the Test.
     * @param createdAt the Date of creation of the Test.
     */
    public TestDto (String nhsCode, String code, String createdAt){
        this.code=code;
        this.nhsCode=nhsCode;
        this.createdAt=createdAt;
    }

    /**
     * Constructor of the Test Data Transfer Object.
     *
     * @param code the Sequential Code attributed to the Test.
     * @param nhsCode the National Healthcare Service Number associated to the Test.
     * @param createdAt the Date of creation of the Test.
     * @param testTypeDto the TestTypeDto of Test Dto.
     */
    public TestDto (String code, String nhsCode, String createdAt, TestTypeDto testTypeDto, List parameterList, List parameterCategoryList){
        this.code=code;
        this.nhsCode=nhsCode;
        this.createdAt=createdAt;
        this.testTypeDto= testTypeDto;
        this.parameterList = parameterList;
        this.parameterCategoryList = parameterCategoryList;
    }

    /**
     * Constructor of the Test Data Transfer Object.
     *
     * @param code the Sequential Code attributed to the Test.
     * @param createdAt the Date of creation of the Test.
     * @param sampleDate the Date of the Samples Collection.
     * @param resultDate the Date of the Results addition.
     */
    public TestDto (String code, String createdAt, String sampleDate, String resultDate){
        this.code = code;
        this.createdAt = createdAt;
        this.sampleDate = sampleDate;
        this.resultDate = resultDate;
    }

    /**
     * Method to get the Test sequential code.
     *
     * @return the sequential Code attributed to the Test.
     */
    public String getCode() {
        return code;
    }

    /**
     * Method to get the National Healthcare Service Number of the Test.
     *
     * @return the National Healthcare Service Number of the Test.
     */
    public String getNhsCode() {
        return nhsCode;
    }


    /**
     * Method that returns a String with the Information of the Test containing all of its dates.
     *
     * @return Test in a String format with all the information.
     */
    @Override
    public String toString() {
        return String.format("##Test## %n CODE: %s %n NHS CODE: %s %n Creation Date: %s %n Sample Insertion Date: %s %n " +
                        "Results Insertion Date: %s %n Report Date: %s%n",
                code,nhsCode,createdAt,sampleDate,resultDate,reportDate);
    }

    /**
     * Method that returns a String with the Information of the Test containing all of Test without Sample attributes.
     *
     * @return Test in a String format with all the information.
     */
    public String toStringWithoutSample() {
        return String.format("##Test## %n CODE: %s %n NHS CODE: %s %n Creation Date: %s %n %s %n %s %n %s %n"
                ,code,nhsCode,createdAt,testTypeDto.toString(),parameterList.toString(),parameterCategoryList.toString());
    }

    /**
     * Method that returns a String with the Information of the Test.
     *
     * @return Test in a String format with information needed for the Report.
     */
    public String toStringTestWithoutReport(){
        return String.format("##Test##%n CODE: %s%n Creation Date: %s%n Sample Insertion Date: %s%n Results Insertion Date: %s%n",
                code, createdAt, sampleDate, resultDate);
    }
}
