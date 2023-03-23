package app.domain.model;


import org.apache.commons.lang3.StringUtils;

/**
 * Class that allows the creation of a Parameter.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class Parameter {

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
     * Object of the class ParameterCategory which will be assigned to a specific parameter
     */
    private ParameterCategory pc;

    /**
     * A Constructor with all parameters of a Parameter.
     * Allows the creation of a Parameter with all parameters.
     *
     * @param code A string that contains a code that identifies the Parameter.
     * @param shortName A string that contains a name that identifies the Parameter.
     * @param description A string that contains brief description that identifies the Parameter.
     */
    public Parameter(String code, String shortName, String description){
        checkCodeRules(code);
        this.code=code;

        checkNameRules(shortName);
        this.shortName=shortName;

        checkDescriptionRules(description);
        this.description=description;
    }

    /**
     * Method that allows the verification of code restrictions throwing an exception if the operation fails.
     *
     * @param code The parameter that will be checked (5 alphabetic numbers).
     */
    public void checkCodeRules(String code){
        if(StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if(code.length()!=5){
            throw new IllegalArgumentException("Code should have 5 alphabetic numbers.");
        }
    }

    /**
     * Method that allows the verification of name restrictions throwing an exception if the operation fails.
     *
     * @param shortName The parameter that will be checked (no more than 8 characters).
     */
    public void checkNameRules(String shortName){
        if(StringUtils.isBlank(shortName))
            throw new IllegalArgumentException("Name cannot be blank.");
        if(shortName.length()>8){
            throw new IllegalArgumentException("Name should have 8 characters or fewer.");
        }
    }

    /**
     * Method that allows the verification of description restrictions throwing an exception if the operation fails.
     *
     * @param description The parameter that will be checked (no more than 20 characters).
     */
    public void checkDescriptionRules(String description){
        if(StringUtils.isBlank(description))
            throw new IllegalArgumentException("Description cannot be blank.");
        if(description.length()>20){
            throw new IllegalArgumentException("Laboratory Id should have 20 characters or fewer.");
        }
    }

    /**
     * Method to get the code of the Parameter
     *
     * @return the code of the Parameter
     */
    public String getCode() {
        return code;
    }

    /**
     * Method to get the name of the Parameter
     *
     * @return the name of the Parameter
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * Method to get the description of the Parameter
     *
     * @return the description of the Parameter
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method to return the Parameter Category object
     *
     * @return Parameter Category object
     */
    public ParameterCategory getPc() {
        return pc;
    }


    /**
     * Allows the association of a Parameter object with a ParameterCategory object
     *
     * @param pc object of the ParameterCategory class
     */
    public void addParameterCategoryToParameter(ParameterCategory pc){
        this.pc=pc;
    }

    /**
     * The method that allows the comparasion between 2 objects (Parameters).
     *
     * @param parameter Parameter that will be compared.
     * @return True if they we're equals, and false if not.
     */
    @Override
    public boolean equals(Object parameter){
        if (this == parameter)
            return true;
        if (parameter == null || getClass() != parameter.getClass())
            return false;
        Parameter p= (Parameter) parameter;
        return this.code.equals(p.code) || this.shortName.equals(p.shortName);
    }

    /**
     * The method that allows to see all the parameters of a Parameter in a organised way.
     *
     * @return All parameters of a Parameter with a specific format.
     */
    @Override
    public String toString(){
        return String.format("##Parameter## %n Code: %s %n Short Name: %s %n Description: %s %n ", code,shortName,description);
    }
}
