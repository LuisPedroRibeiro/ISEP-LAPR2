package app.controller;

import app.domain.model.*;
import app.domain.shared.Constants;
import app.list.AdapterEnum;
import app.list.ClinicalTestTypeList;
import app.list.ParameterCategoryList;
import app.mappers.dto.ClientDto;
import auth.AuthFacade;
import auth.UserSession;
import auth.domain.model.Email;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 * @author Luís Ribeiro <1201884@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class App {

    private Company company;
    private AuthFacade authFacade;

    private App() {
        Properties props = getProperties();
        this.company = new Company(props.getProperty(Constants.PARAMS_COMPANY_DESIGNATION));
        this.authFacade = this.company.getAuthFacade();
        Sample.setAdapterAddress(props.getProperty("Sample.AdapterAddress"));
        bootstrap();
    }

    public Company getCompany()
    {
        return this.company;
    }

    public UserSession getCurrentUserSession()
    {
        return this.authFacade.getCurrentUserSession();
    }

    public boolean doLogin(String email, String pwd)
    {
        return this.authFacade.doLogin(email,pwd).isLoggedIn();
    }

    public void doLogout()
    {
        this.authFacade.doLogout();
    }

    private Properties getProperties()
    {
        Properties props = new Properties();

        // Add default properties and values
        props.setProperty(Constants.PARAMS_COMPANY_DESIGNATION, "Many Labs");


        // Read configured values
        try
        {
            InputStream in = new FileInputStream(Constants.PARAMS_FILENAME);
            props.load(in);
            in.close();
        }
        catch(IOException ex)
        {

        }
        return props;
    }

    private void bootstrap()  {
        this.authFacade.addUserRole(Constants.ROLE_ADMIN,Constants.ROLE_ADMIN);
        this.authFacade.addUserRole(Constants.ROLE_RECEP,Constants.ROLE_RECEP);
        this.authFacade.addUserRole(Constants.ROLE_LABCO,Constants.ROLE_LABCO);
        this.authFacade.addUserRole(Constants.ROLE_CHEMTECH,Constants.ROLE_CHEMTECH);
        this.authFacade.addUserRole(Constants.ROLE_SPECDOC,Constants.ROLE_SPECDOC);
        this.authFacade.addUserRole(Constants.ROLE_MEDTECH,Constants.ROLE_MEDTECH);

        this.authFacade.addUserWithRole("Main Administrator", "admin@lei.sem2.pt", "123456",Constants.ROLE_ADMIN);
        this.authFacade.addUserWithRole("Receptionist","recep@gmail.com","123456",Constants.ROLE_RECEP);
        this.authFacade.addUserWithRole("Laboratory Coordinator","labco@gmail.com","123456",Constants.ROLE_LABCO);
        this.authFacade.addUserWithRole("Chemistry Analysis Technologist","chemtech@gmail.com","123456",Constants.ROLE_CHEMTECH);
        this.authFacade.addUserWithRole("Specialist Doctor","specdoc@gmail.com","123456",Constants.ROLE_SPECDOC);
        this.authFacade.addUserWithRole("Medical Lab Technician","medtech@gmail.com","123456",Constants.ROLE_MEDTECH);

        ParameterCategory pc = new ParameterCategory("12345","Hemogram");
        ParameterCategory pc3 = new ParameterCategory("12333", "Protein");
        ParameterCategory pc4= new ParameterCategory("12332","Covid2");
        this.getCompany().getParameterCategoryStore().saveParameterCategory(pc);
        this.getCompany().getParameterCategoryStore().saveParameterCategory(pc3);
        this.getCompany().getParameterCategoryStore().saveParameterCategory(pc4);

        Parameter p3 = new Parameter("ESR00","ESR","paramESR");
        Parameter p4 = new Parameter("MCHC0","MCHC","MCHCparam");
        Parameter p5 = new Parameter("MCV00","MCV","MCVparam");
        Parameter p6=new Parameter("IgGAN","IgGAN","IgGANparam");
        Parameter p7 = new Parameter("HB000","HB000","HB00param");
        Parameter p8 = new Parameter("PLT00","PLT0","PLT0param");
        Parameter p9=new Parameter("RBC00","RBC00","RBC0param");
        Parameter p10=new Parameter("WBC00","WBC00","WBC0param");

        p7.addParameterCategoryToParameter(pc);
        p8.addParameterCategoryToParameter(pc);
        p9.addParameterCategoryToParameter(pc);
        p10.addParameterCategoryToParameter(pc);
        p3.addParameterCategoryToParameter(pc3);
        p4.addParameterCategoryToParameter(pc3);
        p5.addParameterCategoryToParameter(pc3);
        p6.addParameterCategoryToParameter(pc4);

        ParameterCategoryList parameters = new ParameterCategoryList();
        ParameterCategoryList parameters1 = new ParameterCategoryList();
        ClinicalTestTypeList testTypeList = new ClinicalTestTypeList();
        parameters.saveParameterCategory(pc);
        parameters.saveParameterCategory(pc3);
        parameters1.saveParameterCategory(pc4);
        this.getCompany().getParameterStore().saveParameter(p6);
        this.getCompany().getParameterStore().saveParameter(p3);
        this.getCompany().getParameterStore().saveParameter(p4);
        this.getCompany().getParameterStore().saveParameter(p5);
        this.getCompany().getParameterStore().saveParameter(p8);
        this.getCompany().getParameterStore().saveParameter(p7);
        this.getCompany().getParameterStore().saveParameter(p9);
        this.getCompany().getParameterStore().saveParameter(p10);
        pc.addParameter(p7);
        pc.addParameter(p8);
        pc.addParameter(p9);
        pc.addParameter(p10);
        pc3.addParameter(p3);
        pc3.addParameter(p4);
        pc3.addParameter(p5);
        pc4.addParameter(p6);
        TestType testType = new TestType("12345","Syringe","Blood test");
        testType.setAdapterAddress(AdapterEnum.EXTERNAL_MODULE_BLOOD1.getAdapterAddress());
        TestType testType1 = new TestType("12344","Swab","COVID-19 test");
        testType1.setAdapterAddress(AdapterEnum.EXTERNAL_MODULE_COVID.getAdapterAddress());
        testType.addParameterCategoryListToTestType(parameters);
        testType1.addParameterCategoryListToTestType(parameters1);
        this.getCompany().getTestTypeStore().saveTestType(testType);
        this.getCompany().getTestTypeStore().saveTestType(testType1);
        testTypeList.saveClinicalTestType(testType);
        testTypeList.saveClinicalTestType(testType1);
        ClinicalAnalysisLaboratory c= new ClinicalAnalysisLaboratory("12345","Chelsea Street","CheLab",
                "12345678912","1234567891");
        ClinicalAnalysisLaboratory c2= new ClinicalAnalysisLaboratory("12344","Norwich Street","NorLab",
                "12345678911","1234567899");
        c.saveTestTypeListToClinicalAnalysisLaboratory(testTypeList);
        this.getCompany().getClinicalAnalysisLaboratoryStore().saveClinicalAnalysisLaboratory(c);
        this.getCompany().getClinicalAnalysisLaboratoryStore().saveClinicalAnalysisLaboratory(c2);
        ClientDto cDto= new ClientDto("John",new Email("john@gmail.com"),"1234567890","1234567890123456",
                "1234567890","11/09/2002","Male","91337755612");
       Client c6=new Client(cDto);
        this.getCompany().getClientStore().saveClientBootstrap(c6);
    }

    // Extracted from https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static App singleton = null;
    public static App getInstance() {
        if(singleton == null)
        {
            synchronized(App.class)
            {
                singleton = new App();
            }
        }
        return singleton;
    }
}
