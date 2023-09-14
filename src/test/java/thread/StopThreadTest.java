package thread;

import org.junit.jupiter.api.Test;

class StopThreadTest {

    private StopThread stopThread = new StopThread();

    @Test
    void 스레드가_종료되지_않는다() throws InterruptedException {
        // when
        stopThread.threadStop();

        // 기대와는 달리 테스트가 멈추지 않는다.
    }

}
