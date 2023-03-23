package app.list;

import app.domain.model.TestType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class ClinicalTestTypeListTest {

    @Test
    public void saveClinicalTestType() {
        TestType t = new TestType("12345", "test", "test");
        ClinicalTestTypeList tl1= new ClinicalTestTypeList();
        boolean expected= tl1.saveClinicalTestType(t);
        assertTrue(expected);
    }

    @Test
    public void saveClinicalTestTypeEmpty() {
        ClinicalTestTypeList tl1= new ClinicalTestTypeList();
        boolean expected= tl1.validatesClinicalTestType(null);
        assertFalse(expected);
    }


    @Test
    public void validatesClinicalTestType() {
        TestType t = new TestType("12345", "test", "test");
        ClinicalTestTypeList tl1= new ClinicalTestTypeList();
        boolean expected= tl1.validatesClinicalTestType(t);

        assertTrue(expected);
    }

    @Test
    public void validatesClinicalTestTypeEmpty() {
        ClinicalTestTypeList tl1= new ClinicalTestTypeList();
        boolean expected= tl1.validatesClinicalTestType(null);

        assertFalse(expected);
    }

    @Test
    public void getSizeZero() {
        ClinicalTestTypeList tl1= new ClinicalTestTypeList();
        int expected=0;
        int result= tl1.getSize();

        Assert.assertEquals(expected,result);
    }

    @Test
    public void getSize() {
        ClinicalTestTypeList tl1= new ClinicalTestTypeList();
        int expected=1;
        TestType t = new TestType("12345", "test", "test");
        tl1.saveClinicalTestType(t);
        int result= tl1.getSize();

        Assert.assertEquals(expected,result);
    }
}