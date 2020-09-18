package algorithm.cps.d;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProblemEx40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p1 = 0, p2 = 0, p3 = 0;
        int n, m;

        n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        m = sc.nextInt();
        int[] b = new int[m];
        int[] c = new int[n + m];

        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }

        Arrays.sort(b);

        while(p1 < n && p2 < m){
            if(a[p1] == b[p2]) {
                c[p3++] = a[p1++];
                p2++;
            }else if(a[p1] < b[p2]){
                p1++;
            }else{
                p2++;
            }
        }

        for(int i = 0; i < p3; i++){
            System.out.print(c[i] + " ");
        }

    }
}
