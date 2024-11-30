package thread.executor.future;

import util.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;

public class CallableMainV1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        log("result Value = " + result);
        es.close();
    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() {
            log("Callable 시작");
            ThreadUtils.sleep(2000);
            int value = new Random().nextInt(10);
            log("create Value = " + value);
            log("Callable 완료");
            return value;
        }
    }
}