package app.domain.model;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;

import java.io.IOException;

/**
 * Interface that will be used in Adapters Classes related to BarcodeExternalModule.
 * This interface is necessary to make the code more organized and well structured.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public interface BarcodeExternalModule{

    /**
     * Method that is essencial for this interface.
     *
     * @return a String containing the barcode number
     * @throws OutputException Exception because of the output given by barcode.
     * @throws BarcodeException Exception that needs to be throw because of barbecue library
     * @throws IOException Exception because of the input to create a barcode.
     */
    String getBarcode() throws OutputException, BarcodeException, IOException;
}
