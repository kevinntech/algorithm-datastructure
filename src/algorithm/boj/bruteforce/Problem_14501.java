package algorithm.boj.bruteforce;

import java.util.Scanner;

public class Problem_14501 {
    static int n, ans = Integer.MIN_VALUE;
    static int[] t;
    static int[] p;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        t = new int[n+1]; // 걸리는 기간
        p = new int[n+1]; // 금액

        for(int i=1; i<=n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        go(1, 0);

        System.out.println(ans);
    }

    private static void go(int i, int sum) {

        if(i == n+1){
            if(sum > ans) {
                ans = sum;
            }
            return;
        }

        if(i > n+1)
            return;

        // i일에 상담을 하는 경우
        go(i + t[i], sum + p[i]);

        // i일에 상담을 하지 않는 경우
        go(i + 1, sum);
    }
}
