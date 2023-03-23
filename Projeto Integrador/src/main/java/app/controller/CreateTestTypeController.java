package app.controller;

import app.domain.model.Company;
import app.domain.model.ParameterCategory;
import app.domain.model.TestType;
import app.list.AdapterEnum;
import app.list.ParameterCategoryList;
import app.mappers.ParameterCategoryMapper;
import app.mappers.TestTypeMapper;
import app.mappers.dto.ParameterCategoryDto;
import app.mappers.dto.TestTypeDto;

import java.util.List;

/**
 * This class allows for the creation of a controller for the test type creation
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class CreateTestTypeController {
    /**
     * Object of the Company class,where the store objects are saved
     */
    private final Company company;

    /**
     * Object of the TestType class
     */
    private TestType tt;

    /**
     * Object of the ParameterCategoryList class,where the selected ParameterCategory objects will be saved
     */
    private ParameterCategoryList cl;

    /**
     * Constructor to inicialize the Controller.
     */
    public CreateTestTypeController() {
        this(App.getInstance().getCompany());
    }

    /**
     *
     * Allows the initialization of an CreateTestTypeController using the parameter company while also
     * a TestType object with null and  a ParameterCategoryList object with null
     *
     * @param company  Object of the Company class
     */
    public CreateTestTypeController(Company company) {
        this.company = company;
        this.tt = null;
        this.cl = null;
    }

    /**
     * Allows the creation of a new TestType object using a code,collection method and string while also initializing a
     * new ParameterCategoryList object,and returning if the created TestType object is valid
     *
     * @param code string containing a code that identifies a test type
     * @param collectionMethod string describing the collection method
     * @param description string describing the test type
     * @return boolean statement,true if the TestType object does not exist in the TestTypeStore object,false if not
     */
    public boolean createTestType(String code,String collectionMethod, String description) {
        this.tt = this.company.getTestTypeStore().createTestType(code,collectionMethod,description);
        this.cl=new ParameterCategoryList();
        return this.company.getTestTypeStore().validateTestType(tt);
    }

    /**
     * Allows the save of valid ParameterCategory object in a ParameterCategoryList object using only code
     * that identifies a ParameterCategory.
     *
     * @param code string containing a code that identifies a ParameterCategory
     * @return boolean statement,true if the save was successful, false if not
     */
    public boolean saveParameterCategory(String code){
        ParameterCategory pc = company.getParameterCategoryStore().getParameterCategoryByCode(code);
        if(cl.validateParameterCategory(pc)) {
            return this.cl.saveParameterCategory(pc);
        }
        return false;
    }

    /**
     * Allows the association of a ParameterCategoryList object to a certain TestType object ,and after conducts a save
     * operation of said TestType object into TestTypeStore object.
     *
     * @return boolean statement, true if the save in the TestTypeStore was successful false if not.
     */
    public boolean saveTestType() {
        tt.addParameterCategoryListToTestType(cl);
        return this.company.getTestTypeStore().saveTestType(tt);
    }

    /**
     * Allows the return of a list of ParameterCategory objects that is contained in the object of the ParameterCategoryStore.
     *
     *  @return A list containing all the ParameterCategory objects inside the ParameterCategoryStore.
     */
    private List<ParameterCategory> getListParameterCategory() {
        return company.getParameterCategoryStore().getCategoryStore();
    }

    /**
     * Allows the creation of a list ParameterCategoryDto objects  from the list of ParameterCategory contained inside the parameterCategoryStore.
     *
     * @return list composed by ParameterCategoryDTO objects.
     */
    public List<ParameterCategoryDto> getParameterCategoryStoreDto(){
        ParameterCategoryMapper m=new ParameterCategoryMapper();
        return m.toDTO(getListParameterCategory());
    }


    public  void setAdapterByCode(int index){
        tt.setAdapterAddress(AdapterEnum.getAdapterAddresss().get(index));
    }
    /**
     * Allows the creation of a list TestTypeDto objects  from the list of TestType contained inside the testTypeStore.
     *
     * @return list composed by TestTypeDTO objects.
     */
    public List<TestTypeDto> getTestTypeDto(){
        TestTypeMapper m=new TestTypeMapper();
        return m.listDTO(company.getTestTypeStore().getTypeStore());
    }
}