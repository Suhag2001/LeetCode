package src.com.leetcode.java.threading;

public class PrintInOrder1114 {

    public PrintInOrder1114() {
    }

    int count = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            this.count++;
            printFirst.run();
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while (this.count < 1) {
                wait();
            }
            this.count++;
            printSecond.run();
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while (this.count < 2) {
                wait();
            }
            printThird.run();
            notifyAll();
        }
    }

    public static void main(String[] args) {
        PrintInOrder1114 printInOrder1114 = new PrintInOrder1114();

        Runnable runnable1 = () -> System.out.print("First ");
        Runnable runnable2 = () -> System.out.print("Second ");
        Runnable runnable3 = () -> System.out.print("Third ");

        Thread thread1 = new Thread(() -> {
            try {
                printInOrder1114.first(runnable1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                printInOrder1114.second(runnable2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                printInOrder1114.third(runnable3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads in the correct order

        thread2.start();
        thread3.start();
     thread1.start();
    }
}
