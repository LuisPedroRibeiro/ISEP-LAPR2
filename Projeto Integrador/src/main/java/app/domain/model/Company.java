package app.domain.model;

import app.mappers.TestMapper;
import app.store.*;
import auth.AuthFacade;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author André Soares
 * @author Miguel Ramos
 * @author Luís Ribeiro
 * @author Pedro Graça
 */
public class Company {

    /**
     * A string (description).
     */
    private final String designation;

    /**
     * A AuthFacade Object.
     */
    private final AuthFacade authFacade;

    /**
     * A TestTypeStore Object.
     */
    private final TestTypeStore testTypeStore;

    /**
     * A ParameterCategoryStore Object.
     */
    private final ParameterCategoryStore parameterCategoryStore;

    /**
     * A ClinicalAnalysisLaboratoryStore Object.
     */
    private final ClinicalAnalysisLaboratoryStore clinicalAnalysisLaboratoryStore;

    /**
     * A ClientStore Object.
     */
    private final ClientStore clientStore;

    /**
     * A EmployeeStore Object.
     */
    private final EmployeeStore employeeStore;

    /**
     * A ParameterStore Object.
     */
    private final ParameterStore parameterStore;

    /**
     * A TestStore Object.
     */
    private final TestStore testStore;

    /**
     * A TestMapper Object.
     */
    private final TestMapper testMapper;

    /**
     * A constructor that allows the initialization of all the Company instances.
     *
     * @param designation A string that contains a description of the Company.
     */
    public Company(String designation) {
        if (StringUtils.isBlank(designation))
            throw new IllegalArgumentException("Designation cannot be blank.");
        this.designation = designation;
        this.authFacade = new AuthFacade();
        this.testTypeStore = new TestTypeStore();
        this.parameterCategoryStore = new ParameterCategoryStore();
        this.clinicalAnalysisLaboratoryStore = new ClinicalAnalysisLaboratoryStore();
        this.clientStore = new ClientStore();
        this.employeeStore = new EmployeeStore();
        this.parameterStore = new ParameterStore();
        this.testStore = new TestStore();
        this.testMapper = new TestMapper();
    }

    /**
     * The method that allows the return of the ParameterCategoryStore.
     *
     * @return The Parameter Category Store.
     */
    public ParameterCategoryStore getParameterCategoryStore() {
        return parameterCategoryStore;
    }

    /**
     * The method that allows the return of the TestTypeStore.
     *
     * @return The Test Type Store.
     */
    public TestTypeStore getTestTypeStore() {
        return testTypeStore;
    }

    /**
     * The method that allows the return of Designation.
     *
     * @return The Company Designation.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * The method that allows the return of the AuthFacade.
     *
     * @return The AuthFacade.
     */
    public AuthFacade getAuthFacade() {
        return authFacade;
    }

    /**
     * The method that allows the return of the ClinicalAnalysisLaboratory.
     *
     * @return The ClinicalAnalysisLaboratory.
     */
    public ClinicalAnalysisLaboratoryStore getClinicalAnalysisLaboratoryStore() {
        return clinicalAnalysisLaboratoryStore;
    }

    /**
     * The method that allows the return of the ClientStore.
     *
     * @return The ClientStore.
     */
    public ClientStore getClientStore() {
        return this.clientStore;
    }

    /**
     * The method that allows the return of the EmployeeStore.
     *
     * @return The EmployeeStore.
     */
    public EmployeeStore getEmployeeStore() {
        return employeeStore;
    }

    /**
     * The method that allows the return of the ParameterStore.
     *
     * @return The ParameterStore.
     */
    public ParameterStore getParameterStore() {
        return parameterStore;
    }

    /**
     * The method that allows the return of the TestStore.
     *
     * @return The TestStore.
     */
    public TestStore getTestStore() {
        return testStore;
    }

    /**
     * The method that allows the return of the TestMapper.
     *
     * @return The TestMapper.
     */
    public TestMapper listDTO(){
        return testMapper;
    }
}