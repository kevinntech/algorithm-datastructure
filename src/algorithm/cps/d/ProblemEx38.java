package algorithm.cps.d;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemEx38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j, pos;
        n = sc.nextInt();
        int[] is = new int[n+1];
        int[] os = new int[n+1];

        for(i = 1; i<=n; i++){  // 입력 값 저장
            is[i] = sc.nextInt();
        }

        // 문제를 푸는 것의 핵심은 N번 부터 처리 해야 한다.
        for(i = n; i>=1; i--){
            pos = i;

            for(j = 1; j<=is[i]; j++) { // Inversion Sequence의 값 만큼 반복 하면서
                os[pos] = os[pos+1]; // is의 값 만큼 뒤에 있는 것을 앞으로 당김
                pos++;
            }

            os[pos] = i; // pos에 숫자(i)를 넣어준다.
        }

        for(i = 1; i<=n; i++){  // 입력 값 저장
            System.out.print(os[i] + " ");
        }
    }
}
