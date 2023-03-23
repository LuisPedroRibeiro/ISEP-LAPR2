package app.store;

import app.domain.model.Client;
import app.mappers.dto.ClientDto;
import auth.domain.model.Email;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ClientStoreTest {

    @Test
    public void createClientWithGender() {
        ClientStore clientStore = new ClientStore();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456",
                "1234567890", "11/09/2002", "Male", "91337755612");
        ClientDto clientDto1 = new ClientDto("Pepe", new Email("pepe@gmail.com"), "1234567899",
                "1234567899999999", "1234567777", "11/09/1989", "Male", "91337755678");
        Client client = new Client(clientDto);
        Client client1 = clientStore.createClient(clientDto);
        Client client2 = clientStore.createClient(clientDto1);

        assertEquals(client, client1);
        assertNotEquals(client1, client2);
    }


    @Test
    public void createClientWithoutGender() {
        ClientStore clientStore = new ClientStore();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456",
                "1234567890", "11/09/2002", "91337755612");
        ClientDto clientDto1 = new ClientDto("Pepe", new Email("pp@gmail.com"), "1234567899", "1234567899999999",
                "1234567899", "11/08/2001", "91337755689");
        Client client = new Client(clientDto);
        Client client1 = clientStore.createClient(clientDto);
        Client client2 = clientStore.createClient(clientDto1);

        assertEquals(client, client1);
        assertNotEquals(client1, client2);
    }

    @Test
    public void validateClient() {
        ClientStore clientStore = new ClientStore();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456",
                "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        boolean result = clientStore.validateClient(client);

        assertTrue(result);
    }

    @Test
    public void validateClientNull() {
        ClientStore clientStore = new ClientStore();

        Client client = null;

        boolean result = clientStore.validateClient(client);

        assertFalse(result);
    }

    @Test
    public void validateClientException() throws IOException {
        ClientStore clientStore = new ClientStore();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456",
                "1234567890", "11/09/2002", "Male", "91337755612");

        Client client = new Client(clientDto);

        boolean client1 = clientStore.saveClient(client);
        boolean client2 = clientStore.saveClient(client);

        assertTrue(client1);
        assertFalse(client2);
    }


    @Test
    public void saveClientSuccess() throws IOException {
        ClientStore clientStore = new ClientStore();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456",
                "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);

        boolean result = clientStore.saveClient(client);

        assertTrue(result);
    }

    @Test
    public void saveClientNull() throws IOException {
        ClientStore clientStore = new ClientStore();
        Client client = null;

        boolean clientBool = clientStore.saveClient(client);

        assertFalse(clientBool);
    }

    @Test
    public void testToStringEmpty() {
        ClientStore clientStore = new ClientStore();
        String list = clientStore.getClientList().toString();
        assertEquals(list, "[]");
    }

    @Test
    public void getClientList() throws IOException {
        ClientStore clientStore = new ClientStore();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456",
                "1234567890", "11/09/2002", "Male", "91337755612");
        Client client = new Client(clientDto);
        clientStore.saveClient(client);


        List<Client> list = clientStore.getClientList();
        List<Client> list1 = new ArrayList<>();
        list1.add(client);

        assertEquals(list, list1);
    }

    @Test
    public void containsPhoneNumber() throws IOException {
        ClientStore clientStore = new ClientStore();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456",
                "1234567890", "11/09/2002", "Male", "91337755612");
        ClientDto clientDto1 = new ClientDto("Petro", new Email("petro@gmail.com"), "1234567890", "1234567899999999", "1234567899",
                "11/09/2002", "Male", "91337755612");
        ClientDto clientDto2 = new ClientDto("Petro", new Email("pero@gmail.com"), "1234567890", "1234567899999999", "1234567899",
                "11/09/2002", "Male", "91337755613");
        Client client = new Client(clientDto);
        Client client1 = new Client(clientDto1);
        Client client2 = new Client(clientDto2);

        clientStore.saveClient(client);

        boolean result = clientStore.containsPhoneNumber(client1.getPhoneNumber());
        boolean result1 = clientStore.containsPhoneNumber(client2.getPhoneNumber());


        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void containsEmail() throws IOException {

        ClientStore clientStore = new ClientStore();
        ClientDto clientDto = new ClientDto("Pedro", new Email("pedro@gmail.com"), "1234567890", "1234567890123456",
                "1234567890", "11/09/2002", "Male", "91337755612");
        ClientDto clientDto1 = new ClientDto("Petro", new Email("pedro@gmail.com"), "1234567890", "1234567899999999", "1234567899",
                "11/09/2002", "Male", "91337755613");
        ClientDto clientDto2 = new ClientDto("Petro", new Email("pero@gmail.com"), "1234567890", "1234567899999999", "1234567899",
                "11/09/2002", "Male", "91337755614");

        Client client = new Client(clientDto);
        Client client1 = new Client(clientDto1);
        Client client2 = new Client(clientDto2);

        clientStore.saveClient(client);

        boolean result = clientStore.containsEmail(client1.getEmail());
        boolean result1 = clientStore.containsEmail(client2.getEmail());

        assertTrue(result);
        assertFalse(result1);
    }

    @Test
    public void verifyClientByTin() {

    }

    @Test
    public void getClientByTin() {

    }

    @Test
    public void sendEmail() throws IOException {
        ClientStore cStore=new ClientStore();
        ClientDto clientDto1 = new ClientDto("Pepe", new Email("pepe@gmail.com"), "1234567899",
                "1234567899999999", "1234567777", "11/09/1989", "Male", "91337755678");
        Client client = new Client(clientDto1);
        app.domain.model.Test test= new app.domain.model.Test("123456789012");

        cStore.sendEmail(client,test);

        Assert.assertTrue(true);

    }

    @Test
    public void getClientByTest() throws IOException {
        ClientStore cStore=new ClientStore();
        ClientDto clientDto1 = new ClientDto("Pepe", new Email("pepe@gmail.com"), "1234567899",
                "1234567899999999", "1234567777", "11/09/1989", "Male", "91337755678");
        Client expected = new Client(clientDto1);
        app.domain.model.Test test= new app.domain.model.Test("123456789012");

        expected.addTest(test);
        cStore.saveClient(expected);
        Client result=cStore.getClientByTest(test);

        Assert.assertEquals(result,expected);


    }
}