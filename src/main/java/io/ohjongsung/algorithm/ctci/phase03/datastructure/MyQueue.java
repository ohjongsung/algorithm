package io.ohjongsung.algorithm.ctci.phase03.datastructure;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-27
 * Description : 두 개의 스택을 사용하여 큐를 구현하는 MyQueue 클래스를 작성해보라.
 */
public class MyQueue<T> {
    Stack<T> newest;
    Stack<T> oldest;
    int size;

    public MyQueue() {
        newest = new Stack<>();
        oldest = new Stack<>();
        this.size = 0;
    }

    public void enqueue(T val) {
        newest.push(val);
        size++;
    }

    private void shiftStacks() {
        if (oldest.isEmptry()) {
            while (!newest.isEmptry()) {
                oldest.push(newest.pop());
            }
        }
    }

    public T dequeue() {
        shiftStacks();
        size--;
        return oldest.pop();
    }

    public int size() {
        return size;
    }
}
