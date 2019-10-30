package leet_code.leet_code_1114;

import java.util.concurrent.CountDownLatch;

/**
 * @author chj
 * @date 2019/8/9 10:09
 * 多线程
 * 10:30
 */
class Foo {
    CountDownLatch latch2 = new CountDownLatch(1);
    CountDownLatch latch3 = new CountDownLatch(1);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        latch2.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        latch2.await();
        printSecond.run();
        latch3.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        latch3.await();
        printThird.run();
    }
}