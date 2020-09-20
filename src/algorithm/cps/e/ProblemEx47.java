package algorithm.cps.e;

import java.util.Scanner;

public class ProblemEx47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        boolean isAnswer;
        int n = sc.nextInt();
        int[][] map = new int[n+2][n+2];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        // 격자판 정보를 입력 받는다.
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        // 이중 for문을 반복하면서 탐색을 한다.
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                isAnswer = true;

                for(int k = 0; k < 4; k++){
                    if(map[i][j] <= map[i + dx[k]][j + dy[k]]){ // 자신의 상하좌우 보다 작거나 같으면 봉우리가 아니다.
                        isAnswer = false;
                        break;
                    }
                }

                if(isAnswer == true) // 봉우리 이면 개수 증가
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
