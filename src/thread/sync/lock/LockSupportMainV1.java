package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest(), "thread-1");
        thread.start();

        //잠시 대가하여 thread-1이 park 상태에 빠질 시간을 준다.
        sleep(100);
        log("thread-1 state = " + thread.getState());

        log("main -> unpark(thread-1) " + thread.getState());
        LockSupport.unpark(thread); // 1. unpark
//        thread.interrupt(); // 2. interrupt - waiting 상태에서 걸면 runnable 상태로 꺠어난다.

    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state = " + Thread.currentThread().getState());
            log("인터럽트 상태 = " + Thread.currentThread().isInterrupted());
        }
    }
}
