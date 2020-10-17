package algorithm.boj.bruteforce;

import java.util.Scanner;

public class Problem_15649 {
    static boolean[] c = new boolean[10]; // 숫자 사용 여부 기록
    static int[] a = new int[10]; // 정답 기록

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        go(0, n, m);
    }

    private static void go(int index, int n, int m) {
        if(index == m){
            for(int i=0; i<m; i++){
                System.out.print(a[i]);

                if(i != m-1)
                    System.out.print(" ");
            }
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                if(c[i])
                    continue;
                c[i] = true;
                a[index] = i;
                go(index + 1, n, m);
                c[i] = false;
            }
        }
    }
}
