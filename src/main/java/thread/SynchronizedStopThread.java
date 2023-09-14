package thread;

public class SynchronizedStopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean isStopRequested() { // 필드를 동기화 해서 접근한다!
        return stopRequested;
    }

    public void makeRequest() throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!isStopRequested()) {
                i++;
            }
        });
        backgroundThread.setName("hi");

        backgroundThread.start();

        Thread.sleep(1000);
        requestStop();

        backgroundThread.join();
    }

}
