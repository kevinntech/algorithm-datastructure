package algorithm.cps.two;

import java.util.Scanner;

public class ProblemEx12 {
    public static void main(String[] args) {
        /*
            [변수 설명]
            n : 입력으로 받 값
            len : 자리 수
            cnt : 각 자리 수 마다 총 숫자 개수
                  Ex) 1 자리 수(9개), 2 자리 수(90개)
            sum : cnt를 누적한 값
            result : 결과 값

            [풀이 방법]

            예를 들어, N이 256 이면

            1 자리 수 : 9 개 (1~9)       = 1 * 9  = 9
            2 자리 수 : 90개 (10~99)     = 2 * 90 = 180
            3 자리 수 : 157개 (100~256)  = (256 - 99) * 3 = 471
                      256 - 99 = 157 개 (-99를 한 이유는 2자리 수 까지는 가능 하기 때문)
        */

        int n, len = 1, cnt = 9, sum = 0, result = 0;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        while(sum + cnt < n){ // 입력 값과 sum + cnt를 비교
            result = result + (len * cnt);
            sum = sum + cnt;
            len++; // 자리 수를 증가
            cnt = cnt * 10; // 각 자리 수 마다 총 숫자 개수를 갱신
        }

        result = result + ((n - sum) * len);
        System.out.println(result);
    }
}
