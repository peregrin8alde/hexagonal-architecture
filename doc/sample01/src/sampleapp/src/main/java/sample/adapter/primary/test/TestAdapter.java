package sample.adapter.test;

import sample.application.domain.*;
import sample.application.*;

import java.util.List;
import java.util.ArrayList;

public class TestAdapter {

    IService app;

    public TestAdapter(IService app) {
        this.app = app;
    }

    public List<TestResult> run(List<TestInput> inputList) {
        List<TestResult> resultList = new ArrayList<>();
        inputList.forEach(input -> {
            ResultValue resultValue = app.calculation(input.getInput());

            TestResult result = new TestResult(0, resultValue, "");
            resultList.add(result);
        });

        return resultList;
    }

}
