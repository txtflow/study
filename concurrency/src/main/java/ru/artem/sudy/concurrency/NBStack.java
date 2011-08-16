package ru.artem.sudy.concurrency;

import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author artem
 */
public class NBStack <E>{
    private AtomicReference<Node> head = new AtomicReference<Node>(new Node(null));

    public void push(E e){
        Node newNode = new Node(e);
        Node old;
        do{
            old = head.get();
            newNode.next = old;
        }while(!head.compareAndSet(old, newNode));
    }

    public E pop(){
        Node newNode;
        Node old;
        do{
            old = head.get();
                if(old == null)
                    return null;
            newNode = old.next;
        }while(!head.compareAndSet(old, newNode));
        return old.e;
    }

    private class Node{
        private final E e;
        private Node next;

        public Node(E e) {
            this.e = e;
        }
    }

}
