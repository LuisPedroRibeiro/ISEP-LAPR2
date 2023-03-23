package app.adapter;

import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This Class tests the ExternalModuleAdapter3 class.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ExternalModuleAdapter3Test {

    @Test
    public void getReferenceValue() {

        Parameter parameter = new Parameter("ESR00","ESR00","ESR00");
        ExternalModuleAdapter3 adp3 = new ExternalModuleAdapter3();
        ReferenceValue expected = new ReferenceValue(10.0D,1.0D);

        ReferenceValue result = adp3.getReferenceValue(parameter);

        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void getMetric() {
        Parameter parameter = new Parameter("ESR00","ESR00","ESR00");
        ExternalModuleAdapter3 adp3 = new ExternalModuleAdapter3();
        String expected = "mm/hr";

        String result = adp3.getMetric(parameter);
        assertEquals(expected,result);
    }
}