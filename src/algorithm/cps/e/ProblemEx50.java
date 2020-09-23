package algorithm.cps.e;

import java.util.Scanner;

public class ProblemEx50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] board = new int[h+1][w+1];

        for(int i=1; i<=h; i++){
            for(int j=1; j<=w; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = -2147000000;

        for(int i=1; i<=h-n+1; i++){
            for(int j=1; j<=w-m+1; j++){
                int sum  = 0;

                for(int k=i; k<i+n; k++){
                    for(int l=j; l<j+m; l++){
                            sum += board[k][l];
                    }
                }

                if(sum > max){
                    max = sum;
                }

            }
        }

        System.out.println(max);

    }
}

/*
// 내가 제출한 코드

 public class ProblemEx50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[][] board = new int[h][w];

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int orangeH = sc.nextInt();
        int orangeW = sc.nextInt();

        int max = -2147000000;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                int temp  = 0;

                for(int k=0; k<orangeH; k++){
                    for(int l=0; l<orangeW; l++){
                        if(i+k < h && j+l < w)
                            temp += board[i+k][j+l];
                    }
                }

                if(temp > max){
                    max = temp;
                }

            }
        }

        System.out.println(max);

    }
}

*
* */