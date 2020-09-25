package algorithm.cps.f;

import java.util.Scanner;

public class ProblemEx51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h, w, n, m, i, j, temp, max = -2147000000;
        h = sc.nextInt();
        w = sc.nextInt();
        int[][] a = new int[h+1][w+1];
        int[][] dy = new int[h+1][w+1];

        for(i=1; i<=h; i++){
            for(j=1; j<=w; j++){
                a[i][j] = sc.nextInt();
                // dy의 윗쪽, 왼쪽, 중복되는 부분을 빼고 방금 읽은 것을 더 해주면서 dy 배열을 완성 해나간다.
                dy[i][j] = dy[i-1][j] + dy[i][j-1] - dy[i-1][j-1] + a[i][j];
            }
        }

        // 영지의 크기를 입력 받음
        n = sc.nextInt();
        m = sc.nextInt();

        for(i=n; i<=h; i++){
            for(j=m; j<=w; j++){
                temp = dy[i][j] - dy[i-n][j] - dy[i][j-m] + dy[i-n][j-m];

                if(temp > max)
                    max = temp;
            }
        }

        System.out.println(max);
    }
}
