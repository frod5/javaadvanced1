package thread.start;

import util.MyLogger;

public class ManyThreadMainV1 {
    public static void main(String[] args) {
        MyLogger.log("main() start");

        HelloRunable runable = new HelloRunable();

        Thread thread1 = new Thread(runable);
        thread1.start();
        Thread thread2 = new Thread(runable);
        thread2.start();
        Thread thread3 = new Thread(runable);
        thread3.start();

        MyLogger.log("main() end");
    }
}
