package algorithm.cps.d;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemEx39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = 0, p2 = 0, p3 = 0;
        int n, m;

        n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        m = sc.nextInt();
        int[] b = new int[m];
        int[] c = new int[n + m];

        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }

        // 두 개의 배열 합치기 (병합)
        while(p1 < n && p2 < m){ // 합치는 대상의 배열 중 하나의 모든 요소를 접근 했다면
            if(a[p1] < b[p2]){
                c[p3++] = a[p1++];
            }else{
                c[p3++] = b[p2++];
            }
        }

        while(p1 < n)
            c[p3++] = a[p1++]; // a 배열에 남은 것이 있다면 c 배열에 모두 올긴다.

        while(p2 < m)
            c[p3++] = b[p2++];  // b 배열에 남은 것이 있다면 c 배열에 모두 올긴다.

        for(int i = 0; i < p3; i++){
            System.out.print(c[i] + " ");
        }

    }
}
