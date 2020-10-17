package algorithm.boj.bruteforce;

import java.util.Scanner;

public class Problem_10972 {

    public static boolean next_permutation(int[] a){
        int i = a.length-1;

        while(i > 0 && a[i-1] >= a[i]){ // 1 단계
            i -= 1;
        }

        if(i <= 0)  // 마지막 순열
            return false;

        int j = a.length-1;

        while(a[j] <= a[i-1]){ // 2 단계
            j -= 1;
        }

        int temp = a[i-1]; // 3 단계
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;

        while(i < j){ // 4 단계
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            j -= 1;
            i += 1;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        if(next_permutation(a)){
            for(int i=0; i<n; i++){
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }else{
            System.out.println("-1");
        }
    }
}
