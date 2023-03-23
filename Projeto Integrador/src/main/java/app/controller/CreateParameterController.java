package app.controller;

import app.domain.model.Company;
import app.domain.model.Parameter;
import app.domain.model.ParameterCategory;
import app.mappers.ParameterCategoryMapper;
import app.mappers.dto.ParameterCategoryDto;
import app.store.ParameterStore;

import java.util.List;

/**
 * This class controls the creation of a new Parameter
 *
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class CreateParameterController {

    /**
     * Company that will have the controller
     */
    private final Company company;

    /**
     * Parameter that will be controlled
     */
    private Parameter parameter;

    /**
     * Store the Clients
     */
    private ParameterStore store;

    /**
     * Constructs an instance of CreateParameterController with no parameters
     */
    public CreateParameterController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructs an instance of CreateParameterController receiving the Company
     *
     * @param company the Company that will be on the controller
     */
    public CreateParameterController(Company company) {
        this.company = company;
        this.parameter = null;
    }

    /**
     * Method that returns the boolean value of the creation of a Parameter
     *
     * @param code  A string that contains a code that identifies the Parameter
     * @param shortName A string that contains a name that identifies the Parameter
     * @param description A string that contains brief description that identifies the Parameter
     * @return the boolean value of the operation
     */
    public boolean createParameter(String code, String shortName, String description){
        identifyStore();
        this.parameter=this.store.createParameter(code,shortName,description);
        return this.store.validateParameter(parameter);
    }

    /**
     * Method that add a ParameterCategory object to a Parameter object and returns the boolean value of the saving of a Parameter
     *
     * @return the boolean value of the operation
     */
    public boolean saveParameter(String code){
        ParameterCategory pc=company.getParameterCategoryStore().getParameterCategoryByCode(code);
        parameter.addParameterCategoryToParameter(pc);
        pc.addParameter(parameter);
        return this.store.saveParameter(parameter);
    }

    /**
     * Method to identify the store
     */
    public void identifyStore(){
        store=this.company.getParameterStore();
    }

    /**
     * Allows the return of a list of ParameterCategory objects that is contained in the object of the ParameterCategoryStore
     *
     * @return A list of parameter categories
     */
    private List<ParameterCategory> getListParameterCategoryStore() {
        return company.getParameterCategoryStore().getCategoryStore();
    }

    /**
     * Allows the creation of a DTO ParameterCategory list from the list parameterCategoryStore
     *
     * @return DTO list composed by ParameterCategoryDTO type objects
     */
    public List<ParameterCategoryDto> getParameterCategoryStoreDto(){
        ParameterCategoryMapper m = new ParameterCategoryMapper();
        return m.toDTO(getListParameterCategoryStore());
    }
}
