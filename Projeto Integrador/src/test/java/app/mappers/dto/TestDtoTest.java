package app.mappers.dto;

import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class TestDtoTest {

    @Test
    public void getCode() {
        TestDto testDto=new TestDto("123456789012","123456789012","12/10/2002 12:59");
        String result=testDto.getCode();
        String expected="123456789012";

        Assert.assertEquals(result,expected);
    }

    @Test
    public void getNhsCode() {
        TestDto testDto=new TestDto("123456789012","123456789012","12/10/2002 12:59");
        String result=testDto.getNhsCode();
        String expected="123456789012";

        Assert.assertEquals(result,expected);
    }

    @Test
    public void testToString() {
        TestDto testDto=new TestDto("12345","123456789012","12/10/2002 12:59","12/10/2002 12:59",
                "12/10/2002 12:59","12/10/2002 12:59");
        String result=testDto.toString();
        String expected= String.format("##Test## %n CODE: %s %n NHS CODE: %s %n Creation Date: %s %n Sample Insertion Date: %s %n Results Insertion Date: %s %n Report Date: %s%n",
                "12345","123456789012","12/10/2002 12:59","12/10/2002 12:59",
                "12/10/2002 12:59","12/10/2002 12:59");
        Assert.assertEquals(result,expected);
        }


    @Test
    public void toStringWithoutSample() {
        TestTypeDto t1= new TestTypeDto("12345","method","description");
        Parameter p1 = new Parameter("55555","t","t");
        List<Parameter> parameterList = new ArrayList<>();
        parameterList.add(p1);
        ParameterCategory pc1 = new ParameterCategory("44444","name");
        List<ParameterCategory> parameterCategoriesList = new ArrayList<>();
        parameterCategoriesList.add(pc1);
        TestDto testDto=new TestDto("12345","123456789012","12/10/2002 12:59",t1,parameterList,parameterCategoriesList);
        String result=testDto.toStringWithoutSample();
        String expected= String.format("##Test## %n CODE: %s %n NHS CODE: %s %n Creation Date: %s %n %s %n %s %n %s %n",
                "12345","123456789012","12/10/2002 12:59",t1,parameterList,parameterCategoriesList);
        Assert.assertEquals(result,expected);
    }


    @Test
    public void toStringTestWithoutReport() {
        TestDto testDto=new TestDto("123456789012","12/10/2002 12:59","12/10/2002 12:59",
                "12/10/2002 12:59");
        String result=testDto.toStringTestWithoutReport();
        String expected= String.format("##Test##%n CODE: %s%n Creation Date: %s%n Sample Insertion Date: %s%n Results Insertion Date: %s%n","123456789012","12/10/2002 12:59","12/10/2002 12:59",
                "12/10/2002 12:59");
        Assert.assertEquals(result,expected);
    }
}