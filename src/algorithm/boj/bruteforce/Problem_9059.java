package algorithm.boj.bruteforce;

import java.util.Scanner;

public class Problem_9059 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            System.out.println(go(0, n));
        }
    }

    private static int go(int sum, int goal) {
        if(sum > goal){ // 불가능한 경우
            return 0;
        }

        if(sum == goal){ // 정답을 찾은 경우
            return 1;
        }

        int now = 0;

        for(int i=1; i<=3; i++){
            now += go(sum + i, goal);
        }

        return now;
    }
}
