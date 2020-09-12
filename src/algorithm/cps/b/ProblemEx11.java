package algorithm.cps.b;

import java.util.Scanner;

public class ProblemEx11 {
    public static void main(String[] args) {
        /*
            1 부터 15 까지의 자연수를 종이에 쓸 때, 각 숫자는 총 몇 개가 쓰였을까?
            1개(1~9) : 1, 2, 3, 4, 5, 6, 7, 8, 9
            2개(10~15) : "1, 0"  "1, 1"  "1, 2"  "1, 3"  "1, 4"  "1, 5"
        */
        Scanner sc = new Scanner(System.in);
        int n, cnt=0, tmp;

        n = sc.nextInt();

        for(int i=1; i<=n; i++){
            tmp = i;
            while(tmp > 0){
                tmp = tmp / 10;
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
