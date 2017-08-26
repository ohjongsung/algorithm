package io.ohjongsung.algorithm.ctci.phase03.datastructure;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-26
 * Description : 스택 구현, bottom을 기준으로 연산한다.
 */
public class Stack<T> {
    private class Node {
        T val;
        Node next;
    }
    public static final int DEFAULT_MAX_SIZE = 100;
    private Node bottom;
    private int size;

    public Stack() {
        this.size = 0;
        this.bottom = new Node();
    }

    public T pop() {
        if (size == 0) {
            throw new StackUnderflowException();
        }
        Node lastNode = bottom;
        Node beforeLastNode = null;
        while (lastNode.next != null) {
            beforeLastNode = lastNode;
            lastNode = lastNode.next;
        }
        beforeLastNode.next = null;
        size--;
        return lastNode.val;
    }

    public void push(T val) {
        if (size == DEFAULT_MAX_SIZE) {
            throw new StackOverflowException();
        }

        Node lastNode = bottom;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        Node newbie = new Node();
        newbie.val = val;
        lastNode.next = newbie;
        size++;
    }

    public int size() {
        return size;
    }
}
