package app.controller;

import app.domain.shared.Constants;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class RegisterNewEmployeeControllerTest {

    @Test
    public void registerNewEmployeeWithPhoneNumber() {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        boolean result = controller.registerNewEmployee("Test Person One", "12345678911",
                "testPersonOne@test.com", "1234", Constants.ROLE_RECEP, "Test City");

        assertTrue(result);
    }

    @Test
    public void testRegisterNewEmployeeSpecDocWithPhoneNumber() {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        boolean result = controller.registerNewEmployee("Test Person Two", "12345678923",
                "testPersonTwo@test.com", "1202", Constants.ROLE_SPECDOC, "Test City",
                "111111");

        assertTrue(result);
    }

    @Test
    public void saveEmployeeSuccess() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person One", "12345678907",
                "testPersonFinal@test.com", "1200", Constants.ROLE_RECEP, "Test City");

        assertTrue(controller.saveEmployee());
    }

    @Test
    public void saveEmployeeFailure() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person One", "12345678956",
                "testPersonFour@test.com", "3458", Constants.ROLE_RECEP, "Test City");

        assertTrue(controller.saveEmployee());
    }

    @Test
    public void getEmployeeStore() {
    }

    @Test
    public void containsPhoneNumberTrue() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person One", "12345678901",
                "testPersonOne@test.com", "1234", Constants.ROLE_RECEP, "Test City");

        assertTrue(controller.saveEmployee());

        String phoneNumber = "12345678901";

        assertTrue(controller.containsPhoneNumber(phoneNumber));
    }

    @Test
    public void containsPhoneNumberFalse() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person Ninety", "12345678924",
                "testPersonNinety@test.com", "1962", Constants.ROLE_RECEP, "Test City");

        assertTrue(controller.saveEmployee());

        String phoneNumber = "12345678900";

        assertFalse(controller.containsPhoneNumber(phoneNumber));
    }

    @Test
    public void containsEmailTrue() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person Nine", "12345678709",
                "testPersonNine@test.com", "1296", Constants.ROLE_RECEP, "Test City");

        assertTrue(controller.saveEmployee());

        String email = "testPersonNine@test.com";

        assertTrue(controller.containsEmail(email));
    }

    @Test
    public void containsEmailFalse() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person Twelve", "12345678943",
                "testPersonTwelve@test.com", "1496", Constants.ROLE_RECEP, "Test City");

        assertTrue(controller.saveEmployee());

        String email = "testPersonTwo@test.com";

        assertFalse(controller.containsEmail(email));
    }

    @Test
    public void containsSocCodeTrue() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person One", "12345678908",
                "testPersonTen@test.com", "1209", Constants.ROLE_RECEP, "Test City");

        assertTrue(controller.saveEmployee());

        String socCode = "1234";

        assertTrue(controller.containsSocCode(socCode));
    }

    @Test
    public void containsSocCodeFalse() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person One", "12345678909",
                "testPersonEleven@test.com", "1098", Constants.ROLE_RECEP, "Test City");

        assertTrue(controller.saveEmployee());

        String socCode = "1235";

        assertFalse(controller.containsSocCode(socCode));
    }

    @Test
    public void containsDoctorIndexNumberTrue() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person One", "12345678976",
                "testPersonSeven@test.com", "1230", Constants.ROLE_RECEP, "Test City",
                "123456");

        assertTrue(controller.saveEmployee());

        String doctorIndexNumber = "123456";

        assertTrue(controller.containsDoctorIndexNumber(doctorIndexNumber));
    }

    @Test
    public void containsDoctorIndexNumberFalse() throws IOException {
        RegisterNewEmployeeController controller = new RegisterNewEmployeeController();
        controller.registerNewEmployee("Test Person One", "12345678897",
                "testPersonTwenty@test.com", "1971", Constants.ROLE_RECEP, "Test City",
                "123478");

        assertTrue(controller.saveEmployee());

        String doctorIndexNumber = "123670";

        assertFalse(controller.containsDoctorIndexNumber(doctorIndexNumber));
    }
}
