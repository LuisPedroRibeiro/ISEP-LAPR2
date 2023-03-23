package app.domain.model;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ParameterCategory {

    /**
     * The code of the Parameter Category ( must have 5 chars)
     */
    private final String code;

    /**
     * The name of the Parameter Category (must have no more than 10 chars) (
     */
    private final String name;

    /**
     * A list that contains the Parameters associated to the Category
     */
    private final List<Parameter> parameterList = new ArrayList<>();

    /**
     * Constructs an instance of Parameter Category receiving the code and the name
     *
     * @param code  the Code of the Parameter Category
     * @param name the name of the Parameter Category
     */
    public ParameterCategory(String code, String name) {
        checkCodeRules(code);
        checkNameRules(name);
        this.code = code;
        this.name = name;
    }

    /**
     * Return  the code string
     *
     * @return the code string
     */
    public String getCode() {
        return code;
    }

    /**
     * Return the description string
     *
     * @return the description string
     */
    public String getName() {
        return name;
    }


    /**
     * Method to check the rules applied to Parameter Category codes
     *
     * @param code the Code of the Parameter Category
     */
    public void checkCodeRules(String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if (code.length() !=5 )
            throw new IllegalArgumentException("Code must have 5 chars.");
    }

    /**
     * Method to check the rules applied to Parameter Category descriptions
     *
     * @param name the name of the Parameter Category
     */
    public void checkNameRules(String name) {
        if (StringUtils.isBlank(name))
            throw new IllegalArgumentException("Name cannot be blank.");
        if (name.length() > 10)
            throw new IllegalArgumentException("Name  must have no more that 10 chars");
    }

    /**
     * Returns if this Parameter Category is equal to other Object
     *
     * @param o the Object received as a parameter
     * @return boolean value of the equality between the Parameter Category
     * and the Object received as a parameter
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParameterCategory pc = (ParameterCategory) o;
        return code.equals(pc.code) || name.equals(pc.name);
    }

    /**
     * Method to add a Parameter to the Category
     * @param parameter the Parameter that will be added
     * @return the boolean value of the operation
     */
    public boolean addParameter(Parameter parameter){
        return this.parameterList.add(parameter);
    }

    /**
     * Returns the list of Parameters of the Category
     * @return the list of Parameters
     */
    public List<Parameter> getParameterList() {
        return parameterList;
    }

    /**
     * Returns the textual description of the Parameter Category
     *
     * @return attributes of the Parameter Category
     */
    @Override
    public String toString() {
        return String.format("##Parameter Category## %n Code: %s %nName: %s %n",
                code, name);
    }
}