package thread.executor.future;

import util.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.log;

public class CallableMainV2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("submit() call");
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시 반환, future = " + future);
        log("future.get() [블로킹] 메소드 호출 시작 -> main 쓰레드 WAITING");
        Integer result = future.get();
        log("future.get() [블로킹] 메소드 완료 -> main 쓰레드 RUNNABLE");
        log("result Value = " + result);
        log("future 완료, future = " + future);
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
