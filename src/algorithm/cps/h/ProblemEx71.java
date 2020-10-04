package algorithm.cps.h;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProblemEx71 {
    static final int N = 10000;
    static int[] check;
    static int[] d = {1, -1, 5};

    public static void main(String[] args) {
        // 출발 점에서 도착 점까지 최소 횟수를 구하는 것은 BFS를 이용 할 수 있다.
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();

        int i, pos, x;

        Queue<Integer> queue = new LinkedList();
        check = new int[N+1];

        queue.offer(s);
        // check 배열은 방문 처리 여부 + 해당 지점까지의 최소 점프 횟수를 기록함
        check[s] = 1; // 출발 지점(s)을 방문 처리 + 점프 횟수를 1 지정

        while(!queue.isEmpty()){ // 큐가 비어 있지 않은 동안 (큐에 자료가 있다면)
            x = queue.poll(); // x : 현수가 현재 위치한 지점

            for(i=0; i<3; i++){
                pos = x + d[i]; // pos : 이동 하려는 지점 , d[i] : 한 번의 점프로 이동 할 수 있는 범위

                if(pos <= 0 || pos > N) // pos가 범위를 벗어나면 다음 반복으로 넘어감
                    continue;

                if (pos == e) { // 우리가 이동 하려는 지점(pos)이 도착 지점(e)이면
                    System.out.println(check[x]); // 이동 하기 바로 전 지점까지의 최소 점프 횟수를 출력 (출발 지점의 점프 횟수를 1로 초기화 했기 때문)
                    System.exit(0);
                }

                if(check[pos] == 0){ // 이동 하려는 지점(pos)이 한번도 방문하지 않은 지점이면
                    check[pos] = check[x] + 1; // 방문 처리를 하는데 최소 점프 횟수를 기록한다. (x 지점까지의 최소 점프 횟수 + 1)
                    queue.offer(pos);
                }
            }
        }

    }
}
