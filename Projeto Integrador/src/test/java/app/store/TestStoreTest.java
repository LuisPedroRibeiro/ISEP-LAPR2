package app.store;

import app.domain.model.Client;
import app.domain.model.Sample;
import app.domain.model.TestReport;
import app.mappers.dto.ClientDto;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * This Class tests the TestStore class.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class TestStoreTest {

    @Test
    public void createTest() {
        TestStore testStore = new TestStore();
        app.domain.model.Test test1 = testStore.createTest("1234567890ee");
        app.domain.model.Test test2 = testStore.createTest("1234567890gg");
        assertTrue(true);
        assertNotEquals(test1,test2);
        assertEquals(test1,test1);
    }

    @Test
    public void validateTest() {
        TestStore testStore = new TestStore();
        app.domain.model.Test test1 = testStore.createTest("1234567890ee");

        boolean result= testStore.validateTest(test1);

        assertTrue(result);
    }

    @Test
    public void saveTest() {
        TestStore testStore = new TestStore();
        app.domain.model.Test test1 = testStore.createTest("1234567890ee");
        boolean result= testStore.saveTest(test1);
        assertTrue(result);
    }

    @Test(expected = NullPointerException.class)
    public void getTestsWithoutSamplesList() {
        TestStore testStore = new TestStore();
        app.domain.model.Test test1 = testStore.createTest("1234567890ee");
        testStore.saveTest(test1);
        List<app.domain.model.Test> result= testStore.getTestsWithoutSamplesList();
    }

    @Test
    public void getTestToBeSampledByIndex() {
    }

    @Test(expected = NullPointerException.class)
    public void saveTestWithSamples() {
        TestStore testStore = new TestStore();
        app.domain.model.Test test1 = testStore.createTest("1234567890ee");
        Sample sample = new Sample();
        testStore.saveTest(test1);
        test1.addSampleToTest(sample);
        testStore.saveTestWithSamples(test1);
    }

    @Test
    public void validatesTestWithSamples() {
        TestStore testStore = new TestStore();
        app.domain.model.Test test1 = testStore.createTest("1234567890ee");
        Sample sample = new Sample();
        testStore.saveTest(test1);
        test1.addSampleToTest(sample);
        assertTrue(testStore.validatesTestWithSamples(test1));

    }

    @Test
    public void getTestsWithResultListTest(){
        TestStore testStore = new TestStore();
        app.domain.model.Test test = new app.domain.model.Test("123456789012");
        app.domain.model.Test testTwo = new app.domain.model.Test("123456789011");
        app.domain.model.Test testThree = new app.domain.model.Test("123456789911");
        app.domain.model.Test testFour = new app.domain.model.Test("123456784411");
        app.domain.model.Test testFive = new app.domain.model.Test("123450000021");

        test.addTestResultDate();
        testTwo.addTestResultDate();
        testThree.addTestResultDate();
        testFour.addReportDate();
        testFive.addReportDate();
        testFive.validateTest();

        testStore.saveTest(test);
        testStore.saveTest(testTwo);
        testStore.saveTest(testThree);
        testStore.saveTest(testFour);
        testStore.saveTest(testFive);

        List<app.domain.model.Test> expected = new ArrayList<>();
        expected.add(test);
        expected.add(testTwo);
        expected.add(testThree);

        List<app.domain.model.Test> result = testStore.getTestWithResultList();

        Assert.assertEquals(result,expected);
    }

    @Test()
    public void getTestsWithReportList() {
        TestStore tt=new TestStore();
        app.domain.model.Test t=new app.domain.model.Test("123456789012");
        app.domain.model.Test t1=new app.domain.model.Test("123456789011");
        app.domain.model.Test t2=new app.domain.model.Test("123456789911");
        app.domain.model.Test t3=new app.domain.model.Test("123456709911");
        app.domain.model.Test t4=new app.domain.model.Test("123456709911");

        t.addReportDate();
        t1.addReportDate();
        t3.validateTest();
        t4.addReportDate();
        t4.validateTest();
        tt.saveTest(t);
        tt.saveTest(t1);
        tt.saveTest(t2);
        tt.saveTest(t3);
        List<app.domain.model.Test> expected=new ArrayList<>();
        expected.add(t);
        expected.add(t1);

        List<app.domain.model.Test> result=tt.getTestsWithReportList();

        Assert.assertEquals(result,expected);
    }

    @Test
    public void getTestByNhsCode() {
        TestStore tt=new TestStore();
        app.domain.model.Test expected=new app.domain.model.Test("123456789012");

        tt.saveTest(expected);

        app.domain.model.Test result=tt.getTestByNhsCode("123456789012");
        app.domain.model.Test result1=tt.getTestByNhsCode("123456789000");
        Assert.assertEquals(result,expected);
        Assert.assertNull(result1);
    }

    @Test
    public void saveTestReport() {
        TestStore testStore = new TestStore();
        app.domain.model.Test test = testStore.createTest("1234567890ee");
        testStore.saveTest(test);

        TestReport testReport = new TestReport("This is a simulation of a Test Report.",
                "000000000000", "Specialist Doctor", "sd@test.com");
        assertTrue(testStore.saveTestReport(test, testReport));

        app.domain.model.Test testTwo = testStore.createTest("1234567890ff");
        testStore.saveTest(testTwo);

        assertFalse(testStore.saveTestReport(testTwo, null));
    }

    @Test
    public void addTestToClient() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        TestStore testStore = new TestStore();
        app.domain.model.Test test1 = testStore.createTest("1234567890ee");
        testStore.saveTest(test1);
        assertTrue(testStore.addTestToClient(client,test1));
    }

    @Test
    public void nextCode() {
        long num = 11;
        TestStore testStore = new TestStore();
        String expected = "000000000011";

        String result=testStore.nextCode(num);

        assertEquals(expected,result);
    }

    @Test
    public void getStore() {
        TestStore testStore = new TestStore();
        app.domain.model.Test test1 = testStore.createTest("1234567890ee");
        testStore.saveTest(test1);

        List<app.domain.model.Test> list= testStore.getStore();

        assertTrue(list.contains(test1));
    }

    @Test
    public void getTestByBarcode() {
    }

    @Test
    public void testContainsNhsCode(){
        String existentNhsCode = "1234567890ee";
        String nonexistentNhsCode = "000000000000";
        TestStore testStore = new TestStore();

        app.domain.model.Test test = testStore.createTest(existentNhsCode);
        testStore.saveTest(test);

        app.domain.model.Test testTwo = testStore.createTest("1234567890dd");
        testStore.saveTest(testTwo);

        assertTrue(testStore.containsNhsCode(existentNhsCode));
        assertFalse(testStore.containsNhsCode(nonexistentNhsCode));
    }
}