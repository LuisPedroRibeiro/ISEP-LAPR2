package app.mappers.dto;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ParameterCategoryDtoTest {

    @Test
    public void getCode() {
        ParameterCategoryDto pc=new ParameterCategoryDto("12345","name");
        String result=pc.getCode();
        String expected="12345";
        Assert.assertEquals(result,expected);
    }

    @Test
    public void getDescription() {
        ParameterCategoryDto pc=new ParameterCategoryDto("12345","name");
        String result=pc.getName();
        String expected="name";
        Assert.assertEquals(result,expected);
    }

    @Test
    public void testToString() {
        ParameterCategoryDto pc=new ParameterCategoryDto("12345","name");
        String result=pc.toString();
        String expected=String.format("##Parameter Category## %n Code: 12345 %n Name: name");
        Assert.assertEquals(result,expected);
    }
}