package datastructure.queue;

import java.util.Scanner;

class MyQueue{
    private int front, rear;
    private int size;
    private int[] queueArr;

    // 큐 초기화
    public MyQueue(int size){
        this.front = 0;
        this.rear = 0;
        this.size = size;
        this.queueArr = new int[size];
    }

    // front와 rear가 이동해야 할 위치를 알려주는 메서드
    int nextPosIdx(int pos){
        if(pos == size - 1) //pos가 배열의 마지막 요소를 가리키면 처음 요소로 돌아간다.
            return 0;
        else
            return pos + 1;
    }

    // 큐가 가득 찼는지 체크
    public boolean isFull(){
        return nextPosIdx(rear) == front; // rear의 다음 위치에 front가 있다면 큐가 가득찬 상태
    }

    // 큐가 비어 있는지 체크
    public boolean isEmpty(){
        return front == rear; // front와 rear가 동일한 위치를 가리키면 텅 빈 상태
    }

    // 큐에 item 추가
    public void offer(int value){
        if(!isFull()) {
            rear = nextPosIdx(rear);
            queueArr[rear] = value; // rear을 이동 시키고 그 위치에 데이터 저장
        }
    }

    // 큐에서 item 제거
    public int poll() {
        if (isEmpty()) {
            return -1;
        } else {
            front = nextPosIdx(front);
            return queueArr[front]; // front를 이동 시키고 그 위치의 데이터 반환
            // front가 가리키는 요소는 지워진 데이터라 판단한다.
        }
    }

    public int size() {
        return rear - front;
    }

    public int front() {
        if (isEmpty())
            return -1;
        else
            return queueArr[nextPosIdx(front)];
    }

    public int rear() {
        if (isEmpty())
            return -1;
        else
            return queueArr[rear];
    }

}

public class MyQueueTest {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MyQueue queue = new MyQueue(n);

        for (int k = 0; k < n; k++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                queue.offer(num);
            } else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.front());
                }
            } else if (cmd.equals("size")) {
                System.out.println(queue.size());
            } else if (cmd.equals("empty")) {
                if (queue.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (cmd.equals("pop")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.poll());
                }
            } else if (cmd.equals("back")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.rear());
                }
            }
        }
    }
}