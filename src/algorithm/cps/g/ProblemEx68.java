package algorithm.cps.g;

import java.util.ArrayList;
import java.util.Scanner;

// 가중치 방향 그래프를 인접 리스트로 표현 하려면 Pair라는 것을 사용 해야 한다.
class Pair { // Pair는 2개의 데이터를 한 쌍으로 묶어서 관리한다.
    int x, y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ProblemEx68 {
    static int n, m, min = 2147000000;
    static ArrayList<Pair>[] map;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 노드 개수
        m = sc.nextInt(); // 간선 개수

        map = (ArrayList<Pair>[]) new ArrayList[n+1];
        check = new int[n+1]; // 방문 여부를 체크

        for (int i=1; i<=n; i++) {
            map[i] = new ArrayList<Pair>();
        }

        for (int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            map[a].add(new Pair(b, c));
        }

        check[1] = 1; // 1번 정점을 방문

        dfs(1, 0);

        System.out.println(min);
    }

    private static void dfs(int v, int sum) {
        if(v == n){
            if(sum < min)
                min = sum;
        }else{
            for (int i=0; i < map[v].size(); i++) {  // 정점 v에 연결된 노드의 개수만큼 반복한다.
                int u = map[v].get(i).x; // 정점 v에서 갈 수 있는 다른 정점 번호
                int w = map[v].get(i).y; // 가중치

                if (check[u] == 0) { // 방문 하지 않았다면
                    check[u] = 1; // 방문 처리
                    dfs(u, sum + w);
                    check[u] = 0; // 뒤로 물러 날 때, 방문 처리 해제
                }
            }
        }
    }
}

/*
5 8
1 2 12
1 3 6
1 4 10
2 3 2
2 5 2
3 4 3
4 2 2
4 5 5
*/
