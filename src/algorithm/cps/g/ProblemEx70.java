package algorithm.cps.g;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProblemEx70 {
    static int n, m;
    static ArrayList<Integer>[] map;
    static int[] check;
    static int[] dis;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, a, b, x;
        Queue<Integer> queue = new LinkedList();

        n = sc.nextInt();
        m = sc.nextInt();

        map = (ArrayList<Integer>[]) new ArrayList[n+1];
        check = new int[n+1]; // 방문 여부를 체크
        dis = new int[n+1]; // 해당 정점까지의 최소 이 간선 수

        for (i=1; i<=n; i++) {
            map[i] = new ArrayList<>();
        }

        for(i = 1; i <= m; i++){ // 인접 리스트 만들기
            a = sc.nextInt();
            b = sc.nextInt();
            map[a].add(b); // (방향 그래프) a에서 b로 갈 수 있다.
        }

        queue.add(1);
        check[1] = 1; // 1번 정점을 방문

        while(!queue.isEmpty()){ // 큐가 비어 있지 않은 동안
            x = queue.poll();

            for(i=0; i<map[x].size(); i++){
                int y = map[x].get(i); // x와 연결된 노드
                if (check[y] == 0) { // x와 연결된 노드를 방문 하지 않았다면
                    check[y] = 1; // 방문 처리
                    queue.add(y); // x와 연결된 노드 번호를 큐에 저장
                    dis[y] = dis[x] + 1; // y 노드는 x 노드를 통해서 가기 때문에 x 노드의 최소 간선 수 + 1을 한다.
                }
            }
        }

        for(i = 2; i<=n; i++){
            System.out.println(i + " : " + dis[i]);
        }

    }
}
