package app.mappers.dto;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class TestTypeDtoTest {

    @Test
    public void getCode() {
        TestTypeDto t1= new TestTypeDto("12345","method","description");
        TestTypeDto t2= new TestTypeDto("54321","method","description");

        String result=t1.getCode();
        String result1=t2.getCode();
        String expected= "12345";

        Assert.assertEquals(result,expected);
        Assert.assertNotEquals(result1,expected);
    }

    @Test
    public void getCollectionMethod() {
        TestTypeDto t1= new TestTypeDto("12345","method","description");
        TestTypeDto t2= new TestTypeDto("12345","method2","description");

        String result=t1.getCollectionMethod();
        String result1=t2.getCollectionMethod();
        String expected= "method";

        Assert.assertEquals(result,expected);
        Assert.assertNotEquals(result1,expected);
    }

    @Test
    public void getDescription() {
        TestTypeDto t1= new TestTypeDto("12345","method","description");
        TestTypeDto t2= new TestTypeDto("12345","method","description2");

        String result=t1.getDescription();
        String result1=t2.getDescription();
        String expected= "description";

        Assert.assertEquals(result,expected);
        Assert.assertNotEquals(result1,expected);
    }

    @Test
    public void testToString() {
            TestTypeDto t1= new TestTypeDto("12345","method","description");
            TestTypeDto t2= new TestTypeDto("54321","method","description");

        String expected = String.format("##Test Type## %n Code: %s %n Description: %s %n Collection Method: %s",
                "12345","method","description");
        String result = String.format("##Test Type## %n Code: %s %n Description: %s %n Collection Method: %s",
                t1.getCode(),t1.getCollectionMethod(),t1.getDescription());

        String result2 = String.format("##Test Type## %n Code: %s %n Description: %s %n Collection Method: %s",
                t2.getCode(),t2.getCollectionMethod(),t2.getDescription());

        Assert.assertEquals(expected,result);
        Assert.assertNotEquals(expected,result2);
    }
}