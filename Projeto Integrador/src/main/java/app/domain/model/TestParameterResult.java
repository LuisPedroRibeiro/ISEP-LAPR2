package app.domain.model;

import app.utils.Utils;

public class TestParameterResult {

    /**
     * A string with the metric.
     */
    private final String metric;

    /**
     * A string with the created data of Test Parameter Result.
     */
    private final String createdAt;

    /**
     * A decimal number with the value.
     */
    private final double value;

    /**
     * A ReferenceValue Object.
     */
    private final ReferenceValue refValue;

    /**
     * Constructor that allows the inicialization of Test Parameter Result instances.
     *
     * @param metric The metric of Test Parameter Result.
     * @param value The value of Test Parameter Result.
     * @param refValue The reference values of Test Parameter Result.
     */
    public TestParameterResult(String metric, double value,ReferenceValue refValue) {
        this.metric = metric;
        this.value = value;
        createdAt= Utils.currentDate();
        this.refValue=refValue;
    }

    /**
     * The method that allows the return of ReferenceValue Object.
     *
     * @return The ReferenceValue Object.
     */
    public ReferenceValue getRefValue(){
        return this.refValue;
    }

    /**
     * The method that allows the return of Metric instance of TestParameterResult.
     *
     * @return The Metric instance of TestParameterResult.
     */
    public String getMetric(){return this.metric;}

    /**
     * The method that allows the return of Value instance of TestParameterResult.
     *
     * @return The Value instance of TestParameterResult.
     */
    public double getValue(){return  this.value;}
}
