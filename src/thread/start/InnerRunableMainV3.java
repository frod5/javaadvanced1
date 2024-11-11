package thread.start;

import util.MyLogger;

public class InnerRunableMainV3 {

    public static void main(String[] args) {
        MyLogger.log("main() start");
        Thread thread = new Thread(() -> MyLogger.log("run() start"));
        thread.start();
        MyLogger.log("main() end");
    }

}
