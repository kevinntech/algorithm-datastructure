package algorithm.cps.d;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemEx42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, key, lt = 0, rt, mid;

        n = sc.nextInt();
        key = sc.nextInt();

        int[] a = new int[n];

        for(i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        rt = n - 1;

        while(lt <= rt){ // lt가 rt 보다 작거나 같을 떄까지 (즉,  엇갈리기 전까지는 반복)
            mid = (lt + rt) / 2;

            if(a[mid] == key) {
                System.out.println(mid + 1);
                break;
            }else if(a[mid] > key){
                rt = mid - 1;
            }else{
                lt = mid + 1;
            }
        }

    }
}
