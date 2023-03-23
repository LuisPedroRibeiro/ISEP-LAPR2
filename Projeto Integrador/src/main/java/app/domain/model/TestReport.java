package app.domain.model;

import app.utils.Utils;
import org.apache.commons.lang3.StringUtils;

/**
 * Allows the System to create and work on a Test Report.
 *
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 */
public class TestReport {

    /**
     * Header of the Test Report (contains test number).
     */
    private final String header;
    /**
     * Text/Body of the Test Report.
     */
    private final String text;
    /**
     * E-mail of the Specialist Doctor that wrote the Test Report;
     */
    private final String specialistDoctorEmail;
    /**
     * Name of the Specialist Doctor that wrote the Test Report;
     */
    private final String specialistDoctorName;

    /**
     * Creates a Test Report using the test written by the Specialist Doctor.
     *
     * @param text Text/Body of the Test Report.
     * @param numberOfTheTest Number of the Test.
     * @param specialistDoctorName Name of the Specialist Doctor that wrote the Report.
     * @param specialistDoctorEmail E-mail of the Specialist Doctor that wrote the Report.
     */
    public TestReport(String text, String numberOfTheTest, String specialistDoctorName,
                      String specialistDoctorEmail){
        checkText(text);
        this.header = setHeader(numberOfTheTest);
        this.text = text;
        this.specialistDoctorName = specialistDoctorName;
        this.specialistDoctorEmail = specialistDoctorEmail;
    }

    /**
     * Allows the System to check if the text written by the Specialist Doctor is right, according to the acceptance
     * criteria.
     * Checks if the text is blank or if it has more than four hundred words.
     *
     * @param text Text/Body to be checked.
     */
    public void checkText(String text){
        if(StringUtils.isBlank(text)){
            throw new IllegalArgumentException("The Test Report can not be blank.");
        }
        if(Utils.numberOfWords(text) > 400){
            throw new IllegalArgumentException("The Test Report can not have more than 400 words.");
        }
    }

    /**
     * Allows the System to create an Header for the Test Report (can be used on a file to identify the test).
     *
     * @param numberOfTheTest Number of the Test that is getting a Test Report.
     * @return Header of the Test Report.
     */
    public String setHeader(String numberOfTheTest){
        return String.format("TEST REPORT | Test Code: %s", numberOfTheTest);
    }

    /**
     * Allows the System to obtain the Header of the Test Report.
     *
     * @return Header of the Test Report.
     */
    public String getHeader(){return this.header;}
    /**
     * Allows the System to obtain the Text/Body of the Test Report.
     *
     * @return Text/Body of the Test Report.
     */
    public String getText(){return this.text;}

    /**
     * Allows the System to get the Report in a format that contains the Header and Text.
     *
     * @return Test Report in a format (Header and Text).
     */
    public String toString() {
        return String.format("%s%n %s%n Written by: %s | E-mail: %s", this.header, this.text,
            this.specialistDoctorName, this.specialistDoctorEmail);
    }
}
