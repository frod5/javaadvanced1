package thread.control;

import thread.start.HelloRunable;
import util.MyLogger;

public class ThreadInfoMain {

    public static void main(String[] args) {
        //main 쓰레드
        Thread main = Thread.currentThread();
        MyLogger.log("mainThread = " + main);
        MyLogger.log("mainThread.threadId() = " + main.threadId());
        MyLogger.log("mainThread.getName() = " + main.getName());
        MyLogger.log("mainThread.getPriority() = " + main.getPriority());
        MyLogger.log("mainThread.getThreadGroup() = " + main.getThreadGroup());
        MyLogger.log("mainThread.getState() = " + main.getState());

        //my 쓰레드
        Thread myThread = new Thread(new HelloRunable(), "myThread");
        MyLogger.log("myThread = " + myThread);
        MyLogger.log("myThread.threadId() = " + myThread.threadId());
        MyLogger.log("myThread.getName() = " + myThread.getName());
        MyLogger.log("myThread.getPriority() = " + myThread.getPriority());
        MyLogger.log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
        MyLogger.log("myThread.getState() = " + myThread.getState());

    }
}
