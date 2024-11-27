package thread.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV6 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV6(int initBalance) {
        this.balance = initBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래시작: " + getClass().getSimpleName());

        try {
            if (!lock.tryLock(500, TimeUnit.MILLISECONDS)) {
                log("[진입 실패] 이미 처리중인 작업이 있습니다.");
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            // === 임계 영역 start ====
            log("[검증 시작] 출금액: " + amount + ", 잔액 : " + balance);
            // 잔고가 출금액보다 적으면, 진행하면 안됨
            if(balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액 : " + balance);
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액 : " + balance);

            sleep(1000); // 출금의 걸리는 시간
            balance -= amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액 : " + balance);
            // === 임계 영역 end ====

        }finally {
            lock.unlock();
        }

        log("거래종료: " + getClass().getSimpleName());
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}
