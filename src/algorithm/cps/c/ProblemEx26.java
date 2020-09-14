package algorithm.cps.c;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemEx26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] level = new int[n];
        int cnt = 0;

        for(int i=0; i<n; i++){
            level[i] = sc.nextInt();
        }

        System.out.print("1 ");

        for(int i=1; i<n; i++){
            cnt = 0;
            for(int j=i-1; j>=0; j--){
                if(level[j] >= level[i]){
                    cnt++;
                }
            }
            System.out.print((cnt + 1) + " ");
        }

    }
}


/*
// 내가 제출한 정답

public class ProblemEx26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] level = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++){
            level[i] = sc.nextInt();
            rank[i] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(level[j] >= level[i]){
                    rank[i]++;
                }
            }
        }

        for(int i=0; i<n; i++){
            System.out.print(rank[i] + " ");
        }

    }
}

 */
