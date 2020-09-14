package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int temp, digit;

        for(int i=1; i<=n; i++){
            temp = i;
            while(temp > 0){ // 1의 자리를 구함
                digit = temp % 10;
                if(digit == 3) cnt++;
                temp = temp/10;
            }
        }
        System.out.println(cnt);
    }
}
