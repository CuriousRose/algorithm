package leet_code.leet_code_1117;


import java.util.concurrent.Semaphore;

/**
 * @author chj
 * @date 2019/8/9 11:11
 * 多线程 信号量
 * 11:48
 */
class H2O {

    public H2O() {

    }

    Semaphore semaphoreH = new Semaphore(2);
    Semaphore semaphoreO = new Semaphore(0);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphoreH.acquire();
        releaseHydrogen.run();
        semaphoreO.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphoreO.acquire(2);
        releaseOxygen.run();
        semaphoreH.release(2);
    }
}