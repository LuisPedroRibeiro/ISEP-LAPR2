package app.adapter;

import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This Class tests the ExternalModuleAdapter2 class.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ExternalModuleAdapter2Test {

    @Test
    public void getReferenceValue() {
        Parameter parameter = new Parameter("ESR00","ESR00","ESR00");
        ExternalModuleAdapter2 adp2 = new ExternalModuleAdapter2();
        ReferenceValue expected = new ReferenceValue(10.0D,1.0D);

        ReferenceValue result = adp2.getReferenceValue(parameter);

        assertEquals(expected.toString(),result.toString());
    }

    @Test
    public void getMetric() {
        Parameter parameter = new Parameter("ESR00","ESR00","ESR00");
        ExternalModuleAdapter2 adp2 = new ExternalModuleAdapter2();
        String expected = "mm/hr";

        String result = adp2.getMetric(parameter);
        assertEquals(expected,result);
    }
}