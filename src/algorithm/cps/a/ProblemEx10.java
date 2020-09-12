package algorithm.cps.a;

import java.util.Scanner;

public class ProblemEx10 {

    public static int digit_sum(int x){
        int temp = 0, sum = 0;

        while(x > 0){
            temp = x % 10;
            sum += temp;
            x = x / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxSum = -2147000000;
        int maxNum = 0;

        int n = sc.nextInt();

        for(int i = 0; i<n; i++){
            int num = sc.nextInt();
            int sum = digit_sum(num);

            if(sum > maxSum){
                maxSum = sum;
                maxNum = num;
            }else if (sum == maxSum){
                if(num > maxNum)
                    maxNum = num;
            }
        }

        System.out.println(maxNum);
    }
}

/*
   tmp = x % 10; // x를 10으로 나눴을 때 나머지
   sum += tmp;
   x = x/10; // x를 10으로 나눈 몫

   |  x  |  tmp  |  sum  |
   | 125 |   5   |   5   |
   | 12  |   2   |   7   |
   |  1  |   1   |   8   |
   |  0  |   1   |   8   |

*/

/*

// 문자열 탐색으로 직접 풀어본 정답
public class ProblemEx10 {

    public static int digit_sum(int x){
        int sum = 0;
        String str = String.valueOf(x);

        for(char ch : str.toCharArray()){
            sum += ch -'0';
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxSum = -2147000000;
        int maxNum = 0;

        int n = sc.nextInt();

        while(n-- > 0){
            int num = sc.nextInt(); // 125
            int sum = digit_sum(num);

            if(sum > maxSum){
                maxSum = sum;

            }else if (sum == maxSum){
                if(num > maxNum)
                    maxNum = num;
            }
        }

        System.out.println(maxNum);
    }
}

*/