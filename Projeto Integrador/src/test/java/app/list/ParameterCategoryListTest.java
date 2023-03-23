package app.list;

import app.domain.model.ParameterCategory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author André Soares <1201314@isep.ipp.pt>
 */

public class ParameterCategoryListTest {

    @Test
    public void validateParameterCategory() {
        ParameterCategoryList pcList=new ParameterCategoryList();
        Assert.assertTrue(pcList.validateParameterCategory(new ParameterCategory("12345","name")));
        ParameterCategory pc=null;
        Assert.assertFalse(pcList.validateParameterCategory(pc));
    }
    @Test
    public void saveParameterCategory(){
        ParameterCategoryList pcList=new ParameterCategoryList();
        pcList.saveParameterCategory(new ParameterCategory("12345","name"));
        Assert.assertFalse(pcList.saveParameterCategory(new ParameterCategory("12345","name")));
        pcList.saveParameterCategory(new ParameterCategory("12345","name"));
        Assert.assertFalse(pcList.saveParameterCategory(new ParameterCategory("12345","name")));

    }
    @Test
    public void getClSize() {
        ParameterCategoryList pcList=new ParameterCategoryList();
        ParameterCategoryList pcList1=new ParameterCategoryList();
        pcList.saveParameterCategory(new ParameterCategory("12345","name"));
        pcList1.saveParameterCategory(new ParameterCategory("12345","name"));

        int result=pcList.getClSize();
        int result1=pcList1.getClSize();

        int expected=1;
        int expected1=1;


        Assert.assertEquals(result,expected);
        Assert.assertEquals(result1,expected1);
    }
}