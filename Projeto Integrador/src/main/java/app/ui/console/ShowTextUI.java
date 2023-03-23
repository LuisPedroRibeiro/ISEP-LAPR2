package app.ui.console;

import app.utils.Utils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class ShowTextUI implements Runnable{

    private final String text;
    public ShowTextUI(String text)
    {
        if (StringUtils.isBlank(text))
            throw new IllegalArgumentException("ShowTextUI does not support null or empty text");

        this.text = text;
    }
    public void run()
    {
        Utils.printLineToConsole("\n");
        Utils.printLineToConsole(this.text);
        Utils.printLineToConsole("\n");
    }
}
