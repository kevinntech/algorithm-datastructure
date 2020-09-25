package algorithm.cps.f;

import java.util.Scanner;
import java.util.Stack;

public class ProblemEx54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();

        String str = sc.nextLine();
        char ch;

        for(int i=0; i<str.length(); i++){
            ch = str.charAt(i);

            if(ch == '(')
                stack.push(ch);
            else {
                if (stack.isEmpty()) { // 닫는 괄호인데 스택이 비어 있다면
                    System.out.println("NO");
                    System.exit(0);
                } else {
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty())
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
