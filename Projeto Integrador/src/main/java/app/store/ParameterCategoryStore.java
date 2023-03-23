package app.store;

import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ParameterCategoryStore {

    /**
     * A list designed to contain objects of the ParameterCategory class
     */
    private final List<ParameterCategory> categoryStore;

    /**
     * Initializes a new categoryStore, while also assigning it an empty array list where the parameter categories will be stored
     */
    public ParameterCategoryStore(){
        this.categoryStore =new ArrayList<>();
    }

    /**
     * Initializes a parameter category with a code,name.
     *
     * @param code  the code of the Parameter Category
     * @param name the name of the Parameter Category
     * @return returns the created  Parameter Category object using the parameters
     */
    public ParameterCategory createParameterCategory(String code, String name) {
        return new ParameterCategory(code, name);
    }

    /**
     * Allows the validation of an existing parameter category and throwing  an exception if already inside the store
     *
     * @param pc An existing parameter category object
     * @return a boolean statement true if the parameter category is not null and does not exist in the parameter category store,
     * false if not
     */
    public boolean validateParameterCategory(ParameterCategory pc) {
        if (pc == null) {
            return false;
        }
        if (categoryStore.contains(pc)) {
            throw new IllegalArgumentException("There already exists a parameter category with that information");
        }
        return true;
    }

    /**
     * Allows the addition of an validated parameter category to the the list categoryStore of the object ParameterCategoryStore
     *
     * @param pc An existing ParameterCategory object
     * @return a boolean statement, true if the parameter category was added successfully to the parameter category store false if not
     */
    public boolean saveParameterCategory(ParameterCategory pc) {
        if (!validateParameterCategory(pc))
            return false;
        return this.categoryStore.add(pc);
    }

    /**
     * Allows the search and return of a parameterCategory using a code String
     *
     * @param code string containing a code that identifies a ParameterCategory object
     * @return The ParameterCategory object if found, null if not found
     */
    public ParameterCategory getParameterCategoryByCode(String code){
        for(ParameterCategory pc : getCategoryStore()){
            if(pc.getCode().equals(code))
                return pc;
        }
        return null;
    }

    /**
     * Allows the return of a copy of the list containing parameter categories
     *
     * @return a copy of a list containing parameter categories
     */
    public List<ParameterCategory> getCategoryStore() {

        return new ArrayList<>(categoryStore);
    }
}