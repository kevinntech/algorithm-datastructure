package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx27 {
    public static void main(String[] args) {
        // 매 숫자마다 소인수 분해를 하며 check 배열을 만들어서 발견된 숫자의 개수를 증가
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cnt = new int[n+1];
        int j;

        for(int i = 2; i <= n; i++){ // i는 2부터 왜냐하면 1은 소수가 아니다.
            int temp = i;
            j = 2;

            while(true){ // 소인수 분해
                if(temp % j == 0){
                    temp = temp / j;
                    cnt[j]++;
                }else{
                    j++;
                }

                if(temp == 1) break;
            }
        }

        System.out.print(n + "! = ");
        for(int i = 2; i <= n; i++){
            if(cnt[i] != 0)
                System.out.print(cnt[i] + " ");
        }

    }
}
