package ru.artem.sudy.concurrency;

/**
 *
 * @author artem
 */
public class Caster {

    public static <T> T get(){

        T t = (T)(new Object());

        if(t instanceof Integer){}

        return t;
    }

}
