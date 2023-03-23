package app.controller;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.domain.model.Company;
import app.domain.model.TestType;
import app.mappers.dto.TestTypeDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class CreateClinicalAnalysisLaboratoryControllerTest {

    @Test
    public void createClinicalAnalysisLaboratory() {
        Company cp = new Company("ManyLabs");
        ClinicalAnalysisLaboratory cal = cp.getClinicalAnalysisLaboratoryStore().createClinicalAnalysisLaboratory(
                "12345", "Rua", "Miguel", "12345678912", "1234567891");
        boolean result = cp.getClinicalAnalysisLaboratoryStore().validatesClinicalAnalysisLaboratory(cal);

        Assert.assertTrue(result);
    }

//    @Test
//    public void saveClinicalAnalysisLaboratory() {
//        Company cp = new Company("ManyLabs");
//        ClinicalAnalysisLaboratory cal = cp.getClinicalAnalysisLaboratoryStore().createClinicalAnalysisLaboratory(
//                "12345", "Rua", "Miguel", "12345678912",
//                "1234567891");
//
//        CreateClinicalAnalysisLaboratoryController controller = new CreateClinicalAnalysisLaboratoryController();
//        controller.createClinicalAnalysisLaboratory("12345", "Rua", "Miguel",
//                "12345678912", "1234567891");
//
//        boolean result = cp.getClinicalAnalysisLaboratoryStore().validatesClinicalAnalysisLaboratory(cal);
//        boolean result2 = !cp.getClinicalAnalysisLaboratoryStore().validatesClinicalAnalysisLaboratory(cal);
//        boolean result3 = controller.saveClinicalAnalysisLaboratory();
//
//        boolean expected = cp.getClinicalAnalysisLaboratoryStore().saveClinicalAnalysisLaboratory(cal);
//
//        Assert.assertTrue(result);
//        Assert.assertFalse(result2);
//        Assert.assertEquals(result3, expected);
//    }

    @Test
    public void getClinicalAnalysisLaboratoryStore() {
        CreateClinicalAnalysisLaboratoryController controller = new CreateClinicalAnalysisLaboratoryController();
        controller.createClinicalAnalysisLaboratory("12345", "Rua",
                "Miguel", "12345678912", "1234567891");
        ClinicalAnalysisLaboratory expected = new ClinicalAnalysisLaboratory("12345", "Rua",
                "Miguel", "12345678912", "1234567891");

        ClinicalAnalysisLaboratory result = controller.getClinicalAnalysisLaboratoryStore();

        Assert.assertEquals(expected, result);
    }


//    @Test
//    public void getTypeStore() {
//        TestType t1= new TestType("22222","method","description");
//        TestType t2= new TestType("11111","method","description5");
//        TestType t3= new TestType("12345", "method", "description");
//        List<TestType> expected = new ArrayList<>();
//        expected.add(t1);
//        expected.add(t2);
//        expected.add(t3);
//
//        CreateClinicalAnalysisLaboratoryController controller= new CreateClinicalAnalysisLaboratoryController();
//        controller.getTypeStore().add(t1);
//        List<TestType> result= controller.getTypeStore();
//
//        Assert.assertEquals(result,expected);
//    }

    @Test
    public void listDto() {
        CreateClinicalAnalysisLaboratoryController controller= new CreateClinicalAnalysisLaboratoryController();
        CreateTestTypeController tcontroller= new CreateTestTypeController();

        tcontroller.createTestType("11111","method","description5");
        CreateParameterCategoryController parameterCategoryController=new CreateParameterCategoryController();
        parameterCategoryController.createParameterCategory("98765","named");
        parameterCategoryController.saveParameterCategory();
        tcontroller.saveParameterCategory("98765");
        tcontroller.saveTestType();

        List<TestTypeDto> lttd= controller.listDto();

        boolean print=false;
        for (TestTypeDto ttd: lttd){
            if(ttd.getCode().equals("11111") && ttd.getDescription().equals("description5")){
                        print=true;
            }
        }
        Assert.assertTrue(print);
    }

//    @Test
//    public void getTestTypeCode() {
//        CreateClinicalAnalysisLaboratoryController controller = new CreateClinicalAnalysisLaboratoryController();
//        CreateTestTypeController tcontroller= new CreateTestTypeController();
//        CreateParameterCategoryController parameterCategoryController=new CreateParameterCategoryController();
//
//        TestType expected= new TestType("33333","method","description3");
//
//        tcontroller.createTestType("33333","method","description3");
//        parameterCategoryController.createParameterCategory("98766","namee");
//        parameterCategoryController.saveParameterCategory();
//        tcontroller.saveParameterCategory("98766");
//        tcontroller.saveTestType();
//
//        tcontroller.createTestType("54321","method2","description7");
//        parameterCategoryController.createParameterCategory("98755","namef");
//        parameterCategoryController.saveParameterCategory();
//        tcontroller.saveParameterCategory("98755");
//        tcontroller.saveTestType();
//        int code=3;
//        TestType result= controller.getTestTypeCode(code);
//
//        Assert.assertEquals(expected,result);
//    }

    @Test
    public void saveClinicalTestType() {
        CreateClinicalAnalysisLaboratoryController controller = new CreateClinicalAnalysisLaboratoryController();
        TestType t1 = new TestType("12345", "method", "description");
        boolean result = controller.saveClinicalTestType(t1);
        Assert.assertTrue(result);
    }

//    @Test
//    public void saveTestTypeListToClinicalAnalysisLaboratory() {
//        CreateClinicalAnalysisLaboratoryController controller = new CreateClinicalAnalysisLaboratoryController();
//        CreateTestTypeController tcontroller= new CreateTestTypeController();
//        CreateParameterCategoryController parameterCategoryController=new CreateParameterCategoryController();
//        controller.createClinicalAnalysisLaboratory("12345","Rua",
//                "Miguel", "12345678912","1234567891");
//
//        tcontroller.createTestType("12345", "method", "description");
//        parameterCategoryController.createParameterCategory("16346","nameb");
//        parameterCategoryController.saveParameterCategory();
//        tcontroller.saveParameterCategory("16346");
//        tcontroller.saveTestType();
//        TestType t1= new TestType("12345", "method", "description");
//        parameterCategoryController.createParameterCategory("16345","namec");
//        parameterCategoryController.saveParameterCategory();
//        tcontroller.saveParameterCategory("16345");
//
//        controller.saveClinicalTestType(t1);
//
//        boolean result= false;
//
//        Assert.assertFalse(result);
//    }
}

