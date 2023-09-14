package generics;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.Test;

public class GenericsTest {
    @Test
    void genericTest() {
        Collection<?> c = new ArrayList<String>();
//        c.add(new Object()); // 컴파일 에러
    }
}
