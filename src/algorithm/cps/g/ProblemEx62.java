package algorithm.cps.g;

import java.util.Scanner;

public class ProblemEx62 {
    static int[] data = new int[10];
    static int[] temp = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i;
        n = sc.nextInt();

        for(i=1; i<=n; i++){
            data[i] = sc.nextInt();
        }

        divide(1, n); // 1 부터 N 까지 정렬한다.

        for(i=1; i<=n; i++){
            System.out.print(data[i] + " ");
        }
    }

    private static void divide(int lt, int rt) {
        int mid;
        int p1, p2, p3;

        if(lt < rt) {
            mid = (lt + rt) / 2; // 중간 값을 찾는다.
            // 이 아래 부터는 이진 트리의 후위 순회와 유사하다.
            divide(lt, mid);
            divide(mid+1, rt);

            p1 = lt;
            p2 = mid + 1;
            p3 = lt;

            while(p1<=mid && p2 <=rt){
                if(data[p1] < data[p2])
                    temp[p3++] = data[p1++]; // 작은 값인 p1를 저장
                else
                    temp[p3++] = data[p2++]; // 작은 값인 p2를 저장
            }

            while(p1 <= mid)
                temp[p3++] = data[p1++];

            while(p2 <= rt)
                temp[p3++] = data[p2++];

            for(int i=lt; i<=rt; i++){
                data[i] = temp[i];
            }

        }
    }

}
