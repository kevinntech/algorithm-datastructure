package algorithm.cps.d;

import java.util.Scanner;

public class ProblemEx36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, idx, temp;
        int n = sc.nextInt();
        int[] number = new int[n];

        for(i=0; i<n; i++){
            number[i] = sc.nextInt();
        }

        // ★★★ 삽입 정렬
        for(i=1; i<n; i++){
            temp = number[i];

            for(j=i-1; j>=0; j--){ // temp가 삽입 될 위치를 찾는다.
                if(number[j] > temp)
                    number[j+1] = number[j]; // j번째 요소가 더 크다면 비교 대상(j)을 한 칸 밀기
                else
                    break; // 삽입 위치를 찾았으므로 반복문 종료
            }
            number[j+1] = temp; // 찾은 위치에 정렬 대상 삽
        }

        for(i=0; i<n; i++){
            System.out.print(number[i] + " ");
        }
    }
}
