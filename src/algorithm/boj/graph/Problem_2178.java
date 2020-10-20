package algorithm.boj.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2178 {
    static int[][] a;
    static int[][] dist; // 시작 위치에서 부터 도착 위치까지의 거리 배열
    static boolean[][] check;
    static int n, m;

    /*
            (-1, 0)
     (0,-1) [x, y] (0, 1)
            (1, 0)
    */

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        a = new int[n][m];
        dist = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++){
            String s = sc.nextLine();

            for(int j=0; j<m; j++){
                a[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(dist[n-1][m-1]);

    }

    private static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        check[x][y] = true;
        dist[x][y] = 1; // 문제에서 칸을 셀 때에는 시작 위치도 포함 한다고 하였다. 1로 초기화

        while(!q.isEmpty()){
            Pair p = q.remove();
            x = p.x;    // 큐에서 꺼낼 때 마다 좌표를 갱신 해주어야 한다.
            y = p.y;

            for(int k=0; k<4; k++){
                int nx = p.x + dx[k]; // 내가 이동하려는 지점(nx, ny)
                int ny = p.y + dy[k];

                if(0 <= nx && nx < n && 0 <= ny && ny < m){ // 내가 이동하려는 지점이 문제의 범위를 넘지 않는다면
                    if(a[nx][ny] == 1 && check[nx][ny] == false){ // 이동 할 수 있는 칸이면서 방문 한 적이 없다면
                        q.add(new Pair(nx, ny));
                        check[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                    }
                }

            }
        }

    }
}
