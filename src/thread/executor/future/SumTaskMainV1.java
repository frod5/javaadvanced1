package thread.executor.future;

import thread.control.join.JoinMainV3;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class SumTaskMainV1 {

    public static void main(String[] args) throws InterruptedException {
        log("Start");

        SumTask task1 = new SumTask(1, 50);
        SumTask task2 = new SumTask(51, 100);
        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        // Thread1이 종료될 때까지 대기
        log("join() - main 쓰레드가 thread1, thread2 종료까지 대기");
        thread1.join();
        thread2.join();
        log("main 쓰레드 대기 종료");

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);

        int sumAll = task1.result + task2.result;
        log("sumAll = " + sumAll);
        log("End");
    }

    static class SumTask implements Runnable {

        int startValue = 0;
        int endValue = 0;
        int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);

            int sum = 0;
            for (int i = startValue; i <= endValue ; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료, result = " + result);
        }
    }
}
