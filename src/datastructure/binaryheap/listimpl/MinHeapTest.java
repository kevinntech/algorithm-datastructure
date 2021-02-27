package datastructure.binaryheap.listimpl;

import java.util.ArrayList;
import java.util.List;

class MinHeap {

    private List<Integer> items;

    public MinHeap(){
        items = new ArrayList<>();
        items.add(0); // 인덱스 0을 채우기 (인덱스 1번 부터 사용 하도록 한다.)
    }

    public int len(){
        return items.size() - 1;
    }

    public void heapifyUp() {
        int i = len();
        int parent = i / 2;

        // 비교 할 부모 노드가 있는 동안에는 반복한다.
        while(parent > 0){
            // 새로운 요소(i)가 부모 노드(parent)의 값 보다 작으면 swap을 한다.
            if(items.get(i) < items.get(parent)){
                int temp = items.get(parent);
                items.set(parent, items.get(i));
                items.set(i, temp);
            }

            i = parent;     // 새로운 요소(i)의 위치는 부모 노드의 인덱스로 변경한다.
            parent = i / 2; // 부모 노드의 위치는 i의 부모 노드의 인덱스로 변경한다.
        }
    }

    public void insert(int value) {
        items.add(value); // 새로운 요소를 삽입한다.
        heapifyUp(); // 힙 성질을 만족 하도록 한다.
    }

    public void heapifyDown(int idx) {
        int left = idx * 2;         // 왼쪽 자식 노드 인덱스
        int right = idx * 2 + 1;    // 오른쪽 자식 노드 인덱스
        int smallest = idx;         // 가장 작은 값을 가지는 노드의 위치(smallest)는 부모 노드 인덱스로 초기화한다.

        // smallest는 각각 왼쪽과 오른쪽 자식 노드와 비교하여 더 작다면 해당 인덱스로 변경한다.
        if (left <= len() && items.get(left) < items.get(smallest))
            smallest = left;

        if (right <= len() && items.get(right) < items.get(smallest))
            smallest = right;

        /*
        * smallest가 변경 되었다면 서로 값을 스왑하고 다시 재귀 호출한다.
        * 즉, 힙 성질을 만족할 때까지 계속 반복해서 재귀 호출한다.
        * */
        if (smallest != idx){
            int temp = items.get(idx);
            items.set(idx, items.get(smallest));
            items.set(smallest, temp);

            heapifyDown(smallest);
        }
    }

    public int extract() {
        int extracted = items.get(1); // 루트 노드의 값을 추출한다.

        // 루트 노드에 마지막 노드의 값을 옮기고 마지막 노드를 삭제한다.
        items.set(1, items.get(len()));
        items.remove(len());

        // 힙 성질을 만족 하도록 한다.
        heapifyDown(1);

        // 루트 노드의 값을 반환한다.
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

public class MinHeapTest {

    public static void main(String[] args) {
        System.out.println("최소 힙은 다음과 같이 구성되어 있습니다.");

        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();

        System.out.println("최소 값은 " + minHeap.extract() + "입니다.");
    }
}