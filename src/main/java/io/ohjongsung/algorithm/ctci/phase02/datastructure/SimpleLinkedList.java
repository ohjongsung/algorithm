package io.ohjongsung.algorithm.ctci.phase02.datastructure;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-24
 * Description : 단순 연결 리스트
 */
public class SimpleLinkedList<T> {
    private class Node {
        T val;
        Node next;
    }

    // 기준이 되는 노드, val은 저장되지 않고 pos 0 위치의 노드를 가리키고만 있다.
    private Node header;
    private int size;

    public SimpleLinkedList() {
        header = new Node();
        size = 0;
    }

    public boolean add(int pos, T val) {
        if (pos < 0 || pos > size) {
            return false;
        }

        Node posNode = header;
        for (int i = 0; i < pos; i++) {
            posNode = posNode.next;
        }
        Node newbie = new Node();
        newbie.val = val;
        newbie.next = posNode.next;
        posNode.next = newbie;
        size++;
        return true;
    }

    public boolean addLast(T val) {
        return add(size, val);
    }

    public T remove(int pos) {
        if (pos < 0 || pos > size) {
            return null;
        }

        Node prePosNode = null;
        Node posNode = header;
        for (int i = 0; i < pos; i++) {
            prePosNode = posNode;
            posNode = posNode.next;
        }

        prePosNode.next = posNode.next;
        T retVal = posNode.val;
        posNode = null;
        size--;
        return retVal;
    }

    public T get(int pos) {
        if (pos < 0 || pos > size) {
            return null;
        }

        // 시작은 pos 0에서 즉, header 다음 노드부터 루프 돌아야 한다.
        Node posNode = header.next;
        for (int i = 0; i < pos; i++) {
            posNode = posNode.next;
        }
        return posNode.val;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i < size - 1) {
                sb.append(',');
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
