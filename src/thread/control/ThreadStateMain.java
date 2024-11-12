package thread.control;

import util.MyLogger;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRuunable(), "myThread");
        MyLogger.log("myThread.state1 : " + thread.getState());
        MyLogger.log("myThread.start()");
        thread.start();
        Thread.sleep(1000);
        MyLogger.log("myThread.state3 : " + thread.getState());
        Thread.sleep(4000);
        MyLogger.log("myThread.state5 : " + thread.getState());
    }

    static class MyRuunable implements Runnable{

        @Override
        public void run() {
            try {
                MyLogger.log("start");
                MyLogger.log("myThread.state2 : " + Thread.currentThread().getState());
                MyLogger.log("sleep() start");
                Thread.sleep(3000);
                MyLogger.log("sleep() end");
                MyLogger.log("myThread.state4 : " + Thread.currentThread().getState());
                MyLogger.log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
