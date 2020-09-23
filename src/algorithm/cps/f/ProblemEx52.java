package algorithm.cps.f;

import java.util.Scanner;

public class ProblemEx52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] uglyNum = new int[1501];

        uglyNum[1] = 1;
        int pos = 1;

        // 1500 번째는? ...
        for(int i = 2; i <=1500; i++){

            if(i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                pos++;

                if(pos <= 1500) {
                    uglyNum[pos] = i;
                }
            }
        }

        System.out.println(uglyNum[n]);
    }
}
