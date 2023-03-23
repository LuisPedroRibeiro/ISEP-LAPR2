package app.mappers;

import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André Soares <1201314isep.ipp.pt>
 */
public class ParameterCategoryMapperTest {

    @Test
    public void toDTO() {
        ParameterCategory pc=new ParameterCategory("12345","name");
        ParameterCategoryDto pcDto=new ParameterCategoryDto(pc.getCode(), pc.getName());

        String result=pc.getCode();
        String result1=pc.getName();
        String expected=pc.getCode();
        String expected1=pc.getName();

        Assert.assertEquals(result,expected);
        Assert.assertEquals(result1,expected1);
    }

    @Test
    public void testToDTO() {
        ParameterCategory pc=new ParameterCategory("12345","name");
        ParameterCategory pc1=new ParameterCategory("12345","name1");
        List<ParameterCategory> pcList=new ArrayList<>();
        pcList.add(pc);
        pcList.add(pc1);
        ParameterCategoryMapper m=new ParameterCategoryMapper();
        List<ParameterCategoryDto> pcDtoList=m.toDTO(pcList);
        boolean t=true;
        for(int i=0;i<pcDtoList.size();i++){
            if(!(pcList.get(i).getName().equals(pcDtoList.get(i).getName()) && pcList.get(i).getCode().equals(pcDtoList.get(i).getCode()))){
                t=false;
            }
        }
        Assert.assertTrue(t);
    }
}