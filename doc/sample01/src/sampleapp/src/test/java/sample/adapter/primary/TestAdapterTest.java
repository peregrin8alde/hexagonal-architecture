package sample.adapter;

import sample.application.domain.*;
import sample.application.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestAdapterTest {

    private TestAdapter testAdapter;

    @Test
    void test01() {
        IRateRepository repository = new MockDB();
        IService app = new UseCase01(repository);
        testAdapter = new TestAdapter(app);

        assertEquals(0, testAdapter.run());
    }

}

