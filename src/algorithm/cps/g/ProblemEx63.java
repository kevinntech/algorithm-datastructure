package algorithm.cps.g;

import java.util.Scanner;

public class ProblemEx63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, i, j, a, b, c;
        n = sc.nextInt();
        m = sc.nextInt();

        int[][] map = new int[n+1][n+1];

        for(i=1; i<=m; i++){
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            map[a][b] = c;

            // 무방향 그래프
            //map[a][b] = 1;
            //map[b][a] = 1;
        }

        for(i=1; i<=n; i++){
            for(j=1; j<=n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}

/*
6 9
1 2 7
1 3 4
2 1 2
2 3 5
2 5 5
3 4 5
4 2 2
4 5 5
6 4 5
*/
