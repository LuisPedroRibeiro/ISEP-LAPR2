package app.controller;
import app.domain.model.Client;
import app.domain.model.Company;
import app.mappers.dto.ClientDto;
import app.store.ClientStore;
import auth.domain.model.Email;
import java.io.IOException;

/**
 * @author Pedro Graça <1201184@isep.ipp.pt>
 */
public class RegisterClientController {

    /**
     * Company that will have the controller
     */
    private final Company company;

    /**
     * Client that will be controlled
     */
    private Client client;

    /**
     * Store the Clients
     */
    private ClientStore store;

    /**
     * Constructs an instance of RegisterClientController with no parameters
     */
    public RegisterClientController() {
        this(App.getInstance().getCompany());
    }

    /**
     * Constructs an instance of RegisterClientController receiving the Company
     *
     * @param company the Company that will be on the controller
     */
    public RegisterClientController(Company company) {
        this.company = company;
        this.client = null;
    }

    /**
     * Returns the boolean value of the Client construction with the ClientDto object
     * @param clientDto the Client Data Transfer Object that contains the Client attributes;
     * @return the boolean value of the creation of the Client
     */
    public boolean createClient(ClientDto clientDto) {
        identifyStore();
        this.client = this.store.createClient(clientDto);
        return this.store.validateClient(client);
    }

    /**
     * Method to identify the ClientStore object that is pretended to work in
     */
    private void identifyStore() {
        store = this.company.getClientStore();
    }

    /**
     * Method used to save the Client
     *
     * @return the boolean value of the save of the Client
     */
    public boolean saveClient() throws IOException {
        return this.store.saveClient(client);
    }

    /**
     * Method to return the Client Store to the UI
     *
     * @return the Client Store
     */
    public ClientStore getStore() {
        return this.store;
    }

    /**
     * Method that takes the Phone Number to the store to confirm if is already any Client with this Phone Number
     *
     * @param phoneNumber the Phone Number given as a parameter
     * @return the boolean result of the confirmation of the store
     */
    public boolean containsPhoneNumber(String phoneNumber) {
        identifyStore();
        return store.containsPhoneNumber(phoneNumber);
    }

    /**
     * Method that check if the Store contains the email.
     *
     * @param email The email to be checked
     * @return True if the Store contains the email, false if not.
     */
    public boolean containsEmail(Email email){
        identifyStore();
        return store.containsEmail(email);
    }
}


