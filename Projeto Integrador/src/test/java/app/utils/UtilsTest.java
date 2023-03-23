package app.utils;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Luís Ribeiro <1201184@isep.ipp.pt>
 * @author Pedro Graça <1201188@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 * @author André Soares <1201314@isep.ipp.pt>
 */

public class UtilsTest {

    @Test
    public void containsNumber() {
        ArrayList<Integer> lInt=new ArrayList<>();
        lInt.add(1);
        lInt.add(2);
        boolean b=Utils.containsNumber(lInt,1);
        boolean b1=Utils.containsNumber(lInt,10);
        Assert.assertTrue(b);
        Assert.assertFalse(b1);
    }

    @Test
    public void quantityOfDigits() {
        int n1=0;
        int result=Utils.quantityOfDigits(n1);
        int expected=0;
        int n2=1;
        int result1=Utils.quantityOfDigits(n2);
        int expected1=1;
        int n3=-1;
        int result2=Utils.quantityOfDigits(n3);
        int expected2=1;
        int n4=1000;
        int result3=Utils.quantityOfDigits(n4);
        int expected3=4;

        Assert.assertEquals(result,expected);
        Assert.assertEquals(result1,expected1);
        Assert.assertEquals(result2,expected2);
        Assert.assertEquals(result3,expected3);
    }

    @Test
    public void getStringInitials() {
        String s="Andre Francisco";
        String result=Utils.getStringInitials(s).toString();
        String expected="AF";
        Assert.assertEquals(result,expected);
    }

    @Test
    public void numberOfWords(){
        int expected = 2;
        int result = Utils.numberOfWords("Test Test");
        int result2 = Utils.numberOfWords("Test Test Test");
        Assert.assertEquals(result,expected);
        Assert.assertNotEquals(result2,expected);
    }

    @Test
    public void numberOfWordsWithOneWord(){
        String text = "Word.";

        int expected = 1;
        int result = Utils.numberOfWords(text);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void numberOfWordsWithMoreThanOneWord(){
        String text = "This is a text that is being used to calculate the number of words that are present in this " +
                "String.";

        int expected = 20;
        int result = Utils.numberOfWords(text);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void numberOfWordsWithSpaceBetweenWordAndFinalPoint(){
        String text = "This is a text that is being used to calculate the number of words that are present in this " +
                "String .";

        int expected = 20;
        int result = Utils.numberOfWords(text);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void numberOfWordsWithSpaceBetweenWordAndSemicolon(){
        String text = "This is a text that is being used to calculate the number of words that are present in this " +
                "String ; so lets proceed to the test.";

        int expected = 26;
        int result = Utils.numberOfWords(text);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void numberOfWordsWithSpaceBetweenWordAndColon(){
        String text = "This is a text that is being used to calculate the number of words that are present in this " +
                "String , so lets proceed to the test.";
        int expected = 26;
        int result = Utils.numberOfWords(text);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void onlyDigitsTrue() {
        String str="12345";
        boolean result = Utils.onlyDigits(str);

        Assert.assertTrue(result);
    }

    @Test
    public void onlyDigitsFalse() {
        String str="1234e";
        boolean result = Utils.onlyDigits(str);

        Assert.assertFalse(result);
    }
}