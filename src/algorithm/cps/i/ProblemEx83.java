package algorithm.cps.i;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemEx83 {
    static ArrayList<Integer> T, P;
    static int n, res = -2147000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = new ArrayList(); // 상담 날
        P = new ArrayList(); // 수익

        n = sc.nextInt(); // 상담 일수

        T.add(0); // 0번 인덱스는 0을 넣어서 사용하지 않고 1번 인덱스 부터 사용
        P.add(0);
        
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            T.add(a);
            P.add(b);
        }
        
        DFS(1, 0);
        
        System.out.println(res);
    }

    private static void DFS(int l, int sum) { // l : 날짜 , sum : 수익의 합
        if(l == n+1){
            if(sum > res)
                res = sum;
        }else{
            if(l + T.get(l) <= n+1) // 상담을 할 수 있을 때만
                DFS(l + T.get(l) , sum + P.get(l)); // 상담을 한다.
            DFS(l+1, sum);
        }
    }
}