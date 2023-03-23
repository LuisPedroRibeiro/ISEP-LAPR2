package app.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Enum where the address and informal representation of the various external modules will be stored.
 */
public enum AdapterEnum {

    /**
     * Object representative of the External Module that relates to all SARS-CoV-2 Tests.
     */
    EXTERNAL_MODULE_COVID("app.adapter.ExternalModuleAdapter1", "Covid Module"),

    /**
     * Object representative of the External Module that relates to all Blood Tests.
     */
    EXTERNAL_MODULE_BLOOD1("app.adapter.ExternalModuleAdapter2", "Blood Module 1"),

    /**
     * Object representative of the External Module that relates to all the Other Tests.
     */
    EXTERNAL_MODULE_BLOOD2("app.adapter.ExternalModuleAdapter3", "Blood Module 2");

    /**
     * String containing hte adapter address of a specific external module
     */
    private final String adapterAddress;

    /**
     * A string containing the informal representation of a specific external module
     */
    private final String text;

    /**
     * Allows the initialization of a enum object assigning it their respective address and informal representation.
     *
     * @param adapterAddress String containing hte adapter address of a specific external module.
     * @param text A string containing the informal representation of a specific external module.
     */
    AdapterEnum(String adapterAddress, String text) {
        this.adapterAddress = adapterAddress;
        this.text = text;
    }

    /**
     *Allows the creation List that will contain the adapters address available in the system.
     */
    public static List<String> getAdapterAddresss() {
        List<String> sList = new ArrayList<>();
        sList.add(EXTERNAL_MODULE_COVID.getAdapterAddress());
        sList.add(EXTERNAL_MODULE_BLOOD1.getAdapterAddress());
        sList.add(EXTERNAL_MODULE_BLOOD2.getAdapterAddress());
        return sList;
    }

    /**
     * Allows the creation of the List that will contain the informal representation of the modules.
     */
    public static List<String> getTexts() {
        List<String> sList = new ArrayList<>();
        sList.add(EXTERNAL_MODULE_COVID.getText());
        sList.add(EXTERNAL_MODULE_BLOOD1.getText());
        sList.add(EXTERNAL_MODULE_BLOOD2.getText());
        return sList;
    }

    /**
     * Allows the return of A string containing an adapter address belonging to a specific object.
     *
     * @return A string containing an adapter address.
     */
    public String getAdapterAddress() {
        return adapterAddress;
    }

    /**
     * Allows the return of A string containing containing the specific representation  of a specific module.
     *
     * @return A string containing the informal representation of the modules.
     */
    public String getText() {
        return text;
    }
}
