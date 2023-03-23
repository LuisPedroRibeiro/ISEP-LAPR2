package app.adapter;

import app.domain.model.ExternalModule;
import app.domain.model.Parameter;
import app.domain.model.ReferenceValue;
import com.example2.EMRefValue;
import com.example2.ExternalModule2API;

/**
 * This class allows the communication between ExternalModule2API library and system.
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class ExternalModuleAdapter2 implements ExternalModule {

    /**
     * The method that allows the return of Reference Values (upper and lower) for a Parameter.
     *
     * @param parameter The Parameter that will receive the References Values.
     * @return A Reference Value Object that will have the upper and lower Reference Values.
     */
    @Override
    public ReferenceValue getReferenceValue(Parameter parameter) {

        ExternalModule2API externalModule2API = new ExternalModule2API();

        EMRefValue refValue=externalModule2API.getReferenceFor(parameter.getCode());

        return new ReferenceValue(refValue.getMaxValue(), refValue.getMinValue());
    }

    /**
     * The method that allows the return of the metric (f.e. mg) in a String, of the parameter.
     *
     * @param parameter The Parameter that will receive the metric.
     * @return Metric of the Parameter.
     */
    @Override
    public String getMetric(Parameter parameter) {
        ExternalModule2API externalModule2API = new ExternalModule2API();

        EMRefValue refValue=externalModule2API.getReferenceFor(parameter.getCode());

        return refValue.getMetric();
    }
}
