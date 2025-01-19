package sample.adapter.primary.test;

import sample.application.domain.object.value.CalculationResult;
import sample.application.domain.port.primary.IService;

import java.util.List;
import java.util.ArrayList;

public class TestAdapter {

    IService app;

    public TestAdapter(IService app) {
        this.app = app;
    }

    public List<TestResult> run(List<TestCalculationInput> inputList) {
        List<TestResult> resultList = new ArrayList<>();
        inputList.forEach(input -> {
            CalculationResult resultValue = app.calculation(input.getCalculationInput());

            TestResult result = new TestResult(0, resultValue, "");
            resultList.add(result);
        });

        return resultList;
    }

}
