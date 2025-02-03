package sample.adapter.primary.test;

import sample.adapter.secondary.mock.*;
import sample.adapter.secondary.file.*;
import sample.application.domain.repository.RateRepositoryInterface;
import sample.application.exeption.ApplicationException;
import sample.application.service.*;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class TestAdapterTest {

    private TestAdapter testAdapter;

    @Test
    void testUseCase01MockRepo() {
        RateRepositoryInterface repository = new MockRateRepo();
        ApplicationServiceInterface app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        try {
            List<TestCalculationInput> inputList = new ArrayList<>();
            List<ApplicationResult> expectedList = new ArrayList<>();
            for (int input = 0; input <= 100; input++) {
                inputList.add(new TestCalculationInput(input));
                double rate = 1.01;
                ApplicationResult result = new ApplicationResult(input * rate, rate);
                expectedList.add(result);
            }
            for (int input = 101; input <= 200; input++) {
                inputList.add(new TestCalculationInput(input));
                double rate = 1.5;
                ApplicationResult result = new ApplicationResult(input * rate, rate);
                expectedList.add(result);
            }

            List<ApplicationResult> actualList = testAdapter.run(inputList);

            assertIterableEquals(expectedList, actualList);
        } catch (ApplicationException e) {
            // 異常系の場合はこの例外をテストする必要がある
            e.printStackTrace();
        }
    }

    @Test
    void testUseCase01FileRepo() {
        RateRepositoryInterface repository = new FileRateRepo(
                "src/test/java/sample/adapter/primary/test/file-rate.csv");
        ApplicationServiceInterface app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        try {
            List<TestCalculationInput> inputList = new ArrayList<>();
            List<ApplicationResult> expectedList = new ArrayList<>();
            for (int input = 0; input < 100; input++) {
                inputList.add(new TestCalculationInput(input));
                double rate = 1.0;
                ApplicationResult result = new ApplicationResult(input * rate, rate);
                expectedList.add(result);
            }
            for (int input = 100; input <= 200; input++) {
                inputList.add(new TestCalculationInput(input));
                double rate = 2.0;
                ApplicationResult result = new ApplicationResult(input * rate, rate);
                expectedList.add(result);
            }

            List<ApplicationResult> actualList = testAdapter.run(inputList);

            assertIterableEquals(expectedList, actualList);
        } catch (ApplicationException e) {
            // 正常系のテストではここを通るのはおかしい
            fail(e.getMessage());
        }
    }

    @Test
    void testUseCase01Error() {
        RateRepositoryInterface repository = new MockRateRepo();
        ApplicationServiceInterface app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        try {
            List<TestCalculationInput> inputList = new ArrayList<>();
            inputList.add(new TestCalculationInput(500));

            testAdapter.run(inputList);

            // JUnit3 までは自分で例外の扱いを考えて fail() する必要があったらしい？
            // Junit4 では別の方法があるらしいが、ここでは省略
            // 異常系のテストではここを通るのはおかしい
            fail();
        } catch (ApplicationException e) {
            // 異常系の場合はこの例外をテストする必要がある
            assertEquals(e.getMessage(), "");
        }
    }

    @Test
    void testUseCase01Error2() {
        RateRepositoryInterface repository = new MockRateRepo();
        ApplicationServiceInterface app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        List<TestCalculationInput> inputList = new ArrayList<>();
        inputList.add(new TestCalculationInput(500));

        // JUnit5 の例外検証方法
        ApplicationException e = assertThrows(ApplicationException.class, () -> {
            testAdapter.run(inputList);
        });

        assertEquals(e.getMessage(), "");
    }

    @Test
    void testUseCase02MockRepo() {
        RateRepositoryInterface repository = new MockRateRepo();
        ApplicationServiceInterface app = new UseCase02(repository);
        testAdapter = new TestAdapter(app);

        // 異常時は例外ではなく復帰値でエラーを返すので try / catch 不要
        // 異常系も result の内容をチェック
        List<TestCalculationInput> inputList = new ArrayList<>();
        List<ApplicationResult> expectedList = new ArrayList<>();
        for (int input = 0; input <= 100; input++) {
            inputList.add(new TestCalculationInput(input));
            double rate = 1.01;
            ApplicationResult result = new ApplicationResult(input * rate * 2, rate);
            expectedList.add(result);
        }
        for (int input = 101; input <= 200; input++) {
            inputList.add(new TestCalculationInput(input));
            double rate = 1.5;
            ApplicationResult result = new ApplicationResult(input * rate * 2, rate);
            expectedList.add(result);
        }
        inputList.add(new TestCalculationInput(500));
        expectedList.add(new ApplicationResult(8, "Application Error !!"));

        List<ApplicationResult> actualList = testAdapter.run(inputList);

        assertIterableEquals(expectedList, actualList);
    }

}
