package sample.adapter.test;

import sample.application.domain.*;
import sample.application.*;

import sample.adapter.mock.*;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;

class TestAdapterTest {

    private TestAdapter testAdapter;

    @Test
    void test01() {
        IRateRepository repository = new MockDB();
        IService app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        List<TestInput> inputList = new ArrayList<>();
        List<TestResult> expectedList = new ArrayList<>();
        for (int input = 1; input <= 101; input++) {
            inputList.add(new TestInput(input));
            double rate = 1.01;
            ResultValue resultValue = new ResultValue(input * rate, rate);
            expectedList.add(new TestResult(0, resultValue, ""));
        }
        
        List<TestResult> actualList = testAdapter.run(inputList);

        assertIterableEquals(actualList, expectedList);
        assertIterableEquals(actualList, expectedList);
    }

}

