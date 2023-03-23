package app.domain.model;

import app.list.ClinicalTestTypeList;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratoryTest {

    @Test (expected = IllegalArgumentException.class)
    public void checkLaboratoryIdRulesBlank() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("","Rua","Miguel",
                "12345678912","1234567891");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkLaboratoryIdRulesUp() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("1234567", "Rua", "Miguel",
                "12345678912", "1234567891");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkLaboratoryIdRulesDown() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("123", "Rua", "Miguel",
                "12345678912", "1234567891");
    }

    @Test
    public void checkLaboratoryIdRulesRight() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua","Miguel",
                "12345678912","1234567891");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkAddressRulesBlank() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","","Miguel",
                "12345678912","1234567891");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkAddressRulesUp() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Ruacamoescamoescamoes",
                "Miguel", "12345678912","1234567891");
    }

    @Test
    public void checkAddressRulesDown() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891");
        Assert.assertTrue(true);
    }

    @Test
    public void checkAddressRulesRight() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua Luis de Camoesss",
                "Miguel", "12345678912","1234567891");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkNameRulesBlank() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua","",
                "12345678912","1234567891");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkNameRulesUp() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "MiguelMiguelMiguelMiguelMiguelMiguelMiguel", "12345678912",
                "1234567891");
    }

    @Test
    public void checkNameRulesDown() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891");
        Assert.assertTrue(true);
    }

    @Test
    public void checkNameRulesEqual() {
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Rua",
                "MiguelMiguelMiguelMiguelMiguel", "12345678912",
                "1234567891");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkPhoneNumberRulesOnlyDigits() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "letras","1234567891");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkPhoneNumberRulesBlank() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "","1234567891");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkPhoneNumberRulesUp() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "123456789123","1234567891");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkPhoneNumberRulesDown() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "1234567891","1234567891");
    }

    @Test
    public void checkPhoneNumberRulesEqual() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891");
        Assert.assertTrue(true);
    }


    @Test (expected = IllegalArgumentException.class)
    public void checkTaxIdentificationNumberRulesOnlyDigits() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","letras");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkTaxIdentificationNumberRulesBlank() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkTaxIdentificationNumberRulesUp() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","12345678912");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkTaxIdentificationNumberRulesDown() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","123456789");
    }

    @Test
    public void checkTaxIdentificationNumberRulesEqual() {
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891");
        Assert.assertTrue(true);
    }

    @Test
    public void getLaboratoryId(){
        String expected = "12345";
        String result = new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891").getLaboratoryId();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void getAddress(){
        String expected = "Rua";
        String result = new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891").getAddress();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void getName(){
        String expected = "Miguel";
        String result = new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891").getName();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void getPhoneNumber(){
        String expected = "12345678912";
        String result = new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891").getPhoneNumber();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void getTaxIdentificationNumber(){
        String expected = "1234567891";
        String result = new ClinicalAnalysisLaboratory("12345","Rua",
                "Miguel", "12345678912","1234567891").getTaxIdentificationNumber();
        Assert.assertEquals(expected,result);
    }

    @Test
    public void saveTestTypeListToClinicalAnalysisLaboratory(){
        TestType t1 = new TestType("12345", "test", "test");
        TestType t2 = new TestType("67890", "test", "test");

        ClinicalTestTypeList tl1 = new ClinicalTestTypeList();
        tl1.saveClinicalTestType(t1);
        tl1.saveClinicalTestType(t2);

        ClinicalTestTypeList tl2= new ClinicalTestTypeList();
        tl2.saveClinicalTestType(t2);
        ClinicalTestTypeList expected = tl1;

        Assert.assertEquals(expected,tl1);
        Assert.assertNotEquals(expected,tl2);
    }

    @Test
    public void saveTestTypeListToClinicalAnalysisLaboratoryEmpty(){
        ClinicalTestTypeList tl1 = new ClinicalTestTypeList();

        ClinicalTestTypeList expected = tl1;

        Assert.assertEquals(expected,tl1);
        Assert.assertNotEquals(null,tl1);
    }

    @Test
    public void equals(){
        ClinicalAnalysisLaboratory result= new ClinicalAnalysisLaboratory("12345", "Rua",
                "Miguel", "12345678912", "1234567891");

        ClinicalAnalysisLaboratory expected= new ClinicalAnalysisLaboratory("12345", "Rua",
                "Miguel", "12345678912", "1234567891");
        Assert.assertEquals(expected,result);

        Assert.assertNotEquals(expected, null);

        TestType result2= new TestType("12345", "method", "description");
        Assert.assertNotEquals(expected,result2);

        ClinicalAnalysisLaboratory result3= new ClinicalAnalysisLaboratory("54321", "Rua",
                "Miguel", "12345678912", "1234567891");
        ClinicalAnalysisLaboratory result4= new ClinicalAnalysisLaboratory("12345", "Rua Camoes",
                "Miguel", "12345678912", "1234567891");
        ClinicalAnalysisLaboratory result5= new ClinicalAnalysisLaboratory("12345", "Rua",
                "Miguel", "12345678911", "1234567891");
        ClinicalAnalysisLaboratory result6= new ClinicalAnalysisLaboratory("12345", "Rua",
                "Miguel", "12345678912", "1234567899");
        ClinicalAnalysisLaboratory result7= new ClinicalAnalysisLaboratory("12345", "Rua",
                "Miguel Angelo", "12345678912", "1234567899");

        ClinicalAnalysisLaboratory result8= new ClinicalAnalysisLaboratory("54321", "Rua Camoes",
                "Miguel Angelo", "12345678911", "1234567899");
        Assert.assertEquals(result3,expected);
        Assert.assertEquals(result4,expected);
        Assert.assertEquals(result5,expected);
        Assert.assertEquals(result6,expected);
        Assert.assertEquals(result7,expected);

        Assert.assertNotEquals(result8,expected);

    }

    @Test
    public void toStringTest(){
        ClinicalAnalysisLaboratory c = new ClinicalAnalysisLaboratory("12345", "Rua",
                "Miguel", "12345678912", "1234567891");
        String expected= String.format("##Clinical Analysis Laboratory## %n Laboratory Id: %s %n Address: %s %n " +
                        "Name: %s %n Phone number: %s %n TIN: %s %n",c.getLaboratoryId(),c.getAddress(),c.getName(),
                c.getPhoneNumber(),c.getTaxIdentificationNumber());
        String result = c.toString();

        Assert.assertEquals(expected,result);
    }
}