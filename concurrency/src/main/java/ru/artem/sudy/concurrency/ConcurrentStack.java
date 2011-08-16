package ru.artem.sudy.concurrency;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author artem
 */
public class ConcurrentStack<E> {

    AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(null);

    public void push(E e) {
        Node<E> oldHead;
        Node<E> newHead = new Node<E>(e);

        do{
            oldHead = head.get();
            newHead.next = oldHead;
        }while(!head.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do{
            oldHead = head.get();
            if(oldHead == null)
                return null;
            newHead = oldHead.next;
        }while(!head.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }

    static class Node<E> {

        private final E item;
        Node<E> next;

        public Node(E e) {
            this.item = e;
        }
    }
}
