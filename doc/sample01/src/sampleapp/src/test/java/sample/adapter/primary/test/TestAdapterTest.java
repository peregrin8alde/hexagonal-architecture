package sample.adapter.primary.test;

import sample.application.domain.exception.DomainException;
import sample.application.domain.object.value.CalculationResult;
import sample.application.domain.port.primary.IService;
import sample.adapter.secondary.mock.*;
import sample.adapter.secondary.file.*;
import sample.application.domain.port.secondary.*;
import sample.application.service.*;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;

class TestAdapterTest {

    private TestAdapter testAdapter;

    @Test
    void test01() {
        RateRepositoryInterface repository = new MockRateRepo();
        IService app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        try {
            List<TestCalculationInput> inputList = new ArrayList<>();
            List<TestResult> expectedList = new ArrayList<>();
            for (int input = 0; input <= 100; input++) {
                inputList.add(new TestCalculationInput(input));
                double rate = 1.01;
                CalculationResult resultValue;
                resultValue = new CalculationResult(input * rate, rate);
                expectedList.add(new TestResult(0, resultValue, ""));
            }
            for (int input = 101; input <= 200; input++) {
                inputList.add(new TestCalculationInput(input));
                double rate = 1.5;
                CalculationResult resultValue = new CalculationResult(input * rate, rate);
                expectedList.add(new TestResult(0, resultValue, ""));
            }

            List<TestResult> actualList = testAdapter.run(inputList);

            assertIterableEquals(expectedList, actualList);
        } catch (DomainException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    void test02() {
        RateRepositoryInterface repository = new FileRateRepo(
                "src/test/java/sample/adapter/primary/test/file-rate.csv");
        IService app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        try {
            List<TestCalculationInput> inputList = new ArrayList<>();
            List<TestResult> expectedList = new ArrayList<>();
            for (int input = 0; input < 100; input++) {
                inputList.add(new TestCalculationInput(input));
                double rate = 1.0;
                CalculationResult resultValue = new CalculationResult(input * rate, rate);
                expectedList.add(new TestResult(0, resultValue, ""));
            }
            for (int input = 100; input <= 200; input++) {
                inputList.add(new TestCalculationInput(input));
                double rate = 2.0;
                CalculationResult resultValue = new CalculationResult(input * rate, rate);
                expectedList.add(new TestResult(0, resultValue, ""));
            }

            List<TestResult> actualList = testAdapter.run(inputList);

            assertIterableEquals(expectedList, actualList);
        } catch (DomainException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
