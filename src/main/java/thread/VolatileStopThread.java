package thread;

import java.util.concurrent.TimeUnit;

public class VolatileStopThread {

    /**
     * volatile 키워드는 배타적 수행과는 상관없지만, 변수의 가장 최근 값을 읽어온다.
     */
    private static volatile boolean stopRequested; // synchronized 키워드보다 속도가 조금 더 빠름.

    public void stopThread() throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;

        backgroundThread.join();
    }

}
