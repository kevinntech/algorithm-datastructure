package algorithm.cps.d;

import java.util.Scanner;

public class ProblemEx41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b = 1, cnt = 0, temp , i;
        a = sc.nextInt(); // 15
        temp  = a; // 처음 입력 받은 값을 임시 변수(temp)에 저장한다. 나중에 수식으로 표현할 때 사용

        a--; // 1이 마이너스 됨
        while(a > 0){
            b++;
            a = a - b; // 그 다음에 2가 마이너스

            if(a % b == 0){
                for(i = 1; i<b; i++){
                    System.out.print( (a / b) + i + " + ");
                }
                System.out.println( ((a / b) + i) + " = "  + temp);
                cnt++;
            }
        }

    }
}
