package leet_code.leet_code_1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author chj
 * @date 2019/8/9 10:53
 * 多线程 信号量
 * 11:08
 */
class ZeroEvenOdd {
    private int n;

    Semaphore semaphoreZero = new Semaphore(1);
    Semaphore semaphoreEven = new Semaphore(0);
    Semaphore semaphoreOdd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphoreZero.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaphoreEven.release();
            } else {
                semaphoreOdd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaphoreEven.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            semaphoreOdd.acquire();
            printNumber.accept(i);
            semaphoreZero.release();
        }
    }
}
