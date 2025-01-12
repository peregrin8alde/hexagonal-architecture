package sample.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestAdapterTest {

    private final TestAdapter testAdapter = new TestAdapter();

    @Test
    void test01() {
        assertEquals(0, testAdapter.run());
    }

}

