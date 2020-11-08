package algorithm.basic_ps.dp;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        /*
            DP[N] = 정상까지 가는데 걸리는 N개의 step

            <N-1> + 1 = N
            <N-2> + 2 = N

            DP[N-1] = 정상까지 가는데 1 step으로 가는 경우
            DP[N-2] = 정상까지 가는데 2 step으로 가는 경우

            DP[N] = DP[N-1] + DP[N-2]

            ================================
            DP[0] = 1
            DP[1] = 1
            DP[2] = DP[1] + DP[0] = 1 + 1
            DP[3] = DP[2] + DP[1] = 3
            ================================
        */

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
