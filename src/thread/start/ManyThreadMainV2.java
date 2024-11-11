package thread.start;

import util.MyLogger;

public class ManyThreadMainV2 {
    public static void main(String[] args) {
        MyLogger.log("main() start");

        HelloRunable runable = new HelloRunable();

        for (int i = 0; i < 100; i++) {
            Thread thread1 = new Thread(runable);
            thread1.start();
        }

        MyLogger.log("main() end");
    }
}
