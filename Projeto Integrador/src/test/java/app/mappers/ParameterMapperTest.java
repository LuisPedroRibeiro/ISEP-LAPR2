package app.mappers;

import app.domain.model.Parameter;
import app.mappers.dto.ParameterDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * This class allows to test the ParameterMapper class.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ParameterMapperTest {

    @Test
    public void toDTO() {

        Parameter p1= new Parameter("HH00P","HH00P","HH00Pr");
        ParameterMapper pm = new ParameterMapper();
        ParameterDto expected = new ParameterDto("HH00P","HH00P","HH00Pr");

        ParameterDto result = pm.toDTO(p1);

        assertEquals(expected.toString(),result.toString());
        Assert.assertEquals(expected.getCode(),result.getCode());

    }

    @Test
    public void testToDTO() {
        Parameter p1= new Parameter("HH00P","HH00P","HH00Pr");
        Parameter p2 = new Parameter("HH00H","HHOOH","HH00Hpa");
        ParameterMapper pm = new ParameterMapper();
        List<Parameter> expected = new ArrayList<>();
        expected.add(p1);
        expected.add(p2);

        List<ParameterDto> result = pm.toDTO(expected);

        assertEquals(expected.toString(),result.toString());
    }
}