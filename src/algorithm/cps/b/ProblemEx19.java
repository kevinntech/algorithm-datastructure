package algorithm.cps.b;

import java.util.Scanner;

public class ProblemEx19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        int cnt = 0, maxHeight = 0;

        // 배열 height에 미리 키 정보를 저장한다.
        for(int i=0; i<height.length; i++){
            height[i] = sc.nextInt();
        }

        // 배열의 뒤에서 부터 탐색 하면서 max 값이 갱신될 때마다 개수를 센다.
        maxHeight = height[height.length-1]; // 배열의 마지막 요소로 초기화

        for(int i=height.length-2; i>=0; i--){ // 마지막 요소와 그 전 요소(i번째 인덱)부터 비교
            if(height[i] > maxHeight){
                maxHeight = height[i];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
