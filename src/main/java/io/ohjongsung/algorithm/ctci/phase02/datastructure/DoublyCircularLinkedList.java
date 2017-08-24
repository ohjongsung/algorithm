package io.ohjongsung.algorithm.ctci.phase02.datastructure;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-24
 * Description : 이중 원형 연결 리스트
 */
public class DoublyCircularLinkedList<T> {
    private class Node {
        T val;
        Node prev;
        Node next;
    }

    private Node header;
    private int size;

    public DoublyCircularLinkedList() {
        header = new Node();
        header.prev = header.next = header;
        size = 0;
    }

    public boolean add(int pos, T val) {
        if (pos < 0 || pos > size) {
            return false;
        }

        Node prevNode;
        if (pos == 0) {
            prevNode = header;
        } else {
            prevNode = getNode(pos - 1);
        }
        Node newbie = new Node();
        newbie.val = val;
        if (prevNode.next != null) {
            prevNode.next.prev = newbie;
        } else {
            header.prev = newbie;
        }
        newbie.prev = prevNode;
        newbie.next = prevNode.next;
        prevNode.next = newbie;
        size++;
        return true;
    }

    public boolean addLast(T val) {
        return add(size, val);
    }

    public boolean addFirst(T val) {
        return add(0, val);
    }

    private Node getNode(int pos) {
        Node posNode = header;
        if (size / 2 >= pos) { // 앞에서부터
            for (int i = 0; i <= pos; i++) {
                posNode = posNode.next;
            }
        } else { // 뒤에서부터
            for (int i = size; i > pos; i-- ) {
                posNode = posNode.prev;
            }
        }
        return posNode;
    }

    public T get(int pos) {
        if (pos < 0 || pos > size) {
            return null;
        }
        Node posNode = getNode(pos);
        return posNode.val;
    }

    public T remove(int pos) {
        if (pos < 0 || pos > size) {
            return null;
        }
        Node posNode = getNode(pos);

        posNode.prev.next = posNode.next;
        posNode.next.prev = posNode.prev;

        T retVal = posNode.val;
        posNode = null;
        size--;
        return retVal;
    }

    public T removeLast() {
        return remove(size-1);
    }

    public T removeFirst() {
        return remove(0);
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