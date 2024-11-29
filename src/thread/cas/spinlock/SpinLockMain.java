package thread.cas.spinlock;

import util.MyLogger;
import util.ThreadUtils;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class SpinLockMain {

    public static void main(String[] args) {
//        SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                spinLock.lock();
                try {
                    //critical section
                    log("비지니스 로직 실행");
                    sleep(1); // cas의 단점 오래걸리는 로직인경우 계속 반복하면서 cpu자원 사용.
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread t1 = new Thread(runnable, "thread-1");
        Thread t2 = new Thread(runnable, "thread-2");
        t1.start();
        t2.start();
    }
}
