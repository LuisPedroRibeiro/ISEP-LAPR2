package app.mappers;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.mappers.dto.ClinicalAnalysisLaboratoryDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
/**
 * This class allows to test ClinicalAnalysisLaboratoryMapper class
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratoryMapperTest {

    @Test
    public void toDTO() {
        ClinicalAnalysisLaboratory cal= new ClinicalAnalysisLaboratory("12345","Vila","CaxLab","91337755618","1234567890");
        ClinicalAnalysisLaboratoryMapper calMpr = new ClinicalAnalysisLaboratoryMapper();

        ClinicalAnalysisLaboratoryDto calDto =calMpr.toDTO(cal);

        assertEquals(cal.getLaboratoryId(),calDto.getLaboratoryId());

    }

    @Test
    public void testToDTO() {
        ClinicalAnalysisLaboratory cal= new ClinicalAnalysisLaboratory("12345","Vila","CaxLab","91337755618","1234567890");
        ClinicalAnalysisLaboratory cal2= new ClinicalAnalysisLaboratory("12346","Vila","CaxLab1","91337755619","1234567899");
        ClinicalAnalysisLaboratoryMapper calMpr = new ClinicalAnalysisLaboratoryMapper();
        List<ClinicalAnalysisLaboratory> expected = new ArrayList<>();

        List<ClinicalAnalysisLaboratoryDto> result = calMpr.toDTO(expected);

        assertEquals(expected.toString(),result.toString());
    }
}