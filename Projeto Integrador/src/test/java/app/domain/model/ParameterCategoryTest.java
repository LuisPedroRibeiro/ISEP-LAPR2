package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author André Soares
 */
public class ParameterCategoryTest {

    @Test
    public void getCode() {
        ParameterCategory pc=new ParameterCategory("12345","name");
        String result=pc.getCode();
        String expected="12345";
        Assert.assertEquals(result,expected);
    }

    @Test
    public void getName() {
        ParameterCategory pc=new ParameterCategory("12345","name");
        String result=pc.getName();
        String expected="name";
        Assert.assertEquals(result,expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesExceptionBlank() {
        ParameterCategory pc = new ParameterCategory("", "name");
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesExceptionLessThen() {
        ParameterCategory pc = new ParameterCategory("1234", "name");
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesExceptionGreater() {
        ParameterCategory pc = new ParameterCategory("123456", "name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNameRulesExceptionBlank() {
        ParameterCategory pc = new ParameterCategory("12345", "");
    }
    @Test
    public void checkNameRulesExceptionEqualTo() {
        ParameterCategory pc = new ParameterCategory("12345", "namethatis");
        Assert.assertTrue(true);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkNameRulesExceptionIsGreaterThen() {

        ParameterCategory pc= new ParameterCategory("12345", "namethatisa");
    }
    @Test
    public void testEquals() {
        ParameterCategory pc = new ParameterCategory("12345", "name");
        ParameterCategory pc1 = new ParameterCategory("12345", "name");
        Assert.assertFalse(pc.equals(null));
        Assert.assertTrue(pc.equals(pc));
        TestType tt = new TestType("12345", "method", "description");
        Assert.assertFalse(pc.equals(tt));
        Assert.assertTrue(pc.equals(pc1));
        ParameterCategory pc2 = new ParameterCategory("12346", "name");
        Assert.assertEquals(pc,pc2);
        ParameterCategory pc3= new ParameterCategory("12345", "name1");
        Assert.assertEquals(pc,pc3);
        ParameterCategory pc4= new ParameterCategory("12346", "name1");
        Assert.assertNotEquals(pc,pc4);

    }


    @Test
    public void testToString() {
        ParameterCategory pc = new ParameterCategory("12345", "name");
        String result=pc.toString();
        String expected=String.format("##Parameter Category## %n Code: %s %nName: %s %n",
                pc.getCode(), pc.getName());
        Assert.assertEquals(result,expected);
    }
}