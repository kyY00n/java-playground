package thread;

import java.util.concurrent.TimeUnit;

public class StopThread {

    private static boolean stopRequested;

    public void threadStop() throws InterruptedException{
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.setName("hi");

        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true; // threadStop 실행 스레드가 true로 바꾼다면 backgroudThread가 while loop을 탈출하기를 기대한다. 기대처럼 되는지 테스트를 돌려보자.

        backgroundThread.join(); // 백그라운드 스레드가 종료할때까지 기다리기 위함.
    }

}
