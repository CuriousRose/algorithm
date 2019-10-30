package leet_code.leet_code_1114.test;

/**
 * @author chj
 * @date 2019/8/9 10:33
 */
class Foo {
    volatile boolean mark2, mark3;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        mark2 = true;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (!mark2) {
        }
        printSecond.run();
        mark3 = true;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (!mark3) {
        }
        printThird.run();
    }
}