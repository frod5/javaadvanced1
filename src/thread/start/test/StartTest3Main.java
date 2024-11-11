package thread.start.test;

import util.MyLogger;

public class StartTest3Main {

    public static void main(String[] args) {

        new Thread(new PrintWork("A", 1000), "Thread-A").start();
        new Thread(new PrintWork("B", 500), "Thread-B").start();
    }

    static class PrintWork implements Runnable {
        private final String content;
        private final int sleeMs;

        public PrintWork(String content, int sleeMs) {
            this.content = content;
            this.sleeMs = sleeMs;
        }

        @Override
        public void run() {
            while (true) {
                MyLogger.log(content);
                try {
                    Thread.sleep(sleeMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
