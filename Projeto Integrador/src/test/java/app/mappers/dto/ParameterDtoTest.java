package app.mappers.dto;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class allows to test the ParameterDto class.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ParameterDtoTest {

    @Test
    public void getCode() {
        ParameterDto pDto = new ParameterDto("HH00P","HH00P","HH00Pr");
        String expected = "HH00P";

        String result= pDto.getCode();

        assertEquals(expected,result);
    }

    @Test
    public void testToString() {
        ParameterDto pDto = new ParameterDto("HH00P","HH00P","HH00Pr");
        String expected = String.format("##Parameter## %n Code: %s %n Short Name: %s %n Description: %s %n ", "HH00P","HH00P","HH00Pr");

        String result= pDto.toString();

        assertEquals(expected,result);

    }
}