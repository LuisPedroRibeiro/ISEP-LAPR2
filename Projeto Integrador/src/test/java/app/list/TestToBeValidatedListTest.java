package app.list;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestToBeValidatedListTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkTestToBeValidatedListIsEmpty() {
        TestToBeValidatedList testToBeValidatedList=new TestToBeValidatedList();
        testToBeValidatedList.checkTestToBeValidatedList();
    }

    @Test
    public void checkTestToBeValidatedListIsNotEmpty(){
        TestToBeValidatedList testToBeValidatedList=new TestToBeValidatedList();
        app.domain.model.Test t=new app.domain.model.Test("123456789012");

        testToBeValidatedList.saveTestToTestToBeValidatedList(t);
        testToBeValidatedList.checkTestToBeValidatedList();

        Assert.assertTrue(true);

    }

    @Test
    public void createListWithAllTestsAvailableToBeValidated() {
        TestToBeValidatedList testToBeValidatedList=new TestToBeValidatedList();
        app.domain.model.Test t=new app.domain.model.Test("123456789012");
        app.domain.model.Test t1=new app.domain.model.Test("123456789011");
        List<app.domain.model.Test> expected=new ArrayList<>();
        expected.add(t);
        expected.add(t1);
        testToBeValidatedList.createListWithAllTestsAvailableToBeValidated(expected);

        List<app.domain.model.Test> result=testToBeValidatedList.getTestToBeValidated();
        boolean b=true;
        for (int i = 0; i <result.size(); i++) {
            if (!(result.get(i).equals(expected.get(i)))) {
                b = false;
                break;
            }
        }
        Assert.assertTrue(b);

    }

    @Test
    public void validateTest() {
    }

    @Test
    public void saveTestToTestToBeValidatedList() {
        TestToBeValidatedList testToBeValidatedList=new TestToBeValidatedList();
        app.domain.model.Test t=new app.domain.model.Test("123456789012");

        boolean b= testToBeValidatedList.saveTestToTestToBeValidatedList(t);
        boolean b1= testToBeValidatedList.saveTestToTestToBeValidatedList(t);

        Assert.assertTrue(b);
        Assert.assertFalse(b1);

    }

    @Test
    public void getTestToBeValidated() {
        TestToBeValidatedList testToBeValidatedList=new TestToBeValidatedList();
        app.domain.model.Test t=new app.domain.model.Test("123456789012");
        testToBeValidatedList.saveTestToTestToBeValidatedList(t);

        List<app.domain.model.Test> result=testToBeValidatedList.getTestToBeValidated();
        List<app.domain.model.Test> expected=new ArrayList<>();
        expected.add(t);

        Assert.assertEquals(result,expected);
    }
}