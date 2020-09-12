package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx22 {
    public static void main(String[] args) {
        /*
            a [3] [-2] [-4] [9] [0] [3] [7] [13] [8] [-3]

            sum [ ]

            sum = sum + a[i] - a[i-k]
            if(sum > max){
                max = sum;
            }

        */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] temper = new int[n];
        int sum = 0, max;

        for(int i=0; i<n; i++){
            temper[i] = sc.nextInt();
        }

        for(int i=0; i<k; i++){
            sum += temper[i];
        }

        max = sum;

        for(int i=k; i<n; i++){
            sum = sum + (temper[i] - temper[i-k]);
            if(sum > max) // sum의 최대 값 찾기
                max = sum;
        }

        System.out.println(max);

    }
}
