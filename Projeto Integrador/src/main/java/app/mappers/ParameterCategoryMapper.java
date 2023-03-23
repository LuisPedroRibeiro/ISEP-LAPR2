
package app.mappers;

import app.domain.model.ParameterCategory;
import app.mappers.dto.ParameterCategoryDto;

import java.util.ArrayList;
import java.util.List;

 /**
 * This class allows for the creation of a ParameterCategoryMapper object
 *
 * @author André Soares
 */

public class ParameterCategoryMapper {

    /**
     * Allows the transformation of ParameterCategory into a ParameterCategoryDTO.
     *
     * @param pc An object of the the ParameterCategory,the object that will be converted.
     * @return A DTO object  converted from the one received as parameter.
     */
    public ParameterCategoryDto toDTO(ParameterCategory pc)
    {
        return new ParameterCategoryDto(pc.getCode(),pc.getName());
    }

    /**
     * Allows the transformation of list ParameterCategory objects into a list of
     * ParameterCategoryDTO objects containing the same information (code,name).
     *
     * @param pcStore A list of ParameterCategory objects.
     * @return A list of ParameterCategoryDTO objects.
     */

    public List<ParameterCategoryDto> toDTO(List<ParameterCategory> pcStore) {
        List<ParameterCategoryDto> parameterCategoryDTO = new ArrayList<>();
        for (ParameterCategory pc : pcStore) {
            parameterCategoryDTO.add(this.toDTO(pc));
        }
        return parameterCategoryDTO;
    }
}

