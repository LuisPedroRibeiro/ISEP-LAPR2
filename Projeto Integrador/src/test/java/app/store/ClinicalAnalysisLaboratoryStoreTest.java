package app.store;

import app.domain.model.ClinicalAnalysisLaboratory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratoryStoreTest {

    @Test
    public void createClinicalAnalysisLaboratory() {

        ClinicalAnalysisLaboratoryStore cals = new ClinicalAnalysisLaboratoryStore();
        ClinicalAnalysisLaboratory expected = cals.createClinicalAnalysisLaboratory("12345","l","l",
                "12345678912","1234567891");

        ClinicalAnalysisLaboratory result = cals.createClinicalAnalysisLaboratory("12345","l","l",
                "12345678912","1234567891");
        Assert.assertEquals(expected,result);

        ClinicalAnalysisLaboratory result2 = cals.createClinicalAnalysisLaboratory("54321","la","l",
                "12345678911","1234567890");
        Assert.assertNotEquals(expected,result2);
    }

    @Test
    public void saveClinicalAnalysisLaboratory() {
        ClinicalAnalysisLaboratory t = new ClinicalAnalysisLaboratory("12345","l","l",
                "12345678912","1234567891");
        ClinicalAnalysisLaboratoryStore tl1= new ClinicalAnalysisLaboratoryStore();
        boolean expected = !tl1.validatesClinicalAnalysisLaboratory(t);
        boolean expected2= tl1.saveClinicalAnalysisLaboratory(t);
        assertFalse(expected);
        assertTrue(expected2);
    }

    @Test
    public void saveClinicalAnalysisLaboratoryEmpty() {
        ClinicalAnalysisLaboratoryStore tl1= new ClinicalAnalysisLaboratoryStore();
        boolean expected= tl1.validatesClinicalAnalysisLaboratory(null);
        assertFalse(expected);
    }


    @Test
    public void validatesClinicalAnalysisLaboratory() {
        ClinicalAnalysisLaboratory t = new ClinicalAnalysisLaboratory("12345","l","l",
                "12345678912","1234567891");
        ClinicalAnalysisLaboratoryStore tl1= new ClinicalAnalysisLaboratoryStore();
        boolean expected= tl1.validatesClinicalAnalysisLaboratory(t);
        boolean expected2= !tl1.validatesClinicalAnalysisLaboratory(t);

        assertTrue(expected);
        assertFalse(expected2);
    }

    @Test
    public void validatesClinicalAnalysisLaboratoryEmpty() {
        ClinicalAnalysisLaboratoryStore tl1= new ClinicalAnalysisLaboratoryStore();
        boolean expected= tl1.validatesClinicalAnalysisLaboratory(null);

        assertFalse(expected);
    }
}