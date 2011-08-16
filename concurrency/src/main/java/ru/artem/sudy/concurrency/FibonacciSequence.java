package com.griddynamics.genesis.dev;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class FibonacciSequence {
    private final AtomicReference<Tuple<BigInteger>> current =
            new AtomicReference<Tuple<BigInteger>>(
                    new Tuple<BigInteger>(new BigInteger("0"), new BigInteger("1")));

    BigInteger next(){
        Tuple<BigInteger> oldValue;
        Tuple<BigInteger> newValue;
        do{
            oldValue = current.get();
            newValue = new Tuple<BigInteger>(oldValue.b, oldValue.b.add(oldValue.a));
        } while (!current.compareAndSet(oldValue, newValue));

        return newValue.a;
    }

    private class Tuple<T>{
        private final T a;
        private final T b;

        public Tuple(T a, T b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence();
        for(int i=1;i<10;i++){
            System.out.println(sequence.next());
        }
    }
}
