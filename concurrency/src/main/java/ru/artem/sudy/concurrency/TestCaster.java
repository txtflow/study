package ru.artem.sudy.concurrency;

import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 *
 * @author artem
 */
public class TestCaster {

    public static void main(String[] args) {
        Class c1 = (new ArrayList()).getClass();

        Class c2 = (new ArrayList<String>()).getClass();

        System.out.println(c1.toString());
        System.out.println(c2.toString());

        System.out.println(c1.equals(c2));

        ScheduledThreadPoolExecutor a = new ScheduledThreadPoolExecutor(4);
    }

}
