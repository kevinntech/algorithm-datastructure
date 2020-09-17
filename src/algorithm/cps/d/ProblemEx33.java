package algorithm.cps.d;

import java.util.Scanner;

public class ProblemEx33 {
    public static void main(String[] args) {
        // 내림차순 정렬한 다음,
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] score = new int[n];
        int rank, idx, temp;;

        for(int i=0; i<n; i++){
            score[i] = sc.nextInt();
        }

        // 선택 정렬
        for(int i=0; i<n-1; i++){
            idx = i;

            for(int j=i+1; j<n; j++){
                if(score[j] > score[idx])
                    idx = j;
            }

            temp = score[i];
            score[i] = score[idx];
            score[idx] = temp;
        }

        rank = 1;
        for(int i=1; i<n; i++){ // 인덱스가 1인 배열 요소와 앞의 요소를 비교 했을 때, 같지 않으면 순위 증가
            if(i-1 >= 0 && score[i-1] != score[i])
                rank++;

            if(rank == 3) {
                System.out.println(score[i]);
                break;
            }
        }

    }
}
