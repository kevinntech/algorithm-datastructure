package algorithm.boj.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{

    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Problem_2667 {
    /*
             (-1,0)
      (0,-1) (x, y) (0,1)
             (1, 0)
    */
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[][] a = new int[n][n];  // 지도
        int[][] group = new int[n][n]; // 방문 여부

        for(int i=0; i<n; i++){
            String temp = sc.nextLine();

            for(int j=0; j<n; j++){
                a[i][j] = temp.charAt(j) - '0';
            }
        }

        int cnt = 0; // 단지의 개수
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(a[i][j] == 1 && group[i][j] == 0) { // 지도에서 집이면서 방문 하지 않았다면
                    bfs(a, group, ++cnt, i, j, n);
                }
            }
        }

        System.out.println(cnt);

        int[] ans = new int[cnt];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(group[i][j] != 0){
                    ans[group[i][j]-1]++;
                }
            }
        }

        Arrays.sort(ans);

        for(int i=0; i<cnt; i++){
            System.out.println(ans[i]);
        }

    }

    private static void bfs(int[][] a, int[][] group, int cnt, int x, int y, int n) { // x행, y열을 방문한다.
        Queue<Pair> q = new LinkedList<>(); // 큐를 생성
        group[x][y] = cnt; // 방문 처리
        q.add(new Pair(x, y)); // 큐에 노드를 넣는다.

        while(!q.isEmpty()){
            Pair p = q.remove();

            for(int i=0; i<4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(0 <= nx && nx < n && 0 <= ny && ny < n){
                    if(a[nx][ny] == 1 && group[nx][ny] == 0){
                        group[nx][ny] = cnt;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
