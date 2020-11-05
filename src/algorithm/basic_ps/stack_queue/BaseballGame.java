package algorithm.basic_ps.stack_queue;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] strs = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints(strs));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for(String op : ops){
            if(op.equals("+")){
                int x = stack.pop();
                int y = stack.pop();

                stack.push(y);
                stack.push(x);
                stack.push(x + y);
            }else if(op.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(op.equals("C")){
                stack.pop();
            }else{
                stack.push(Integer.valueOf(op));
            }
        }

        int sum = 0;

        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        return sum;
    }
}