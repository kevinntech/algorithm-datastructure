package algorithm.cps.c;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemEx24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] diff = new int[n];
        String result = "YES";

        for(int i=0; i<n; i++){
            num[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            if(i+1 < n){
                diff[i] = Math.abs(num[i+1] - num[i]);
            }
        }

        Arrays.sort(diff);

        for(int i=0; i<n; i++){
            if(i+1 < n){
                if(Math.abs(diff[i] - diff[i+1]) != 1){
                    result = "NO";
                    break;
                }
            }
        }

        System.out.println(result);


    }
}
