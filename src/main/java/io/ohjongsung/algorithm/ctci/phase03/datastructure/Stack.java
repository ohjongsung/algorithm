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

    public T peek() {
        if (size == 0) {
            throw new StackUnderflowException();
        }

        Node lastNode = bottom;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

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

    public static Stack<Integer> sort(Stack<Integer> now) {
        Stack<Integer> sorted = new Stack<>();
        while (!now.isEmptry()) {
            int tmp = now.pop();
            while (!sorted.isEmptry() && sorted.peek() > tmp) {
                now.push(sorted.pop());
            }
            sorted.push(tmp);
        }
        return sorted;
    }

    public boolean isEmptry() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node lastNode = bottom.next;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(lastNode.val);
            lastNode = lastNode.next;
            if (i < size - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
