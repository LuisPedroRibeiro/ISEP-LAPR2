package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class contains all the Tests that were made on the code made for the class TestReport.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class TestReportTest {

    @Test
    public void checkTextSuccess() {
        String text = "This is a Test Report simulation, intended for a Test of the Code.";
        TestReport testReport = new TestReport(text, "000000000001", "Spec Doc", "sd@test.com");
        Assert.assertTrue(true);
    }

    @Test
    public void checkTextSuccessWith400Words() {
        String text = "";
        for(int i = 1; i <= 400; i ++){
            if(i == 400){
                text = String.format("%sword.", text);
            }
            else{
                text = String.format("%sword ", text);
            }

        }
        TestReport testReport = new TestReport(text, "000000000002", "Spec Doc", "sd2@test.com");
        Assert.assertTrue(true);
    }

    @Test
    public void checkTextSuccessWithOneWord() {
        String text = "Word.";
        TestReport testReport = new TestReport(text, "000000000003", "Spec Doc", "sd3@test.com");
        Assert.assertTrue(true);
    }


    @Test (expected = IllegalArgumentException.class)
    public void checkTextFailureBlank() {
        String text = "";
        TestReport testReport = new TestReport(text, "000000000004", "Spec Doc", "sd4@test.com");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkTextFailureMoreThan400Words() {
        String text = "";
        for(int i = 1; i <= 401; i ++){
            if(i == 401){
                text = String.format("%sword.", text);
            }
            else{
                text = String.format("%sword ", text);
            }

        }
        TestReport testReport = new TestReport(text, "000000000005", "Spec Doc", "sd5@test.com");
    }

    @Test
    public void setHeader() {
        String text = "This is a Test Report simulation, intended for a Test of the Code.";
        String numberOfTheTest = "000000000006";

        TestReport testReport = new TestReport(text, numberOfTheTest, "Spec Doc", "sd6@test.com");

        String expected = "TEST REPORT | Test Code: 000000000006";
        String result = testReport.setHeader(numberOfTheTest);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getHeader() {
        String text = "This is a Test Report simulation, intended for a Test of the Code.";
        String numberOfTheTest = "000000000007";

        TestReport testReport = new TestReport(text, numberOfTheTest, "Spec Doc", "sd7@test.com");

        String expected = "TEST REPORT | Test Code: 000000000007";
        String result = testReport.getHeader();

        Assert.assertEquals(expected, result);
    }

    @Test
    public void getText() {
        String text = "This is a Test Report simulation, intended for a Test of the Code.";
        String numberOfTheTest = "000000000008";

        TestReport testReport = new TestReport(text, numberOfTheTest, "Spec Doc", "sd8@test.com");

        String result = testReport.getText();

        Assert.assertEquals(text, result);
    }

    @Test
    public void testToString() {
        String text = "This is a Test Report simulation, intended for a Test of the Code.";
        String numberOfTheTest = "000000000009";

        String name = "Specialist Doctor";
        String email = "specialistDoctor@test.com";

        TestReport testReport = new TestReport(text, numberOfTheTest, name, email);

        String expected = String.format("%s%n %s%n Written by: %s | E-mail: %s", testReport.getHeader(), text,
                name, email);
        String result = testReport.toString();

        Assert.assertEquals(expected, result);
    }
}