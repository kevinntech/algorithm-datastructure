package algorithm.cps.d;

import java.util.Scanner;

public class ProblemEx34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp;
        int n = sc.nextInt();
        int[] number = new int[n];

        for(int i=0; i<n; i++){
            number[i] = sc.nextInt();
        }

        int i, j;

        // 버블 정렬
        for(i=0; i<n-1; i++){
            for(j=0; j<n-i-1; j++){
                if(number[j] > number[j+1]) {
                    temp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = temp;
                }
            }
        }

        for(i=0; i<n; i++){
            System.out.print(number[i] + " ");
        }
    }
}
