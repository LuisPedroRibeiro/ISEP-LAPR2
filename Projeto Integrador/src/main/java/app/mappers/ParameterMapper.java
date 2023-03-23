package app.mappers;

import app.domain.model.Parameter;
import app.mappers.dto.ParameterDto;
import java.util.ArrayList;
import java.util.List;

/**
 * This class allows to create a Parameter Mapper.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ParameterMapper {

    /**
     * Allows the transformation of Parameter into a ParameterDTO.
     *
     * @param parameter An object of the the Parameter that will be converted to a DTO.
     * @return A DTO object  converted from the one received as parameter.
     */
    public ParameterDto toDTO(Parameter parameter)
    {
        return new ParameterDto(parameter.getCode(),parameter.getShortName(),parameter.getDescription());
    }

    /**
     * Allows the transformation of list Parameter objects into a list of  ParameterDTO objects.
     *
     * @param listParameters A list of Parameter objects.
     * @return A list of ParameterDTO objects.
     */

    public List<ParameterDto> toDTO(List<Parameter> listParameters)
    {
        List<ParameterDto> parameterDto = new ArrayList<>();
        for(Parameter parameter: listParameters )
        {
            parameterDto.add(this.toDTO(parameter));
        }
        return parameterDto;
    }
}
