package io.ohjongsung.algorithm.ctci.phase02.datastructure;

import java.util.Hashtable;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-24
 * Description : 단순 연결 리스트
 */
public class SimplyLinkedList<T> {
    private class Node {
        T val;
        Node next;
    }

    // 기준이 되는 노드, val은 저장되지 않고 pos 0 위치의 노드를 가리키고만 있다.
    private Node header;
    private int size;

    public SimplyLinkedList() {
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

    // 03. 노드 삭제
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

    // 01. 중복 문자 제거
    public void removeDuplicate() {
        Hashtable table = new Hashtable();
        Node n = header.next;
        Node prev = null;
        while (n != null) {
            if (table.containsKey(n.val)) {
                prev.next = n.next;
                size--;
            } else {
                table.put(n.val, true);
                prev = n;
            }
            n = n.next;
        }
    }

    // 02. 뒤에서 k번째 원소 찾기 : size 아는 경우
    public T getFromEndPos(int posFromEnd) {
        if (posFromEnd < 0 || posFromEnd > size) {
            return null;
        }
        int pos = size - posFromEnd;

        return get(pos);
    }

    // 02. 뒤에서 k번째 원소 찾기 : size 모르는 경우
    public T getFromEndPosWithoutSize(int posFromEnd) {
        if (posFromEnd < 0 || posFromEnd > size) {
            return null;
        }
        Node p1 = header;
        Node p2 = header;

        for (int i = 0; i < posFromEnd - 1; i++) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.val;
    }

    // 07. 회문(palindrome)
    public boolean isPalindrome() {
        for (int i = 0; i < size / 2; i++) {
            if (get(i) != get(size - 1 - i)) {
                return false;
            }
        }
        return true;
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
