package app.domain.model;

import app.mappers.dto.ClientDto;
import app.utils.Utils;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */

public class ClientTest {


    @Test(expected = NullPointerException.class)
    public void clientNull(){
        Client client = new Client(null);
    }

    @Test
    public void getEmail() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        Email expected = new Email("pedro@gmail.com");

        Email result = client.getEmail();

        assertEquals(expected, result);
    }

    @Test
    public void getPhoneNumber() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        String expected = "91337755612";

        String result = client.getPhoneNumber();

        assertEquals(expected, result);
    }

    @Test
    public void checkNameRulesSuccess() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }
    @Test
    public void checkNameRulesSuccess35chars() {
        ClientDto clientDto = new ClientDto("abcdefghijklmnopqrstuvwxyzPedroGege", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNameRulesBlank() {
        ClientDto clientDto = new ClientDto("", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNameRulesGreater() {
        ClientDto clientDto = new ClientDto("PedroHenriqueMacielGraçaTemDeTerMaisDeTrintaECincoSenãoNãFunciona", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test
    public void checkTaxIdentificationNumberRulesSuccess() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTaxIdentificationRulesBlank() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkTaxIdentificationRulesEquals0() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "0", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTaxIdentificationRulesLessThan() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "12345", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTaxIdentificationRulesGreater() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "11234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkTaxIdentificationRulesNegative() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "-123456789", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }


    @Test
    public void checkCitizenCardNumberRulesSuccess() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberRulesBlank() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberRulesEquas0() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "0", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberRulesLessThan() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "123456789012345", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberRulesGreater() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "12345678901234561", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCitizenCardNumberRulesNegative() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "-123456789012345", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test
    public void checkNhsNumberRulesSuccess() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNhsNumberRulesBlank() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkNhsNumberRulesEquals() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "0", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNhsNumberRulesLessThan() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNhsNumberRulesGreater() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "12345678901", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNhsNumberRulesNegative() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "-123456789", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
    }


    @Test
    public void checkGenderRulesSuccessMale() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }

    @Test
    public void checkGenderRulesSuccessFemale() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Female", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }

    @Test
    public void checkGenderRulesSuccessOmission() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkGenderRulesError() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "No", "91337755612");
        Client client = new Client(clientDto);
    }

    @Test
    public void checkPhoneNumberRulesSuccess() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        assertTrue(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPhoneNumberRulesBlank() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "");
        Client client = new Client(clientDto);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkNhsNumberRulesEquals0() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "0");
        Client client = new Client(clientDto);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkPhoneNumberRulesLessThan() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "913377556");
        Client client = new Client(clientDto);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkPhoneNumberRulesGreater() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "9133775566666");
        Client client = new Client(clientDto);
    }
    @Test(expected = IllegalArgumentException.class)
    public void checkPhoneNumberRulesNegative() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "-9133775561");
        Client client = new Client(clientDto);
    }

    @Test
    public void setPassword() {
            ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
            Client client = new Client(clientDto);
            int expected= 10;

            String result = Utils.randomPassword();

            Assert.assertEquals(expected,result.length());


    }

    @Test
    public void addUserAndSendEmail() throws IOException {
        /*ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        client.setPassword();
        client.addUserAndSendEmail();

        boolean result = App.getInstance().getCompany().getAuthFacade().existsUser(client.getEmail().toString());

        assertTrue(result);
*/

    }

    @Test
    public void testEquals() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Pedro", new Email("pedro2@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "91337755632");
        Client client2 = new Client(clientDto2);
        Object o = new Object();
        assertNotEquals(client, o);
        Assert.assertFalse(false);
        assertEquals(client, client);
        assertEquals(client2, client2);
        assertNotEquals(client, client2);

    }
    @Test
    public void testEqualsDifferentName(){
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Peter", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002","Male", "91337755612");
        Client client2 = new Client(clientDto2);
        assertNotEquals(client,client2);
    }
    @Test
    public void testEqualsDifferentEmail(){
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Pedro", new Email("pedro1@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002","Male", "91337755612");
        Client client2 = new Client(clientDto2);
        assertNotEquals(client,client2);
    }
    @Test
    public void testEqualsDifferentTaxIdentificationNumber(){
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567891", "1234567890123456", "1234567890", "11/09/2002","Male", "91337755612");
        Client client2 = new Client(clientDto2);
        assertNotEquals(client,client2);
    }
    @Test
    public void testEqualsDifferentCitizenCardNumber(){
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123455", "1234567890", "11/09/2002","Male", "91337755612");
        Client client2 = new Client(clientDto2);
        assertNotEquals(client,client2);
    }
    @Test
    public void testEqualsDifferentNhsNumber(){
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567891", "11/09/2002","Male", "91337755612");
        Client client2 = new Client(clientDto2);
        assertNotEquals(client,client2);
    }
    @Test
    public void testEqualsDifferentBirthDate(){
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2003","Male", "91337755612");
        Client client2 = new Client(clientDto2);
        assertNotEquals(client,client2);
    }
    @Test
    public void testEqualsDifferentGender(){
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002","(Unknown)", "91337755612");
        Client client2 = new Client(clientDto2);
        assertNotEquals(client,client2);
    }
    @Test
    public void testEqualsDifferentPhoneNumber(){
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        ClientDto clientDto2 = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002","Male", "91337755613");
        Client client2 = new Client(clientDto2);
        assertNotEquals(client,client2);
    }

    @Test
    public void testToString() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        String expected = String.valueOf(client);

        String result = client.toString();

        assertEquals(expected, result);
    }
    @Test(expected = NullPointerException.class)
    public void testToStringNull(){
        Client client = null;
        String expected=null;

        String result= client.toString();
         assertNull(result);

    }

    @Test
    public void getTaxIdentificationNumber() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        String expected = "1234567890";

        String result = client.getTaxIdentificationNumber();

        Assert.assertEquals(expected,result);

    }

    @Test
    public void addTest() {
        app.domain.model.Test test = new app.domain.model.Test("123456789011");
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        boolean result = client.addTest(test);

        assertTrue(result);

    }

    @Test
    public void getName() {
        app.domain.model.Test test = new app.domain.model.Test("123456789011");
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        String expected = "Pedro";

        String result = client.getName();

        assertEquals(expected,result);

    }
}