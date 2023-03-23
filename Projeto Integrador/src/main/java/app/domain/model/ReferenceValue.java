package app.domain.model;

/**
 * This class allows for the creation of ReferenceValue object
 *
 * @author André Soares <1201314@isep.ipp.pt>
 * @author Luis Ríbeiro <1201184@isep.ipp.pt>
 */
public class ReferenceValue {

    /**
     * A number with decimal places,that represents the upper Reference Value of a specific parameter.
     */
    private final double upperReferenceValue;

    /**
     * A number with decimal places that represents the lower Reference Value of a specific parameter.
     */
    private final double lowerReferenceValue;

    /**
     * Constructor that allows the initialization of all instances.
     *
     * @param upperReferenceValue A decimal number of upper reference value.
     * @param lowerReferenceValue A decimal number of lower reference value.
     */
    public ReferenceValue(double upperReferenceValue, double lowerReferenceValue) {
        checkReferenceValues(upperReferenceValue, lowerReferenceValue);
        this.upperReferenceValue = upperReferenceValue;
        this.lowerReferenceValue = lowerReferenceValue;
    }

    /**
     * The method that check if the value of either upperReferenceValue or lowerReferenceValue are equal to -1
     * if they are an exception is thrown
     *
     * @param upperReferenceValue A decimal number of upper reference value.
     * @param lowerReferenceValue A decimal number of lower reference value.
     */
    public void checkReferenceValues(double upperReferenceValue, double lowerReferenceValue){
        if(upperReferenceValue == -1 || lowerReferenceValue == -1){
            throw new IllegalArgumentException("The Parameter was not found on the Module (of the selected Test Type).");
        }
    }

    /**
     * The method that return a string in a formatted and organised way.
     *
     * @return All parameters of References Values with a specific format.
     */
    public String toString(){
        return String.format("Lower Reference Value: %.2f | Upper Reference Value: %.2f", this.lowerReferenceValue,
                this.upperReferenceValue);
    }
}
