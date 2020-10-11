package algorithm.cps.g;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProblemEx69 {
    static final int N = 7;
    static ArrayList<Integer>[] map;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, x;
        Queue<Integer> queue = new LinkedList<>();

        map = (ArrayList<Integer>[]) new ArrayList[N+1];
        check = new int[N+1]; // 방문 여부를 체크

        for (int i=1; i<=N; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i=1; i<=6; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            // 무방향 인접리스트
            map[a].add(b); // a에서 b로 갈 수 있다.
            map[b].add(a);
        }

        queue.add(1); // 1번 루트노드 큐에 넣고 방문처리
        check[1] = 1;

        while(!queue.isEmpty()){ // 큐가 비어 있지 않은 동안
            x = queue.poll();
            System.out.print(x + " "); // 방문

            for(int i=0; i<map[x].size(); i++){ // for 문을 돌면서 인접 리스트에서 x와 연결된 노드를 찾는다.
                int y = map[x].get(i);
                if (check[y] == 0) { // 방문 하지 않았다면
                    check[y] = 1; // 방문 처리
                    queue.add(y); // 노드 번호를 큐에 저장
                }
            }
        }

    }
}

/*

1 2
1 3
2 4
2 5
3 6
3 7

*/