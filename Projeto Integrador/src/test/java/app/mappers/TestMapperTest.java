package app.mappers;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.mappers.dto.TestDto;
import app.mappers.dto.TestTypeDto;
import app.utils.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class TestMapperTest {

    @Test
    public void toDTOWithDate() {
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        test.setCode("12345");
        test.setCreatedAt("12/10/2002 12:59");
        test.setSampleDate();
        test.addTestResultDate();
        test.addReportDate();
        String expected = String.format("##Test## %n CODE: %s %n NHS CODE: %s %n Creation Date: %s %n " +
                "Sample Insertion Date: %s %n Results Insertion Date: %s %n Report Date: %s%n",
                test.getCode(),test.getNhsCode(),test.getCreatedAt(),test.getSampleDate(),
                test.getResultDate(),test.getReportDate());
        TestMapper testMapper= new TestMapper();
        TestDto result = testMapper.toDTOWithDate(test);
        Assert.assertEquals(expected,result.toString());
    }

    @Test
    public void toDTOForReport() {
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        test.setCode("12345");
        test.setCreatedAt("12/10/2002 12:59");
        test.setSampleDate();
        String expected = String.format("##Test##%n CODE: %s%n Creation Date: %s%n Sample Insertion Date: %s%n " +
                "Results Insertion Date: %s%n",test.getCode(),test.getCreatedAt(),test.getSampleDate(),test.getResultDate());
        TestMapper testMapper= new TestMapper();
        TestDto result = testMapper.toDTOForReport(test);
        Assert.assertEquals(expected,result.toStringTestWithoutReport());
    }

    @Test
    public void toDTOForSample() {
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        test.setCode("12345");
        test.setCreatedAt("12/10/2002 12:59");
        test.setSampleDate();
        TestType testType = new TestType("12345","l","l");
        test.saveTestType(testType);
        TestTypeDto testTypeDto = TestTypeMapper.toDTO(test.getTestType());
        Parameter p1 = new Parameter("55555","t","t");
        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(p1);
        ParameterCategory pc1 = new ParameterCategory("44444","name");
        List<ParameterCategory> parameterCategoriesList = new ArrayList<>();
        parameterCategoriesList.add(pc1);
        p1.addParameterCategoryToParameter(pc1);
        test.addTestParameter(p1);
        String expected = String.format("##Test## %n CODE: %s %n NHS CODE: %s %n Creation Date: %s %n %s %n %s %n %s %n"
                ,test.getCode(),test.getNhsCode(),test.getCreatedAt(),testTypeDto,parameterList,parameterCategoriesList);
        TestMapper testMapper= new TestMapper();
        TestDto result = testMapper.toDTOForSample(test);
        Assert.assertEquals(expected,result.toStringWithoutSample());
    }

    @Test
    public void testToDTOWithDate() {
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        test.setCode("12345");
        test.setCreatedAt("12/10/2002 12:59");
        test.setSampleDate();
        test.addTestResultDate();
        test.addReportDate();
        TestDto test3 = new TestDto("12345","123456789012","12/10/2002 12:59", Utils.currentDate(),Utils.currentDate(),Utils.currentDate());
        List<app.domain.model.Test> testList = new ArrayList<>();
        testList.add(test);
        List<TestDto> expected = new ArrayList<>();
        expected.add(test3);
        TestMapper testMapper = new TestMapper();
        List<TestDto> result = testMapper.toDTOWithDate(testList);
        Assert.assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void testToDTOForReport() {
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        test.setCode("12345");
        test.setCreatedAt("12/10/2002 12:59");
        test.setSampleDate();
        test.addTestResultDate();
        TestDto test3 = new TestDto("12345","12/10/2002 12:59", Utils.currentDate(),Utils.currentDate());
        List<app.domain.model.Test> testList = new ArrayList<>();
        testList.add(test);
        List<TestDto> expected = new ArrayList<>();
        expected.add(test3);
        TestMapper testMapper = new TestMapper();
        List<TestDto> result = testMapper.toDTOForReport(testList);
        Assert.assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void testToDTOForSample(){
    }
}