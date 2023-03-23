package app.mappers;

import app.domain.model.TestType;
import app.mappers.dto.TestTypeDto;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allows the UI get the Test Type Store without touching the Test Type Store.
 *
 * @author Miguel Ramos <1201247@isep.ipp.pt>
 */
public class TestTypeMapper {

    /**
     * The method that return the Test Type created in TestTypeDto.
     *
     * @param testType The Test Type that will be returned.
     * @return The Test Type Dto that have the same parameters of Test Type.
     */
    public static TestTypeDto toDTO(TestType testType){
        return new TestTypeDto(testType.getCode(),testType.getCollectionMethod(), testType.getDescription());
    }

    /**
     * The method that return a List of Test Type Store created in TestTypeDto.
     *
     * @param testTypeStore The List of Test Type that will be returned.
     * @return The List of Test Type of all TestTypeDto created.
     */
    public List<TestTypeDto> listDTO(List<TestType> testTypeStore)
    {
        List<TestTypeDto> testTypeDtoList = new ArrayList<>();
        for(TestType test: testTypeStore)
        {
            testTypeDtoList.add(toDTO(test));
        }
        return testTypeDtoList;
    }
}

