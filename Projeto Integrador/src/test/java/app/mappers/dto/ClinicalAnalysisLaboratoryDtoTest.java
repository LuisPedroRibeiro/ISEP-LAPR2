package app.mappers.dto;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class allows to test ClinicalAnalysisLaboratoryDto class
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratoryDtoTest {

    @Test
    public void getLaboratoryId() {
        ClinicalAnalysisLaboratoryDto calDto= new ClinicalAnalysisLaboratoryDto("12345","Vila","CaxLab","91337755618","1234567890");
        String expected = "12345";

        String result = calDto.getLaboratoryId();

        assertEquals(expected,result);
    }

    @Test
    public void testToString() {
        ClinicalAnalysisLaboratoryDto calDto= new ClinicalAnalysisLaboratoryDto("12345","Vila","CaxLab",
                "91337755618","1234567890");
        String expected = String.format("##Clinical Analysis Laboratory## %n LaboratoryId: %s %n Address: %s %n Name: %s %n Phone Number: %s %n Tax Identification Number: %s ",
                "12345", "Vila" , "CaxLab", "91337755618","1234567890");

        String result = calDto.toString();

        assertEquals(expected,result);

    }
}