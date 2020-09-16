package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx30 {
    public static void main(String[] args) {
        int left = 1, right, cur, k = 1, result = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(left != 0){
            left = n / (k * 10);
            right = n % k;
            cur = (n / k) % 10;

            if(cur > 3)
                result += ((left + 1) * k);
            else if(cur == 3)
                result += ((left * k) + (right + 1));
            else
                result += (left * k);

            k = k * 10;
        }

        System.out.println(result);
    }
}
