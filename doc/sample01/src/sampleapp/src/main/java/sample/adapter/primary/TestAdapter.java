package sample.adapter;

import sample.application.domain.*;
import sample.application.*;

public class TestAdapter {

    public TestAdapter() {

    }

    public int run() {
        int input = 100;
        IRateRepository repository = new MockDB();

        UseCase01 app = new UseCase01(repository);
        ResultValue resultValue = app.calculation(input);

        double resultValueValue = resultValue.getValue();
        double expected = input * 1.01;

        if (resultValueValue == expected) {
            return 0;
        } else {
            return 1;
        }
    }

}
