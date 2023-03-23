package app.domain.model;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This Class tests the TestParameter class.
 * 
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class TestParameterTest {

    @Test
    public void getParameter() {
        Parameter parameter = new Parameter("12345","PH00","Parameter");
        TestParameter testParameter = new TestParameter(parameter);

        Parameter result = testParameter.getParameter();

        assertEquals(parameter,result);
    }

    @Test
    public void addTestResult() {
        Parameter parameter = new Parameter("12345","PH00","Parameter");
        TestParameter testParameter = new TestParameter(parameter);
        ReferenceValue ref= new ReferenceValue(11,6);

        testParameter.addTestResult(1,"l", ref);
    }

    @Test
    public void getTestResult() {
        Parameter parameter = new Parameter("12345","PH00","Parameter");
        TestParameter testParameter = new TestParameter(parameter);
        ReferenceValue ref= new ReferenceValue(11,6);

        TestParameterResult expected = new TestParameterResult("l",1,ref);

        testParameter.addTestResult(1,"l", ref);
        TestParameterResult result = testParameter.getTestResult();

        assertEquals(expected.getMetric(),result.getMetric());
        assertEquals(expected.getRefValue(),result.getRefValue());
        assertEquals(result.getValue(),1,0);
    }

    @Test
    public void testToString() {
        Parameter parameter = new Parameter("12345","PH00","Parameter");
        TestParameter testParameter = new TestParameter(parameter);
        ReferenceValue ref= new ReferenceValue(11,6);
        String expected = String.format("%sResult Value: %.2f%n Metric: %s", parameter.toString(), 1.00,
               "l");

        testParameter.addTestResult(1,"l", ref);
        String result = testParameter.toString();
        System.out.println(result);

        assertEquals(expected,result);
    }
}