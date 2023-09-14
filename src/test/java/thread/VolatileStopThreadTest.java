package thread;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VolatileStopThreadTest {

    private VolatileStopThread volatileStopThread = new VolatileStopThread();
    @Test
    void stopThread() throws InterruptedException {
        volatileStopThread.stopThread();
    }
}
