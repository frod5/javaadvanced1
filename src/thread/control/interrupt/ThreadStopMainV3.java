package thread.control.interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        Mytask task = new Mytask();
        Thread thread = new Thread(task, "work");
        thread.start();

        sleep(100);
        log("작업 중단 지시 thread.interrupt()");
        thread.interrupt();
        log("work 스레드 인터럽트 상태1 = " + Thread.currentThread().isInterrupted());
    }

    static class Mytask implements Runnable {


        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) { //인터럽트 상태 변경 X
                log("작업 중");
            }

            log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());
            log("자원 정리");
            log("작업 종료");
        }
    }
}
