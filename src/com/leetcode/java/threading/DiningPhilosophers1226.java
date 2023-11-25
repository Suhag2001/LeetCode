package src.com.leetcode.java.threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers1226 {

    private Lock leftForkLock = new ReentrantLock();
    private Lock rightForkLock = new ReentrantLock();

    public DiningPhilosophers1226() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        while (true) {
            if (leftForkLock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    pickLeftFork.run();

                    if (rightForkLock.tryLock(100, TimeUnit.MILLISECONDS)) {
                        try {
                            pickRightFork.run();
                            eat.run();
                            putRightFork.run();

                            /*
                             * we have eaten
                             */
                            return;
                        } finally {
                            rightForkLock.unlock();
                        }
                    }

                } finally {
                    putLeftFork.run();
                    leftForkLock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        DiningPhilosophers1226 diningPhilosophers = new DiningPhilosophers1226();

        for (int i = 0; i <= 5; i++) {
            final int philosopher = i;

            Runnable pickLeftFork = () -> System.out.println("Philosopher " + philosopher + " picks up left fork");
            Runnable pickRightFork = () -> System.out.println("Philosopher " + philosopher + " picks up right fork");
            Runnable eat = () -> System.out.println("Philosopher " + philosopher + " eats");
            Runnable putLeftFork = () -> System.out.println("Philosopher " + philosopher + " puts down left fork");
            Runnable putRightFork = () -> System.out.println("Philosopher " + philosopher + " puts down right fork");

            Thread philosopherThread = new Thread(() -> {
                try {
                    diningPhilosophers.wantsToEat(philosopher, pickLeftFork, pickRightFork, eat, putLeftFork, putRightFork);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            philosopherThread.start();
        }
    }
}
