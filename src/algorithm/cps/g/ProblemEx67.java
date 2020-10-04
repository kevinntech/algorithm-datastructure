package algorithm.cps.g;

import java.util.Scanner;

public class ProblemEx67 {
    static int n, m, min = 2147000000;
    static int[][] map;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, a, b, c;

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n+1][n+1];
        check = new int[n+1]; // 방문 여부를 체크하는 배열

        for(i = 1; i <= m; i++){ // 인접 행렬 만들기
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            map[a][b] = c; // a에서 b로 가는 정점
        }

        check[1] = 1; // 1번 정점을 방문
        dfs(1, 0);

        System.out.println(min);
    }

    private static void dfs(int v, int sum) { // sum : 누적 가중치
        if(v == n){ // 종료 지점이면
            if(sum < min)
                min = sum;
        }else{
            for(int i=1; i<=n; i++){
                if(map[v][i] > 0 && check[i] == 0) {  // 현재 정점(v)에서 i 정점으로 갈 수 있고 (가중치가 0보다 크다면) 방문하지 않았다면
                    check[i] = 1; // 방문 처리
                    dfs(i, sum + map[v][i]); // sum에 가중치 값을 누적한다.
                    check[i] = 0; // 방문 처리 해제
                }
            }
        }
    }
}
