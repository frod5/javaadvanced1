package thread.start;

import util.MyLogger;

public class InnerRunableMainV2 {

    public static void main(String[] args) {
        MyLogger.log("main() start");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                MyLogger.log("run() start");
            }
        });
        thread.start();
        MyLogger.log("main() end");
    }

}
