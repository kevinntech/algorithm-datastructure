package algorithm.cps.i;

import java.util.Scanner;

public class ProblemEx82 {
    static int n, r;
    static int[] a;
    static int[] check;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();

        a = new int[n];
        check = new int[n];
        result = new int[n];

        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        DFS(0);
    }

    private static void DFS(int l) {
        if(l == r){
            for(int i=0; i<l; i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }else{
            for(int i=0; i<n; i++){
                if(check[i] == 0){ // i 번째 원소를 사용한 적이 없을 때만
                    result[l] = a[i];
                    check[i] = 1;
                    DFS(l+1);
                    check[i] = 0;
                }
            }
        }

    }
}
