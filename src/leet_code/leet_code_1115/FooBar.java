package leet_code.leet_code_1115;

import java.util.concurrent.Semaphore;

/**
 * @author chj
 * @date 2019/8/9 10:38
 * 多线程 信号量
 * 10:42
 */
class FooBar {
    Semaphore semaphore1 = new Semaphore(1);
    Semaphore semaphore2 = new Semaphore(0);
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore2.acquire();
            printBar.run();
            semaphore1.release();
        }
    }
}