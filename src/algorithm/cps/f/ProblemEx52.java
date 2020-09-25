package algorithm.cps.f;

import java.util.Scanner;

public class ProblemEx52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, p2, p3, p5, min = 2147000000;

        n = sc.nextInt();

        int[] a = new int[n+1]; // a 배열은 Ugly Numbers

        a[1] = 1;
        p2 = p3 = p5 = 1;

        for(i = 2; i <=n; i++){

            if(a[p2] * 2 < a[p3] * 3)
                min = a[p2] * 2;
            else
                min = a[p3] * 3;

            if(a[p5] * 5 < min)
                min = a[p5] * 5;

            //최소 값과 같다면 포인터 변수를 같이 증가 시킨다.
            if(a[p2] * 2 == min)
                p2++;

            if(a[p3] * 3 == min)
                p3++;

            if(a[p5] * 5 == min)
                p5++;

            a[i] = min;

        }

        System.out.println(a[n]);
    }
}
