package app.controller;

import app.mappers.dto.ClientDto;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

/**
 * @author Pedro Graça
 */
public class RegisterClientControllerTest {

    @Test
    public void createClientWithGender() {
        RegisterClientController registerClientController= new RegisterClientController();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "Male", "91337755612");

        boolean result = registerClientController.createClient(clientDto);

        Assert.assertTrue(result);

    }
    @Test
    public void createClientWithoutGender(){
        RegisterClientController registerClientController= new RegisterClientController();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "(Unknown)", "91337755612");

        boolean result = registerClientController.createClient(clientDto);


        Assert.assertTrue(result);

    }

    @Test
    public void saveClient() throws IOException {
        RegisterClientController registerClientController= new RegisterClientController();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "(Unknown)", "91337755612");
        registerClientController.createClient(clientDto);

        Assert.assertTrue(registerClientController.saveClient());
    }

    @Test
    public void getStore() {
        RegisterClientController registerClientController= new RegisterClientController();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "(Unknown)", "91337755612");

        Assert.assertNull(registerClientController.getStore());
    }

    @Test
    public void containsPhoneNumber() throws AssertionError {
        RegisterClientController registerClientController= new RegisterClientController();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "(Unknown)", "91337755613");
        boolean expected= false;

        boolean result=registerClientController.containsPhoneNumber(clientDto.getPhoneNumber());

        Assert.assertFalse(result);
    }

    @Test
    public void containsEmail() {
        RegisterClientController registerClientController= new RegisterClientController();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456", "1234567890", "11/09/2002", "(Unknown)", "91337755612");
        boolean expected= false;

        boolean result=registerClientController.containsEmail(clientDto.getEmail());

        Assert.assertFalse(result);
    }
}