package app.utils;

import app.mappers.dto.TestDto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Utils {

    private Utils(){
        //This method is empty because don't only need to be inicialized.
    }

    /**
     * String with a message to try again
     */
    private static final String TRY_AGAIN = "Invalid Format. Please try again.";

    /**
     * String with a message to cancel
     */
    private static final String CANCEL = "\n0 - Cancel";

    /**
     * String with a message to show that the List is Empty.
     */
    private static final String EMPTY = "  Empty List  ";

    /**
     * Array of natural numbers, from 0 to 9.
     */
    private static final int[] numbersArray = {0, 1, 2, 3, 4, 5 , 6, 7, 8, 9};

    /**
     * Array of all the alphabet letters.
     */
    private static final String[] lettersArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "z"};

    /**
     * Generates a random password that has got three capital letters, two digits (according to the acceptance
     * criteria), f. The password does not have any type of format, because
     * the position of the characters is always randomized.
     * Returns the generated password.
     *
     * @return Password with random format.
     */
    public static String randomPassword(){
        String capitalLetters = setCapitalLetters();
        String lowerCaseLetters = setLowerCaseLetters();
        String numbers = setNumbers();
        String normalPassword = setNormalPassword(capitalLetters, lowerCaseLetters, numbers);
        return setRandomPassword(normalPassword);
    }

    /**
     * Returns three capital letters that will make part of the randomized password.
     *
     * @return three random capital letters.
     */
    public static String setCapitalLetters(){
        int positionCapitalLetter1 = (int) (Math.random() * (lettersArray.length));
        int positionCapitalLetter2 = (int) (Math.random() * (lettersArray.length));
        int positionCapitalLetter3 = (int) (Math.random() * (lettersArray.length));
        String capitalLetter1 = lettersArray[positionCapitalLetter1].toUpperCase();
        String capitalLetter2 = lettersArray[positionCapitalLetter2].toUpperCase();
        String capitalLetter3 = lettersArray[positionCapitalLetter3].toUpperCase();
        return String.format("%s%s%s", capitalLetter1, capitalLetter2, capitalLetter3);
    }

    /**
     * Returns five lower case letters that will make part of the randomized password.
     *
     * @return five random lower case letters.
     */
    public static String setLowerCaseLetters(){
        int positionLowerCaseLetter1 = (int) (Math.random() * (lettersArray.length));
        int positionLowerCaseLetter2 = (int) (Math.random() * (lettersArray.length));
        int positionLowerCaseLetter3 = (int) (Math.random() * (lettersArray.length));
        int positionLowerCaseLetter4 = (int) (Math.random() * (lettersArray.length));
        int positionLowerCaseLetter5 = (int) (Math.random() * (lettersArray.length));
        String lowerCaseLetter1 = lettersArray[positionLowerCaseLetter1];
        String lowerCaseLetter2 = lettersArray[positionLowerCaseLetter2];
        String lowerCaseLetter3 = lettersArray[positionLowerCaseLetter3];
        String lowerCaseLetter4 = lettersArray[positionLowerCaseLetter4];
        String lowerCaseLetter5 = lettersArray[positionLowerCaseLetter5];
        return String.format("%s%s%s%s%s", lowerCaseLetter1, lowerCaseLetter2, lowerCaseLetter3, lowerCaseLetter4,
                lowerCaseLetter5);
    }

    /**
     * Returns two random natural numbers (contained in the interval [0;9]) that make part of the randomized password.
     *
     * @return two random natural numbers (contained in the interval [0;9]).
     */
    public static String setNumbers(){
        int positionNumber1 = (int) (Math.random() * (numbersArray.length));
        int positionNumber2 = (int) (Math.random() * (numbersArray.length));
        String number1 = Integer.toString(numbersArray[positionNumber1]);
        String number2 = Integer.toString(numbersArray[positionNumber2]);
        return String.format("%s%s", number1, number2);
    }

    /**
     * Returns a password in the format CClllllnn (C: Capital Letters; l: lower case letters; n: numbers).
     *
     * @param capitalLetters Random Capital Letters.
     * @param lowerCaseLetters Random Lower Case Letters.
     * @param numbers Random Natural Numbers (contained in the interval [0;9]).
     * @return Password in the format CClllllnn.
     */
    private static String setNormalPassword(String capitalLetters, String lowerCaseLetters, String numbers){
        return String.format("%s%s%s", capitalLetters, lowerCaseLetters, numbers);
    }

    /**
     * Randomizes the position of the characters of the password (in the format CClllllnn).
     *
     * @param normalPassword Password in the format CClllllnn.
     * @return Randomized password.
     */
    public static String setRandomPassword(String normalPassword){
        String[] passChar = normalPassword.split("", 10);
        String[] passwordArray = new String[10];

        int position;
        int counter = 0;
        ArrayList<Integer> positions = new ArrayList<>();
        position = (int) (Math.random() * (passChar.length));
        while(counter != 10){
            if(containsNumber(positions, position)){
                position = (int) (Math.random() * (passChar.length));
            }
            else{
                passwordArray[counter] = passChar[position];
                positions.add(position);
                counter ++;
            }
        }

        StringBuilder newPassword = new StringBuilder();

        for (String string : passwordArray) {
            newPassword.append(string);
        }

        return String.format("%s", newPassword.toString());
    }

    /**
     * Allows to verify if a character position of the password is already occupied.
     *
     * @param positions List that contains all of the character positions in use of the randomized password.
     * @param position Position to be checked.
     * @return Boolean value according to if the position is on the List or not.
     */
    public static boolean containsNumber(ArrayList<Integer> positions, int position){
        for(Integer p : positions){
            if(p == position){
                return true;
            }
        }
        return false;
    }

    /**
     * Function that returns the quantity of digits of a certain number.
     *
     * @param number the number whose digits will be counted
     * @return quantity of digits of a number
     */
    public static int quantityOfDigits(int number){
        int digits=0;
        while(number != 0){
            number = number/10;
            digits++;
        }
        return digits;
    }

    /**
     * Allows to verify if only exist digits in str String
     *
     * @param str String that will be tested
     * @return Boolean value, true if only exist digits in string, false if not
     */
    public static boolean onlyDigits(String str) {
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                p++;
        }
        return p == str.length();
    }

    /**
     * Method to get the Tax Identification Number from the console
     *
     * @return the Tax Identification Number
     */
    public static String getTaxIdentificationNumber() {
        boolean taxIdentificationNum;
        String taxIdentificationNumber;
        do {
            taxIdentificationNumber = Utils.readLineFromConsole("Tax Identification Number:");
            assert taxIdentificationNumber != null;
            taxIdentificationNum = onlyDigits(taxIdentificationNumber);
            if (!taxIdentificationNum)
                Utils.printLineToConsole(TRY_AGAIN);
        } while (!taxIdentificationNum);
        return taxIdentificationNumber;
    }

    /**
     * Obtains the initial letters from a String.
     * Returns a String containing the initials.
     *
     * @param string String to get Initials from.
     * @return Initials of the used String.
     */
    public static StringBuilder getStringInitials(String string){
        StringBuilder stringInitials;
        string = string.trim();
        stringInitials = new StringBuilder(String.valueOf(string.charAt(0)));
        for (int i = 0; i < string.length(); i++) {
            String x = String.valueOf(string.charAt(i));
            if(x.equals(" ")){
                stringInitials.append(string.charAt(i + 1));
            }
        }
        return stringInitials;
    }

    /**
     * Allows the system to write/print a line to the console.
     *
     * @param prompt String to be printed to the console.
     */
    public static void printLineToConsole(String prompt){
        System.out.println(prompt);
    }

    /**
     * Allows the system to write/print a line to the console.
     *
     * @param prompt Int to be printed to the console.
     */
    public static void printIntToConsole(int prompt){
        System.out.println(prompt);
    }

    /**
     * Allows the system to read a line from the console.
     *
     * @param prompt String that gives a description about what the user is inserting/writing on the console.
     * @return String that contains the information given by the user.
     */
    public static String readLineFromConsole(String prompt) {
        try {
            Utils.printLineToConsole("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Allows the system to read an Integer from the console.
     *
     * @param prompt String that gives a description about what the user is inserting/writing on the console.
     * @return Integer that contains (is equal to) the value given by the user.
     */
    public static int readIntegerFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                return  Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Allows the system to read a Double from the console.
     *
     * @param prompt String that gives a description about what the user is inserting/writing on the console.
     * @return Double that contains (is equal to) the value given by the user.
     */
    public static double readDoubleFromConsole(String prompt) {
        do {
            try {
                String input = readLineFromConsole(prompt);

                return Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Allows the system to read a Date from the console.
     *
     * @param prompt String that gives a description about what the user is inserting/writing on the console.
     * @return Date that is equal to the one given by the user.
     */
    public static Date readDateFromConsole(String prompt) {
        do {
            try {
                String strDate = readLineFromConsole(prompt);

                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                return df.parse(strDate);
            } catch (ParseException ex) {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

    /**
     * Allows the system to ask the user for a confirmation.
     *
     * @param message String that gives a description about what the user is inserting/writing on the console.
     * @return Boolean value relative to the confirmation (true = yes | false = no).
     */
    public static boolean confirm(String message) {
        String input;
        do {
            input = Utils.readLineFromConsole("\n" + message + "\n");
        } while (!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("n"));

        return input.equalsIgnoreCase("s");
    }

    /**
     * Allows the system to show a List of Objects and ask the user to select one of the objects.
     *
     * @param list List that contains the Objects.
     * @param header Header that gives a description about what the user is selecting.
     * @return Object that was selected by the user.
     */
    public static Object showAndSelectOne(List list, String header) {
        showList(list,header);
        return selectsObject(list);
    }

    /**
     * Allows the system to show a List and ask the user to select an index.
     *
     * @param list List that contains the information to be selected by the user.
     * @param header Header that gives a description about what the user is selecting.
     * @return Index that was selected by the user.
     */
    public static int showAndSelectIndex(List list, String header) {
        showList(list,header);
        return selectsIndex(list);
    }

    /**
     * Allows the system to show a List and ask the user to select an index.
     *
     * @param list List that contains the information to be selected by the user.
     * @param header Header that gives a description about what the user is selecting.
     * @return Index that was selected by the user.
     */
    public static int showAndSelectIndexForParameterAndCategories(List list, String header) {
        showListToParameterAndCategories(list,header);
        return selectsIndex(list);
    }

    /**
     * Allows the system to show a List of Tests without Report and ask the user to select an index.
     *
     * @param listOfTestsWithoutReport List that contains the information to be selected by the user.
     * @param header Header that gives a description about what the user is selecting.
     * @return Index that was selected by the user.
     */
    public static int showAndSelectIndexForTestsWithoutReport(List<TestDto> listOfTestsWithoutReport, String header) {
        showListOfTestsWithoutReport(listOfTestsWithoutReport,header);
        return selectsIndex(listOfTestsWithoutReport);
    }

    /**
     * Allows the system to show/print a List on the console.
     *
     * @param list List that contains information.
     * @param header Header that gives a description about what the user is selecting.
     */
    public static void showList(List list, String header) {
        Utils.printLineToConsole(header);

        int index = 0;
        for (Object o : list) {
            index++;

            Utils.printLineToConsole(index + ". " + o.toString());
        }
        Utils.printLineToConsole(CANCEL);
    }

    /**
     * Allows the system to show/print a List on the console.
     *
     * @param list List that contains information.
     * @param header Header that gives a description about what the user is selecting.
     */
    public static void showListToParameterAndCategories(List list,String header){
        Utils.printLineToConsole(header);

        int index = 0;
        for (Object o : list) {
            index++;

            Utils.printLineToConsole(index + ". " + o.toString());
        }
        if(list.isEmpty())
            Utils.printLineToConsole(EMPTY);
        Utils.printLineToConsole(CANCEL);

    }

    /**
     * Allows the system to show/print a List of Tests without Report on the console.
     *
     * @param listOfTestsWithoutReport List that contains information.
     * @param header Header that gives a description about what the user is selecting.
     */
    public static void showListOfTestsWithoutReport(List<TestDto> listOfTestsWithoutReport, String header) {
        Utils.printLineToConsole(header);

        int index = 0;
        for (TestDto testDto : listOfTestsWithoutReport) {
            index++;

            Utils.printLineToConsole(index + ". " + testDto.toStringTestWithoutReport());
        }

        Utils.printLineToConsole(CANCEL);
    }

    /**
     * Allows the system to show/print a List of Tests without Report on the console.
     *
     * @param listOfTestsWithoutSamples List that contains information.
     * @param header Header that gives a description about what the user is selecting.
     */
    public static void showListOfTestsWithoutSamples(List<TestDto> listOfTestsWithoutSamples, String header) {
        Utils.printLineToConsole(header);

        int index = 0;
        for (TestDto testDto : listOfTestsWithoutSamples) {
            index++;

            Utils.printLineToConsole(index + ". " + testDto.toStringWithoutSample());
        }

        Utils.printLineToConsole(CANCEL);
    }

    /**
     * Allows the system to permit the user to select a certain Object from a List.
     *
     * @param list List containing Objects.
     * @return Object that was selected by the user.
     */
    public static Object selectsObject(List list) {
        String input;
        int value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            value =  Integer.parseInt(input);
        } while (value < 0 || value > list.size());

        if (value == 0) {
            return null;
        } else {
            return list.get(value - 1);
        }
    }

    /**
     * Allows the system to permit the user to select an Index from a List.
     *
     * @param list List that contains the information to be selected by the user.
     * @return Integer representative of the Index selected by the user.
     */
    public static int selectsIndex(List list) {
        String input;
        int value;
        do {
            input = Utils.readLineFromConsole("Type your option: ");
            value =  Integer.parseInt(input);
        } while (value < 0 || value > list.size());

        return value - 1;
    }


    /**
     * Allows the system to know how many words have a String input.
     *
     * @param text Text that will be counted.
     * @return An integer of the number of words.
     */
    public static int numberOfWords(String text){
        int words = 1;
        for(int i = 0; i < text.length() - 1; i ++){
            String position = String.valueOf(text.charAt(i));
            String nextPosition = String.valueOf(text.charAt(i + 1));
            if(position.equals(" ") && !nextPosition.equals(".") && !nextPosition.equals(";") &&
                    !nextPosition.equals(",")  && !nextPosition.equals(" ")){
                words ++;
            }
        }
        return words;
    }

    /**
     * Allows the system to receive the current data and return a String in a formatted and specific way.
     *
     * @return A string of the current data.
     */
    public static String currentDate() {
        LocalDateTime instant = LocalDateTime.now();
        DateTimeFormatter formatInstant = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return instant.format(formatInstant);
    }
}
