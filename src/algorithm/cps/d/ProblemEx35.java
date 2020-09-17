package algorithm.cps.d;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemEx35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, temp;
        int n = sc.nextInt();
        int[] number = new int[n];

        for(i=0; i<n; i++){
            number[i] = sc.nextInt();
        }

        // 버블 정렬
        for(i=0; i<n-1; i++){
            for(j=0; j<n-i-1; j++){
                // j 번째 수가 양수이고 j+1 번째 수가 음수이면 자리 바꿈을 한다.
                // 즉, 양수는 양수끼리 음수는 음수끼리 정렬한다.
                if(number[j] > 0 && number[j+1] < 0) {
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
