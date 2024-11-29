package thread.cas;

import util.MyLogger;
import util.ThreadUtils;

import java.util.ArrayList;

public class IncrementThreadMain {

    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
    }

    private static void test(IncrementInteger increment) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ThreadUtils.sleep(10);
                increment.increment();
            }
        };

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int result = increment.get();
        System.out.println(increment.getClass().getSimpleName() + " result: " + result);
    }
}
