package app.mappers;

import app.domain.model.ClinicalAnalysisLaboratory;
import app.mappers.dto.ClinicalAnalysisLaboratoryDto;
import java.util.ArrayList;
import java.util.List;

/**
 * This class allows to create a Clinical Analysis Laboratory Mapper.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ClinicalAnalysisLaboratoryMapper {

    /**
     * Allows the transformation of ParameterCategory into a ParameterCategoryDTO
     *
     * @param clinicalAnalysisLaboratory An object of Clinical Analysis Laboratory that will be converted to a DTO
     * @return A DTO object  converted from the one received as parameter
     */
    public ClinicalAnalysisLaboratoryDto toDTO(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory)
    {
        return new ClinicalAnalysisLaboratoryDto(clinicalAnalysisLaboratory.getLaboratoryId(),
                clinicalAnalysisLaboratory.getAddress(),clinicalAnalysisLaboratory.getName(),
                clinicalAnalysisLaboratory.getPhoneNumber(),clinicalAnalysisLaboratory.getTaxIdentificationNumber());
    }

    /**
     * Allows the transformation of list Clinical Analysis Laboratory objects into a list of Clinical Analysis Laboratory DTO objects
     *
     * @param clinicalAnalysisLaboratoryList A list of Clinical Analysis Laboratory objects
     * @return A list of ClinicalAnalysisLaboratoryDro objects
     */

    public List<ClinicalAnalysisLaboratoryDto> toDTO(List<ClinicalAnalysisLaboratory> clinicalAnalysisLaboratoryList)
    {
        List<ClinicalAnalysisLaboratoryDto> clinicalAnalysisLaboratoryDto = new ArrayList<>();
        for(ClinicalAnalysisLaboratory clinicalAnalysisLaboratory: clinicalAnalysisLaboratoryList )
        {
           clinicalAnalysisLaboratoryDto.add(this.toDTO(clinicalAnalysisLaboratory));
        }
        return clinicalAnalysisLaboratoryDto;
    }
}
