package app.store;

import app.domain.model.Parameter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class ParameterStoreTest {

    @Test
    public void createParameter() {
        String code="qwert";
        String code2="qwery";
        String shortName="Seringu";
        String shortName1="Seringu1";
        String description="l";
        String description1="la";

        ParameterStore ps = new ParameterStore();
        Parameter expected = ps.createParameter(code,shortName,description);

        Parameter result = ps.createParameter(code,shortName,description);
        Assert.assertEquals(expected,result);

        Parameter result2 = ps.createParameter(code2,shortName,description);
        Parameter result3 = ps.createParameter(code2,shortName1,description1);
        Assert.assertNotEquals(expected,result3);
    }

    @Test
    public void saveParameter() {
        Parameter t = new Parameter("qwert","Seringue","l");
        ParameterStore tl1= new ParameterStore();
        boolean expected= tl1.saveParameter(t);
        assertTrue(expected);
    }

    @Test
    public void saveParameterEmpty() {
        ParameterStore tl1= new ParameterStore();
        boolean expected= tl1.validateParameter(null);
        assertFalse(expected);
    }


    @Test
    public void validateParameter() {
        Parameter t = new Parameter("qwert","Seringue","l");
        ParameterStore tl1= new ParameterStore();
        boolean expected= tl1.validateParameter(t);

        assertTrue(expected);
    }

    @Test
    public void validatesParamaterEmpty() {
        ParameterStore tl1= new ParameterStore();
        boolean expected= tl1.validateParameter(null);

        assertFalse(expected);
    }

}