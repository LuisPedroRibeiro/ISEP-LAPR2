package app.domain.model;

import org.junit.Assert;
import org.junit.Test;
import app.list.ParameterCategoryList;

/**
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class TestTypeTest {
    @Test
    public void RulesExceptionSuccess() {
        TestType tt = new TestType("12345", "method", "description");
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesExceptionBlank() {
        TestType tt = new TestType("", "method", "description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesExceptionLessThen() {
        TestType tt = new TestType("1234", "method", "description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesExceptionGreater() {
        TestType tt = new TestType("123456", "method", "description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDescriptionRulesExceptionBlank() {
        TestType tt = new TestType("12345", "method", "");
    }

    @Test
    public void checkDescriptionRulesExceptionEqualTo() {
        TestType tt = new TestType("12345", "method", "descriptionthat");
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDescriptionRulesExceptionIsGreaterThen() {

        TestType tt = new TestType("12345", "method", "descriptionthats");
    }


    @Test(expected = IllegalArgumentException.class)
    public void checkCollectionMethodRulesExceptionBlank() {
        TestType tt = new TestType("12345", "", "description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCollectionMethodRulesExceptionIsGreaterThen() {
        TestType tt = new TestType("12345", "abcdefgijklmnopkrstuy", "description");
    }

    @Test
    public void checkCollectionMethodRulesExceptionIsEqualTo() {
        TestType tt = new TestType("12345", "abcdefgijklmnopkrstu", "description");
        Assert.assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkParameterCategoryListRules() {
        ParameterCategoryList cl = new ParameterCategoryList();
        TestType tt = new TestType("12345", "method", "description");
        tt.validateParameterCategoryList(cl);
    }

    @Test
    public void addParameterCategoryListToTestType() {
        ParameterCategoryList expected = new ParameterCategoryList();
        TestType tt = new TestType("12345", "method", "description");
        expected.saveParameterCategory(new ParameterCategory("12345", "name"));
        tt.addParameterCategoryListToTestType(expected);

        ParameterCategoryList result=tt.getCl();

        Assert.assertEquals(result, expected);

    }

    @Test
    public void testEquals() {
        ParameterCategory pc = new ParameterCategory("12345", "name");
        TestType tt = new TestType("12345", "method", "description");
        TestType tt1 = new TestType("12345", "methodd", "descr");
        TestType tt2 = new TestType("12345", "methoddd", "description");
        TestType tt3 = new TestType("12355", "method", "descr");
        TestType tt4=null;

        Assert.assertNotEquals(tt, tt4);
        Assert.assertEquals(tt, tt);
        Assert.assertNotEquals(tt, pc);
        Assert.assertEquals(tt, tt1);
        Assert.assertEquals(tt, tt2);
        Assert.assertNotEquals(tt, tt3);

    }

    @Test
    public void getCode() {
        TestType tt = new TestType("12345", "method", "description");
        String result = tt.getCode();
        String expected = "12345";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void getDescription() {
        TestType tt = new TestType("12345", "method", "description");
        String result = tt.getCollectionMethod();
        String expected = "method";
        Assert.assertEquals(result, expected);


    }

    @Test
    public void getCollectionMethod() {
        TestType tt = new TestType("12345", "method", "description");
        String result = tt.getDescription();
        String expected = "description";
        Assert.assertEquals(result, expected);
    }

    @Test
    public void toStringTest() {
        TestType tt = new TestType("12345", "method", "description");

        String result = tt.toString();
        String expected = String.format("##Test Type## %n Code: %s %n Description: %s %n Collection Method: %s",
                tt.getCode(), tt.getDescription(), tt.getCollectionMethod());
        Assert.assertEquals(result, expected);


    }

    @Test(expected = IllegalArgumentException.class)
    public void checkRulesCodeIsAlphaNumeric() {
        TestType tt = new TestType("123/5", "method", "description");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTypeNull(){
        TestType tt= new TestType(null,null,null);
    }

}

