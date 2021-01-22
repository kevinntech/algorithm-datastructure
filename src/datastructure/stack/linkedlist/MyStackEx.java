package datastructure.stack.linkedlist;

/* 연결 리스트를 이용한 스택 구현 */
class MyStack{

    // 연결 리스트를 담을 Node 클래스를 정의한다.
    class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;

    public void push(int data){
        // 가장 마지막 값(top)을 next로 지정하고, 포인터인 top은 가장 마지막으로 이동시킨다.
        top = new Node(data, top);
    }

    public int pop(){
        if(isEmpty())
            return -1;

        int data = top.data; // top이 가리키는 데이터를 변수에 저장한다.
        top = top.next; // 다음 노드를 top으로 만든다.
        return data;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }

        return top.data; // top이 가리키는 데이터
    }

    public boolean isEmpty(){
        return top == null;
    }
}

public class MyStackEx {

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }


    }

}