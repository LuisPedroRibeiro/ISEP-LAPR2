package app.store;

import app.domain.model.Parameter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows for the construction of an object ParameterStore,where the all the created parameter will be stored
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ParameterStore {

    /**
     * A list designed to contain objects of the Parameter class
     */
    private final List<Parameter> paramStore;


    /**
     * Initializes a new ParameterStore, while also initializing  an empty array list where the Parameters will be stored
     */
    public ParameterStore() {
        this.paramStore = new ArrayList<>();
    }


    /**
     * Initializes a parameter with a code,name and description, lowerReferenceValue and upperReferenceValue.
     *
     * @param code A string that contains a code that identifies the Parameter.
     * @param shortName A string that contains a name that identifies the Parameter.
     * @param description A string that contains brief description that identifies the Parameter.
     * @return the created object of the Parameter class
     */
    public Parameter createParameter(String code, String shortName, String description) {
        return new Parameter(code, shortName, description);
    }

    /**
     * Allows the validation of an existing parameter
     *
     * @param p An existing parameter
     * @return a boolean statement true if the Parameter is not null and does not exist in the parameter store,
     * false if not
     */
    public boolean validateParameter(Parameter p) {
        if (p == null) {
            return false;
        }
        if (paramStore.contains(p)) {
            throw new IllegalArgumentException("There already exists a parameter with that information");
        }
        return true;
    }

    /**
     * Allows the addition of an validated parameter to the the list parameterStore of the object ParameterStore
     *
     * @param p An existing parameter object
     * @return a boolean statement, true if the parameter was added successfully to the parameter store false if not
     */
    public boolean saveParameter(Parameter p) {
        if (validateParameter(p))
            return paramStore.add(p);
        return false;
    }

    /**
     * Method that returns the Parameter that contains the code given as a parameter
     * @param code the code of the Parameter
     * @return the Parameter
     */
    public Parameter getParameterByCode(String code){
        for (Parameter parameter:paramStore) {
            if(parameter.getCode().equals(code))
                return parameter;
        }
        return null;
    }
}