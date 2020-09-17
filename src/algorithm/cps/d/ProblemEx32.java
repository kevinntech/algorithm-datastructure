package algorithm.cps.d;

import java.util.Scanner;

public class ProblemEx32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx, temp;
        int n = sc.nextInt();
        int[] number = new int[n];

        for(int i=0; i<n; i++){
            number[i] = sc.nextInt();
        }

        // 선택 정렬
        for(int i=0; i<n-1; i++){
            idx = i;

            for(int j=i+1; j<n; j++){ // 오름차순 기준 , 최소 값의 위치 탐색
                if(number[j] < number[idx])
                    idx = j;
            }

            temp = number[i]; // i와 idx 값 SWAP
            number[i] = number[idx];
            number[idx] = temp;
        }

        for(int i=0; i<n; i++){
            System.out.print(number[i] + " ");
        }
    }
}
