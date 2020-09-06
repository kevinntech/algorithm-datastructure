package algorithm.cps.two;

import java.util.Scanner;

public class ProblemEx14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, num, tmp;

        n = sc.nextInt();

        for(int i=1; i<=n; i++){
            num = sc.nextInt();
            tmp = reverse(num);

            if(isPrime(tmp))
                System.out.print(tmp + " ");
        }

    }

    private static boolean isPrime(int num) { // 소수 여부 확인
        if(num == 1)         // 1은 소수가 아님
            return false;

        int i;
        boolean flag = true; // boolean 플래그를 만들고 true로 초기화

        for(i=2; i<num; i++){ // 2 부터 자기 자신 전까지 약수가 있는지 확인
            if(num%i == 0) { // i가 num의 약수 인지 확인
                flag = false;
                break;
            }
        }

        return flag;
    }

    /*  num     : 3700 ->  370  -> 37 -> 3 -> 0 [break]
        temp    : 0    ->   0   -> 7  -> 3
        result  : 0    ->   0   -> 7  -> 73     */
    private static int reverse(int num) { // num = 3700 이면
        int result = 0;
        int temp;

        while(num > 0){
            temp = num % 10;
            result = result * 10 + temp;
            num = num / 10;
        }

        return result;
    }
}
