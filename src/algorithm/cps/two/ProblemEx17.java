package algorithm.cps.two;

import java.util.Scanner;

public class ProblemEx17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-- > 0){ // for(int i=1; i<=n; i++) 으로 해도 됨
            int cardNum = sc.nextInt();
            int stdAnswer = sc.nextInt();
            int answer = 0; // 학생 마다 정답이 다르므로 매번 초기화 해주어야 함

            for(int i=1; i<=cardNum; i++){
                answer += i;
            }

            if(stdAnswer == answer)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
