package app.store;

import app.domain.model.ParameterCategory;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ParameterCategoryStoreTest {

    @Test
    public void createParameterCategory() {

        ParameterCategoryStore pcs = new ParameterCategoryStore();
        ParameterCategory expected = pcs.createParameterCategory("abcde","l");

        ParameterCategory result = pcs.createParameterCategory("abcde","l");
        Assert.assertEquals(expected,result);

        ParameterCategory result2 = pcs.createParameterCategory("edcab","la");
        Assert.assertNotEquals(expected,result2);
    }

    @Test
    public void saveParameterCategory() {

        ParameterCategory t = new ParameterCategory("abcde","l");
        ParameterCategoryStore pc= new ParameterCategoryStore();

        boolean expected=pc.saveParameterCategory(t);
        assertTrue(expected);
    }

    @Test
    public void saveParameterCategoryEmpty() {
        ParameterCategoryStore pcs= new ParameterCategoryStore();
        boolean expected= pcs.saveParameterCategory(null);
        assertFalse(expected);
    }


    @Test
    public void validatesParameterCategory() {
        ParameterCategory pc = new ParameterCategory("abcde","l");
        ParameterCategoryStore tl1= new ParameterCategoryStore();
        boolean expected= tl1.validateParameterCategory(pc);

        assertTrue(expected);
    }
    @Test(expected = IllegalArgumentException.class)
    public void validateParameterCategoryWithException() {
        ParameterCategory pc = new ParameterCategory("abcde","l");
        ParameterCategory pc1 = new ParameterCategory("abcde","l");
        ParameterCategoryStore tl1= new ParameterCategoryStore();
        tl1.saveParameterCategory(pc);
        tl1.validateParameterCategory(pc1);
    }

    @Test
    public void validatesParameterCategoryEmpty() {
        ParameterCategoryStore pcs= new ParameterCategoryStore();
        boolean expected= pcs.validateParameterCategory(null);

        assertFalse(expected);
    }
    @Test
    public void getParameterCategoryByCode(){
        ParameterCategory expected = new ParameterCategory("abcde","l");
        ParameterCategoryStore tl1= new ParameterCategoryStore();
        tl1.saveParameterCategory(expected);
        ParameterCategory result= tl1.getParameterCategoryByCode(expected.getCode());
        Assert.assertEquals(result,expected);
        ParameterCategory result1= tl1.getParameterCategoryByCode("a");
        Assert.assertNotEquals(expected,result1);
    }
    @Test
    public  void getCategoryStore(){
        ParameterCategory pc = new ParameterCategory("abcde","l");
        ParameterCategory pc1 = new ParameterCategory("edcab","la");
        ParameterCategoryStore tl1= new ParameterCategoryStore();
        List<ParameterCategory> expected=new ArrayList<>();
        expected.add(pc);
        expected.add(pc1);
        tl1.saveParameterCategory(pc);
        tl1.saveParameterCategory(pc1);
        List<ParameterCategory> result=tl1.getCategoryStore();
        Assert.assertEquals(result,expected);


    }
}