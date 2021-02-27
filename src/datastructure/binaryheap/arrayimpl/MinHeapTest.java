package datastructure.binaryheap.arrayimpl;

import java.util.Scanner;

class MinHeap {
    private final int MAX_SIZE = 1000000;
    private int[] heap = new int[MAX_SIZE];
    private int size = 0;

    public void push(int value) {
        if(size + 1 >= MAX_SIZE) { // 배열 크기를 넘어 섰을 때
            return;
        }

        heap[++size] = value;    // 힙 크기를 하나 증가 하고 마지막 노드에 value를 넣는다.
        int idx = size;

        while(idx > 1 && heap[idx] < heap[idx / 2]){   // 마지막 노드가 자신의 부모 노드 보다 작으면 swap (최소 힙)
            int temp = heap[idx / 2];
            heap[idx / 2] = heap[idx];
            heap[idx] = temp;
            idx = idx / 2;
        }
    }

    public int pop(){
        if(size == 0) // 배열이 비어있는 경우
            return 0;

        int pop = heap[1];          // 루트 노드의 값을 변수에 저장 한다.
        heap[1] = heap[size--];     // 마지막 노드의 값을 루트 노드에 옮긴 다음, 힙 크기를 1 감소 시킨다.

        int idx = 1;
        int next;

        while(true){              // 마지막 노드를 자식 노드와 비교하여 제자리를 찾는다.
            next = idx * 2;       // 왼쪽 자식 노드 부터 비교한다.

            if (next < size && heap[next] > heap[next + 1])   // 왼쪽 자식 노드 보다 오른쪽 자식 노드가 더 작다면 오른쪽 자식 노드와 교환
                next++;

            if (next > size || heap[next] > heap[idx])   // 배열 크기를 초과하거나 마지막 노드가 자식 노드 보다 작으면
                break;                                  // 교환하지 않으므로 반복문 종료

            // swap
            int temp = heap[idx];
            heap[idx] = heap[next];
            heap[next] = temp;

            idx = next;
        }

        return pop;
    }

    public boolean isEmpty(){
        boolean result;

        if(size <= 0)
            result = true;
        else
            result = false;

        return result;
    }
}

public class MinHeapTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        MinHeap heap = new MinHeap();

        while(input-- > 0){
            int x = sc.nextInt();
            if(x == 0){
                if(heap.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(heap.pop());
            }else
                heap.push(x);
        }
    }
}