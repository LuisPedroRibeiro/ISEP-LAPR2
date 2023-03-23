package app.domain.model;


public class TestParameter {

    /**
     * The Parameter Object.
     */
    private final Parameter parameter;

    /**
     * The TestParameterResult Object.
     */
    private TestParameterResult testResult;

    /**
     * Constructor that allows the initialization of Test Parameter instances.
     *
     * @param parameter The parameter of the TestParameter.
     */
    public TestParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    /**
     * The method that allows the return of the Parameter.
     *
     * @return The parameter of the TestParameter.
     */
    public Parameter getParameter() {
        return parameter;
    }

    /**
     * The method that allows the set of a Test Result with result, metric and Reference Values to a TestResult
     *
     * @param result The result of Test Parameter.
     * @param metric The metric of Test Parameter.
     * @param refValue The References Values of Test Parameter.
     */
    public void addTestResult(double result,String metric,ReferenceValue refValue){
        testResult = new TestParameterResult(metric,result,refValue);
    }

    /**
     * The method that allows the return of TestParameterResult object.
     *
     * @return The TestParameterResult object inside the TestParameter object
     */
    public TestParameterResult getTestResult(){
        return this.testResult;
    }

    /**
     * The method that allows seeing all the parameters of a Test Parameter in a formatted organized way.
     *
     * @return All parameters of a Clinical Analysis Laboratory with a specific format.
     */
    public String toString(){
        return String.format("%sResult Value: %.2f%n Metric: %s", this.parameter.toString(), this.testResult.getValue(),
                this.testResult.getMetric());
    }
}
