package algorithm.cps.e;

import java.util.Scanner;

public class ProblemEx49 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, j, sum = 0;
        int[][] board = new int[n+1][n+1];
        int[] num = new int[n+1];

        for(i=1; i<=n; i++) // 정면 숫자를 1차원 배열에 저장
            num[i] = sc.nextInt();

        for(i=1; i<=n; i++){
            for(j=1; j<=n; j++){
                board[j][i] = num[i]; // 행 번호는 변경 되며 열 번호는 i로 고정
            }
        }

        for(i=n; i>=1; i--) // 오른쪽 측면 정보는 거꾸로 입력 받음
            num[i] = sc.nextInt(); // num 배열을 재사용

        for(i=1; i<=n; i++){
            for(j=1; j<=n; j++){ // 행은 고정되고 열은 변경되면서 탐색 (원래 배열 탐색 하듯이)
                if(board[i][j] > num[i]) // 위에서 채워 놓은 숫자 중 오른쪽 측면 숫자 보다 큰 숫자가 있다면 변경
                    board[i][j] = num[i];
            }
        }

        for(i=1; i<=n; i++){
            for(j=1; j<=n; j++){
                sum += board[i][j];
            }
        }

        System.out.println(sum);
    }
}
