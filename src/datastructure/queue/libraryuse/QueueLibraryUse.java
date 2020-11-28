package datastructure.queue.libraryuse;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/* Java는 Queue에 back 메소드가 없어서 LinkedList 클래스의 getLast()를 이용하면 됩니다. */
public class QueueLibraryUse {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> queue = new LinkedList<Integer>(); // Queue<Integer> queue = new LinkedList<Integer>();

        for (int k=0; k<n; k++) {
            String cmd = sc.next();
            if (cmd.equals("push")) {
                int num = Integer.parseInt(sc.next());
                queue.offer(num);
            } else if (cmd.equals("front")) {
                if (queue.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(queue.peek());
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
                if (queue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(queue.getLast());

            }
        }
    }
}