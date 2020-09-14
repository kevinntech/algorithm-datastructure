package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        int[] rank = new int[n];

        // 현재 내 점수 보다 큰 점수를 만났을 때, 내 점수에 대한 순위를 변경한다.
        // 순위는 처음에 1로 모두 초기화 한다.

        for(int i=0; i<n; i++){
            score[i] = sc.nextInt();
            rank[i] = 1;
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(score[i] < score[j])
                    rank[i]++;
            }
        }

        for(int i=0; i<n; i++){
            System.out.print(rank[i] + " ");
        }

    }
}
