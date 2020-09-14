package algorithm.cps.c;

import java.util.Scanner;

public class ProblemEx28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int j, cnt1=0, cnt2=0;

        for(int i = 2; i <= n; i++){ // i는 2부터 왜냐하면 1은 소수가 아니다.
            int temp = i;
            j = 2;

            while(true){ // 소인수 분해
                if(temp % j == 0){
                    if(j == 2)
                        cnt1++;
                    else if(j == 5)
                        cnt2++;
                    temp = temp / j;
                }else{
                    j++;
                }
                if(temp == 1) break;
            }
        }

        if(cnt1 < cnt2)
            System.out.println(cnt1);
        else
            System.out.println(cnt2);

    }

}

/*
// 쉽게 구하는 방법
public class ProblemEx28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        for (int i=5; i<=n; i*=5) {
            ans += n/i;
        }
        System.out.println(ans);
    }
}

 */
