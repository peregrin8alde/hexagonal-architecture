package sample.adapter.test;

import sample.application.domain.*;
import sample.application.*;

import sample.adapter.mock.*;
import sample.adapter.file.*;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;

class TestAdapterTest {

    private TestAdapter testAdapter;

    @Test
    void test01() {
        IRateRepository repository = new MockRateRepo();
        IService app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        List<TestInput> inputList = new ArrayList<>();
        List<TestResult> expectedList = new ArrayList<>();
        for (int input = 0; input <= 100; input++) {
            inputList.add(new TestInput(input));
            double rate = 1.01;
            ResultValue resultValue = new ResultValue(input * rate, rate);
            expectedList.add(new TestResult(0, resultValue, ""));
        }
        for (int input = 101; input <= 200; input++) {
            inputList.add(new TestInput(input));
            double rate = 1.5;
            ResultValue resultValue = new ResultValue(input * rate, rate);
            expectedList.add(new TestResult(0, resultValue, ""));
        }
        
        List<TestResult> actualList = testAdapter.run(inputList);

        assertIterableEquals(expectedList, actualList);
    }

    @Test
    void test02() {
        IRateRepository repository = new FileRateRepo("src/test/java/sample/adapter/primary/test/file-rate.csv");
        IService app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        List<TestInput> inputList = new ArrayList<>();
        List<TestResult> expectedList = new ArrayList<>();
        for (int input = 0; input < 100; input++) {
            inputList.add(new TestInput(input));
            double rate = 1.0;
            ResultValue resultValue = new ResultValue(input * rate, rate);
            expectedList.add(new TestResult(0, resultValue, ""));
        }
        for (int input = 100; input <= 200; input++) {
            inputList.add(new TestInput(input));
            double rate = 2.0;
            ResultValue resultValue = new ResultValue(input * rate, rate);
            expectedList.add(new TestResult(0, resultValue, ""));
        }
        
        List<TestResult> actualList = testAdapter.run(inputList);

        assertIterableEquals(expectedList, actualList);
    }


}

