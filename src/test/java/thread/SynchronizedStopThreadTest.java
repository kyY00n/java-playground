package thread;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedStopThreadTest {

    private SynchronizedStopThread synchronizedStopThread = new SynchronizedStopThread();

    @Test
    void 스레드가_멈추고_테스트가_끝난다() throws InterruptedException {
        //when
        synchronizedStopThread.makeRequest();
    }
}
