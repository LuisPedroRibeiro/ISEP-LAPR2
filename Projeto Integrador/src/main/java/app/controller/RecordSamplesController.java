package app.controller;

import app.domain.model.Company;
import app.domain.model.Sample;
import app.domain.model.Test;
import app.mappers.TestMapper;
import app.mappers.dto.TestDto;
import app.store.TestStore;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;
import java.util.List;

/**
 * This class allows the communication between RecordSamplesUI and all the domain model.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class RecordSamplesController {

    private final Company company;

    private final TestMapper mapper;

    private final TestStore testStore;

    private Test test;

    private Sample sample;

    /**
     * Allows the initialization of an RecordSamplesController with the company returned from
     * "App.getInstance().getCompany()."
     */
    public RecordSamplesController() throws OutputException, BarcodeException, IOException {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructor that allows the initialization of Company with Sample List and Clinical Analysis
     * Laboratory with a null value.
     *
     * @param company Company Class
     */
    public RecordSamplesController(Company company) {
        this.company = company;
        this.testStore = new TestStore();
        this.mapper = new TestMapper();
    }

    /**
     * The method that allows the return of Test Store, using the Company class.
     *
     * @return The Test Store.
     */
    public TestStore getTestStore(){
        return this.company.getTestStore();
    }

    /**
     * The method that allows the return of Test to be Sampled List by the Test Store, using the Company class.
     *
     * @return A list of Tests to be Sampled List.
     */
    public List<Test> getTestToBeSampledList(){
        return this.company.getTestStore().getTestsWithoutSamplesList();
    }

    /**
     * The method that allows the return of Test Mapper List, that is a copy of Test List.
     *
     * @return A list of Tests to be sampled.
     */
    public List<TestDto> listDto(){
        return this.mapper.toDTOForSample(getTestToBeSampledList());
    }

    /**
     * The method that allows the return of a Test without Sample, selected by Index.
     *
     * @param index An integer selected by the Medical Lab Technician.
     * @return A Test selected by Index.
     */
    public void getTestToBeSampledByIndex(int index){
        this.test=this.company.getTestStore().getTestToBeSampledByIndex(index);
    }

    /**
     * The method that allows the set of Sample Date to test.
     */
    public void setCurrentDate(){
        this.test.setSampleDate();
    }

    /**
     * The method that allows the creation of a Sample.
     *
     * @throws OutputException Exception because of the output given by barcode.
     * @throws BarcodeException Exception that needs to be throw because of barbecue library
     * @throws IOException Exception because of the input to create a barcode.
     * @throws ClassNotFoundException Exception to be thrown if the Class is not found.
     * @throws InstantiationException Exception to be throw if the Constructor is not available.
     * @throws IllegalAccessException Exception to be throw if the Method does not have access to the wanted Class.
     */
    public void createSample() throws OutputException, BarcodeException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        this.sample = new Sample();
        this.sample.getBarcode();
        this.test.addSampleToTest(sample);
    }

    /**
     * The method that allows the save of a Test with samples in the Test Store.
     *
     * @return a boolean, true if the save as done, false if don't.
     */
    public boolean saveTestWithSamples(){
        return this.testStore.saveTestWithSamples(test);
    }
}

