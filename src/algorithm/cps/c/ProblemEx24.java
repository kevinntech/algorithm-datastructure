package algorithm.cps.c;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemEx24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int now, pos;
        int n = sc.nextInt();
        int pre = sc.nextInt();
        int[] check = new int[n];

        for(int i=1; i<n; i++){
            now = sc.nextInt();
            pos = Math.abs(pre-now);
            if(pos > 0 && pos < n && check[pos] == 0){ // 중복이 아니면
                check[pos] = 1;
            }else{
                System.out.println("NO");
                System.exit(0);
            }
            pre=now;
        }

        System.out.println("YES");
    }
}

/*

// 내가 작성한 코드

public class ProblemEx24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] diff = new int[n];
        String result = "YES";

        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            if(i+1 < n){
                diff[i] = Math.abs(num[i+1] - num[i]);
            }
        }

        Arrays.sort(diff);

        for(int i=0; i<n; i++){
            if(i+1 < n){
                if(Math.abs(diff[i] - diff[i+1]) != 1){
                    result = "NO";
                    break;
                }
            }
        }

        System.out.println(result);
    }
}

*/