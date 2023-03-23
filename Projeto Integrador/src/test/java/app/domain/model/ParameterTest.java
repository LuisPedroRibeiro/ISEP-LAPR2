package app.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pedro Graça
 */
public class ParameterTest {

    @Test
    public void checkCodeRulesSuccess() {
        Parameter par = new Parameter("12345", "Blood", "Take a sample");
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesBlank() {
        Parameter par = new Parameter("", "Blood", "Take a sample");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesLess() {
        Parameter par = new Parameter("123", "Blood", "Take a sample");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCodeRulesGreater() {
        Parameter par = new Parameter("123456", "Blood", "Take a sample");
    }

    @Test
    public void checkNameRulesSuccess() {
        Parameter par = new Parameter("12345", "Blood", "Take a sample");
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNameRulesBlank() {
        Parameter par = new Parameter("12345", "", "Take a sample");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNameRulesGreat() {
        Parameter par = new Parameter("12345", "BloodBlood", "Take a sample");
    }

    @Test
    public void checkNameRules8chars() {
        Parameter par = new Parameter("12345", "Bloodies", "Take a sample");
        assertTrue(true);
    }

    @Test
    public void checkDescriptionRulesSuccess() {
        Parameter par = new Parameter("12345", "Blood", "Take a sample");
        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDescriptionRulesBlank() {
        Parameter par = new Parameter("12345", "Blood", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkDescriptionRulesGreater() {
        Parameter par = new Parameter("12345", "Blood", "TakeASampleTakeASampleTakeASample");
    }

    @Test
    public void checkDescriptionRules20Chars() {
        Parameter par = new Parameter("12345", "Blood", "Take a sample with b");
        assertTrue(true);
    }

    @Test
    public void getCode() {
        Parameter par = new Parameter("12345", "Blood", "Take a sample with b");
        String expected = "12345";

        String result = par.getCode();

        assertEquals(expected, result);
    }

    @Test
    public void getShortName() {
        Parameter par = new Parameter("12345", "Blood", "Take a sample");
        String expected = "Blood";

        String result = par.getShortName();

        assertEquals(expected, result);
    }

    @Test
    public void getDescription() {
        Parameter par = new Parameter("12345", "Blood", "Take a sample");
        String expected = "Take a sample";

        String result = par.getDescription();

        assertEquals(expected, result);
    }


    @Test
    public void getPc() {
        Parameter par = new Parameter("12345", "Blood", "Take a sample");
        ParameterCategory pc= par.getPc();

        assertNull(pc);
    }

    @Test
    public void addParameterCategoryToParameter() {
        ParameterCategory pc = new ParameterCategory("12345","Name");
        Parameter par = new Parameter("12345", "Blood", "Take a sample");

        par.addParameterCategoryToParameter(pc);

        ParameterCategory pc1 = par.getPc();

        assertEquals(pc,pc1);

    }
}