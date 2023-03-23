package app.domain.model;

import app.controller.App;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.output.OutputException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;


/**
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class SampleTest {

    @Ignore
    @Test
    public void testGetBarcode() throws OutputException, BarcodeException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        App.getInstance();
        Sample sample = new Sample();
        String expected = "30000000005";
        String result = sample.getBarcode();
        String result2 = sample.getBarcode();
        Assert.assertEquals(expected,result);
        Assert.assertNotEquals(expected,result2);
    }

    @Ignore
    @Test
    public void testToString() throws OutputException, BarcodeException, IOException {
        Sample sample = new Sample();
        String result = sample.toString();
        String expected = "Barcode: 30000000004";
        String expected2 = "Barcode: 30000000000";
        Assert.assertEquals(result,expected);
        Assert.assertNotEquals(result,expected2);
    }

    @Ignore
    @Test
    public void getBarcodeNumber() throws OutputException, BarcodeException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        App.getInstance();
        Sample sample = new Sample();
        sample.getBarcode();
        String result = sample.getBarcodeNumber();
        String expected = "30000000007";
        String expected2 = "30000000000";
        Assert.assertEquals(result,expected);
        Assert.assertNotEquals(result,expected2);
    }
}