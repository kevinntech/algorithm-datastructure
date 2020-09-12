package algorithm.cps.a;

import java.util.Scanner;

/* 최대 나이 차이는 최대 값 - 최소 값이다. */
public class ProblemEx4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int min = 2147000000 , max = -2147000000;
        int age;

        while(n-- > 0){
            age = sc.nextInt();

            if(age < min)
                min = age;
            if(age > max)
                max = age;
        }

        System.out.println(max-min);
    }
}
