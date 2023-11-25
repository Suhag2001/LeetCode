package src.com.leetcode.java.threading;

import java.util.function.IntConsumer;

public class FizzBuzz1195 {

    private int n;
    private int i;

    public FizzBuzz1195(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 3 == 0 && i % 5 != 0) {
                    printFizz.run();
                    i += 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 3 != 0 && i % 5 == 0) {
                    printBuzz.run();
                    i += 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 15 == 0) {
                    printFizzBuzz.run();
                    i += 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            while (i <= n) {
                if (i % 3 != 0 && i % 5 != 0) {
                    printNumber.accept(i);
                    i += 1;
                    notifyAll();
                } else {
                    wait();
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 15; // Change this to the desired value
        FizzBuzz1195 fizzBuzz = new FizzBuzz1195(n);

        Runnable fizzRunnable = () -> System.out.print("fizz ");
        Runnable buzzRunnable = () -> System.out.print("buzz ");
        Runnable fizzBuzzRunnable = () -> System.out.print("fizzbuzz ");
        IntConsumer numberConsumer = x -> System.out.print(x + " ");

        Thread fizzThread = new Thread(() -> {
            try {
                fizzBuzz.fizz(fizzRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread buzzThread = new Thread(() -> {
            try {
                fizzBuzz.buzz(buzzRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread fizzBuzzThread = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(fizzBuzzRunnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread numberThread = new Thread(() -> {
            try {
                fizzBuzz.number(numberConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start the threads
        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();
    }
}
