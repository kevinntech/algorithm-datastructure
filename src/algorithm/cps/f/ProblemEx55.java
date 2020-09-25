package algorithm.cps.f;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ProblemEx55 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        int i, j = 1, n, m;

        n = sc.nextInt();

        ArrayList<Character> str = new ArrayList<>();

        for(i=1; i<=n; i++){
            m = sc.nextInt();
            stack.push(m);
            str.add('P');

            while(true){
                if(stack.empty()) // Stack이 비어 있다면 반복문 탈출
                    break;

                if(j == stack.peek()) {
                    stack.pop();
                    j++;
                    str.add('O');
                }else{
                    break;
                }
            }
        }

        if(!stack.isEmpty())
            System.out.println("impossible");
        else{
            for(i=0; i<str.size(); i++)
                System.out.print(str.get(i));

            System.out.println();
        }

    }
}
