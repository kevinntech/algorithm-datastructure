package algorithm.cps.g;

import java.util.Scanner;

public class ProblemEx61 {
    static int n, m, cnt = 0;
    static int[] a;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n+1];

        for(int i=1; i<=n; i++){
            a[i] = sc.nextInt();
        }

        DFS(1, 0);

        if(cnt == 0)
            System.out.println(-1);
        else
            System.out.println(cnt);

    }

    private static void DFS(int l, int val) { // val : 경우의 수에 따른 결과 값
        if(l == n+1){ // 종료 지점
            if(val == m) { // val이 내가 만들고자 한 값(m)이면 개수 증가
                cnt++;
            }
        }else{
            DFS(l+1, val + a[l]); // 레벨 증가 및 원소를 더하는 경우
            DFS(l+1, val - a[l]); // 레벨 증가 및 원소를 빼는 경우
            DFS(l+1, val); // 레벨 증가 및 원소를 사용 하지 않는 경우
        }
    }
}
