package app.mappers;

import app.domain.model.TestType;
import app.mappers.dto.TestTypeDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class TestTypeMapperTest {

    @Test
    public void toDTO() {
        TestType t1= new TestType("12345","method","description");
        TestType t2= new TestType("54321","method","description");
        TestTypeDto expected= new TestTypeDto("12345","method","description");
        TestTypeDto result= TestTypeMapper.toDTO(t1);
        TestTypeDto result2= TestTypeMapper.toDTO(t2);

        Assert.assertEquals(expected.getCode(),result.getCode());
        Assert.assertEquals(expected.getCollectionMethod(),result.getCollectionMethod());
        Assert.assertEquals(expected.getDescription(),expected.getDescription());
    }

    @Test
    public void listDTO() {
        TestType t1= new TestType("12345","method","description");
        TestType t2= new TestType("54321","method","description");
        List<TestType> expected= new ArrayList<>();
        expected.add(t1);
        expected.add(t2);

        TestTypeMapper r= new TestTypeMapper();
        List<TestTypeDto> result= r.listDTO(expected);

        boolean print= true;
        for(int i=0; i<result.size();i++){
            if(!(result.get(i).getCode().equals(expected.get(i).getCode()) &&
                    result.get(i).getCollectionMethod().equals(expected.get(i).getCollectionMethod()) &&
                    result.get(i).getDescription().equals(expected.get(i).getDescription()))){
                print= false;
            }
        }
        Assert.assertTrue(print);
    }
}