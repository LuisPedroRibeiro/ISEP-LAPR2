package app.store;

import app.domain.model.TestType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Andre Soares <1201314@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class TestTypeStoreTest {

    @Test
    public void createTestType() {
        TestTypeStore ts=new TestTypeStore();
        TestType tt=new TestType("12345","method","description");
        TestType tt1= ts.createTestType("12345", "method", "description");
        TestType tt2= ts.createTestType("12344", "method", "descriptionn");

        assertEquals(tt,tt1);
        assertNotEquals(tt2, tt1);
    }

    @Test
    public void validateTestType() {
        TestTypeStore typeStore=new TestTypeStore();
        TestType tt1=new TestType("12345","method","description");
        TestType tt=null;

        boolean result=typeStore.validateTestType(tt);
        boolean result1=typeStore.validateTestType(tt1);

        assertFalse(result);
        assertTrue(result1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateTestTypeException() {
        TestTypeStore typeStore = new TestTypeStore();

        TestType tt = new TestType("12345","method","description");

        typeStore.saveTestType(tt);
        typeStore.saveTestType(tt);
    }

    @Test
    public void saveTestType() {
        TestTypeStore typeStore=new TestTypeStore();
        TestType tt=null;

        boolean result= typeStore.saveTestType(tt);

        Assert.assertFalse(result);
    }


    @Test
    public void getTypeStore() {
        TestType tt= new TestType("12345","method","description");
        List<TestType> expected= new ArrayList<>();
        TestTypeStore result= new TestTypeStore();

        result.saveTestType(tt);
        expected.add(tt);

        Assert.assertEquals(result.getTypeStore(),expected);
    }

    @Test
    public void getTestTypeByCode() {
        int number=0;

        TestType expected= new TestType("12345","method","description");
        TestType t2= new TestType("54321","method","descriptionn");
        TestTypeStore typeStore= new TestTypeStore();

        typeStore.saveTestType(expected);
        typeStore.saveTestType(t2);

        TestType result= typeStore.getTestTypeByCode(number);

        Assert.assertEquals(expected,result);
    }
}