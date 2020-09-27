package algorithm.cps.g;

import java.util.Scanner;

public class ProblemEx65 {
    static final int N = 7;
    static int[][] map = new int[N+1][N+1];
    static int[][] check = new int[N+1][N+1];
    static int[] dx = { -1, 0, 1, 0};
    static int[] dy = { 0, 1, 0, -1};
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i=1; i<=N; i++){ // 격자판 정보를 입력 받음
            for(int j=1; j<=N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        check[1][1] = 1; // 1행 1열 부터 출발
        dfs(1, 1);
        System.out.println(cnt);
    }

    private static void dfs(int x , int y) {
        int nextX, nextY;

        if(x == N && y == N){ // 종료 지점
           cnt++;
        }else{
            for(int i=0; i<4; i++){
                nextX = x + dx[i]; // 이동 할 좌표는 현재 X 좌표 + dx[i]
                nextY = y + dy[i]; // 이동 할 좌표는 현재 Y 좌표 + dy[i]

                if(nextX < 1 || nextX > N || nextY < 1 || nextY > N) // 격자의 범위를 벗어나면 다음 반복으로 넘어감
                    continue;

                if(map[nextX][nextY] == 0 && check[nextX][nextY] == 0) { // 방문 하려고 하는 지점이 통로이고 방문 하지 않았다면
                    check[nextX][nextY] = 1;
                    dfs(nextX , nextY);
                    check[nextX][nextY] = 0;
                }
            }
        }
    }
}

/*

0 0 0 0 0 0 0
0 1 1 1 1 1 0
0 0 0 1 0 0 0
1 1 0 1 0 1 1
1 1 0 0 0 0 1
1 1 0 1 1 0 0
1 0 0 0 0 0 0

 */