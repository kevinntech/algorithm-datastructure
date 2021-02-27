package datastructure.binaryheap.listimpl;

import java.util.ArrayList;
import java.util.List;

class MaxHeap {

    private List<Integer> items;

    public MaxHeap(){
        items = new ArrayList<>();
        items.add(0); // 인덱스 0을 채우기 (인덱스 1번 부터 사용 하도록 한다.)
    }

    public int len(){
        return items.size() - 1;
    }

    public void heapifyUp() {
        int i = len();
        int parent = i / 2;

        while(parent > 0){
            if(items.get(i) > items.get(parent)){ // ** 최대 힙
                int temp = items.get(parent);
                items.set(parent, items.get(i));
                items.set(i, temp);
            }

            i = parent;
            parent = i / 2;
        }
    }

    public void insert(int value) {
        items.add(value);
        heapifyUp();
    }

    public void heapifyDown(int idx) {
        int left = idx * 2;
        int right = idx * 2 + 1;
        int largest = idx;

        if (left <= len() && items.get(left) > items.get(largest)) // ** 최대 힙
            largest = left;

        if (right <= len() && items.get(right) > items.get(largest)) // ** 최대 힙
            largest = right;

        if (largest != idx){
            int temp = items.get(idx);
            items.set(idx, items.get(largest));
            items.set(largest, temp);
            heapifyDown(largest);
        }
    }

    public int extract() {
        int extracted = items.get(1);

        // 루트 노드에 마지막 값 넣고 마지막 값 삭제
        items.set(1, items.get(len()));
        items.remove(items.size() - 1);

        heapifyDown(1);

        return extracted;
    }

    /*
    * 힙에 저장된 요소를 출력한다.
    * */
    public void print(){
        for (int i = 1; i <= len() / 2; i++) {
            System.out.print(" 부모 노드 : " + items.get(i)
                    + ", 왼쪽 자식 노드 : " + items.get(i * 2)
                    + ", 오른쪽 자식 노드 : " + items.get(i * 2 + 1));
            System.out.println();
        }
    }

}

public class MaxHeapTest {

    public static void main(String[] args) {
        System.out.println("최대 힙은 다음과 같이 구성되어 있습니다.");

        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();

        System.out.println("최대 값은 " + maxHeap.extract() + "입니다.");
    }
}