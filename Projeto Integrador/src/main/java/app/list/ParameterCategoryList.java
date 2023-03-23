package app.list;

import app.domain.model.ParameterCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows for the construction of an object parameterCategoryList ,where the selected
 * parameter category by the user will be stored
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ParameterCategoryList {

    /**
     * A list designed to contain objects of the ParameterCategory class
     */
    private final List<ParameterCategory> cl;


    /**
     * Initializes a new list, while also assigning it an empty array list where
     * the chosen categories will be stored.
     */
    public ParameterCategoryList(){
        this.cl=new ArrayList<>();
    }

    /**
     * Allows the validation of an existing ParameterCategory object.
     *
     * @param pc An existing ParameterCategory object.
     * @return a boolean statement true,if the ParameterCategory object is validated , false if not.
     */
    public boolean validateParameterCategory(ParameterCategory pc) {
        if (pc == null) {
            return false;
        }
        return !cl.contains(pc);
    }

    /**
     * Allows the addition of an validated ParameterCategory object to the the parameter category
     * list of the object of the class ParameterCategoryList.
     *
     * @param pc An existing ParameterCategory object.
     * @return a boolean statement, true if the ParameterCategory object was added successfully to the parameter category
     * list false if not.
     */
    public boolean saveParameterCategory(ParameterCategory pc) {
        if (validateParameterCategory(pc)) {
            return cl.add(pc);
        }
        return false;
    }

    /**
     * Allows for the return of the size of the list cl.
     *
     * @return size in a integer of the list cl.
     */
    public int getClSize() {
        return cl.size();
    }

    /**
     * Method that returns the Parameter Category list.
     *
     * @return the Parameter Category list.
     */
    public List<ParameterCategory> getCl(){
        return cl;
    }
}

