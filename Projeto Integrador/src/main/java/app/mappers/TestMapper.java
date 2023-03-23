package app.mappers;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.Test;
import app.domain.model.TestParameter;
import app.mappers.dto.TestDto;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class allows the interaction between User and System in a safety way.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class TestMapper{
    /**
     * Allows the transformation of a Test to a Data Transfer Object.
     *
     * @param test the Test that will be transformed
     * @return a new Test Dto
     */
    public TestDto toDTOWithDate(Test test)
    {
        return new TestDto(test.getCode(), test.getNhsCode(),test.getCreatedAt(), test.getSampleDate(), test.getResultDate(),test.getReportDate());
    }
    /**
     * Allows the transformation of a Test to a Data Transfer Object.
     *
     * @param test the Test that will be transformed.
     * @return a new Test Dto.
     */
    public TestDto toDTOForReport(Test test){
        return new TestDto(test.getCode(), test.getCreatedAt(), test.getSampleDate(), test.getResultDate());
    }

    /**
     * Allows the transformation of a Test to a Data Transfer Object.
     *
     * @param test the Test that will be transformed.
     * @return a new Test Dto.
     */
    public TestDto toDTOForSample(Test test){
        List<TestParameter> testParameterList=test.getTestParameterList();
        List<Parameter> parameterList=new ArrayList<>();
        for(TestParameter tp : testParameterList) {
            if (!parameterList.contains(tp.getParameter())) {
                parameterList.add(tp.getParameter());
            }
        }
        List<ParameterCategory> parameterCategoriesList=new ArrayList<>();
        for(Parameter tp : parameterList) {
            if (!parameterCategoriesList.contains(tp.getPc())) {
                parameterCategoriesList.add(tp.getPc());
            }
        }
         return new TestDto(test.getCode(),test.getNhsCode(), test.getCreatedAt(), TestTypeMapper.toDTO(test.getTestType()),
                 parameterList, parameterCategoriesList);
    }

    /**
     * Allows the transformation of list Test objects into a list of TestDTO objects containing the same information
     * (nhsCode,registrationDate,sample insertion date,result insertion Date and report insertion date).
     *
     * @param testWithReportList A list of Test objects.
     * @return A list of TestDTO objects.
     */
    public List<TestDto> toDTOWithDate(List<Test> testWithReportList)
    {
        List<TestDto> testList = new ArrayList<>();
        for(Test test: testWithReportList)
        {
            testList.add(this.toDTOWithDate(test));
        }
        return testList;
    }

    /**
     * Allows the transformation of list Test objects into a list of TestDTO objects containing the same information
     * (code,registrationDate,sample insertion date,result insertion date).
     *
     * @param testStore A list of Test objects.
     * @return A list of TestDTO objects.
     */
    public List<TestDto> toDTOForReport(List<Test> testStore) {
        List<TestDto> testList = new ArrayList<>();
        for(Test test: testStore)
        {
            testList.add(this.toDTOForReport(test));
        }
        return testList;
    }

    /**
     * Allows the transformation of list Test objects into a list of TestDTO objects containing the same information
     * (code,registrationDate,sample insertion date,result insertion date).
     *
     * @param testStore A list of Test objects.
     * @return A list of TestDTO objects.
     */
    public List<TestDto> toDTOForSample(List<Test> testStore) {
        List<TestDto> testList = new ArrayList<>();
        for(Test test: testStore)
        {
            testList.add(this.toDTOForSample(test));
        }
        return testList;
    }
}

