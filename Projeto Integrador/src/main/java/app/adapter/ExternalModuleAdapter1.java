package app.adapter;

import app.domain.model.ExternalModule;
import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import com.example3.CovidReferenceValues1API;

/**
 * This class allows the communication between CovidReferenceValues library and system .
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ExternalModuleAdapter1 implements ExternalModule {

    /**
     * The method that allows the return of Reference Values (upper and lower) for a Parameter.
     *
     * @param parameter The Parameter that will receive the References Values.
     * @return A Reference Value Object that will have the upper and lower Reference Values.
     */
    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {
        CovidReferenceValues1API covidReferenceValues1API = new CovidReferenceValues1API();

        Double maxReferenceValue=covidReferenceValues1API.getMaxReferenceValue(parameter.getCode(),12345);
        Double minReferenceValue= covidReferenceValues1API.getMinReferenceValue(parameter.getCode(),12345);

        return new ReferenceValue(maxReferenceValue,minReferenceValue);
    }

    /**
     * The method that allows the return of the metric (f.e. mg) in a String, of the parameter.
     *
     * @param parameter  A object of the Parameter class.
     * @return Metric of the Parameter.
     */
    @Override
    public String getMetric(Parameter parameter) {
        CovidReferenceValues1API covidReferenceValues1API = new CovidReferenceValues1API();
        return covidReferenceValues1API.usedMetric(parameter.getCode(), 12345);
    }
}
