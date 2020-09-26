package algorithm.cps.f;

import java.util.Scanner;

public class ProblemEx59 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] ch = new int[n+1];

        DFS(1 , ch);
    }


    private static void DFS(int l , int[] ch) { // ch : check
        if(l == n+1){ // 종료 지점
            for(int i=1; i<=n; i++){
                if(ch[i] == 1)
                    System.out.print(i + " ");
            }
            System.out.println(""); // 반환타입 void이므로 return 문 없어도 됨
        }else{
            ch[l] = 1; // 왼쪽 자식을 탐색 (부분 집합에 포함 O)
            DFS(l+1, ch); // LEVEL를 1 증가
            ch[l] = 0; // 오른쪽 자식을 탐색 (부분 집합에 포함 X)
            DFS(l+1, ch); // LEVEL를 1 증가
        }
    }

}
