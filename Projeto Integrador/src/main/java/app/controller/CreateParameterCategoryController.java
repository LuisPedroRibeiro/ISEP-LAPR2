package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;

/**
 * Allows the System to control the creation of a new Parameter Category.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class CreateParameterCategoryController {

    /**
     * Company that has the controller.
     */
    private final Company company;

    /**
     * Parameter Category that will be created.
     */
    private ParameterCategory pc;

    /**
     * Constructs an instance of CreateParameterCategoryController with no parameters.
     */
    public CreateParameterCategoryController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Allows the creation of a Controller that uses a Company.
     *
     * @param company Company that will have the control of the Controller.
     */
    public CreateParameterCategoryController(Company company) {
        this.company = company;
        this.pc = null;
    }

    /**
     * Permits the creation of a Parameter Category.
     *
     * @param code Code that identifies the Parameter Category.
     * @param name Name that identifies the Parameter Category.
     * @return Boolean Value that represents if the Parameter Category was created or not
     * (true = Parameter Category was created | false = Parameter Category was not created).
     */
    public boolean createParameterCategory(String code, String name) {
        this.pc = this.company.getParameterCategoryStore().createParameterCategory(code,name);
        return this.company.getParameterCategoryStore().validateParameterCategory(pc);
    }

    /**
     * Allows the addition of a Parameter Category to the Employee Store.
     * If the Employee is not validated, the returned boolean value will be false, if not, the value will be true.
     *
     * @return Boolean value considering the addition of a Parameter Category to the Store.
     */
    public boolean saveParameterCategory() {
        return this.company.getParameterCategoryStore().saveParameterCategory(pc);
    }
}
