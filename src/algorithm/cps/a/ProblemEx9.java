package algorithm.cps.a;

import java.util.Scanner;

public class ProblemEx9 {
    public static void main(String[] args) {
        // 해당 코드는 시간 초과를 받지 않는 코드이며 자세한 내용은 소스코드 하단의 주석을 참고하자.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] cnt = new int[n+1];

        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j+=i){ // j는 i의 배수
                cnt[j]++;
            }
        }

        for(int i=1; i<=n; i++){
            System.out.print(cnt[i] + " ");
        }

    }
}

/*
    // 일반적인 2중 for문을 사용하면 시간 초과를 받게 되므로 아래 내용처럼 구현해야 된다.

    배열이 아래와 같이 구성 되어 있다면 (배열의 인덱스가 0인 요소는 사용하지 않음.)

         0   1   2   3   4   5   6   7   8
    cnt [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ] [ ]

    i의 범위가 1~n 일 때
    i가 1아면 i를 약수로 갖는 숫자는 무엇일까? 라는 관점에서 보자.
    그 숫자는 1의 배수이며 1의 배수에 해당 하는 값의 카운트를 1 증가 시킨다.

           0    1     2     3     4     5     6     7     8
    cnt [ 1 ] [ 1 ] [ 1 ] [ 1 ] [ 1 ] [ 1 ] [ 1 ] [ 1 ] [ 1 ]

    i가 2아면 i를 약수로 갖는 숫자는 무엇일까? 라는 관점에서 보자.
    그 숫자는 2의 배수이며 2의 배수에 해당 하는 값의 카운트를 1 증가 시킨다.

          0     1     2     3     4     5     6     7     8
    cnt [ 1 ] [ 1 ] [ 2 ] [ 1 ] [ 2 ] [ 1 ] [ 2 ] [ 1 ] [ 2 ]


*/


/*

// 아래 코드는 시간 초과를 받게 됨 (시간복잡도 N^2

public class ProblemEx9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // i는 1부터 N 까지의 숫자
        for(int i=1; i<=n; i++){
            // 각 i에 대한 약수의 개수를 구함
            int cnt = 0;

            for(int j=1; j<=i; j++){
                if(i%j == 0){ // if(i%j == 0){
                    ++cnt;
                }
            }
            System.out.print(cnt + " ");
        }

    }
}

*/
