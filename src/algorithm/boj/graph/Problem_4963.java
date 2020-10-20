package algorithm.boj.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_4963 {
    /*
        (-1, -1) (-1, 0) (-1, 1)
        (0, -1)  [x, y]  (0, 1)
        (1, -1)  (1, 0)  (1, 1)

    */
    static int[][] a;
    static int[][] group;
    static int m, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            m = sc.nextInt(); // 문제를 잘 읽자! 너비(w)는 열(m)이며
            n = sc.nextInt(); // 높이(h)는 행(n)이다.

            if(n == 0 && m == 0)
                break;

            a = new int[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    a[i][j] = sc.nextInt();
                }
            }

            int cnt = 0; // 섬의 개수
            group = new int[n][m];

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(a[i][j] == 1 && group[i][j] == 0) {
                        bfs(i, j, ++cnt);
                    }
                }
            }

            System.out.println(cnt);
        }

    }

    private static void bfs(int x, int y, int cnt) { // x행, y열에 대해서 방문한다.
        Queue<Pair> q = new LinkedList<>(); // 큐를 생성
        q.add(new Pair(x, y)); // 시작점을 큐에 넣는다.
        group[x][y] = cnt; // 방문 처리

        while(!q.isEmpty()){
            Pair p = q.remove();

            for(int k = 0; k < 8; k++){
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];

                if(0 <= nx && nx < n && 0 <= ny && ny < m){
                    if(a[nx][ny] == 1 && group[nx][ny] == 0){ // 이동하려는 지점이 지도에서 땅이면서 방문한적이 없다면
                        q.add(new Pair(nx, ny));
                        group[nx][ny] = cnt;
                    }
                }
            }

        }

    }
}
