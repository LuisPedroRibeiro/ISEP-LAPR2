package app.domain.shared;

import auth.domain.model.Email;

import java.io.*;

public class EmailSMS {

    private EmailSMS(){
        //This method is empty because don't only need to be inicialized.
    }

    /**
     * String that allows to create a line division/break between sections of the E-mail.
     */
    private static final String LINE_FILL = String.format("--------------------------------------------------------------------------------------%n");

    /**
     * Allows the System to send an E-mail message (simulation, sent to a file) to a new User of the Application,
     * that contains information that he/she needs to log in to the Application (E-mail and Password to be used).
     *
     * @param email Email of the new User.
     * @param name Name of the User.
     * @param password Password of the User.
     * @throws FileNotFoundException Exception thrown the file is not found.
     */
    public static void sendRegistrationEmail(Email email, String name, String password) throws IOException {
        File file = new File("emailAndSMSMessages.txt");
        PrintWriter printWriter= new PrintWriter(new FileWriter(file, true));

        printWriter.printf("EMAIL%n%s Sent By: Many Labs%n Sent To: %s%n%s Message:%n%n  Mister/Miss %s, your " +
                "registration to our application was a success.%n  To do the login in the application, you must use " +
                "the following data:%n%n   - E-mail: %s%n   - Password: %s%n%n  The best regards from,%n  " +
                "Many Labs Team.%n%s", LINE_FILL, email.toString(), LINE_FILL, name, email, password, LINE_FILL);
        printWriter.close();
    }
    /**
     * Allows the System to send an E-mail message (simulation, sent to a file) to a new User of the Application,
     * that contains information that his/her test results can be seen by logging in the application.
     *
     * @param email Email of the new User.
     * @param name Name of the User.
     * @param nhsCode nhsCode belonging to a specific Test.
     * @throws IOException Exception thrown the file is not found.
     */
    public static void sendTestNotification(Email email, String name, String nhsCode) throws IOException {
        File file = new File("emailAndSMSMessages.txt");
        PrintWriter printWriter= new PrintWriter(new FileWriter(file, true));

        printWriter.printf("EMAIL%n%s Sent By: Many Labs%n Sent To: %s%n%s Message:%n%n  Mister/Miss %s," +
                "the test results for the test with NHS code %s are ready.%n  To check them please log in our application using your login information " +
                "and use%n  the check results option in the client area. %n%n  The best regards from,%n  " +
                "Many Labs Team.%n%s", LINE_FILL, email.toString(),LINE_FILL,name,nhsCode,LINE_FILL);
        printWriter.close();
    }
}
