package app.mappers.dto;

/**
 * This class allows to support the Test Type Mapper.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class TestTypeDto {

    /**
     * Five alphanumeric string unique to a test type.
     */
    private final String code;

    /**
     *  Less then 20 characters string describing the collection method of a test type.
     */
    private final String collectionMethod;

    /**
     * Less than 15 characters string with the description of the test type.
     */
    private final String description;


    /**
     * Allows the initialization of  a test type with a code,collectionMethod and description
     * while also checking if those are in accordance with the rules.
     *
     * @param code string containing a code that identifies a parameter category.
     * @param collectionMethod string describing the collection method.
     * @param description string describing the test type.
     */
    public TestTypeDto(String code, String collectionMethod, String description) {
        this.code = code;
        this.collectionMethod = collectionMethod;
        this.description = description;
    }

    /**
     * Returns the code of Test Type.
     *
     * @return the code String.
     */

    public String getCode() {
        return code;
    }

    /**
     * Returns the collection method of Test Type.
     *
     * @return the collection method String.
     */
    public String getCollectionMethod() {
        return collectionMethod;
    }

    /**
     * Returns the description of Test Type.
     *
     * @return the description String.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Allows the return of a string containing the code,description and collection method.
     * in a formal and organized manner.
     *
     * @return a string containing the code,description and collection method in a formal manner.
     */
    @Override
    public String toString() {
        return String.format("##Test Type## %n Code: %s %n Description: %s %n Collection Method: %s",
                code,description,collectionMethod);
    }
}
