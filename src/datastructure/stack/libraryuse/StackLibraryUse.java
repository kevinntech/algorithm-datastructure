package datastructure.stack.libraryuse;

import java.util.*;

public class StackLibraryUse {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int k=0; k<n; k++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                stack.push(num);
            } else if (cmd.equals("top")) {
                if (stack.empty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            } else if (cmd.equals("size")) {
                System.out.println(stack.size());
            } else if (cmd.equals("empty")) {
                if (stack.empty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (cmd.equals("pop")) {
                if (stack.empty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            }
        }
    }
}