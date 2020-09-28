package algorithm.cps.g;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProblemEx66 {
    static int n, m, cnt;
    static ArrayList<Integer>[] map;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 노드 개수
        m = sc.nextInt(); // 간선 개수

        map = (ArrayList<Integer>[]) new ArrayList[n+1];
        check = new int[n+1]; // 방문 여부를 체크

        for (int i=1; i<=n; i++) {
            map[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            map[u].add(v);
        }

        check[1] = 1; // 1번 정점을 방문

        dfs(1);

        System.out.println(cnt);
    }

    private static void dfs(int v) {
        if(v == n){
            cnt++;
        }else{

            for (int i=0; i < map[v].size(); i++) {    // 노드 x와 연결된 인접한 노드 중 방문 하지 않은 노드를 방문 합니다.
                int y = map[v].get(i);
                if (check[y] == 0) { // 방문 하지 않았다면
                    check[y] = 1; // 방문 처리
                    dfs(y);
                    check[y] = 0; // 뒤로 물러 날 때, 방문 처리 해제
                }
            }

            /*
            // 또 다른 방법
            for (int y : map[v]) {    // 노드 x와 연결된 인접한 노드 중 방문 하지 않은 노드를 방문 합니다.
                if (check[y] == 0) {
                    check[y] = 1; // 방문 처리
                    dfs(y);
                    check[y] = 0; // 뒤로 물러 날 때, 방문 처리 해제
                }
            }
            */
        }
    }
}
