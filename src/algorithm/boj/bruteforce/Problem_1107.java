package algorithm.boj.bruteforce;

import java.util.Scanner;

public class Problem_1107 {
    static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            broken[x] = true;
        }

        int ans = Math.abs(n - 100); // 숫자 버튼을 하나도 사용하지 못하는 경우

        for(int i=0; i<=1000000; i++){
            int c = i; // 이동 할 채널 c

            int len = possible(c);

            if(len > 0){
                int press = Math.abs(c - n); // +, - 버튼을 눌러야 하는 횟수

                if(press + len < ans)
                    ans = press + len;
            }

        }

        System.out.println(ans);


    }

    private static int possible(int c) {
        if(c == 0){
            if(broken[c])
                return 0;
            else
                return 1;
        }

        int len = 0;

        while(c > 0){
            if(broken[c % 10]){
                return 0;
            }

            len++;
            c /= 10;
        }

        return len;
    }
}
