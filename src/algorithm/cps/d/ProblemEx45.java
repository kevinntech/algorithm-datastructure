package algorithm.cps.d;

import java.util.Scanner;

public class ProblemEx45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, pos = 0, breakPoint = 0, cnt = 0; // breakPoint는 N-1이 되면 종료
        n = sc.nextInt();
        k = sc.nextInt();

        int[] prince = new int[n + 1]; // 인덱스 1 부터 사용

        while(true){ // 무한 반복
            pos++;

            if(pos > n) // pos가 n을 넘어서는 순간, 1로 만들어준다. (배열의 첫 번째 위치로 가게 함)
                pos = 1;

            if(prince[pos] == 0){ // 0을 만나면 개수를 1 증가
                cnt++;

                if(cnt == k) {// k번째 이면
                    prince[pos] = 1; // 1로 만들면 제외 시킨다는 의미
                    cnt = 0;
                    breakPoint++; // 왕자가 제외 될 때마다 breakPoint 값 증가한다
                }
            }

            if(breakPoint == n-1) // 제외된 왕자의 수가 n-1명이면 반복을 종료
                break;
        }

        for(int i = 1; i <= n; i++){
            if(prince[i] == 0) { // prince 배열 요소의 값이 0인 왕자가 정답이 된다.
                System.out.println(i);
                break;
            }
        }

    }
}
