package app.mappers.dto;

/**
 * This class allows for the creation of a ParameterCategoryDto object
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ParameterCategoryDto {

    /**
     * The code of the Parameter Category ( must have 5 chars).
     */
    private final String code;

    /**
     * The name of the Parameter Category (must have no more than 10 chars).
     */
    private final String name;

    /**
     * Constructs an instance of Parameter Category receiving the code and the name string.
     *
     * @param code the code string of the Parameter Category.
     * @param name the name string of the Parameter Category.
     */
    public ParameterCategoryDto(String code, String name) {
        this.code=code;
        this.name = name;
    }

    /**
     * Returns the organized textual description of the Parameter Category.
     *
     * @return textual description of the Parameter Category.
     */
    @Override
    public String toString() {
        return String.format("##Parameter Category## %n Code: %s %n Name: %s",
                code, name);
    }

    /**
     * Returns the code string.
     *
     * @return the code string.
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns the name string.
     *
     * @return the name string.
     */
    public String getName() {
        return name;
    }
}
