package algorithm.cps.f;

import java.util.Scanner;

public class ProblemEx60 {
    static int n, total = 0;
    static int[] a;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n+1];

        for(int i=1; i<=n; i++){
            a[i] = sc.nextInt();
            total += a[i]; // total에 입력 받은 원소를 모두 더한다. 그리고 sum에는 부분 집합의 합을 구한다.
        }

        DFS(1, 0);

        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }


    private static void DFS(int l, int sum) {
        if(sum > (total / 2)) // 총합의 절반을 넘어서면 더 이상 탐색 할 필요가 없으면 메서드 종료
            return;           // 해당 코드가 없어도 답을 구할 순 있음 (성능을 더 높이기 위해 사용)
        
        if(flag == true) // 더 이상 탐색 할 필요가 없으면 메서드 종료
            return;

        if(l == n+1){ // 종료 지점 : l이 n+1이라는 것은 하나의 부분 집합을 완성한 것
            if(sum == (total-sum)) { // sum : 내가 만든 부분 집합의 총합 , total-sum : 남아 있는 원소들의 합
                flag = true;
            }
        }else{
            DFS(l+1, sum + a[l]); // LEVEL를 1 증가하며 a[l]이라는 원소를 사용하겠다.
            DFS(l+1, sum); // LEVEL만 1 증가
        }
    }
}
