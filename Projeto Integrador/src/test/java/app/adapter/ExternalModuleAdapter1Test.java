package app.adapter;

import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This Class tests the ExternalModuleAdapter1 class.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ExternalModuleAdapter1Test {

    @Test
    public void getReferenceValue() {
        Parameter parameter = new Parameter("IgGAN","IgGAN","IgGAN");
        ExternalModuleAdapter1 adp1 = new ExternalModuleAdapter1();
        ReferenceValue expected = new ReferenceValue(1.4D,0.0D);

        ReferenceValue result = adp1.getReferenceValue(parameter);

        assertEquals(expected.toString(),result.toString());
    }



    @Test
    public void getMetric() {
        Parameter parameter = new Parameter("IgGAN","IgGAN","IgGAN");
        ExternalModuleAdapter1 adp1 = new ExternalModuleAdapter1();
        String expected = "Index (S/C) Value";

        String result = adp1.getMetric(parameter);

        assertEquals(expected,result);
    }
}