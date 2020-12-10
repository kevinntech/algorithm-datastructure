package algorithm.basic_ps.dp;

public class UniquePaths {

    public static void main(String[] args) {
        int m = 7, n = 3;

        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
//        if(m==0 || n==0) return 0;
//        if(m==1 || n==1) return 1;

        int[][] dp = new int[m][n];

        // 열의 인덱스가 0인 경우, 맨 왼쪽 컬럼을 전부 1로 채우기
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }

        // 행의 인덱스가 0인 경우, 최상단 행을 전부 1로 채우기
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }

        // 인덱스가 0이 아닌 경우, 왼쪽과 위쪽의 값을 더하면 현재 위치로 도달 할 수 있는 경로의 수가 나온다. (dp 배열 채우기)
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

