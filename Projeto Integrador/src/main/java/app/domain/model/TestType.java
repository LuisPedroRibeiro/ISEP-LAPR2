package app.domain.model;

import app.list.ParameterCategoryList;
import org.apache.commons.lang3.StringUtils;

import java.util.List;


/**
 * This class allows for the construction of a TestType object
 *
 * @author André Soares <1201314@isep.ipp.pt>
 */
public class TestType {

    /**
     * Five alphanumeric string that identifies a test type
     */
    private final String code;

    /**
     *  Less then 20 characters string describing the collection method of a test type
     */
    private final String collectionMethod;

    /**
     * Less than 15 characters string with the description of the test type
     */
    private final String description;

    /**
     * Object of the class ParameterCategoryList where the set of categories pertaining
     * to a specific test type will be stored
     */
    private ParameterCategoryList cl;

    /**
     * String of Adapter Address.
     */
    private String adapterAddress;

    /**
     * Allows the initialization of a test type with a code,collectionMethod and description
     *  while also checking if those are in accordance with the rules
     *
     * @param code string containing a code that identifies a test type
     * @param collectionMethod string describing the collection method of a test type
     * @param description string describing a test type
     */
    public TestType(String code, String collectionMethod, String description) {
        checkCodeRules(code);
        checkDescriptionRules(description);
        checkCollectionMethodRules(collectionMethod);
        this.code = code;
        this.collectionMethod = collectionMethod;
        this.description = description;
    }

    /**
     *
     * Allows the verification of the code ,checking if it is in accordance with the rule of having 5 chars and
     * being alphanumeric ,trowing the appropriate exception if any of the rules are broken
     *
     * @param code  string containing a code that identifies a test type
     */
    private void checkCodeRules(String code) {
        if (StringUtils.isBlank(code))
            throw new IllegalArgumentException("Code cannot be blank.");
        if ((code.length() != 5 ))
            throw new IllegalArgumentException("Code must have 5 chars.");
        if(!checkRulesCodeAlphaNumeric(code))
            throw new IllegalArgumentException("Code must be Alphanumeric.");
    }

    /**
     * Allows the verification of the description,checking if it is in accordance with the rules
     * of the description having no more than 15 chars and not being blank.
     * trowing the appropriate exception if any of the rules are broken
     *
     * @param description string describing the test type
     */
    public void checkDescriptionRules(String description) {
        if (StringUtils.isBlank(description))
            throw new IllegalArgumentException("The description cannot be blank.");
        if (description.length() > 15 )
            throw new IllegalArgumentException("The description must have no more than 15 characters.");
    }

    /**
     * Allows the verification of the collectionMethod,checking if it is in accordance with
     * the rules of the collection method not being blank and having no more than 20 chars
     * trowing the appropriate exception if any of the rules are broken
     *
     *  @param collectionMethod  string describing the collection method
     */

    public void checkCollectionMethodRules(String collectionMethod) {
        if (StringUtils.isBlank(collectionMethod))
            throw new IllegalArgumentException("The description cannot be blank.");
        if (collectionMethod.length() > 20 )
            throw new IllegalArgumentException("The collection method must have no more than 20 characters.");
    }

    /**
     * Allows the verification if the list inside the object of the ParameterCategoryList class is empty and if it is
     * throws an appropriate exception
     *
     * @param cl object of the ParameterCategoryList class,where the list of ParameterCategory objects resides
     */
    public void validateParameterCategoryList(ParameterCategoryList cl) {
        if(cl.getClSize()==0)
            throw new IllegalArgumentException("A test type should have at least a parameter category associated with " +
                    "it");
    }

    /**
     * Allows the association of a TestType object with a validated ParameterCategoryList object
     *
     * @param cl object of the ParameterCategoryList class
     */
    public void addParameterCategoryListToTestType(ParameterCategoryList cl){
        validateParameterCategoryList(cl);
        this.cl=cl;
    }

    /**
     * Allows the verification if there is only letters and numbers in code String
     *
     * @param code string containing a code that identifies a test type
     * @return boolean statement,true if there is only letters and numbers in the code false if not
     */
    public boolean checkRulesCodeAlphaNumeric(String code){
        for(int i=0;i<code.length();i++){
            if(!Character.isLetterOrDigit(code.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * Allows the comparison between two object checking if it is the same object and if not checking if the
     * unique code or the description is equal  between the two of them
     *
     * @param o Object that will be compared against
     * @return boolean statement,true if its equal according to the standards or false if not
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestType testType = (TestType) o;
        return code.equals(testType.code) || description.equals(testType.description);
    }

    /**
     * Allows the return of a string containing the code,description and collection method
     * in a formal and organized manner
     *
     * @return a string containing the code,description and collection method of a testType in a organized manner
     */
    @Override
    public String toString() {
        return String.format("##Test Type## %n Code: %s %n Description: %s %n Collection Method: %s",
                code,description,collectionMethod);
    }

    /**
     * Allows the return of the code String
     * @return the code String
     */
    public String getCode() {
        return code;
    }

    /**
     * Allows the return of the collection method String
     * @return the collection method String
     */
    public String getCollectionMethod() {
        return collectionMethod;
    }

    /**
     * Allows the return of the description String
     * @return the description String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Allows the return of the ParameterCategoryList object
     * @return the ParameterCategoryList object
     */
    public ParameterCategoryList getCl() {
        return cl;
    }

    /**
     * Method that returns the Parameter Category list associated to the Test Type
     * @return the Parameter Category List
     */
    public List<ParameterCategory> getParameterCategoryList(){
        return cl.getCl();
    }

    /**
     * The method that allows the automatic choose of the External Module.
     *
     * @return The external module that wil be used
     * @throws ClassNotFoundException Exception to be thrown if the Class is not found.
     * @throws InstantiationException Exception to be throw if the Constructor is not available.
     * @throws IllegalAccessException Exception to be throw if the Method does not have access to the wanted Class.
     */
    public ExternalModule getExternalModule() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> oClass = Class.forName(adapterAddress);
        return (ExternalModule) oClass.newInstance();
    }

    /**
     * The method that set the adapter address to String of Adapter address.
     *
     * @param adapterAddress The adapter Adress that will be setted.
     */
    public void setAdapterAddress(String adapterAddress) {
        this.adapterAddress = adapterAddress;
    }
}
