package app.domain.model;

import app.adapter.BarcodeAdapter;
import app.utils.Utils;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;

/**
 * This Class allows the creation of a Sample with all the attributes (barcode).
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class Sample{

    /**
     * string containing the adapter address
     */
    private static String adapterAddress;
    /**
     * A String of Barcode.
     */
    private String barcode;

    /**
     * A String of Barcode Number.
     */
    private String barcodeNumber;

    /**
     * Constructor that allows the initialization of all the instances.
     *
     */
    public Sample(){
        this.barcode=null;
    }

    /**
     * The method that inicialize and create the Barcode using the BarcodeAdapter Class.
     *
     * @return A String of Barcode.
     * @throws OutputException Exception because of the output given by barcode.
     * @throws BarcodeException Exception that needs to be throw because of barbecue library
     * @throws IOException Exception because of the input to create a barcode.
     */
    public String getBarcode() throws OutputException, BarcodeException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        BarcodeAdapter ba=(BarcodeAdapter) getBarcodeAdapter();
        this.barcode=ba.getBarcode();
        this.barcodeNumber= ba.getBarcodeNumber();
        Utils.printLineToConsole(barcodeNumber);
        return barcode;
    }
    /**
     * Method that allows showing the barcode number from a string.
     *
     * @return a String to show the barcode number.
     */
    @Override
    public String toString(){
        String number = new BarcodeAdapter().getBarcodeNumber();
        return String.format("Barcode: %s",number);
    }

    /**
     * The method that returns the Barcode Number.
     *
     * @return A string of Barcode Number.
     */
    public String getBarcodeNumber() {
        return barcodeNumber;
    }

    /**
     * Method that get BarcodeAdapter by Java Reflection.
     *
     * @return The BarcodeExternalModule.
     * @throws ClassNotFoundException Exception to be thrown if the Class is not found.
     * @throws InstantiationException Exception to be throw if the Constructor is not available.
     * @throws IllegalAccessException Exception to be throw if the Method does not have access to the wanted Class.
     */
    public BarcodeExternalModule getBarcodeAdapter() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> oClass = Class.forName(adapterAddress);
        return (BarcodeExternalModule) oClass.newInstance();
    }

    /**
     * Method that set the AdapterAddress.
     *
     * @param adapterAddress The AdapterAddress.
     */
    public static void setAdapterAddress(String adapterAddress) {
        Sample.adapterAddress = adapterAddress;
    }
}
