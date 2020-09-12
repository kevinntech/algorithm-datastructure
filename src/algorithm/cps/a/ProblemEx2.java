package algorithm.cps.a;

import java.util.Scanner;

public class ProblemEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;

        for(int i=a; i<b; i++){
            sum += i;
            System.out.print(i + " + ");
        }

        sum += b;
        System.out.print(b + " = " + sum);
    }
}
