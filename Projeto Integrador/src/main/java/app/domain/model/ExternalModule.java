package app.domain.model;

/**
 * Interface that will be used in Adapter Classes related to External Module.
 * This interface is necessary to turn the code more organized and well structured.
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public interface ExternalModule {

    /**
     * Method that is essencial for this interface.
     * This method will return References Values (upper and lower) according to Reference Value Class.
     *
     * @param parameter The Parameter that will receive the References Values.
     * @return ReferencesValue object
     */
    ReferenceValue getReferenceValue(Parameter parameter);

    /**
     * Method that is essencial for this interface.
     * This method will return the metric (f.e. mg) in a String, of the parameter.
     *
     * @param parameter The Parameter that will receive the metric.
     * @return Metric of the TestParameter.
     */
    String getMetric(Parameter parameter);
}
