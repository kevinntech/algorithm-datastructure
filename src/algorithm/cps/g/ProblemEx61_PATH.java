package algorithm.cps.g;

import java.util.Scanner;

public class ProblemEx61_PATH {
    static int n, m, cnt = 0;
    static int[] path = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[] a = new int[n+1];

        for(int i=1; i<=n; i++){
            a[i] = sc.nextInt();
        }

        DFS(1, a , 0);

        if(cnt == 0)
            System.out.println(-1);
        else
            System.out.println(cnt);

    }

    private static void DFS(int l, int[] a, int val) {
        if(l == n+1){       // 종료 지점
            if(val == m){  // val이 내가 찾고자 하는 값(m)이면 개수 증가
                cnt++;
                for(int i=1; i<l; i++){ // 결과를 만드는 경우를 모두 출력
                    System.out.print(path[i] + " ");
                }
                System.out.println();
            }
        }else{
            path[l] = a[l]; // 더하는 경우
            DFS(l+1, a, val + a[l]);
            path[l] = -a[l]; // 빼는 경우
            DFS(l+1, a, val - a[l]);
            path[l] = 0; // 사용 하지 않는 경우
            DFS(l+1, a, val);
        }
    }
}
