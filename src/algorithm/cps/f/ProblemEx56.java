package algorithm.cps.f;

import java.util.Scanner;

public class ProblemEx56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        recursive(n);
    }

    private static void recursive(int n) {
        if(n == 0) // 재귀 함수는 원하는 종료 지점을 지정한다.
            return;
        else { // 그렇지 않은 경우에는 경우의 수로 뻗어 나가기
            recursive(n-1);
            System.out.print(n + " ");
        }
    }
}
