package app.mappers.dto;

/**
 * This class allows to create a Parameter Dto.
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ParameterDto {

    /**
     * A string with five alphabetic characters.
     */
    private final String code;

    /**
     * A string with no more than 8 characters.
     */
    private final String shortName;

    /**
     * A string with no more than 20 characters.
     */
    private final String description;

    /**
     * A Constructor with all parameters of a Parameter.
     * Allows the creation of a Parameter Dto with all the variables received as parameters.
     *
     * @param code A string that contains a code that identifies the Parameter.
     * @param shortName A string that contains a name that identifies the Parameter.
     * @param description A string that contains brief description that identifies the Parameter.
     */
    public ParameterDto(String code, String shortName, String description) {
        this.code = code;
        this.shortName = shortName;
        this.description = description;
    }

    /**
     * Method that returns the Parameter Dto code.
     *
     * @return the Parameter Dto code.
     */
    public String getCode() {
        return code;
    }

    /**
     * The method that allows to see all the attributes of a Parameter in a organised way.
     *
     * @return All parameters of a Parameter with a specific format.
     */
    @Override
    public String toString(){
        return String.format("##Parameter## %n Code: %s %n Short Name: %s %n Description: %s %n ", code,shortName,description);
    }
}
