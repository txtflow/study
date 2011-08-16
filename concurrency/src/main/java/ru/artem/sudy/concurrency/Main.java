package ru.artem.sudy.concurrency;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author artem
 */
public class Main {

    public static void main(String[] args){
        try {
            //        ExecutorService exec = Executors.newCachedThreadPool();
            Runnable r = new Runnable() {

                public void run() {
                    try{
                    String[] importantInfo = {"1", "2", "3", "4", "5", "6", "7", "8"};
                        for (String anImportantInfo : importantInfo) {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                                //Print a message
                                System.out.println(anImportantInfo);
                            } catch (InterruptedException ex) {
                                System.out.println("InterruptedException");
                            } catch (Exception e) {
                                System.out.println("HERE: " + e);
                            }
                        }
                    }catch(ThreadDeath e){
                        System.out.println(e);
                    }
                }
            };
            //        exec.execute(r);
            Thread t = new Thread(r);
            t.start();
            TimeUnit.MILLISECONDS.sleep(2500);
            t.stop();
            TimeUnit.MILLISECONDS.sleep(10);
            System.out.println("finish");

        } catch (Exception ex) {
            System.out.println("Exception in main thread: "+ex);
        }
    }
}
