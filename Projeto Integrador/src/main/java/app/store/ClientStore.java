package app.store;

import app.domain.model.Client;
import app.domain.model.Test;
import app.domain.shared.EmailSMS;
import app.mappers.dto.ClientDto;
import app.utils.Utils;
import auth.domain.model.Email;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pedro Graça <1201188@isep.ipp.pt>
 */
public class ClientStore {

    /**
     * List with the capacity of save Client objects
     */
     List<Client> clientList = new ArrayList<>();

    /**
     * Method that returns a new Client with the attributes contained in the ClientDto object
     *
     * @param clientDto the Client Data Transfer Object that contains the Client attributes
     * @return a Client with the attributes given by parameter
     */
    public Client createClient(ClientDto clientDto) {
        return new Client(clientDto);
    }

    /**
     * Method to validate the Client in a global way
     *
     * @param client the Client to be validated
     * @return the boolean result of the Client validation
     */
    public boolean validateClient(Client client) {
        if (client == null)
            return false;
        return !this.clientList.contains(client);
    }

    /**
     * Method to save the Client in the Client List
     *
     * @param client the Client to be added
     * @return the boolean result of the addition of the Client to the Client List
     */
    public boolean saveClient(Client client) throws IOException {
        if (!validateClient(client)) {
            return false;
        }else{
            client.setPassword();
            client.addUserAndSendEmail();
        }
        return this.clientList.add(client);
    }

    /**
     * Method just to save a Client to run the bootstrap
     *
     * @param client the Client
     */
    public void saveClientBootstrap(Client client) {
        if (!validateClient(client)) {
            return;
        }else{
            client.setPassword();
        }
        this.clientList.add(client);
    }

    /**
     * Method that returns the list of Clients
     *
     * @return the list of Clients
     */
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     * Method that returns if in the Client list exists someone with the Phone Number that is given by parameter
     *
     * @param phoneNumber the Phone Number given by parameter
     * @return the boolean result of the list containing this Phone Number
     */
    public boolean containsPhoneNumber(String phoneNumber) {
        for (Client client : clientList) {
            if (phoneNumber.equals(client.getPhoneNumber())) {
                Utils.printLineToConsole("This Phone Number is already being used.");
                return true;
            }
        }
        return false;
    }

    /**
     * Method that returns if in the Client list exists someone with the Email given by parameter
     *
     * @param email the Email given by parameter
     * @return the boolean result of the list containing this Email
     */
    public boolean containsEmail(Email email) {
        for (Client client : clientList) {
            if (email.equals(client.getEmail())) {
                Utils.printLineToConsole("This Email is already being used.");
                return true;
            }
        }
        return false;
    }

    /**
     * Method that returns if a Client exists at the Company
     *
     * @param taxIdentificationNumber the TIN of the Client
     * @return the boolean result of the verification
     */
    public boolean verifyClientByTin(String taxIdentificationNumber){
        for (Client client:clientList) {
            if(client.getTaxIdentificationNumber().equals(taxIdentificationNumber)){
                return true;
            }
        }
       return false;
    }

    /**
     * Method that returns the Client that contains the Tax Identification Number given as a parameter
     *
     * @param taxIdentificationNumber the TIN of the Client
     * @return the Client with the given data
     */
    public Client getClientByTin(String taxIdentificationNumber){
        for(Client client: clientList){
            if (client.getTaxIdentificationNumber().equals(taxIdentificationNumber))
                return client;
        }
        return null;
    }

    /**
     * Allows the return of the client that possesses a test received as parameter
     *
     * @param test a object of the Test class
     * @return The client if the test received as parameter belongs to a client in the clientList,null if it does not
     */
    public Client getClientByTest(Test test){
        for(Client client: clientList){
            if(client.isTestInsideClientTestList(test)){
                return client;
            }
        }
        return null;
    }

    /**
     * Allows the sending of a  text to the txt file emailAndSMSMessages.txt
     * containing some information about the test being validated and the client the test belongs too.
     *
     * @param client An object of the Client class
     * @param test An object of the Test class
     */
    public void sendEmail(Client client,Test test) throws IOException {
        EmailSMS.sendTestNotification(client.getEmail(),client.getName(),test.getNhsCode());
    }
}
