package datastructure.stack;

import java.util.Scanner;

class MyStack{
    private int top;
    private int size;
    private int[] stackArr;

    public MyStack(int size){
        this.top = 0;
        this.size = size;
        this.stackArr = new int[size];
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public boolean isFull(){
        return top == size;
    }

    public void push(int value){
        if(!isFull())
            stackArr[top++] = value;
    }

    public int peek(){
        int result;

        if(isEmpty()){
            result = -1;
        }else{
            result = stackArr[top - 1];
        }

        return result;
    }

    public int pop(){
        int result;

        if(isEmpty()){
            result = -1;
        }else{
            result = stackArr[--top];
        }
        return result;
    }

    public int size(){
        return top;
    }

}

public class MyStackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        MyStack stack = new MyStack(n);

        for (int k=0; k<n; k++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                stack.push(num);
            } else if (cmd.equals("top")) {
                System.out.println(stack.peek());
            } else if (cmd.equals("size")) {
                System.out.println(stack.size());
            } else if (cmd.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (cmd.equals("pop")) {
                System.out.println(stack.pop());
            }
        }
    }
}
