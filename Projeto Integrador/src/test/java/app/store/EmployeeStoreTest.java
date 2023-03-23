package app.store;

import app.domain.model.Employee;
import app.domain.model.SpecialistDoctor;
import app.domain.shared.Constants;
import auth.domain.model.Email;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class EmployeeStoreTest {


    @Test
    public void registerNewEmployeeWithPhoneNumber() {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
        Employee employeeTwo = employeeStore.registerNewEmployee("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        assertTrue(employeeOne.equals(employeeTwo));

        Employee employeeThree = employeeStore.registerNewEmployee("Test Person Two", "12345678910",
                new Email("testPersonTwo@test.com"), "1235", Constants.ROLE_RECEP, "Test City");

        assertFalse(employeeOne.equals(employeeThree));
    }

    @Test
    public void testRegisterNewEmployeeSpecialistDoctorWithPhoneNumber() {
        EmployeeStore employeeStore = new EmployeeStore();

        SpecialistDoctor specialistDoctorOne = new SpecialistDoctor("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC,
                "Test City", "111111");
        SpecialistDoctor specialistDoctorTwo = new SpecialistDoctor("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC,
                "Test City", "111111");

        assertTrue(specialistDoctorOne.equals(specialistDoctorTwo));

        SpecialistDoctor specialistDoctorThree = new SpecialistDoctor("Test Person Two", "12345678910",
                new Email("testPersonTwo@test.com"), "1235", Constants.ROLE_SPECDOC,
                "Test City", "111128");

        assertFalse(specialistDoctorOne.equals(specialistDoctorThree));
    }

    @Test
    public void saveEmployeeSuccess() throws IOException {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        boolean result = employeeStore.saveEmployee(employeeOne);

        assertTrue(result);
    }

    @Test (expected = IllegalArgumentException.class)
    public void saveEmployeeBadName() {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void saveEmployeeBadEmail() {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("", "12345678911",
                new Email(""), "1234", Constants.ROLE_RECEP, "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void saveEmployeeBadAddress() {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "");
    }

    @Test (expected = IllegalArgumentException.class)
    public void saveEmployeeBadSOCCode() {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("", "12345678911",
                new Email("testPersonOne@test.com"), "123456", Constants.ROLE_RECEP, "Test City");
    }

    @Test (expected = IllegalArgumentException.class)
    public void saveEmployeeBadOrganizationRole() {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("", "12345678911",
                new Email("testPersonOne@test.com"), "1234", "", "Test City");
    }

    @Test
    public void validateEmployeeNull() {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        assertTrue(employeeStore.validateEmployee(employeeOne));

        Employee employeeTwo = null;

        assertFalse(employeeStore.validateEmployee(employeeTwo));
    }

    @Test (expected = IllegalArgumentException.class)
    public void validateEmployeeException() throws IOException {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("", "",
                new Email(""), "", "", "");

        employeeStore.saveEmployee(employeeOne);
    }

    @Test
    public void getEmployeeList() {
    }

    @Test
    public void containsPhoneNumber() throws IOException {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        employeeStore.saveEmployee(employeeOne);

        Employee employeeTwo = employeeStore.registerNewEmployee("Test Person Two", "12345678911",
                new Email("testPersonTwo@test.com"), "1233", Constants.ROLE_RECEP, "Test City");

        assertTrue(employeeStore.containsPhoneNumber(employeeTwo.getPhoneNumber()));
    }

    @Test
    public void containsEmail() throws IOException {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        employeeStore.saveEmployee(employeeOne);

        Employee employeeTwo = employeeStore.registerNewEmployee("Test Person Two", "12345678910",
                new Email("testPersonOne@test.com"), "1233", Constants.ROLE_RECEP, "Test City");

        assertTrue(employeeStore.containsEmail(employeeTwo.getEmail()));
    }

    @Test
    public void containsSocCode() throws IOException {
        EmployeeStore employeeStore = new EmployeeStore();

        Employee employeeOne = new Employee("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        employeeStore.saveEmployee(employeeOne);

        Employee employeeTwo = employeeStore.registerNewEmployee("Test Person Two", "12345678910",
                new Email("testPersonTwo@test.com"), "1234", Constants.ROLE_RECEP, "Test City");

        assertTrue(employeeStore.containsSocCode(employeeTwo.getSocCode()));
    }


    @Test
    public void containsDoctorIndexNumber() throws IOException {
        EmployeeStore employeeStore = new EmployeeStore();

        SpecialistDoctor specialistDoctorOne = new SpecialistDoctor("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC,
                "Test City", "111111");

        employeeStore.saveEmployee(specialistDoctorOne);

        SpecialistDoctor specialistDoctorTwo = new SpecialistDoctor("Test Person One", "12345678911",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC,
                "Test City", "111111");

        assertTrue(employeeStore.containsDoctorIndexNumber(specialistDoctorTwo.getDoctorIndexNumber()));
    }
}
