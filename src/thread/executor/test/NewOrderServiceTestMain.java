package thread.executor.test;

import java.util.concurrent.ExecutionException;

public class NewOrderServiceTestMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NewOrderService newOrderService = new NewOrderService();
        newOrderService.order("Order#1234");
    }
}
