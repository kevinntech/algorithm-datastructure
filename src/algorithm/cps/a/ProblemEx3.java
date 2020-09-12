package algorithm.cps.a;

import java.util.Scanner;

public class ProblemEx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 1; // 1은 모든 숫자의 약수이므로 1로 초기화

        System.out.print(1);
        for(int i = 2; i<n; i++){ // n은 진약수이므로 포함 되지 않음
            /* 약수  : 어떤 수를 (나머지 없이) 나누어 떨어지게 하는 수를 말한다.
               진약수 : 자기 자신을 제외한 약수를 말한다. */

            if(n%i == 0) {
                System.out.print(" + " + i );
                sum += i;
            }
        }
        System.out.print(" = " + sum);
    }
}
