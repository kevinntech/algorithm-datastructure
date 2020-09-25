package algorithm.cps.f;

import java.util.Scanner;
import java.util.Stack;

public class ProblemEx53 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        Stack<Integer> stack = new Stack<>();
        char[] str = "0123456789ABCDEF".toCharArray();

        n = sc.nextInt();
        k = sc.nextInt();

        while(n > 0){
            stack.push(n % k); // 12를 2로 나눈 나머지를 PUSH
            n = n / k;              // 12를 2로 나눈 몫으로 변경함. 이것을 반복하다가 0이 되면 반복 종료
        }

        while(!stack.isEmpty()){
            System.out.print(str[stack.pop()]);
        }
    }
}
