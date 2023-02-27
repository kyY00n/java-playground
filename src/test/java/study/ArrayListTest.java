package study;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ArrayListTest {
    @Test
    void remove() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            String a = i + "";
            list.add(a);
            list.remove(0);
        }
    }
}
