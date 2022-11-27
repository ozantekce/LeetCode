package Print_in_Order_1114;

class Foo {

    public Foo() {

    }

    private boolean waitThird = true;
    private boolean waitSecond = true;
    private boolean waitFirst = false;

    public void first(Runnable printFirst) throws InterruptedException {
        while(waitFirst){
            Thread.sleep(1);
        }
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        waitFirst = true;
        waitSecond = false;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(waitSecond){
            Thread.sleep(1);
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        waitSecond = true;
        waitThird = false;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(waitThird){
            Thread.sleep(1);
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        waitThird = true;
        waitFirst =false;
    }


    public static void busySleep(long nanos)
    {
        long elapsed;
        final long startTime = System.nanoTime();
        do {
            elapsed = System.nanoTime() - startTime;
        } while (elapsed < nanos);
    }

}