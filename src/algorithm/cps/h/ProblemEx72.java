package algorithm.cps.h;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProblemEx72 {
    public static void main(String args[]) {
        /*  큐를 이용하여 맨 앞의 요소를 POP 한 다음, 맨 뒤로 PUSH 한다.
            이를 반복하면서 3번째가 될 때 마다 POP을 하여 큐에서 제거한다. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int i=1; i<k; i++){ // k번이 되기 전 까지는 POP, PUSH 반복
                queue.offer(queue.poll());
            }

            queue.poll(); // k 번째(3 번쨰)가 되면 큐에서 제거

            if(queue.size() == 1) {
                System.out.println(queue.poll());
            }
        }
    }
}
