package io.ohjongsung.algorithm.ctci.phase03.datastructure;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-26
 * Description : 스택 구현, top을 기준으로 연산한다.
 */
public class StackBetter<T> {
    private class Node {
        T val;
        Node next;
    }

    public static final int DEFAULT_MAX_SIZE = 100;
    private Node top;
    private int size;

    public StackBetter() {
        this.size = 0;
        this.top = new Node();
    }

    public T pop() {
        if (size == 0) {
            throw new StackUnderflowException();
        }
        T retVal = top.val;
        top = top.next;
        size--;
        return retVal;
    }

    public T peek() {
        if (size == 0) {
            throw new StackUnderflowException();
        }

        return top.val;
    }

    public void push(T val) {
        if (size == DEFAULT_MAX_SIZE) {
            throw new StackOverflowException();
        }

        Node newbie = new Node();
        newbie.val = val;

        newbie.next = top;
        top = newbie;
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
}
