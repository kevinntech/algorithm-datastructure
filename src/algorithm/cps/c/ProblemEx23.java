package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx23 {
    public static void main(String[] args) {
        /*
            내 코드는 배열을 이용하였음.
        */
        Scanner sc = new Scanner(System.in);
        int now, cnt = 0 , max = -2147000000;
        int n = sc.nextInt();
        int[] num = new int[n];

        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            if(i+1 < n && num[i+1] >= num[i]){
                cnt++;
                if(cnt > max)
                    max = cnt;
            }else{
                cnt = 1;
            }
        }

        System.out.println(max);

    }
}

/*
// 강사님 정답
public class ProblemEx23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int now;
        int n = sc.nextInt();
        int pre = sc.nextInt();
        int cnt = 1 , max = 1;

        for(int i=2; i<=n; i++){
            now = sc.nextInt();

            if(now >= pre){
                cnt++;
                if(cnt > max)
                    max = cnt;
            }else{
                cnt = 1;
            }
            pre = now;
        }

        System.out.println(max);

    }
}

*/