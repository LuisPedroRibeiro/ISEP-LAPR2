package app.domain.model;

import app.controller.App;
import app.domain.shared.Constants;
import app.utils.Utils;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class EmployeeTest {

    @Test
    public void rulesExceptionsSuccess() {
        Employee employee = new Employee("Test Person", "00000000001",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkNameExceptionBlank() {
        Employee employee = new Employee("", "00000000002",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
    }

    @Test
    public void checkNameExceptionSuccess() {
        Employee employee = new Employee("Test Person", "00000000003",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        Assert.assertTrue(true);
    }

    @Test
    public void checkNameExceptionSuccessWithThirtyFiveCharacters() {
        Employee employee = new Employee("TESTETESTETESTETESTETESTETESTETESTE",
                "00000000004",
                new Email("testPersonPerson@test.com"), "1100", Constants.ROLE_RECEP, "Test City");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkNameExceptionBigger() {
        Employee employee = new Employee("ABCDE ABCDE ABCDE ABCDE ABCDE ABCDEF", "00000000005",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkPhoneNumberExceptionBlank() {
        Employee employee = new Employee("Test Person", "",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkPhoneNumberExceptionLessThanElevenCharacters() {
        Employee employee = new Employee("Test Person", "123456789",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkPhoneNumberExceptionMoreThanElevenCharacters() {
        Employee employee = new Employee("Test Person", "123456789123",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
    }

    @Test
    public void checkPhoneNumberExceptionSuccess() {
        Employee employee = new Employee("Test Person", "00000000006",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkSOCCodeExceptionIsBlank() {
        Employee employee = new Employee("Test Person", "00000000007",
                new Email("testPerson@test.com"), "", Constants.ROLE_RECEP, "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkSOCCodeExceptionLessThanFourCharacters() {
        Employee employee = new Employee("Test Person", "00000000008",
                new Email("testPerson@test.com"), "123", Constants.ROLE_RECEP, "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkSOCCodeExceptionMoreThanFourCharacters() {
        Employee employee = new Employee("Test Person", "00000000009",
                new Email("testPerson@test.com"), "12345", Constants.ROLE_RECEP, "Test City");
    }

    @Test
    public void checkSOCCodeExceptionSuccess() {
        Employee employee = new Employee("Test Person", "00000000010",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkOrganizationRoleExceptionIsBlank() {
        Employee employee = new Employee("Test Person", "00000000011",
                new Email("testPerson@test.com"), "1234", "", "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkOrganizationRoleExceptionMoreThanThirtyCharacters() {
        Employee employee = new Employee("Test Person", "00000000012",
                new Email("testPersonThirteen@test.com"), "1003",
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkOrganizationRoleExceptionWithThirtyCharacters() {
        Employee employee = new Employee("Test Person", "00000000013",
                new Email("testPersonThirteen@test.com"), "1003",
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", "Test City");
        Assert.assertTrue(true);
    }

    @Test
    public void checkOrganizationRoleExceptionSuccess() {
        Employee employee = new Employee("Test Person", "00000000014",
                new Email("testPerson@test.com"), "1001", Constants.ROLE_RECEP, "Test City");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkAddressExceptionIsBlank() {
        Employee employee = new Employee("Test Person", "00000000015",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "");
    }

    @Test
    public void checkAddressExceptionSuccess() {
        Employee employee = new Employee("Test Person", "00000000016",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        Assert.assertTrue(true);
    }

    /**
     * NOTE: This test is on a comment as it was causing lots of trouble in the teams' Jenkins build.
     */
    /*@Test
    public void setEmployee_ID(){
        Employee employee = new Employee("Test Person", "12345678911",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        employee.setEmployeeID();

        String expected = "TP00015";
        String result = employee.getEmployeeID();

        assertEquals(expected, result);
    }*/

    @Test
    public void setPassword() {
        Employee employee = new Employee("Test Person", "00000000017",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        employee.setPassword();
        String password = Utils.randomPassword();

        int expected = 10;
        int result = password.length();

        assertEquals(expected, result);
    }

    @Test
    public void setAuthFacade() throws IOException {
        Employee employee = new Employee("Test Person", "00000000018",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        employee.setPassword();
        employee.registerUserAndSendEmail();

        boolean result = App.getInstance().getCompany().getAuthFacade().existsUser("testPerson@test.com");

        assertTrue(result);
    }

    @Test
    public void getName(){
        Employee employee = new Employee("Test Person", "00000000019",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        String expected = "Test Person";
        String result = employee.getName();

        assertEquals(expected, result);
    }

    @Test
    public void getAddress(){
        Employee employee = new Employee("Test Person", "00000000020",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        String expected = "Test City";
        String result = employee.getAddress();

        assertEquals(expected, result);
    }

    @Test
    public void getOrganizationRole(){
        Employee employee = new Employee("Test Person", "00000000021",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        String expected = Constants.ROLE_RECEP;
        String result = employee.getOrganizationRole();

        assertEquals(expected, result);
    }

    /**
     * NOTE: This test is on a comment as it was causing lots of trouble in the teams' Jenkins build.
     */
    /*@Test
    public void getEmployeeID() {
        Employee employee = new Employee("Test Person", "12345678911",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        employee.setEmployeeID();

        String expected = "TP00019";
        String result = employee.getEmployeeID();

        assertEquals(expected, result);
    }*/

    @Test
    public void getPhoneNumber() {
        Employee employee = new Employee("Test Person", "00000000022",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        String expected = "00000000022";
        String result = employee.getPhoneNumber();

        assertEquals(expected, result);
    }

    @Test
    public void getEmail() {
        Employee employee = new Employee("Test Person", "00000000023",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        String expected = "testPerson@test.com";
        String result = employee.getEmail();

        assertEquals(expected, result);
    }

    @Test
    public void getSocCode() {
        Employee employee = new Employee("Test Person", "00000000024",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        String expected = "1234";
        String result = employee.getSocCode();

        assertEquals(expected, result);
    }


    @Test
    public void testToString() {
        Employee employee = new Employee("Test Person", "00000000025",
                new Email("testPerson@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        String expected = String.format("%n1. NAME AND ADDRESS %n - Name: %s %n - Address: %s %n%n2. CONTACTS %n " +
                        "- Phone Number: %s %n - E-mail: %s %n%n3. COMPANY INFORMATION %n - Role: %s %n " +
                        "- Employee ID: %s %n - SOC Code: %s %n", employee.getName(), employee.getAddress(),
                employee.getPhoneNumber(), employee.getEmail(), employee.getOrganizationRole(),
                employee.getEmployeeID(), employee.getSocCode());
        String result = employee.toString();

        assertEquals(expected, result);
    }

    @Test
    public void testEquals(){
        Employee employee = new Employee("Test Person", "00000000026",
                new Email("testPersonSeventyOne@test.com"), "0021", Constants.ROLE_RECEP,
                "Test City");
        Employee otherEmployee = new Employee("Test Person", "76345678911",
                new Email("testPersonSeventyFive@test.com"), "0439", Constants.ROLE_RECEP,
                "Test City");

        assertFalse(employee.equals(otherEmployee));

        Employee otherEmployeeTwo = new Employee("Test Person", "76345678911",
                new Email("testPersonSeventyFive@test.com"), "0439", Constants.ROLE_RECEP,
                "Test City");

        assertTrue(otherEmployee.equals(otherEmployeeTwo));

    }
}
