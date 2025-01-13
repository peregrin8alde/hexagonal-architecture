package sample.adapter;

import sample.application.domain.*;
import sample.application.*;

public class TestAdapter {

    IService app;

    public TestAdapter(IService app) {
        this.app = app;
    }

    public int run() {
        int input = 100;
        ResultValue resultValue = app.calculation(input);

        double resultValueData = resultValue.getData();
        double expected = input * 1.01;

        if (resultValueData == expected) {
            return 0;
        } else {
            return 1;
        }
    }

}
