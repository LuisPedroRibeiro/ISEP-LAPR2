package app.adapter;

import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class BarcodeAdapterTest {

    @Test
    public void testGetBarcode() throws BarcodeException, OutputException, IOException {
        BarcodeAdapter barAdap = new BarcodeAdapter();
        String expected = "30000000003";
        String result = barAdap.getBarcode();
        String result2 = barAdap.getBarcode();
        Assert.assertEquals(expected,result);
        Assert.assertNotEquals(expected,result2);
    }

    @Test
    public void testIncreaseNumberOfSamples() {
        int expected=1;
        BarcodeAdapter.increseNumberOfSamples();
        int result= BarcodeAdapter.getNumberOfSamples();
        BarcodeAdapter.increseNumberOfSamples();
        int result2= BarcodeAdapter.getNumberOfSamples();
        Assert.assertEquals(expected,result);
        Assert.assertNotEquals(expected,result2);

    }

    @Test
    public void testGetBarcodeNumber() {
        BarcodeAdapter barAdap = new BarcodeAdapter();
        String expected = "30000000001";
        String result = barAdap.getBarcodeNumber();
        BarcodeAdapter.increseNumberOfSamples();
        String result2 = barAdap.getBarcodeNumber();
        Assert.assertEquals(expected,result);
        Assert.assertNotEquals(expected,result2);
    }
}