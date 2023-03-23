package app.mappers.dto;

import auth.domain.model.Email;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ClientDtoTest {

    @Test
    public void getName() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        String expected= "Pedro";

        String result= clientDto.getName();

        assertEquals(expected,result);
    }

    @Test
    public void getEmail() {

        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        Email expected= new Email("pedro@gmail.com");

        Email result= clientDto.getEmail();

        assertEquals(expected,result);
    }

    @Test
    public void getTaxIdentificationNumber() {

        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        String expected= "1234567890";

        String result= clientDto.getTaxIdentificationNumber();

        assertEquals(expected,result);
    }

    @Test
    public void getCitizenCardNumber() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        String expected= "1234567890123456";

        String result= clientDto.getCitizenCardNumber();

        assertEquals(expected,result);
    }

    @Test
    public void getNhsNumber() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        String expected= "1234567890";

        String result= clientDto.getNhsNumber();

        assertEquals(expected,result);
    }

    @Test
    public void getBirthDate() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        String expected= "11/09/2002";

        String result= clientDto.getBirthDate();

        assertEquals(expected,result);
    }

    @Test
    public void getGender() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        String expected= "Male";

        String result= clientDto.getGender();

        assertEquals(expected,result);
    }

    @Test
    public void getPhoneNumber() {ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        String expected= "91337755612";

        String result= clientDto.getPhoneNumber();

        assertEquals(expected,result);
    }

    @Test
    public void testToString() {
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"),
                "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");
        String expected= String.format("Client %n Name: %s %n Email: %s %n Tax Identification Number: %s %n Citizen Card Number: %s %n" +
                " National Healthcare Service Number: %s %n Birth Date: %s %n Gender: %s %n Phone Number: %s", clientDto.getName(),clientDto.getEmail(),clientDto.getTaxIdentificationNumber(),clientDto.getCitizenCardNumber(),clientDto.getNhsNumber(),clientDto.getBirthDate(),clientDto.getGender(),clientDto.getPhoneNumber());

        String result = clientDto.toString();

        assertEquals(expected,result);
    }
}