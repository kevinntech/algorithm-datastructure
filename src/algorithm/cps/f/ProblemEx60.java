package algorithm.cps.f;

import java.util.Scanner;

public class ProblemEx60 {
    static int n, total = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n+1];

        for(int i=1; i<=n; i++){
            a[i] = sc.nextInt();
            total += a[i];
        }

        DFS(1, a, 0);

        if(flag == true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }


    private static void DFS(int l, int[] a, int sum) {
        if(sum > (total / 2)) // 이 경우도 더 이상 탐색 할 필요가 없으면 메서드 종료
            return;
        
        if(flag == true) // 더 이상 탐색 할 필요가 없으면 메서드 종료
            return;

        if(l == n+1){ // 종료 지점
            if(sum == (total-sum)) { // sum : 내가 만든 부분 집합의 총합 , total-sum : 남아 있는 원소들의 합
                flag = true;
            }
        }else{
            DFS(l+1, a, sum + a[l]); // LEVEL를 1 증가하며 a[l]이라는 원소를 사용하겠다.
            DFS(l+1, a, sum); // LEVEL만 1 증가
        }
    }
}
