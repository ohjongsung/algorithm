package io.ohjongsung.algorithm.ctci.phase03.datastructure;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-26
 * Description : 큐 구현
 */
public class Queue<T> {
    private class Node {
        T val;
        Node next;
    }

    public static final int DEFAULT_MAX_SIZE = 100;
    private Node last;
    private int size;

    public void enqueue(T val) {
        if (size == DEFAULT_MAX_SIZE) {
            throw new QueueOverflowException();
        }
        Node newbie = new Node();
        newbie.val = val;

        if (last == null) {
            last = newbie;
        } else {
            newbie.next = last;
            last = newbie;
        }
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new QueueUnderflowException();
        }
        Node first = last;
        Node beforeFirst = last;
        while (first.next != null) {
            beforeFirst = first;
            first = first.next;
        }
        T retVal = first.val;
        beforeFirst.next = null;

        size--;
        if (size == 0) {
            last = null;
        }
        return retVal;
    }

    public T peek() {
        if (size == 0) {
            throw new QueueUnderflowException();
        }
        Node first = last;
        while (first.next != null) {
            first = first.next;
        }
        T retVal = first.val;
        return retVal;
    }

    public int size() {
        return size;
    }
}
