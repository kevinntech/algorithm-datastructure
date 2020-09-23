package algorithm.cps.e;

import java.util.Scanner;

public class ProblemEx48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum, temp, nearNum = 0 , nearIdx = 0, avg, diff;
        int[][] board = new int[9][9];

        for(int i=0; i<9; i++){
            sum = 0;

            for(int j=0; j<9; j++){
                board[i][j] = sc.nextInt();
                sum += board[i][j];
            }

            avg = (int) (Math.round(sum / 9.0));

            System.out.print(avg + " ");

            diff = 2147000000;

            for(int j=0; j<9; j++) {
                temp = Math.abs(board[i][j] - avg);

                if (temp < diff) {
                    diff = temp;
                    nearNum = board[i][j];
                }else if(temp == diff){ // 평균과 가까운 값이 두 값이면 그 중 큰 값을 출력한다.
                    if(board[i][j] > nearNum)
                        nearNum = board[i][j];
                }
            }

            System.out.println(nearNum);
        }

    }
}
