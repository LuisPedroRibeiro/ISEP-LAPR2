package app.controller;

import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.TestTypeDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class CreateTestTypeControllerTest {

    @Test
    public void createTestType() {
        CreateTestTypeController testTypeController=new CreateTestTypeController();

        boolean result=testTypeController.createTestType("14490","method","descriptio");

        Assert.assertTrue(result);
    }

    @Test
    public void saveParameterCategory() {
        CreateParameterCategoryController parameterCategoryController=new CreateParameterCategoryController();
        parameterCategoryController.createParameterCategory("12245","nam");
        parameterCategoryController.saveParameterCategory();
        CreateTestTypeController testTypeController=new CreateTestTypeController();
        testTypeController.createTestType("11344","method","descriptione");

        boolean result=testTypeController.saveParameterCategory("12245");
        boolean result1=testTypeController.saveParameterCategory("12245");

        Assert.assertTrue(result);
        Assert.assertFalse(result1);
    }

    @Test
    public void saveTestType() {
        CreateParameterCategoryController parameterCategoryController=new CreateParameterCategoryController();
        parameterCategoryController.createParameterCategory("12346","namek");
        parameterCategoryController.saveParameterCategory();
        CreateTestTypeController testTypeController=new CreateTestTypeController();
        testTypeController.createTestType("00006","method","descriptionn");
        testTypeController.saveParameterCategory("12346");

        boolean result=testTypeController.saveTestType();

        Assert.assertTrue(result);
    }

    @Test
    public void getParameterCategoryStoreDto() {
        CreateParameterCategoryController parameterCategoryController=new CreateParameterCategoryController();
        parameterCategoryController.createParameterCategory("16386","namebb");
        parameterCategoryController.saveParameterCategory();
        CreateTestTypeController testTypeController=new CreateTestTypeController();
        List<ParameterCategoryDto>  parameterCategoryDtoList = testTypeController.getParameterCategoryStoreDto();
        boolean result=false;

        for (ParameterCategoryDto pc:parameterCategoryDtoList){
            if(pc.getCode().equals("16386") && pc.getName().equals("namebb")){
                result=true;
            }
        }

        Assert.assertTrue(result);
    }
    @Test
    public void getTestTypeDto() {
        CreateTestTypeController testTypeController= new CreateTestTypeController();

        testTypeController.createTestType("11133","method","descrition");
        CreateParameterCategoryController parameterCategoryController=new CreateParameterCategoryController();
        parameterCategoryController.createParameterCategory("98760","namel");
        parameterCategoryController.saveParameterCategory();
        testTypeController.saveParameterCategory("98760");
        testTypeController.saveTestType();

        List<TestTypeDto> testTypeDtoList= testTypeController.getTestTypeDto();

        boolean print=false;
        for (TestTypeDto ttDto: testTypeDtoList){
            if(ttDto.getCode().equals("11133") && ttDto.getDescription().equals("descrition")){
                print=true;
            }
        }
        Assert.assertTrue(print);
    }

}