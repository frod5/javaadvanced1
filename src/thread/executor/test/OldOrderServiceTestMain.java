package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class OldOrderServiceTestMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OldOrderService oldOrderService = new OldOrderService();
        oldOrderService.order("Order#1234");
    }
}
