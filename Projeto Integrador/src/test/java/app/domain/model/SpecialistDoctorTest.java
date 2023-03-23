package app.domain.model;

import app.domain.shared.Constants;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class SpecialistDoctorTest {

    @Test
    public void checkDoctorIndexNumberExceptionSuccess() {
        SpecialistDoctor specialistDoctor = new SpecialistDoctor("Test Person", "12345678998",
                new Email("testPersonFifteen@test.com"), "9431", Constants.ROLE_RECEP, "Test City",
                "999999");
        Assert.assertTrue(true);
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkDoctorIndexNumberExceptionIsBlank() {
        SpecialistDoctor specialistDoctor = new SpecialistDoctor("Test Person", "12345678653",
                new Email("testPersonSixteen@test.com"), "9433", Constants.ROLE_RECEP, "Test City",
                "");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkDoctorIndexNumberExceptionMoreThanSixDigits() {
        SpecialistDoctor specialistDoctor = new SpecialistDoctor("Test Person", "12345678076",
                new Email("testPersonSeventeen@test.com"), "9781", Constants.ROLE_RECEP, "Test City",
                "9123459");
    }

    @Test (expected = IllegalArgumentException.class)
    public void checkDoctorIndexNumberExceptionLessThanSixDigits() {
        SpecialistDoctor specialistDoctor = new SpecialistDoctor("Test Person", "12345678001",
                new Email("testPersonFourteen@test.com"), "1847", Constants.ROLE_RECEP, "Test City",
                "9123");
    }

    @Test
    public void testEqualsAllCategories() {
        SpecialistDoctor specialistDoctor1 = new SpecialistDoctor("Test Person One", "12345678901",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC, "Test City",
                "123456");

        SpecialistDoctor specialistDoctor2 = new SpecialistDoctor("Test Person One", "12345678901",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC, "Test City",
                "123456");

        boolean result = specialistDoctor1.equals(specialistDoctor2);

        assertTrue(result);
    }

    @Test
    public void testEqualsPhoneNumber() {
        SpecialistDoctor specialistDoctor1 = new SpecialistDoctor("Test Person One", "12345678901",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC, "Test City",
                "123459");

        SpecialistDoctor specialistDoctor2 = new SpecialistDoctor("Test Person Two", "12345678901",
                new Email("testPersonTwo@test.com"), "1233", Constants.ROLE_SPECDOC, "Test City",
                "123409");

        boolean result = specialistDoctor1.equals(specialistDoctor2);

        assertTrue(result);
    }

    @Test
    public void testEqualsEmail() {
        SpecialistDoctor specialistDoctor1 = new SpecialistDoctor("Test Person One", "12345678901",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC, "Test City",
                "123457");

        SpecialistDoctor specialistDoctor2 = new SpecialistDoctor("Test Person Two", "12345678902",
                new Email("testPersonOne@test.com"), "1233", Constants.ROLE_SPECDOC, "Test City",
                "123450");

        boolean result = specialistDoctor1.equals(specialistDoctor2);

        assertTrue(result);
    }

    @Test
    public void testEqualsDoctorIndexNumber() {
        SpecialistDoctor specialistDoctor1 = new SpecialistDoctor("Test Person One", "12345678901",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC, "Test City",
                "123451");

        SpecialistDoctor specialistDoctor2 = new SpecialistDoctor("Test Person Two", "12345678902",
                new Email("testPersonTwo@test.com"), "1233", Constants.ROLE_SPECDOC, "Test City",
                "123451");

        boolean result = specialistDoctor1.equals(specialistDoctor2);

        assertTrue(result);
    }

    @Test
    public void getDoctorIndexNumber() {
        SpecialistDoctor specialistDoctor1 = new SpecialistDoctor("Test Person One", "12345678901",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC, "Test City",
                "123456");

        String expected = "123456";
        String result = specialistDoctor1.getDoctorIndexNumber();

        assertEquals(expected, result);
    }

    @Test
    public void testToString() {
        SpecialistDoctor specialistDoctor1 = new SpecialistDoctor("Test Person One", "12345678901",
                new Email("testPersonOne@test.com"), "1234", Constants.ROLE_SPECDOC, "Test City",
                "123458");

        String expected = String.format("%n1. NAME AND ADDRESS %n - Name: %s %n - Address: %s %n%n2. CONTACTS %n " +
                        "- Phone Number: %s %n - E-mail: %s %n%n3. COMPANY INFORMATION %n - Role: %s %n " +
                        "- Employee ID: %s %n - SOC Code: %s %n - Doctor Index Number: %s %n",
                specialistDoctor1.getName(), specialistDoctor1.getAddress(), specialistDoctor1.getPhoneNumber(),
                specialistDoctor1.getEmail(), specialistDoctor1.getOrganizationRole(), specialistDoctor1.getEmployeeID(),
                specialistDoctor1.getSocCode(), specialistDoctor1.getDoctorIndexNumber());
        String result = specialistDoctor1.toString();

        assertEquals(expected, result);
    }
}
