package sample.adapter.primary.test;

import sample.application.service.ApplicationResult;
import sample.application.service.ApplicationServiceInterface;

import java.util.List;
import java.util.ArrayList;

public class TestAdapter {

    ApplicationServiceInterface app;

    public TestAdapter(ApplicationServiceInterface app) {
        this.app = app;
    }

    public List<ApplicationResult> run(List<TestCalculationInput> inputList) {
        List<ApplicationResult> resultList = new ArrayList<>();
        inputList.forEach(input -> {
            ApplicationResult result = app.calculation(input.getCalculationInput());
            resultList.add(result);
        });

        return resultList;
    }

}
