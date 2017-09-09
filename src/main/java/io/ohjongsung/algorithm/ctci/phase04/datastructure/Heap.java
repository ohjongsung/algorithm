package io.ohjongsung.algorithm.ctci.phase04.datastructure;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description : Heap 자료구조 구현
 */
public class Heap {
    private int size;
    private int items[];

    public Heap() {
        size = 0;
        items = new int[50];
    }

    public void insertHeap(int item) {
        int i = ++size;

        while (i != 1 && item > items[i / 2]) {
            items[i] = items[i / 2];
            i /= 2;
        }
        items[i] = item;
    }

    public int getSize() {
        return this.size;
    }

    public int deleteHeap() {
        int parent, child;
        int item, temp;

        item = items[1];
        temp = items[size--];
        parent = 1;
        child = 2;

        while (child <= size) {
            if (child < size && items[child] < items[child + 1]) { // 자식둘 중 큰 값을 찾는 연산
                child++;
            }
            if (temp >= items[child]) { // 자식보다 크거나 같으니 현재 위치 유지
                break;
            }
            items[parent] = items[child];
            parent = child;
            child *= 2;
        }

        items[parent] = temp;
        return item;
    }
}
