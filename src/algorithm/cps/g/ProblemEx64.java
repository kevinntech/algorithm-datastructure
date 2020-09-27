package algorithm.cps.g;

import java.util.Scanner;

public class ProblemEx64 {
    static int n, m, cnt;
    static int[][] map;
    static int[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, i, a, b;

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n+1][n+1];
        check = new int[n+1]; // 방문 여부를 체크

        for(i = 1; i <= m; i++){ // 인접 행렬 만들기
            a = sc.nextInt();
            b = sc.nextInt();
            map[a][b] = 1;
        }

        check[1] = 1; // 1번 정점을 방문

        dfs(1);

        System.out.println(cnt);
    }

    private static void dfs(int v) {
        if(v == n){
            cnt++;
        }else{
            for(int i=1; i<=n; i++){
                if(map[v][i] == 1 && check[i] == 0) { // 현재 정점(v)에서 i 정점으로 갈 수 있고 방문하지 않았다면
                    check[i] = 1; // 방문 처리
                    dfs(i);
                    check[i] = 0; // 뒤로 물러 날 때, 방문 처리 해제
                }
            }
        }
    }
}
