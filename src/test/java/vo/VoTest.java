package vo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VoTest {
    @Test
    void equals() {
        // 만점은 100점이다.
        Score perfect = new Score(100);

        // 로지는 다맞아서 만점이다!
        Score rosie = perfect;

        // 문제 정답이 바뀌어서 로지에게 수정된 점수를 부여했다.
        Score newRosie = rosie.minus(3);

        assertEquals(perfect, new Score(100)); // 만점은 100점에서 변하지 않는다.
    }
}
