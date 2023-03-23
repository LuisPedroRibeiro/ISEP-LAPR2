package app.store;

import app.domain.model.TestType;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows for the construction of an object testTypeStore,where the all the created test types will be stored
 *
 * @author André Soares <1201314@isep.ipp.pt>
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class TestTypeStore {

    /**
     * A list designed to contain objects of the TestType class.
     */
    private final List<TestType> typeStore;

    /**
     * Initializes a new testTypeStore, while also assigning it an empty array list where the test types will be stored.
     */
    public TestTypeStore() {
        this.typeStore = new ArrayList<>();
    }

    /**
     * Initializes a test type with a code,collectionMethod and description.
     *
     * @param code             string containing a code that identifies a test type.
     * @param collectionMethod string describing the collection method.
     * @param description      string describing the test type.
     * @return returns the created the test type using the parameters.
     */
    public TestType createTestType(String code, String collectionMethod, String description) {
        return new TestType(code, collectionMethod, description);
    }

    /**
     * Allows the validation of an existing test type and throwing an exception if already exists inside the store.
     *
     * @param tt An existing TestType object.
     * @return a boolean statement true if the TestType object is not null and does not exist in the test type store,
     * false if null.
     */
    public boolean validateTestType(TestType tt) {
        if (tt == null) {
            return false;
        }
        if (typeStore.contains(tt)) {
            throw new IllegalArgumentException("There already exists a test type with that information");
        }
        return true;
    }

    /**
     * Allows the addition of an validated TestType object to the the list testTypeStore of the object TestTypeStore.
     *
     * @param tt An existing TestType object.
     * @return a boolean statement, true if the test type was added successfully to the test type store false if not.
     */
    public boolean saveTestType(TestType tt) {
        if (validateTestType(tt))
            return typeStore.add(tt);
        return false;
    }

    /**
     * This method allows other classes to take the Test Type Store.
     *
     * @return a List of Test Type Store.
     */
    public List<TestType> getTypeStore() {
        List<TestType> copy = typeStore;
        return copy;
    }

    /**
     * This method allows get a test type by a code.
     *
     * @param code The parameter that will be compared.
     * @return The test type that has the same code.
     */
    public TestType getTestTypeByCode(int code) {
        return typeStore.get(code);
    }


    /**
     * This method allows get a test type by hisn code.
     *
     * @param code The parameter that will be given as a parameter.
     * @return The test type that has the same code.
     */
    public TestType getTestTypeByCode(String code) {
        for (TestType testType : typeStore) {
            if (testType.getCode().equals(code))
                return testType;
        }
        return null;
    }
}