package algorithm.cps.h;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ProblemEx73 {

    public static void main(String[] args) {
        // 최대 힙
        Scanner sc = new Scanner(System.in);
        int input;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

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
                queue.offer(input);
        }

    }

}

/*

5
3
6
0
5
0
2
4
0
-1


*/