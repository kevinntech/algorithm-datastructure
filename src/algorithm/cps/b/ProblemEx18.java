package algorithm.cps.b;

import java.util.Scanner;

public class ProblemEx18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int sound = 0, cnt = 0, maxCnt = -2147000000;

        while(n-- > 0){ // for(int i=1; i<=n; i++) 으로 해도 됨
            sound = sc.nextInt();

            if(sound > m){
                cnt++;
            }else{
                cnt = 0;
            }

            if (cnt > maxCnt)
                maxCnt = cnt;
        }

        if(maxCnt == 0)
            System.out.println("-1");
        else
            System.out.println(maxCnt);

    }
}
