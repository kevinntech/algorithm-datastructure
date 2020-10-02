package algorithm.cps.h;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ProblemEx74 {

    public static void main(String[] args) {
        // 최소 힙
        Scanner sc = new Scanner(System.in);
        int input;
        Queue<Integer> queue = new PriorityQueue<>(); // Comparator.naturalOrder()

        while(true){
            input = sc.nextInt();

            if(input == -1)
                break;

            if(input == 0) {
                if (queue.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(queue.poll());
            }else
                queue.add(input);

        }

    }
}