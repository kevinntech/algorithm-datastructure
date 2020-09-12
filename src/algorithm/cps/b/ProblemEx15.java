package algorithm.cps.b;

import java.util.Scanner;

public class ProblemEx15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, cnt = 0;
        boolean flag;

        n = sc.nextInt();

        for(int i=2; i<=n; i++){
            flag = true;

            for(int j=2; j*j<=i; j++){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                cnt++;
        }

        System.out.println(cnt);

    }
}
