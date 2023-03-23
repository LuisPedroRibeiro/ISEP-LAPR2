package app.adapter;

import app.domain.model.ExternalModule;
import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import com.example1.ExternalModule3API;

/**
 * This class allows the communication between ExternalModule3API library and system.
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ExternalModuleAdapter3 implements ExternalModule {

    /**
     * The method that allows the return of Reference Values (upper and lower) for a Parameter.
     *
     * @param parameter The Parameter that will receive the References Values.
     * @return A Reference Value Object that will have the upper and lower Reference Values.
     */
    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {
       ExternalModule3API externalModule3API = new ExternalModule3API();

        Double maxReferenceValue=externalModule3API.getMaxReferenceValue(parameter.getCode(),12345);
        Double minReferenceValue= externalModule3API.getMinReferenceValue(parameter.getCode(),12345);

        return new ReferenceValue(maxReferenceValue,minReferenceValue);
    }

    /**
     * The method that allows the return of the metric (f.e. mg) in a String, of the parameter.
     *
     * @param parameter The Parameter that will receive the metric.
     * @return Metric of the Parameter.
     */
    @Override
    public String getMetric(Parameter parameter) {
        ExternalModule3API externalModule3API = new ExternalModule3API();
        return externalModule3API.usedMetric(parameter.getCode(), 12345);
    }
}

