package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This Class tests the Reference Value class.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ReferenceValueTest {

    @Test
    public void testToString() {

        ReferenceValue r= new ReferenceValue(3,1);
        String expected = String.format("Lower Reference Value: %.2f | Upper Reference Value: %.2f", 1.00,
                3.00);

        String result=r.toString();

        assertEquals(expected,result);
    }
}