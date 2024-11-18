package thread.volatile1;

import util.MyLogger;
import util.ThreadUtils;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        MyLogger.log("runFlag = " + task.runFlag);
        thread.start();

        ThreadUtils.sleep(1000);
        MyLogger.log("runFlag를 false로 변경 시도");
        task.runFlag = false;
        MyLogger.log("runFlag = " + task.runFlag);
        MyLogger.log("main 종료");
    }

    static class MyTask implements Runnable {

        boolean runFlag = true;
//        volatile boolean runFlag = true;

        @Override
        public void run() {
            MyLogger.log("task 시작");
            while (runFlag) {
                // runFlag = false로 변하면 탈출
            }
            MyLogger.log("task 종료");
        }
    }
}
