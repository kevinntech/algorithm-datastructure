package algorithm.cps.f;

import java.util.Scanner;

public class ProblemEx57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DFS(n);
    }

    private static void DFS(int n) {
        if(n == 0){ // 원하는 종료 지점을 지정
            return;
        }else{
            DFS(n / 2);
            System.out.print(n % 2 + " ");
        }
    }
}
