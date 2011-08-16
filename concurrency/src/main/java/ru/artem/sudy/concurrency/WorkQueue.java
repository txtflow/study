package ru.artem.sudy.concurrency;

import java.util.LinkedList;

/**
 *
 * @author artem
 */
public class WorkQueue {

    public static void main(String[] args) {

        WorkQueue wq = new WorkQueue(5);
        for(int i=0;i<20;i++){
            wq.execute(new Runnable() {

                public void run() {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {System.out.println("sleep exception");}
                }
            });
        }

    }

    private final LinkedList<Runnable> queue;
    private final PoolWorker threads[];

    public WorkQueue(int threadsNum) {
        queue = new LinkedList<Runnable>();
        threads = new PoolWorker[threadsNum];

        for (threadsNum--; threadsNum >= 0; threadsNum--) {
            threads[threadsNum] = new PoolWorker(threadsNum);
            threads[threadsNum].start();
        }
    }

    public void execute(Runnable r) {
        synchronized (queue) {
            queue.add(r);
            queue.notify();
        }
    }

    private class PoolWorker extends Thread {

        private final int i;

        public PoolWorker(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            Runnable r;
            while (true) {
                synchronized (queue) {
                    while(queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException ignored) {}
                    }
                    r = queue.removeFirst();
                }
                try{
                    r.run();
                    System.out.println("i = "+i);
                } catch(RuntimeException e){}
            }
        }
    }
}
