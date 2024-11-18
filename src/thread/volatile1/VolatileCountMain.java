package thread.volatile1;

import util.MyLogger;
import util.ThreadUtils;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();

        ThreadUtils.sleep(1000);
        task.flag = false;
        MyLogger.log("flag = " + task.flag + ", count = " + task.count + "in main");
    }

    static class MyTask implements Runnable {

        //        boolean flag = true;
//        long count = 0;
        volatile long count = 0; // volatile 를 사용하면 캐시메모리가 아닌 메인메모리에 직접 접근 (메모리 가시성문제 해결) 성능이 조금 떨어짐.
        volatile boolean flag = true;

        @Override
        public void run() {
            while (flag) {
                count++;
                if (count % 100_000_000 == 0) {
                    MyLogger.log("flag = " + flag + ", count = " + count + "in while()");
                }
            }
            MyLogger.log("flag = " + flag + ", count = " + count + "종료");
        }
    }
}
